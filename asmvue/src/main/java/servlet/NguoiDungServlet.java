package servlet;

import dao.NguoiDungDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import model.NguoiDung;
import utils.RestIO;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/nguoidung")
public class NguoiDungServlet extends HttpServlet {
    NguoiDungDAO dao = new NguoiDungDAO();

    private void enableCORS(HttpServletRequest req, HttpServletResponse resp) {
        String origin = req.getHeader("Origin");
        resp.setHeader("Access-Control-Allow-Origin", origin != null ? origin : "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        enableCORS(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        enableCORS(req, resp);
        String id = req.getParameter("id");
        if (id != null) {
            NguoiDung nd = dao.findById(id);
            RestIO.writeObject(resp, nd);
        } else {
            List<NguoiDung> list = dao.findAll();
            RestIO.writeObject(resp, list);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        enableCORS(req, resp);
        NguoiDung nd = RestIO.readObject(req, NguoiDung.class);
        dao.create(nd);
        RestIO.writeEmptyObject(resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        enableCORS(req, resp);
        NguoiDung nd = RestIO.readObject(req, NguoiDung.class);
        dao.update(nd);
        RestIO.writeEmptyObject(resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        enableCORS(req, resp);
        String id = req.getParameter("id");
        dao.deleteById(id);
        RestIO.writeEmptyObject(resp);
    }
}
