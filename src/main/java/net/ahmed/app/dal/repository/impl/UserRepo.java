/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.dal.repository.impl;

import net.ahmed.app.dal.entity.User;
import net.ahmed.app.dal.repository.AbstractRepo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ahmed Hafez
 */
@Repository
public class UserRepo extends AbstractRepo<User> {

    public UserRepo() {
        super(User.class);
    }

    public User findUserByEmail(String email) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> entityCriteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> from = entityCriteriaQuery.from(User.class);
        entityCriteriaQuery.select(from);
        entityCriteriaQuery.where(criteriaBuilder.equal(from.get("email"), email));
        Query<User> userQuery = getCurrentSession().createQuery(entityCriteriaQuery);
        List<User> entityList = userQuery.getResultList();
        if (entityList.size() > 0) {
            return entityList.get(0);
        }
        return null;
    }

    public Integer checkUserEmail(String email) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> entityCriteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> from = entityCriteriaQuery.from(User.class);
        entityCriteriaQuery.select(from);

        entityCriteriaQuery.where(criteriaBuilder.equal(from.get("email"), email));
        Query<User> userQuery = getCurrentSession().createQuery(entityCriteriaQuery);
        List<User> entityList = userQuery.getResultList();
        if (entityList.size() > 0) {
            return entityList.size();
        }
        return 0;
    }
}
