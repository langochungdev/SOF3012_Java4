package servlet;
import dao.BinhLuanDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import model.BinhLuan;
import utils.RestIO;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/api/binhluan")
public class BinhLuanServlet extends HttpServlet {
    BinhLuanDAO dao = new BinhLuanDAO();

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
        String idBaiViet = req.getParameter("maBaiViet");

        if (id != null) {
            BinhLuan bl = dao.findById(id);
            RestIO.writeObject(resp, bl);
        } else if (idBaiViet != null) {
            List<BinhLuan> list = dao.findByBaiVietId(idBaiViet);
            RestIO.writeObject(resp, list);
        } else {
            List<BinhLuan> list = dao.findAll();
            RestIO.writeObject(resp, list);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        enableCORS(req, resp);
        BinhLuan bl = RestIO.readObject(req, BinhLuan.class);
        bl.setNgayTao(new Date());
        dao.create(bl);
        RestIO.writeEmptyObject(resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        enableCORS(req, resp);
        BinhLuan bl = RestIO.readObject(req, BinhLuan.class);
        dao.update(bl);
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
