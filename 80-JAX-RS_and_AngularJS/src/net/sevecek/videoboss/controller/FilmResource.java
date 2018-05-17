package net.sevecek.videoboss.controller;

import java.util.*;
import javax.ws.rs.*;
import net.sevecek.videoboss.*;
import net.sevecek.videoboss.entity.*;
import net.sevecek.videoboss.service.*;

@Path("/films")
public class FilmResource {

    private FilmService filmService =
            ServiceLocator.getInstance().getFilmService();

    //--------------------------------------------------------------------

    @GET
    @Path("/all{ext:|\\.xml|\\.son}")
    public List<Film> findAllFilms(
            @QueryParam("first") int firstItem,
            @QueryParam("count") int count) {
        List<Film> allFilms = filmService.findAllFilms(firstItem, count);
        return allFilms;
    }

    @GET
    @Path("/{id}{ext:|\\.xml|\\.json}")
    public Film findFilmById(@PathParam("id") long filmId) {
        Film film = filmService.findFilm(filmId);
        return film;
    }

    @POST
    @Path("/{id}{ext:|\\.xml|\\.json}")
    public Film updateFilm(@PathParam("id") long filmId,
                           Film film) {
        Film updatedFilm = filmService.updateFilm(film);
        return updatedFilm;
    }

    @POST
    @Path("/new{ext:|\\.xml|\\.json}")
    public Film addFilm(Film film) {
        Film addedFilm = filmService.addFilm(film);
        return addedFilm;
    }
}
