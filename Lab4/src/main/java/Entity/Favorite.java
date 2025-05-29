package Entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Favorite", schema = "dbo")
public class Favorite {

    @Id
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video video;

    @Column(name = "LikeDate")
    private Date likeDate;

    public Favorite() {
    }

    public Favorite(Long id, User user, Video video, Date likeDate) {
        this.id = id;
        this.user = user;
        this.video = video;
        this.likeDate = likeDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }
}
