package com.overwatch.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "hero", catalog = "overwatchdb")
public class Hero implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private int total;
	private String first;
	private String next;
	private String previous;
	private String last;
	private Set<HeroData> heroDatas = new HashSet<HeroData>(0);
	
	public Hero() {
	}
	
	public Hero(long id, int total) {
		this.id = id;
		this.total = total;
	}

	public Hero(long id, String first, String last, String next, String previous, int total, Set<HeroData> heroDatas) {
		this.id = id;
		this.first = first;
		this.last = last;
		this.next = next;
		this.previous = previous;
		this.total = total;
		this.heroDatas = heroDatas;
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

	@Column(name = "first")
	public String getFirst() {
		return this.first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	@Column(name = "last")
	public String getLast() {
		return this.last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Column(name = "next")
	public String getNext() {
		return this.next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	@Column(name = "previous")
	public String getPrevious() {
		return this.previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	@Column(name = "total", nullable = false)
	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="hero_id")
	@JsonBackReference
	public Set<HeroData> getHeroDatas() {
		return this.heroDatas;
	}

	public void setHeroDatas(Set<HeroData> heroDatas) {
		this.heroDatas = heroDatas;
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", total=" + total + ", first=" + first + ", next=" + next + ", previous=" + previous
				+ ", last=" + last + ", heroDatas=" + heroDatas + "]";
	}
}
