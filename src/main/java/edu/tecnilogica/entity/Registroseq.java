package edu.tecnilogica.entity;
// Generated 27-jun-2017 12:19:36 by Hibernate Tools 5.1.4.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Registroseq generated by hbm2java
 */
@Entity
@Table(name = "REGISTROSEQ", schema = "HR")
@SequenceGenerator(name = "generador", initialValue = 1, allocationSize = 1)
public class Registroseq implements java.io.Serializable {

	private BigDecimal id;

	public Registroseq() {
	}

	public Registroseq(BigDecimal id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador")
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

}
