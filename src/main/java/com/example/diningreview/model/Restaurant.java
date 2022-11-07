package com.example.diningreview.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT")
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "CUISINE")
    private String cuisine;
    @Column(name="PEANUT")
    private Float peanutScore;
    @Column(name="EGG")
    private Float eggScore;
    @Column(name="DIARY")
    private Float diaryScore;
    @Column(name="SCORE")
    private Float score;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public Float getPeanutScore() {
		return peanutScore;
	}
	public void setPeanutScore(Float peanutScore) {
		this.peanutScore = peanutScore;
	}
	public Float getEggScore() {
		return eggScore;
	}
	public void setEggScore(Float eggScore) {
		this.eggScore = eggScore;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Float getDiaryScore() {
		return diaryScore;
	}
	public void setDiaryScore(Float diaryScore) {
		this.diaryScore = diaryScore;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public Restaurant() {}
	
	public Restaurant(Long id, String name, String city, String zipCode, String cuisine, Float peanutScore,
			Float eggScore, Float diaryScore, Float score) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.zipCode = zipCode;
		this.cuisine = cuisine;
		this.peanutScore = peanutScore;
		this.eggScore = eggScore;
		this.diaryScore = diaryScore;
		this.score = score;
	}
	
}
