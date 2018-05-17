package net.sevecek.techeddemo;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @RequestMapping("/services/hello")
    public @ResponseBody String showHello() {
        return "{ \"name\": \"Kamil\" }";
    }

    @RequestMapping("/services/films/all")
    public @ResponseBody List<Film> showFilms() {
        Film film1 = new Film("Terminator 2", "https://www.imdb.com/title/tt0103064/", 1991, 85.0);
        Film film2 = new Film("Terminator 3", "https://www.imdb.com/title/tt0181852/", 2003, 63.0);
        List<Film> allFilms = new ArrayList<>();
        allFilms.add(film1);
        allFilms.add(film2);
        return allFilms;
    }

}
