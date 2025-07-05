package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/api/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploaded";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

        Part filePart = req.getPart("file");
        String fileName = getFileName(filePart);

        String appPath = req.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + UPLOAD_DIR;

        File uploadDir = new File(savePath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        filePart.write(savePath + File.separator + fileName);

        resp.setContentType("application/json");
        resp.getWriter().write("{\"link\":\"" + req.getContextPath() + "/uploaded/" + fileName + "\"}");
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String cd : contentDisp.split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
