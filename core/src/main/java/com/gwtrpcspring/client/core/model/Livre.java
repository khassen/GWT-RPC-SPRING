package com.gwtrpcspring.client.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "LIVRE")
public class Livre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7724036772977951308L;

	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "LIV_SEQ")
	@SequenceGenerator(name = "LIV_SEO", sequenceName = "LIV_SEQ")
	@Id
	private Long id;

	@Column(name = "TITRE", nullable = false, length = 150)
	private String titre;

	public Livre() {
		super();
	}

	public Livre(Long id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	}

	public Livre(String titre) {
		super();
		this.titre = titre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "Livre [titre=" + titre + "]";
	}

}
