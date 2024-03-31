/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package book;

import business.Book;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the parameters from the form
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("publish");

        // Create a new Book object with the provided information
        Book book = new Book(title, author, isbn);

        // Retrieve the list of books from the ServletContext
        List<Book> bookList = (List<Book>) getServletContext().getAttribute("bookList");

        // If the list doesn't exist, create a new one and store it in the ServletContext
        if (bookList == null) {
            bookList = new ArrayList<>();
            getServletContext().setAttribute("bookList", bookList);
        }

        // Add the new book to the list
        bookList.add(book);

        // Set response content type
        response.setContentType("text/html");

        // Print the result
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Book added successfully!</h2>");
        out.println("<p>Title: " + title + "</p>");
        out.println("<p>Author: " + author + "</p>");
        out.println("<p>ISBN: " + isbn + "</p>");
        out.println("</body></html>");
    }
}
