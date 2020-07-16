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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Product{
	
	@EqualsAndHashCode.Include
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@SequenceGenerator(name = "product_generator", sequenceName = "product_seq")
	private Integer id;

	@Getter
	@Setter
	@Column(name = "name", nullable = false)
	private String name;
	
	@Getter
	@Setter
	@Column(name = "type", nullable = false)
	private ProductType type;
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(name="restaurant_id", referencedColumnName="id")
	private Restaurant restaurant;
}
