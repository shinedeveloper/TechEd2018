package net.sevecek.videoboss.controller;

import org.apache.struts.action.*;
import net.sevecek.videoboss.entity.*;

public class MvcTranslator {

    public void translate(Film film, FilmForm form) {
        form.setId(film.getId());
        form.setName(film.getName());
        form.setReleaseYear(film.getReleaseYear());
        form.setExternalLink(film.getExternalLink());
        form.setRating(film.getRating());
        form.setVersion(film.getVersion());
    }


    public Film translate(FilmForm form) {
        return new Film(
                form.getId(),
                form.getName(),
                form.getExternalLink(),
                form.getReleaseYear(),
                form.getRating(),
                form.getVersion());
    }
}
