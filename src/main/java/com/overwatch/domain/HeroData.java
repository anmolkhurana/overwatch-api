package com.overwatch.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "hero_data", catalog = "overwatchdb")
public class HeroData implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String description;
	private String url;
	private Hero hero;
	private HeroAbility heroAbilities;
	
	public HeroData() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "hero_id")
	@JsonBackReference
	public Hero getHero() {
		return this.hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="hero_data_id")
	public HeroAbility getHeroAbilities() {
		return heroAbilities;
	}

	public void setHeroAbilities(HeroAbility heroAbilities) {
		this.heroAbilities = heroAbilities;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

