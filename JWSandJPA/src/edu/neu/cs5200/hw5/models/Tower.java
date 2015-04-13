package edu.neu.cs5200.hw5.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Tower {
	@Id
	private Integer id;
	private String name;
	private String height;
	private String sides;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="siteId")
	private Site site;
	@OneToMany(mappedBy="tower")
	private List<Equipment> equipments;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getSides() {
		return sides;
	}
	public void setSides(String sides) {
		this.sides = sides;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public Tower(Integer id, String name, String height, String sides, Site site) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
		this.site = site;
	}
	public Tower() {
		super();
	}
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

}
