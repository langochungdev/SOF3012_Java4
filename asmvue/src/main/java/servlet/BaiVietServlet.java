package servlet;
import dao.BaiVietDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import model.BaiViet;
import utils.RestIO;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/baiviet")
public class BaiVietServlet extends HttpServlet {
    BaiVietDAO dao = new BaiVietDAO();

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
        String maNguoiDung = req.getParameter("maNguoiDung");

        if (id != null) {
            BaiViet bv = dao.findById(id);
            RestIO.writeObject(resp, bv);
        } else if (maNguoiDung != null) {
            List<BaiViet> list = dao.findByNguoiDung(maNguoiDung);
            RestIO.writeObject(resp, list);
        } else {
            List<BaiViet> list = dao.findAll();
            RestIO.writeObject(resp, list);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        enableCORS(req, resp);
        BaiViet bv = RestIO.readObject(req, BaiViet.class);
        dao.create(bv);
        RestIO.writeEmptyObject(resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        enableCORS(req, resp);
        BaiViet bv = RestIO.readObject(req, BaiViet.class);
        dao.update(bv);
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
