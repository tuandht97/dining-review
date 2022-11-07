package com.example.diningreview.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "PEANUT_ALLERGY")
    private boolean isPeanutAllergy;
    @Column(name = "EGG_ALLERGY")
    private boolean isEggAllergy;
    @Column(name = "DAIRY_ALLERGY")
    private boolean isDairyAllergy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public boolean isPeanutAllergy() {
		return isPeanutAllergy;
	}
	public void setPeanutAllergy(boolean isPeanutAllergy) {
		this.isPeanutAllergy = isPeanutAllergy;
	}
	public boolean isEggAllergy() {
		return isEggAllergy;
	}
	public void setEggAllergy(boolean isEggAllergy) {
		this.isEggAllergy = isEggAllergy;
	}
	public boolean isDairyAllergy() {
		return isDairyAllergy;
	}
	public void setDairyAllergy(boolean isDairyAllergy) {
		this.isDairyAllergy = isDairyAllergy;
	}

}
