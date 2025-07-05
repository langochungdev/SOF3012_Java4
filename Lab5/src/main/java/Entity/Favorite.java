package Entity;
import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Data 
@NoArgsConstructor
@AllArgsConstructor
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
}
