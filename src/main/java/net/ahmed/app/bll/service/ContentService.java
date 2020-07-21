/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bll.service;

import java.util.List;
import net.ahmed.app.dal.entity.Content;

/**
 *
 * @author Ahmed Hafez
 */
public interface ContentService {
    public Content addContent(Content content)throws Exception;
    public List<Content> findAllContent()throws Exception;
    public Content editContent(Content content)throws Exception;
    public void removeContent(int contentId)throws Exception;
    public Content getContent(Integer id)throws Exception;
}
