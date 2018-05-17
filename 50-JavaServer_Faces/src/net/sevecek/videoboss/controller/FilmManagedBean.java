package net.sevecek.videoboss.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import net.sevecek.util.SameObjectList;
import net.sevecek.videoboss.ServiceLocator;
import net.sevecek.videoboss.entity.Film;
import net.sevecek.videoboss.service.FilmService;

@ManagedBean(name = "filmBean")
public class FilmManagedBean {

    private FilmService filmService =
            ServiceLocator.getInstance().getFilmService();

    //----------------------------------------------------------

    private List<Film> allFilms;

    public List<Film> getAllFilms() {
        if (allFilms == null) {
            int size = (Integer) getViewMap().get("allFilms.size");
            allFilms = new SameObjectList<>(new Film(-1L, null, null, -1, -1.0, -1), size);
        }
        return allFilms;
    }

    public void loadAllFilms() {
        allFilms = filmService.findAllFilms(0, -1);
        getViewMap().put("allFilms.size", allFilms.size());
    }

    //----------------------------------------------------------

    private Film film;

    public Film getFilm() {
        if (film == null) {
            String idStr = getParamMap().get("id");
            if (idStr != null) {
                Long id = Long.parseLong(idStr);
                film = new Film(id, null, null, -1, -1.0, -1);
            } else {
                film = new Film(null, null, null, -1, -1.0, -1);
            }
        }
        return film;
    }

    public void loadFilm(Long id) {
        if (id != null) {
            // Load the film for edit
            film = filmService.findFilm(id);
        } else {
            // Create a new film for add
            film = new Film(null, null, null, 0, 0.0, 0);
        }
    }

    public String saveFilm() {
        if (film.getId() != null) {
            filmService.updateFilm(film);
        } else {
            filmService.addFilm(film);
        }

        return "/films/all.xhtml?faces-redirect=true";
    }

    //-------------------------------------------------------------------------

    public static Map<String, Object> getViewMap() {
        return FacesContext.getCurrentInstance().getViewRoot().getViewMap();
    }

    public static Flash getFlashMap() {
        return FacesContext.getCurrentInstance().getExternalContext().getFlash();
    }

    public static Map<String, String> getParamMap() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    }
}
