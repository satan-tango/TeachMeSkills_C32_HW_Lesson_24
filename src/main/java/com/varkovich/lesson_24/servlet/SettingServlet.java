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

@WebServlet("/setting")
public class SettingServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        Logger.logInfo("Servlet 'SettingServlet' has been created.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.logInfo("Servlet 'SettingServlet' has started to process request.");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Settings</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<nav class='navbar'>");
        writer.println("<ul class='link-group'>");
        writer.println("<li class='link'><a href='/'>Welcome page</a></li>");
        writer.println("<li class='link'><a href='/count'>Counter</a></li>");
        writer.println("<li class='link'><a href='/tasks'>Tasks</a></li>");
        writer.println("<li class='link'><a href='/logs'>Logs</a></li>");
        writer.println("</ul>");
        writer.println("</nav>");
        writer.println("<h1 class='main-heading'>Application Settings</h1>");
        writer.println("<ul class='settings-group'>");
        writer.println("<li>Application name: " + getServletContext().getInitParameter("appName") + "</li>");
        writer.println("<li>Application version: " + getServletContext().getInitParameter("appVersion") + "</li>");
        writer.println("<li>Developer name: " + getServletContext().getInitParameter("developerName") + "</li>");
        writer.println("<li>Support email: " + getServletContext().getInitParameter("supportEmail") + "</li>");
        writer.println("</ul>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    public void destroy() {
        Logger.logInfo("Servlet 'SettingServlet' has been destroyed.");
    }
}
