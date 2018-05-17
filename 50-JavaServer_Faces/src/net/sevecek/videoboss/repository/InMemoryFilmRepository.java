package net.sevecek.videoboss.repository;

import java.util.*;
import javax.persistence.*;
import net.sevecek.videoboss.entity.*;

public class InMemoryFilmRepository implements FilmRepository {

    private long idSequence = 100L;
    private Map<Long, Film> films = new TreeMap<>();


    public void initialize() {
        addFilm(new Film("The Terminator", "http://www.imdb.com/title/tt0088247/", 1984, 81.0));
        addFilm(new Film("Terminator 2: Judgment Day", "http://www.imdb.com/title/tt0103064/", 1991, 85.0));
        addFilm(new Film("Terminator 3: Rise of the Machines", "http://www.imdb.com/title/tt0181852/", 2003, 64.0));
        addFilm(new Film("Valkyrie", "http://www.imdb.com/title/tt0985699/", 2008, 71.0));
        addFilm(new Film("Obecná škola", "http://www.imdb.com/title/tt0102571/", 1991, 84.0));
        addFilm(new Film("Schindler's List", "http://www.imdb.com/title/tt0108052/", 1993, 89.0));
    }


    @Override
    public synchronized List<Film> findAllFilms(long firstItem, int count) {
        if (count == -1) {
            count = films.size();
        }
        List<Film> all = new ArrayList<>(count);
        for (Film film : films.values()) {
            if (firstItem > 0) {
                firstItem--;
            } else {
                all.add(film);
                count--;
                if (count == 0) break;
            }
        }
        return all;
    }


    @Override
    public synchronized Film findFilm(Long id) {
        Film film = films.get(id);
        if (film == null) {
            throw new EntityNotFoundException("Film " + id);
        }
        return film;
    }


    @Override
    public synchronized Film addFilm(Film film) {
        long id = generateNextIdFromSequence();
        film.setId(id);
        films.put(id, film);
        return film;
    }


    @Override
    public synchronized Film updateFilm(Film newFilm) {
        Film originalFilm = films.get(newFilm.getId());
        if (originalFilm.getVersion() != newFilm.getVersion()) {
            throw new OptimisticLockException(newFilm);
        }
        originalFilm.setName(newFilm.getName());
        originalFilm.setReleaseYear(newFilm.getReleaseYear());
        originalFilm.setExternalLink(newFilm.getExternalLink());
        originalFilm.setRating(newFilm.getRating());
        originalFilm.setVersion(originalFilm.getVersion() + 1);
        return originalFilm;
    }


    private long generateNextIdFromSequence() {
        return ++idSequence;
    }
}
