package net.sevecek.videoboss.repository;

import java.util.List;
import net.sevecek.videoboss.entity.Film;

public interface FilmRepository {

    List<Film> findAllFilms(long firstItem, int count);

    Film findFilm(Long id);

    Film addFilm(Film film);

    Film updateFilm(Film film);

}
