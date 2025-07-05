package Entity;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "[User]", schema = "dbo")
public class User{
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullname; 

	@Column(name = "email")
	private String email;

	@Column(name = "admin")
	private Boolean admin = false;
	
	@OneToMany(mappedBy = "user")
	private List<Favorite> favorites;
}
