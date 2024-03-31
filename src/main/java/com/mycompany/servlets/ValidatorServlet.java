package com.mycompany.servlets;

import com.mycompany.model.HistoryMenager;
import com.mycompany.model.HistoryObject;
import com.mycompany.model.Validator;
import com.mycompany.model.ValidatorException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * The Validator servlet class provides methods for handling validation
 * requests. It processes requests, manages validation history, and counts
 * validation errors using cookies.
 *
 * @author jfalkowski
 * @version 5.0
 */
@WebServlet(name = "ValidatorServlet", urlPatterns = {"/ValidatorServlet"})
public class ValidatorServlet extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Validation.jsp");
        dispatcher.forward(request, response);

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String input = request.getParameter("inputTextBox");

            try {
                if (!input.matches("\\d+")) {
                    ErrorCountCookies(request, response);
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please enter only numbers.");
                    return;
                }
                Validator validator = new Validator(input);
                Object result = validator.numberHandler();
                String resultString = result.toString();
                HistoryObject he = new HistoryObject(input, resultString);
                HistoryMenager hm = new HistoryMenager();
                hm.persistObject(he);

                request.setAttribute("validationResult", resultString);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Validation.jsp");
                dispatcher.forward(request, response);

            } catch (ValidatorException e) {
                ErrorCountCookies(request, response);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Validation Error: " + e.getMessage());

            }
        }
    }

    /**
     * Increments the error count using cookies.
     *
     * @param request servlet request
     * @param response servlet response
     */
    private void ErrorCountCookies(HttpServletRequest request, HttpServletResponse response) {
        int errorCount = 0;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("errorCount")) {
                    errorCount = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }
        errorCount++;
        Cookie errorCountCookie = new Cookie("errorCount", String.valueOf(errorCount));
        errorCountCookie.setPath(request.getContextPath());
        response.addCookie(errorCountCookie);
    }
}
