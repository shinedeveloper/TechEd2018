package net.sevecek.videoboss.controller;

import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import net.sevecek.videoboss.*;
import net.sevecek.videoboss.repository.*;
import net.sevecek.videoboss.entity.*;

public class EditFilmController extends Action {

    private FilmRepository filmDao = ServiceLocator.getInstance().getFilmRepository();
    private MvcTranslator mvcTranslator = ServiceLocator.getInstance().getMvcTranslator();


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {
            return showEdit(mapping, form, request, response);
        } else {
            return processEdit(mapping, form, request, response);
        }
    }


    private ActionForward showEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        String idString = request.getParameter("id");
        if (idString == null || idString.isEmpty()) {
            throw new IllegalArgumentException("Missing 'id' URL parameter");
        }
        Film film = filmDao.findFilm(Long.parseLong(idString));
        mvcTranslator.translate(film, (FilmForm) form);
        return mapping.findForward("view");
    }


    private ActionForward processEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        Film film = mvcTranslator.translate((FilmForm) form);
        filmDao.updateFilm(film);
        return mapping.findForward("success");
    }
}
