package com.varkovich.lesson_24.servlet;

import com.varkovich.lesson_24.constants.Constants;
import com.varkovich.lesson_24.logger.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@WebServlet("/logs")
public class LoggerServlet extends HttpServlet {

    @Override
    public void init() {
        Logger.logInfo("Servlet 'LoggerServlet' has been created.");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Logger.logInfo("Servlet 'LoggerServlet' has started to process request.");
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
        writer.println("<li class='link'><a href='/tasks'>Tasks</a></li>");
        writer.println("</ul>");
        writer.println("</nav>");


        try {
            List<String> logList = Files.readAllLines(Paths.get(Constants.PATH_LOG));
            writer.println("<h2>Logs</h2>");
            for (String log : logList) {
                writer.println("<p>" + log + "</p>");
            }
        } catch (IOException e) {
            try {
                writer = response.getWriter();
                writer.println("Log file has been not found.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
        Logger.logInfo("Servlet 'LoggerServlet' has been destroyed.");
    }

}
