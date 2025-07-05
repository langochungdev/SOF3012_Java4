package Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
