package net.sevecek.videoboss.service;

import java.util.List;
import net.sevecek.videoboss.entity.Film;

public interface FilmService {

    List<Film> findAllFilms(long firstItem, int count);

    Film findFilm(Long id);

    Film addFilm(Film film);

    Film updateFilm(Film newFilm);

}
