package servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@MultipartConfig
@WebServlet("/upload")
public class upload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
    	Part part = req.getPart("photo");
    	String name = part.getSubmittedFileName(); // tên file
    	long size = part.getSize(); // kích thước file
    	String type = part.getContentType(); // kiểu file

    	// tạo thư mục nếu chưa có
    	String folder = req.getServletContext().getRealPath("/files");
    	File dir = new File(folder);
    	if (!dir.exists()) dir.mkdirs();

    	String filename = folder + File.separator + name;
    	part.write(filename); // lưu vào file trên server

    	resp.setCharacterEncoding("utf-8");
    	resp.setContentType("application/json");
    	String format = "{\"name\": \"%s\", \"type\": \"%s\", \"size\": %d}";
    	String responseData = String.format(format, name, type, size);
    	resp.getWriter().print(responseData);


    }
}
