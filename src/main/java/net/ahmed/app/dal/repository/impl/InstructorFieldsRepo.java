/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.dal.repository.impl;

import net.ahmed.app.dal.entity.InstructorField;
import net.ahmed.app.dal.repository.AbstractRepo;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ahmed Hafez
 */
@Repository
public class InstructorFieldsRepo extends AbstractRepo<InstructorField>{
    public InstructorFieldsRepo() {
        super(InstructorField.class);
    }
}
