package net.sevecek.videoboss.repository;

import java.util.*;
import javax.persistence.*;
import net.sevecek.videoboss.entity.*;

public class InMemoryFilmRepository implements FilmRepository {

    private long idSequence = 100L;
    private Map<Long, Film> films = new TreeMap<>();


    public void initialize() {
        addFilm(new Film("Terminátor 1", "http://www.external.cz/film/1249-terminator/", 1984, 87.0));
        addFilm(new Film("Terminátor 2: Den zúčtování", "http://www.external.cz/film/1248-terminator-2-den-zuctovani/", 1991, 91.0));
        addFilm(new Film("Terminátor 3: Vzpoura strojů", "http://www.external.cz/film/15908-terminator-3-vzpoura-stroju/", 2003, 72.0));
        addFilm(new Film("Valkýra", "http://www.external.cz/film/233151-valkyra/", 2008, 82.0));
        addFilm(new Film("Obecná škola", "http://www.external.cz/film/8806-obecna-skola/", 1991, 90.0));
        addFilm(new Film("Schindlerův seznam", "http://www.external.cz/film/8653-schindleruv-seznam/", 1993, 93.0));
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
        newFilm.setVersion(newFilm.getVersion() + 1);
        films.put(newFilm.getId(), newFilm);
        return newFilm;
    }


    private long generateNextIdFromSequence() {
        return ++idSequence;
    }
}
