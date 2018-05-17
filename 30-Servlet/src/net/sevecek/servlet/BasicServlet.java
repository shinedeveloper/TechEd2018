package net.sevecek.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("  <h1>The servlet is alive and kicking!</h1>");
        out.println("  <h2>");
        out.println("   Liveliness demonstrated by random number:");
        out.println((int)(Math.random()*100.0));
        out.println("  </h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}
