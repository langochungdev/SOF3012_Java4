package Entity;
import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Share", schema = "dbo")
public class Share {
    @Id
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video video;

    @Column(name = "Emails")
    private String smails;
    
    @Column(name = "ShareDate")
    private Date shareDate;
}
