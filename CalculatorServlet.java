import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Generate form for user input
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<form action='CalculatorServlet' method='POST'>");
        out.println("Number 1: <input type='text' name='num1'><br>");
        out.println("Number 2: <input type='text' name='num2'><br>");
        out.println("Operation: <select name='operation'>");
        out.println("<option value='add'>Add</option>");
        out.println("<option value='subtract'>Subtract</option>");
        out.println("<option value='multiply'>Multiply</option>");
        out.println("<option value='divide'>Divide</option>");
        out.println("</select><br>");
        out.println("<input type='submit' value='Calculate'>");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process the calculation
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        String operation = request.getParameter("operation");

        int result = 0;
        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                result = num1 / num2;
                break;
        }

        out.println("<h1>Result: " + result + "</h1>");
    }
}
