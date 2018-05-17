package net.sevecek.videoboss.service;

import java.util.List;
import net.sevecek.videoboss.ServiceLocator;
import net.sevecek.videoboss.repository.FilmRepository;
import net.sevecek.videoboss.entity.Film;

public class DefaultFilmService implements FilmService {

    private FilmRepository filmRepository
            = ServiceLocator.getInstance().getFilmRepository();

    @Override
    public List<Film> findAllFilms(long firstItem, int count) {
        return filmRepository.findAllFilms(firstItem, count);
    }

    @Override
    public Film findFilm(Long id) {
        return filmRepository.findFilm(id);
    }

    @Override
    public Film updateFilm(Film newFilm) {
        return filmRepository.updateFilm(newFilm);
    }

    @Override
    public Film addFilm(Film film) {
        return filmRepository.addFilm(film);
    }

}
