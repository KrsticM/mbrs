package ftn.uns.ac.rs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "restaurant")
public class Restaurant{
	
	@EqualsAndHashCode.Include
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_generator")
	@SequenceGenerator(name = "restaurant_generator", sequenceName = "restaurant_seq")	
    private Integer id;

    @Getter
	@Setter
    @Column(name = "name", nullable = false, unique = true)
    private String name;    
    
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(nullable = false)
	private Category category;
    
    @Getter
	@Setter
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Product> products = new HashSet<Product>();
    
  }
