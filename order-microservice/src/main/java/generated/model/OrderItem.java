package generated.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "order_item")
public class OrderItem {
	@EqualsAndHashCode.Include
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_generator")
	@SequenceGenerator(name = "order_item_generator", sequenceName = "order_item_seq")	
    private Integer id;
	
	@Getter
	@Setter
	@Column(nullable = false)
	private Integer quantity;
	
	@Getter
	@Setter
	@Column(nullable = false)
	private Integer product; //jer pripada drugom mikroservisu
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(name="order_id", referencedColumnName="id")
	private Order order;
}
