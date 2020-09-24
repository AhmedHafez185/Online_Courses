/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service.impl;

import java.util.List;
import net.ahmed.app.bll.service.ReviewService;
import net.ahmed.app.dal.entity.Review;
import net.ahmed.app.dal.repository.impl.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ahmed Hafez
 */
@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewRepo reviewRepo;
    @Transactional
    @Override
    public Review addReview(Review review) throws Exception {
        try {
            Review resultReview = reviewRepo.add(review);
            return resultReview;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public List<Review> findAllReview() throws Exception {

        try {
            List<Review> reviews = reviewRepo.findList();
            return reviews;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Review editReview(Review review) throws Exception {
        try {
            Review updatedReview = reviewRepo.update(review);
            return updatedReview;
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Transactional
    @Override
    public void removeReview(int reviewId) throws Exception {
        try {
            reviewRepo.remove(reviewId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Review getReview(Integer id) throws Exception {
        try {
            Review review = reviewRepo.findById(id);
            return review;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    @Transactional
    public List<Review> findAllReviewByCourse(Integer id) throws Exception {
        try {
            List<Review> reviews = reviewRepo.findReviewsByCourse(id);
            return reviews;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
