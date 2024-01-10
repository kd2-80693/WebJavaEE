package com.app.pojos;

import javax.persistence.*;

/*
 * #teams : id , name, abbrevation,owner,
 * max_age,batting_avg,wickets_taken	
 * */

@Entity
@Table(name = "teams")
public class Teams {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private Integer id;
	@Column(length = 20,unique = true , nullable = false )
	private String name;
	@Column(length = 10,unique = true , nullable = false)
	private String abbrevation;
	@Column(length=20 , nullable = false)
	private String owner;
	@Column(name = "max_age" , nullable = false)
	private int maxAge;
	@Column(name = "batting_avg" , nullable = false)
	private double battingAverage;
	@Column(name = "wickets_taken" , nullable = false)
	private int wicketsTaken;
	
	public Teams() {
	}
	
	public Teams(Integer id, String abbrevation) {
		super();
		this.id = id;
		this.abbrevation = abbrevation;
	}

	public Teams( String name, String abbrevation, String owner, int maxAge, double battingAverage,
			int wicketsTaken) {
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAverage = battingAverage;
		this.wicketsTaken = wicketsTaken;
	}
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
	public String getAbbrevation() {
		return abbrevation;
	}
	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public double getBattingAverage() {
		return battingAverage;
	}
	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}
	public int getWic1ketsTaken() {
		return wicketsTaken;
	}
	public void setWic1ketsTaken(int wic1ketsTaken) {
		this.wicketsTaken = wic1ketsTaken;
	}
	@Override
	public String toString() {
		return "Teams [id=" + id + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner + ", maxAge="
				+ maxAge + ", battingAverage=" + battingAverage + ", wicketsTaken=" + wicketsTaken + "]";
	}
	
	
}
