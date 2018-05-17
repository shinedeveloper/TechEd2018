package net.sevecek.videoboss;

import net.sevecek.videoboss.repository.*;
import net.sevecek.videoboss.service.FilmService;
import net.sevecek.videoboss.service.DefaultFilmService;

public class ServiceLocator {

    private static ServiceLocator instance = new ServiceLocator();

    public static ServiceLocator getInstance() {
        return instance;
    }

    protected ServiceLocator() {
    }

    //--------------------------------------------------------------------

    private FilmService filmService;
    private FilmRepository filmDao;

    public synchronized FilmService getFilmService() {
        if (filmService == null) {
            DefaultFilmService service = new DefaultFilmService();
            service.initialize();
            filmService = service;
        }
        return filmService;
    }

    public synchronized FilmRepository getFilmRepository() {
        if (filmDao == null) {
            InMemoryFilmRepository repository = new InMemoryFilmRepository();
            repository.initialize();
            filmDao = repository;
        }
        return filmDao;
    }
}
