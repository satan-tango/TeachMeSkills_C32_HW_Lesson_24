package com.varkovich.lesson_24.servlet;

import com.varkovich.lesson_24.logger.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tasks")
public class TasksServlet extends HttpServlet {
    @Override
    public void init() {
        Logger.logInfo("Servlet 'TasksServlet' has been created.");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Logger.logInfo("Servlet 'TasksServlet' has started to process request.");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Settings</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<nav class='navbar'>");
        writer.println("<ul class='link-group'>");
        writer.println("<li class='link'><a href='/'>Welcome page</a></li>");
        writer.println("<li class='link'><a href='/count'>Counter</a></li>");
        writer.println("<li class='link'><a href='/setting'>Settings</a></li>");
        writer.println("<li class='link'><a href='/logs'>Logs</a></li>");
        writer.println("</ul>");
        writer.println("</nav>");
        writer.println("<h1 class='main-heading'>Goals</h1>");
        writer.println("<h3 class='main-heading'>Sport</h3>");
        writer.println("<ul class='settings-group'>");
        writer.println("<li>Bench press 140kg</li>");
        writer.println("<li>Marathon</li>");
        writer.println("<li>Boxing competition</li>");
        writer.println("</ul>");

        writer.println("<h3 class='main-heading'>Studying</h3>");
        writer.println("<ul class='settings-group'>");
        writer.println("<li>English C1 level</li>");
        writer.println("</ul>");

        writer.println("<h3 class='main-heading'>Works</h3>");
        writer.println("<ul class='settings-group'>");
        writer.println("<li>Change work area</li>");
        writer.println("</ul>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    public void destroy() {
        Logger.logInfo("Servlet 'TasksServlet' has been destroyed.");
    }
}
