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
import java.util.List;

/**
 *
 * @author ASUS
 */
public class GetBookListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetBookListServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetBookListServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        List<Book> bookList = (List<Book>) getServletContext().getAttribute("bookList");
        getServletContext().setAttribute("bookList", bookList);
        // Set response content type to JSON
        response.setContentType("application/json");

        // Convert book list to JSON format
        String json = convertBookListToJson(bookList);

        // Send JSON response
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    
      
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    

    // Method to convert book list to JSON format
    private String convertBookListToJson(List<Book> bookList) {
        StringBuilder json = new StringBuilder("[");
        if (bookList != null && !bookList.isEmpty()) {
            for (int i = 0; i < bookList.size(); i++) {
                Book book = bookList.get(i);
                json.append("{");
                json.append("\"title\":\"").append(book.getBookName()).append("\",");
                json.append("\"author\":\"").append(book.getAuthor()).append("\",");
                json.append("\"isbn\":\"").append(book.getPublish()).append("\"");
                json.append("}");
                if (i < bookList.size() - 1) {
                    json.append(",");
                }
            }
        }
        json.append("]");
        return json.toString();
    }

}
