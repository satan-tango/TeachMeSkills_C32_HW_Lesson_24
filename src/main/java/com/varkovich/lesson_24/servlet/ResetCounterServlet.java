package com.varkovich.lesson_24.servlet;

import com.varkovich.lesson_24.logger.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reset")
public class ResetCounterServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        Logger.logInfo("Servlet 'ResetCounterServlet' has been created.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.logInfo("Servlet 'ResetCounterServlet' has started to process request.");
        HttpSession session = req.getSession();
        session.setAttribute("counter", null);

        resp.sendRedirect(req.getContextPath() + "/count");
    }

    @Override
    public void destroy() {
        Logger.logInfo("Servlet 'ResetCounterServlet' has been destroyed.");
    }
}
