package net.sevecek.videoboss.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.apache.struts.action.*;
import net.sevecek.videoboss.*;
import net.sevecek.videoboss.repository.*;
import net.sevecek.videoboss.entity.*;

public class AllFilmsController extends Action {

    private FilmRepository filmDao = ServiceLocator.getInstance().getFilmRepository();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Film> films = filmDao.findAllFilms(0L, -1);
        request.setAttribute("films", films);
        return mapping.findForward("success");
    }
}
