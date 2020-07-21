/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service.impl;

import java.util.List;
import net.ahmed.app.bll.service.ContentService;
import net.ahmed.app.dal.entity.Content;
import net.ahmed.app.dal.repository.impl.ContentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Ahmed Hafez
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentRepo contentRepo;
    @Transactional
    @Override
    public Content addContent(Content content) throws Exception {
        try {
            Content resultContent = contentRepo.add(content);
            return resultContent;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public List<Content> findAllContent() throws Exception {

        try {
            List<Content> contents = contentRepo.findList();
            return contents;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Content editContent(Content content) throws Exception {
        try {
            Content updatedContent = contentRepo.update(content);
            return updatedContent;
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Transactional
    @Override
    public void removeContent(int contentId) throws Exception {
        try {
            contentRepo.remove(contentId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Transactional
    @Override
    public Content getContent(Integer id) throws Exception {
        try {
            Content content = contentRepo.findById(id);
            return content;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
