package com.example.diningreview.repositories;

import com.example.diningreview.model.AdminReviewStatus;
import com.example.diningreview.model.DiningReview;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

public interface ReviewRepository extends CrudRepository<DiningReview, Long> {
    Iterable<DiningReview> findByIdAndAdminReviewStatus(Long id, AdminReviewStatus status);
    Iterable<DiningReview> findByAdminReviewStatus(AdminReviewStatus pending);
    
    @Nullable
    List<DiningReview> findByRestaurantIdAndAdminReviewStatus(Long restaurantId, AdminReviewStatus status);
}
