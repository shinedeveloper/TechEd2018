package net.sevecek.videoboss.controller;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@ApplicationPath("/services")
public class JaxrsApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(FilmResource.class);
        return classes;
    }

}
