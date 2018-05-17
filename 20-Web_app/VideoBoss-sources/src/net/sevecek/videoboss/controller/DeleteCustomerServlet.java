package net.sevecek.videoboss.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import net.sevecek.videoboss.*;
import net.sevecek.videoboss.entity.*;
import net.sevecek.videoboss.repository.*;

public class DeleteCustomerServlet extends HttpServlet {

    private CustomerRepository customerRepository;

    @Override
    public void init() throws ServletException {
        customerRepository = InMemoryCustomerRepository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        String versionString = request.getParameter("version");
        if (idString == null) {
            throw new ServletException("No 'id' URL parameter");
        }
        if (versionString == null) {
            throw new ServletException("No 'version' URL parameter");
        }

        long id = Long.parseLong(idString);
        int version = Integer.parseInt(versionString);
        customerRepository.deleteCustomer(new Customer(id, version));

        response.sendRedirect(request.getContextPath() + "/customers/all.html");
    }
}
