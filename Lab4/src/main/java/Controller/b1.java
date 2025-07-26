package Controller;

import java.util.List;
import DAO.UserDAOImpl;
import DAO.VideoDAOImpl;
import Entity.User;
import Entity.Video;

public class b1 {
	static void p(String s) {
		System.out.println(s);
	}
	public static void main(String[] args) {
		UserDAOImpl userDAO = new UserDAOImpl();
		VideoDAOImpl videoDAO = new VideoDAOImpl();

		String idOrEmail = "1";
		User user = userDAO.findByIdOrEmail(idOrEmail);
		p("User tim theo id hoac mail: " + user.getFullname());

		String keyword = "1";
		List<Video> videos = videoDAO.findByKeyword(keyword);
		for (Video v : videos) {
			p("Tìm video theo từ khóa" + v.getTitle());
		}

		List<Video> topVideos = videoDAO.findTop10MostFavorited();
		for (Video v : topVideos) {
			p("video được yêu thích nhất: " + v.getTitle());
		}

		List<Video> notFavorited = videoDAO.findNotFavorited();
		for (Video v : notFavorited) {
			p("video ko ai thích: " + v.getTitle());
		}

		List<Video> shared2024 = videoDAO.findSharedIn2024();
		for (Video v : shared2024) {
			p("Video được chia sẻ trong năm 2024" + v.getTitle());
		}
	}
}
