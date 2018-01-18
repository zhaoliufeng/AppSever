package servlet;

import bean.Admin;
import conts.ReqCode;
import db.AdminDAO;
import db.VersionDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        switch (Integer.valueOf(req.getParameter(ReqCode.OP_CODE))) {
            case ReqCode.ADMIN_LOGIN:
                loginAdmin(req, resp);
                break;
            case ReqCode.ADMIN_ADD:
                addAdmin(req, resp);
                break;
        }
    }

    private void loginAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin = AdminDAO.getAdminInfo(req.getParameter("name"));
        if (admin.mPw.equals(req.getParameter("pw"))){
            //验证通过
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    private void addAdmin(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
