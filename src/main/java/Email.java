import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration; 

public class Email extends HttpServlet {
    int accesses = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // If you don't want to print page content, but instead send the
        // user to another web page use this -
        // response.sendRedirect(request.getContextPath() + "/destination.html");

        out.print("<html><body><h1>Result</h1>");
        // This is just an example, but you could use this class
        // to help debug forms.
        Enumeration<String> params = request.getParameterNames();
        while(params.hasMoreElements()){
            String name = params.nextElement(); 
            out.print("<p>" + name + "=" + request.getParameterValues(name)[0] + "</p>");
        }
        // Normally you would just write something like -
        // String password = request.getParameterValues("password")[0];
        // Note that you get an array of values returned as HTML forms are 
        // allowed to return multiple values for each parameter. Taking the
        // first value is usually the right thing to do.

        out.print("</body></html>");
    }
} 