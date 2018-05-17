package net.sevecek.videoboss;

import net.sevecek.videoboss.controller.*;
import net.sevecek.videoboss.repository.*;

public class ServiceLocator {

    private static ServiceLocator instance = new ServiceLocator();
    private MvcTranslator mvcTranslator;


    public static ServiceLocator getInstance() {
        return instance;
    }

    protected ServiceLocator() {
    }

    //--------------------------------------------------------------------

    private FilmRepository filmDao;

    public synchronized FilmRepository getFilmRepository() {
        if (filmDao == null) {
            InMemoryFilmRepository repository = new InMemoryFilmRepository();
            repository.initialize();
            filmDao = repository;
        }
        return filmDao;
    }


    public synchronized MvcTranslator getMvcTranslator() {
        if (mvcTranslator == null) {
            mvcTranslator = new MvcTranslator();
        }
        return mvcTranslator;
    }
}
