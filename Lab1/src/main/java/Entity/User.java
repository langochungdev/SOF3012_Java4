package entity;
import jakarta.persistence.*;
import lombok.*;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User{
	@Id
	@Column(name = "id")
	String id;
	@Column(name = "password")
	String password;
	@Column(name = "fullname")
	String fullname;
	@Column(name = "email")
	String email;
	@Column(name = "admin")
	Boolean admin = false;
}
