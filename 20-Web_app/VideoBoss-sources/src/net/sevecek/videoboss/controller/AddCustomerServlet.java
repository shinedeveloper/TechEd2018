package net.sevecek.videoboss.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import net.sevecek.util.web.*;
import net.sevecek.videoboss.*;
import net.sevecek.videoboss.entity.*;
import net.sevecek.videoboss.repository.*;

public class AddCustomerServlet extends HttpServlet {

    private CustomerRepository customerRepository;
    private RequestDispatcher viewRenderer;


    @Override
    public void init() {
        viewRenderer = ServletUtils.prepareViewRenderer(
                getServletContext(), "customers/edit.jsp");
        customerRepository = InMemoryCustomerRepository.getInstance();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("customer", new Customer("", "", ""));
        request.setAttribute("postbackUrl", getServletContext().getContextPath() + "/customers/add.html");
        viewRenderer.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String address = request.getParameter("address");
        Customer newCustomer = new Customer(firstName, lastName, address);
        customerRepository.addCustomer(newCustomer);
        response.sendRedirect(request.getContextPath() + "/customers/all.html");
    }
}
