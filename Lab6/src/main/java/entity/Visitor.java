package entity;
import jakarta.persistence.*;
import lombok.*;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Visitors", schema = "dbo")
public class Visitor {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "count")
	private int count;
}
