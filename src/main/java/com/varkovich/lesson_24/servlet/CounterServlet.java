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

@WebServlet("/count")
public class CounterServlet extends HttpServlet {
    @Override
    public void init()  {
        Logger.logInfo("Servlet 'CounterServlet' has been created.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.logInfo("Servlet 'CounterServlet' has started to process request.");
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Settings</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<nav class='navbar'>");
        writer.println("<ul class='link-group'>");
        writer.println("<li class='link'><a href='/'>Welcome page</a></li>");
        writer.println("<li class='link'><a href='setting'>Settings</a></li>");
        writer.println("<li class='link'><a href='tasks'>Tasks</a></li>");
        writer.println("<li class='link'><a href='/logs'>Logs</a></li>");
        writer.println("</ul>");
        writer.println("</nav>");

        Integer counter = (Integer) session.getAttribute("counter");
        if (counter != null) {
            counter = counter + 1;
            session.setAttribute("counter", counter);
            writer.println("<h1 class='main-heading'>Number of page visits: " + counter + "</h1>");
        } else {
            counter = 1;
            session.setAttribute("counter", 1);
            writer.println("<h1 class='main-heading'>Number of page visits: " + counter + "</h1>");
        }

        writer.println("<a href='/reset'>Reset visitor counter</a>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    public void destroy() {
        Logger.logInfo("Servlet 'CounterServlet' has been destroyed.");
    }

}
