package net.sevecek.videoboss.controller;

import java.util.*;
import javax.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import net.sevecek.videoboss.*;
import net.sevecek.videoboss.entity.*;
import net.sevecek.videoboss.service.*;

@Controller
@RequestMapping("/films")
public class FilmController {

    private FilmService filmService;

    @PostConstruct
    public void initialize() {
        filmService = ServiceLocator.getInstance().getFilmService();
    }

    //--------------------------------------------------------------------

    @RequestMapping("/all.html")
    public String showAll(Map<String, Object> model) {
        List<Film> films = filmService.findAllFilms(0L, -1);
        model.put("films", films);
        return "/WEB-INF/view/films/all.jsp";
    }
    
    @RequestMapping(value = "/{filmId}.html",
                    method = RequestMethod.GET)
    public String showEdit(
	            Map<String, Object> model,
                @PathVariable("filmId") Long filmId) {
        Film film = filmService.findFilm(filmId);
        model.put("film", film);
        return "/WEB-INF/view/films/edit.jsp";
    }

    @RequestMapping(value = "/{filmId}.html",
                    method = RequestMethod.POST)
    public String processEdit(
	            @PathVariable("filmId") Long filmId,
                Film film) {
        film.setId(filmId);
        filmService.updateFilm(film);
        return "redirect:/films/all.html";
    }

    @RequestMapping(value = "/add.html",
                    method = RequestMethod.GET)
    public String showAdd(Map<String, Object> model) {
        Film film = new Film(null, "", "", 2000, 0.0);
        model.put("film", film);
        return "/WEB-INF/view/films/edit.jsp";
    }

    @RequestMapping(value = "/add.html",
                    method = RequestMethod.POST)
    public String processAdd(Film film) {
        film.setId(null);
        filmService.addFilm(film);
        return "redirect:/films/all.html";
    }

}
