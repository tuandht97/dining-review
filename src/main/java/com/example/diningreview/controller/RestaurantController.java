package com.example.diningreview.controller;

import com.example.diningreview.model.Restaurant;
import com.example.diningreview.model.AdminReviewStatus;
import com.example.diningreview.model.DiningReview;
import com.example.diningreview.repositories.RestaurantRepository;
import com.example.diningreview.repositories.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
	private ReviewRepository reviewRepository;

    @GetMapping("/restaurants")
    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/restaurants/search")
    public Optional<Restaurant> getRestaurantsByZipCode(@RequestParam String zipCode) {
        return restaurantRepository.findByZipCode(zipCode);
    }
    
    @GetMapping("/restaurants/{id}/reviews")
    public List<DiningReview> getAllReviewsOfRestaurant(@PathVariable("id") Long id) {
        return this.reviewRepository.findByRestaurantIdAndAdminReviewStatus(id, AdminReviewStatus.APPROVED);
    }

    @GetMapping("/restaurants/{id}")
    public Optional<Restaurant> getRestaurantBy(@PathVariable("id") Long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This restaurant does not exist");
        }
        return restaurantRepository.findById(id);
    }

    @PostMapping("/restaurants")
    public Restaurant createNewRestaurant(@RequestBody Restaurant restaurant) {
        if (restaurantRepository.existsByZipCode(restaurant.getZipCode()) && restaurantRepository.existsByName(restaurant.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A restaurant with this name and zipcode already exists");
        }
        return restaurantRepository.save(restaurant);
    }
}
