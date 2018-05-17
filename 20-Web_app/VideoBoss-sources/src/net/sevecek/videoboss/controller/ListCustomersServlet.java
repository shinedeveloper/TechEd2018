package net.sevecek.videoboss.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sevecek.util.web.ServletUtils;
import net.sevecek.videoboss.*;
import net.sevecek.videoboss.entity.Customer;
import net.sevecek.videoboss.repository.*;

public class ListCustomersServlet extends HttpServlet {

    private CustomerRepository customerRepository;
    private RequestDispatcher viewRenderer;


    @Override
    public void init() {
        viewRenderer = ServletUtils.prepareViewRenderer(
                getServletContext(), "customers/all.jsp");
        customerRepository = InMemoryCustomerRepository.getInstance();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> allCustomers = customerRepository.findAllCustomers(0, -1);
        request.setAttribute("customers", allCustomers);
        viewRenderer.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
