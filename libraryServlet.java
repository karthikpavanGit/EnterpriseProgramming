import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LibraryServlet extends HttpServlet {
    private List<String> books = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<h1>Library Books</h1>");
        for (String book : books) {
            out.println("<p>" + book + "</p>");
        }

        out.println("<form action='LibraryServlet' method='POST'>");
        out.println("Add Book: <input type='text' name='bookName'><br>");
        out.println("<input type='submit' value='Add Book'>");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        books.add(bookName);
        doGet(request, response);
    }
}
