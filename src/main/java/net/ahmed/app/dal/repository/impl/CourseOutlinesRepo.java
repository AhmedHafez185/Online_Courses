/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.dal.repository.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.dal.entity.CourseOutlines;
import net.ahmed.app.dal.entity.User;
import net.ahmed.app.dal.repository.AbstractRepo;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ahmed Hafez
 */
@Repository
public class CourseOutlinesRepo extends AbstractRepo<CourseOutlines>{
    
    public CourseOutlinesRepo() {
        super(CourseOutlines.class);
    }
   
 public List<CourseOutlines>getOutlinesOfCourse(Integer id){
      CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
      CriteriaQuery<CourseOutlines> entityCriteriaQuery = criteriaBuilder.createQuery(CourseOutlines.class);
        Root<CourseOutlines> from = entityCriteriaQuery.from(CourseOutlines.class);
        entityCriteriaQuery.select(from);
        entityCriteriaQuery.where(criteriaBuilder.equal(from.get("course"),id));
        Query<CourseOutlines> query = getCurrentSession().createQuery(entityCriteriaQuery);
        List<CourseOutlines> entityList = query.getResultList();
        if (entityList.size() > 0) {
            return entityList;
        }
        return null;
 }
}
