
package com.askrademia.appointments.controller;


import com.askrademia.appointments.model.Review;
import com.askrademia.appointments.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.save(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        Review existingReview = reviewService.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
        existingReview.setComment(updatedReview.getComment());
        existingReview.setRating(updatedReview.getRating());
        existingReview.setProfessional(updatedReview.getProfessional());
        return reviewService.save(existingReview);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteById(id);
    }
}
