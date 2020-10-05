/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.dal.repository.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.dal.repository.AbstractRepo;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ahmed Hafez
 */
@Repository
public class CourseRepo extends AbstractRepo<Course>{
    
    public CourseRepo() {
        super(Course.class);
    }
    public List<Course> getCoursesByName(String name) throws Exception {
      String courseName = "%"+name+"%";
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Course> entityCriteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> from = entityCriteriaQuery.from(Course.class);
        entityCriteriaQuery.select(from).where(criteriaBuilder.like(from.get("title").as(String.class),courseName));
        Query<Course> userQuery = getCurrentSession().createQuery(entityCriteriaQuery);
        List<Course> entityList = userQuery.getResultList();
        if (entityList.size() > 0) {
            return entityList;
        }
        return new ArrayList<Course>();
    }
}
