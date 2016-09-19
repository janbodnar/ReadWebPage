package com.zetcode.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;

public class ReadPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        
        String webPage = request.getParameter("url");

        try (PrintWriter out = response.getWriter()) {

            String html = Jsoup.connect(webPage).get().html();

            out.println(html);
        }
    }
}
