package servlet;

import conts.ReqCode;
import db.VersionDAO;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class VersionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        switch (Integer.valueOf(req.getParameter(ReqCode.OP_CODE))) {
            case ReqCode.VERSION_REQUEST_CODE:
                getVersionCode(req, resp);
                break;
            case ReqCode.VERSION_SET_CODE:
                updateVersionInfo(req, resp);
                break;
        }
    }

    private void getVersionCode(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", VersionDAO.getVersion());
        PrintWriter out = resp.getWriter();
        out.print(jsonObject);
        out.close();
    }

    private void updateVersionInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int version = Integer.parseInt(req.getParameter("version"));
        String link = req.getParameter("link");
        if (version != 0){
            VersionDAO.updateVersion(version);
        }

        if (link != null){
            VersionDAO.updateUpdateLink(link);
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
