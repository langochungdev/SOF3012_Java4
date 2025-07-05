package entity;
import java.util.List;
import jakarta.persistence.*;
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
