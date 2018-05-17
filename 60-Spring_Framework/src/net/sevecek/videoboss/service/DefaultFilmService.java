package net.sevecek.videoboss.service;

import java.util.List;
import net.sevecek.videoboss.ServiceLocator;
import net.sevecek.videoboss.repository.FilmRepository;
import net.sevecek.videoboss.entity.Film;

public class DefaultFilmService implements FilmService {

    private FilmRepository filmDao;

    public void initialize() {
        filmDao = ServiceLocator.getInstance().getFilmRepository();
    }

    @Override
    public List<Film> findAllFilms(long firstItem, int count) {
        return filmDao.findAllFilms(firstItem, count);
    }

    @Override
    public Film findFilm(Long id) {
        return filmDao.findFilm(id);
    }

    @Override
    public Film updateFilm(Film newFilm) {
        return filmDao.updateFilm(newFilm);
    }

    @Override
    public Film addFilm(Film film) {
        return filmDao.addFilm(film);
    }

}
