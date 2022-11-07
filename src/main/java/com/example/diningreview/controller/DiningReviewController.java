package com.example.diningreview.controller;

import com.example.diningreview.model.AdminReviewStatus;
import com.example.diningreview.model.DiningReview;
import com.example.diningreview.model.Restaurant;
import com.example.diningreview.repositories.RestaurantRepository;
import com.example.diningreview.repositories.ReviewRepository;
import com.example.diningreview.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@RestController
public class DiningReviewController {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/dining-review")
    public Iterable<DiningReview> getAllDiningReviews(){
        return reviewRepository.findAll();

    }

    @PostMapping("/dining-review")
    public DiningReview createNewDiningreview(@RequestBody DiningReview diningReview){
        if(restaurantRepository.findById(diningReview.getRestaurantId()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This restaurant does not exist");
        }
        if(userRepository.findByUserName(diningReview.getReviewedBy()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user does not exist");
        }
        return reviewRepository.save(diningReview);
    }

    @GetMapping("/dining-review/pending")
    public Iterable<DiningReview> getPendingReviews(){
        return reviewRepository.findByAdminReviewStatus(AdminReviewStatus.PENDING);
    }

    @PutMapping("/dining-review/{id}/approve")
    public DiningReview approveReview(@PathVariable("id") Long id){
        Optional<DiningReview> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This review does not exist");
        }
        DiningReview reviewToApprove = reviewOptional.get();
        reviewToApprove.setAdminReviewStatus(AdminReviewStatus.APPROVED);
        
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(reviewToApprove.getRestaurantId());
        Restaurant restaurantReview = restaurantOptional.get();
        
        Float peanutS;
        Float eggS;
        Float diaryS;
        Float totalS;
        
        peanutS = (restaurantReview.getPeanutScore() + reviewToApprove.getPeanutScore()) / 2;
        eggS = (restaurantReview.getEggScore() + reviewToApprove.getEggScore()) / 2;
        diaryS = (restaurantReview.getDiaryScore() + reviewToApprove.getDairyScore()) / 2;
        totalS = (peanutS + eggS + diaryS) / 3;
        
        restaurantReview.setPeanutScore(peanutS);
        restaurantReview.setEggScore(eggS);
        restaurantReview.setDiaryScore(diaryS);
        restaurantReview.setScore(totalS);
        
        restaurantRepository.save(restaurantReview);
        		
        return reviewRepository.save(reviewToApprove);
    }

    @PutMapping("/dining-review/{id}/reject")
    public DiningReview rejectReview(@PathVariable("id") Long id){
        Optional<DiningReview> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This review does not exist");
        }
        DiningReview reviewToReject = reviewOptional.get();
        reviewToReject.setAdminReviewStatus(AdminReviewStatus.REJECTED);
        return reviewRepository.save(reviewToReject);
    }
}
