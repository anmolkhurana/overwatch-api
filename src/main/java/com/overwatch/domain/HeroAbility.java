package com.overwatch.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hero_ability", catalog = "overwatchdb")
public class HeroAbility implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String description;
	private int health;
	private int armour;
	private int shield;
	private String real_name;
	private int age;
	private int height;
	private String affiliation;
	private int difficulty;
	private String url;
	private HeroData heroData;
	
	public HeroAbility() {
	
	}
	
	public HeroAbility(long id) {
		this.id = id;
	}
	
	public HeroAbility(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public HeroAbility(long id, String name, String description, int health, int armour, int shield, String real_name,
			int age, int height, String affiliation, int difficulty, String url) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.health = health;
		this.armour = armour;
		this.shield = shield;
		this.real_name = real_name;
		this.age = age;
		this.height = height;
		this.affiliation = affiliation;
		this.difficulty = difficulty;
		this.url = url;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "hero_data_id")
	public HeroData getHeroData() {
		return heroData;
	}

	public void setHeroData(HeroData heroData) {
		this.heroData = heroData;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "health")
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	@Column(name = "armour")
	public int getArmour() {
		return armour;
	}
	
	public void setArmour(int armour) {
		this.armour = armour;
	}
	
	@Column(name = "shield")
	public int getShield() {
		return shield;
	}
	
	public void setShield(int shield) {
		this.shield = shield;
	}
	
	@Column(name = "real_name")
	public String getReal_name() {
		return real_name;
	}
	
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	
	@Column(name = "age")
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Column(name = "heigth")
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Column(name = "affiliation")
	public String getAffiliation() {
		return affiliation;
	}
	
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	
	@Column(name = "difficulty", nullable = false)
	public int getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
}
