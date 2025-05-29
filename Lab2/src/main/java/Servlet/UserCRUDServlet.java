package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import DAO.UserDAOImpl;
import DAO.UserDAO;
import Entity.User;

@WebServlet({ "/user/crud/index", "/user/crud/edit/*", "/user/crud/create", "/user/crud/update", "/user/crud/delete",
		"/user/crud/reset" })
public class UserCRUDServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO dao = new UserDAOImpl();
		User form = new User();
		try {
			BeanUtils.populate(form, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		String message = "Nhập thông tin người dùng";
		String path = req.getServletPath();
		
		if (path.contains("edit")) {
			String id = req.getPathInfo() != null ? req.getPathInfo().substring(1) : "";
			form = dao.findById(id);
			message = "Chỉnh sửa người dùng: " + id;
		} else if (path.contains("create")) {
			if (!form.getId().isEmpty()) {
				dao.create(form);
				message = "Tạo thành công";
				form = new User();
			} else {
				message = "ID ko bỏ trống";
			}
		} else if (path.contains("update")) {
			if (!form.getId().isEmpty()) {
				dao.update(form);
				message = "Cập nhật thành công";
			} else {
				message = "ID ko bỏ trống";
			}
		} else if (path.contains("delete")) {
			if (!form.getId().isEmpty()) {
				dao.deleteById(form.getId());
				message = "Xóa người thành công";
				form = new User();
			} else {
				message = "ID ko bỏ trống";
			}
		} else if (path.contains("reset")) {
			form = new User();
			message = "Đã reset form";
		}

		
//		List<User> list = List.of(new User(), new User(), new User());
//		req.setAttribute("users", list);
		List<User> list = dao.findAll();

		req.setAttribute("message", message);
		req.setAttribute("user", form);
		req.getRequestDispatcher("/pages/user-crud.jsp").forward(req, resp);
	}
}
