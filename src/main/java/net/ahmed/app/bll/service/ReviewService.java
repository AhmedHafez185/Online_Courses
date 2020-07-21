/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service;

import java.util.List;
import net.ahmed.app.dal.entity.Review;

/**
 *
 * @author Ahmed Hafez
 */
public interface ReviewService {
    public Review addReview(Review review)throws Exception;
    public List<Review> findAllReview()throws Exception;
    public Review editReview(Review review)throws Exception;
    public void removeReview(int reviewId)throws Exception;
    public Review getReview(Integer id)throws Exception;
}
