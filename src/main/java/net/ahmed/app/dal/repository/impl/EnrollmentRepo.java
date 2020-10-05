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
import net.ahmed.app.dal.entity.Enrollment;
import net.ahmed.app.dal.entity.Student;
import net.ahmed.app.dal.entity.User;
import net.ahmed.app.dal.repository.AbstractRepo;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ahmed Hafez
 */
@Repository
public class EnrollmentRepo extends AbstractRepo<Enrollment>{
    
    public EnrollmentRepo() {
        super(Enrollment.class);
    }
        
public boolean checkStudentCourseEnrollment(Course course, Student student) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Enrollment> entityCriteriaQuery = criteriaBuilder.createQuery(Enrollment.class);
        Root<Enrollment> from = entityCriteriaQuery.from(Enrollment.class);
        entityCriteriaQuery.select(from);
        entityCriteriaQuery.where(criteriaBuilder.and(
                criteriaBuilder.equal(from.get("student"), student),
                criteriaBuilder.equal(from.get("course"), course)
           ));
        Query<Enrollment> userQuery = getCurrentSession().createQuery(entityCriteriaQuery);
        List<Enrollment> entityList = userQuery.getResultList();
        return entityList.size() > 0;
    }    
    

    
}
