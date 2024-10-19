import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class EmployeePaginationServlet extends HttpServlet {
    private List<String> employees = Arrays.asList("John", "Jane", "Alice", "Bob", "Charlie", "David", "Eva", "Frank");
    private static final int EMPLOYEES_PER_PAGE = 3;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page") != null ? request.getParameter("page") : "1");
        int start = (page - 1) * EMPLOYEES_PER_PAGE;
        int end = Math.min(start + EMPLOYEES_PER_PAGE, employees.size());

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<h1>Employees Page " + page + "</h1>");
        
        for (int i = start; i < end; i++) {
            out.println("<p>" + employees.get(i) + "</p>");
        }

        // Pagination controls
        out.println("<a href='EmployeePaginationServlet?page=" + (page - 1) + "'>Previous</a>");
        out.println("<a href='EmployeePaginationServlet?page=" + (page + 1) + "'>Next</a>");
    }
}
