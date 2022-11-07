package com.example.diningreview.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DINING_REVIEW")
@Getter
@Setter
@NoArgsConstructor
public class DiningReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "REVIEWED_BY")
    private String reviewedBy;
    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;
    @Column(name = "PEANUT_SCORE")
    private Integer peanutScore;
    @Column(name = "EGG_SCORE")
    private Integer eggScore;
    @Column(name = "DAIRY_SCORE")
    private Integer dairyScore;
    @Column(name = "COMMENTARY")
    private String commentary;
    @Column(name = "REVIEW_STATUS")
    @Enumerated(EnumType.STRING)
    private AdminReviewStatus adminReviewStatus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReviewedBy() {
		return reviewedBy;
	}
	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Integer getPeanutScore() {
		return peanutScore;
	}
	public void setPeanutScore(Integer peanutScore) {
		this.peanutScore = peanutScore;
	}
	public Integer getEggScore() {
		return eggScore;
	}
	public void setEggScore(Integer eggScore) {
		this.eggScore = eggScore;
	}
	public Integer getDairyScore() {
		return dairyScore;
	}
	public void setDairyScore(Integer dairyScore) {
		this.dairyScore = dairyScore;
	}
	public String getCommentary() {
		return commentary;
	}
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	public AdminReviewStatus getAdminReviewStatus() {
		return adminReviewStatus;
	}
	public void setAdminReviewStatus(AdminReviewStatus adminReviewStatus) {
		this.adminReviewStatus = adminReviewStatus;
	}
    
    

}
