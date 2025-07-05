package Entity;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Video", schema = "dbo")
public class Video {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Poster")
    private String poster;

    @Column(name = "Views")
    private Integer views;

    @Column(name = "Description")
    private String description;

    @Column(name = "Active")
    private Boolean active;
//mappedby video là biến của favorite 
    @OneToMany(mappedBy = "video")
    private List<Favorite> favorites;
    
    @OneToMany(mappedBy = "video")
    private List<Share> shares;

}
