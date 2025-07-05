package entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Logs")
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Url")
	private String url;
	@Column(name = "AccessTime")
	private LocalDateTime accessTime;
	@Column(name = "Username")
	private String username;
}
