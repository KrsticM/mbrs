package ftn.uns.ac.rs.model;

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

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_generator")
	@SequenceGenerator(name = "restaurant_generator", sequenceName = "restaurant_seq")
	@EqualsAndHashCode.Include
	@Getter
	@Setter
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    @Getter
	@Setter
    private String name;    
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
    @Getter
    @Setter
	private Category category;
    
  }
