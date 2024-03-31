package com.mycompany.servlets;

import com.mycompany.model.HistoryMenager;
import com.mycompany.model.HistoryObject;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * The History servlet class provides methods for managing the history of
 * operations. It processes requests, retrieves the validation history from the
 * session, and increments the visit count using cookies.
 *
 * @author jfalkowski
 * @version 5.0
 */
@WebServlet(name = "HistoryServlet", urlPatterns = {"/HistoryServlet"})
public class HistoryServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HistoryMenager hm = new HistoryMenager();
            List<HistoryObject> history = hm.getObjectsFromDB();
            VisitCountCookies(request, response);

            request.setAttribute("history", history);
            request.getRequestDispatcher("/History.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/History.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * Increments the visitation count using cookies.
     *
     * @param request servlet request
     * @param response servlet response
     */
    private void VisitCountCookies(HttpServletRequest request, HttpServletResponse response) {
        int visitCount = 0;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }
        visitCount++;
        Cookie visitCountCookie = new Cookie("visitCount", String.valueOf(visitCount));
        visitCountCookie.setPath(request.getContextPath());
        response.addCookie(visitCountCookie);
    }

}
