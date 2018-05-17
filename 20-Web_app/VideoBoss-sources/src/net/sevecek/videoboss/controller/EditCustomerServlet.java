package net.sevecek.videoboss.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import net.sevecek.util.web.*;
import net.sevecek.videoboss.*;
import net.sevecek.videoboss.entity.*;
import net.sevecek.videoboss.repository.*;

public class EditCustomerServlet extends HttpServlet {

    private CustomerRepository customerRepository;
    private RequestDispatcher viewRenderer;


    @Override
    public void init() {
        viewRenderer = ServletUtils.prepareViewRenderer(
                getServletContext(), "customers/edit.jsp");
        customerRepository = InMemoryCustomerRepository.getInstance();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        if (idString == null) {
            throw new ServletException("No 'id' URL parameter");
        }
        long id = Long.parseLong(idString);
        Customer customer = customerRepository.findCustomer(id);
        request.setAttribute("customer", customer);
        request.setAttribute("postbackUrl", getServletContext().getContextPath() + "/customers/edit.html?id=" + id);
        viewRenderer.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String address = request.getParameter("address");
        String version = request.getParameter("version");
        String isDeleted = request.getParameter("deleted");
        if (idString == null) {
            throw new ServletException("No 'id' URL parameter");
        }

        Customer customer = new Customer(
                new Long(idString),
                firstName,
                lastName,
                address,
                Boolean.parseBoolean(isDeleted),
                Integer.parseInt(version));
        customerRepository.updateCustomer(customer);

        response.sendRedirect(request.getContextPath() + "/customers/all.html");
    }
}
