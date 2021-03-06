package org.example.spring.mvc.servlet;
import org.example.spring.mvc.jdbc.StudentHomeworkJdbc;
import org.example.spring.mvc.bean.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hand")
public class HandinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        List<StudentHomework> sh =  StudentHomeworkJdbc.selectALL();
        req.setAttribute("studenthomeworklist",sh);
        req.getRequestDispatcher("handin.jsp").forward(req,resp);
    }
}
