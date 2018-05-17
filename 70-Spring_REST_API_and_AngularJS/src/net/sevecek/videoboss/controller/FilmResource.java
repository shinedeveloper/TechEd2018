package net.sevecek.videoboss.controller;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import net.sevecek.videoboss.*;
import net.sevecek.videoboss.entity.*;
import net.sevecek.videoboss.service.*;

@Controller
@RequestMapping("/films")
public class FilmResource {

    private FilmService filmService
            = ServiceLocator.getInstance().getFilmService();

    //--------------------------------------------------------------------

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public @ResponseBody List<Film> findAllFilms() {
        return filmService.findAllFilms(0L, -1);
    }

    @RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET)
    public @ResponseBody Film findFilm(@PathVariable("id") Long id) {
        return filmService.findFilm(id);
    }

    @RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.PUT)
    public @ResponseBody Film updateFilm(
            @PathVariable("id") Long id, @RequestBody Film film) {
        Film changedFilm = filmService.updateFilm(film);
        return changedFilm;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public @ResponseBody Film addFilm(
            @RequestBody Film film) {
        Film addedFilm = filmService.addFilm(film);
        return addedFilm;
    }

}
