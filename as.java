// AddStudentServlet.java

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name=request.getParameter("name");
        int age=Integer.parseInt(request.getParameter("age"));
        String course=request.getParameter("course");

        try{

            Connection con=DBConnection.getConnection();

            String sql="insert into students(name,age,course) values(?,?,?)";

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,name);
            ps.setInt(2,age);
            ps.setString(3,course);

            ps.executeUpdate();

            response.sendRedirect("ViewStudentServlet");

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}