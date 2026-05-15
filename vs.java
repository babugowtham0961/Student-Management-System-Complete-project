// ViewStudentServlet.java

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out=response.getWriter();

        out.println("<html><body>");

        out.println("<table border='1'>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Age</th>");
        out.println("<th>Course</th>");
        out.println("</tr>");

        try{

            Connection con=DBConnection.getConnection();

            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery("select * from students");

            while(rs.next()){

                out.println("<tr>");

                out.println("<td>"+rs.getInt("id")+"</td>");
                out.println("<td>"+rs.getString("name")+"</td>");
                out.println("<td>"+rs.getInt("age")+"</td>");
                out.println("<td>"+rs.getString("course")+"</td>");

                out.println("</tr>");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}