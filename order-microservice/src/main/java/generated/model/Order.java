package generated.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Geteri i seteri su iznad polja kako bismo mogli staviti u modelu da se za svako
 * polje bira hoce li getter i setter.
 * 
 * Equals i hash include ide samo iznad ključa.
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "restaurant_order") //order nije dozvoljena rec isto kao user
public class Order {
	@EqualsAndHashCode.Include
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
	@SequenceGenerator(name = "order_generator", sequenceName = "order_seq")	
    private Integer id;
	
	@Getter
	@Setter
	@Column(nullable = false)
	private Date dateOrdered;
	
	@Getter
	@Setter
	@Column(nullable = false)
	private Integer restaurant; //jer pripada drugom mikroservisu
	
	@Getter
	@Setter
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<OrderItem> items = new HashSet<OrderItem>();
}
