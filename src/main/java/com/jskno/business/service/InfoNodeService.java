//@formatter:off
/**
 *  $$Id$$
 *       . * .
 *     * RRRR  *    Copyright (c) 2017 EUIPO: European Union Intellectual
 *   .   RR  R   .  Property Office (trade marks and designs)
 *   *   RRR     *
 *    .  RR RR  .   ALL RIGHTS RESERVED
 *     * . _ . *
 */
//@formatter:on
package com.jskno.business.service;

import com.jskno.persistence.entity.InfoNode;
import com.jskno.persistence.repository.InfoNodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jose on 02/12/17.
 */
@Service
public class InfoNodeService {

    private static final Logger log = LoggerFactory.getLogger(InfoNodeService.class);

    @Autowired
    private InfoNodeRepository infoNodeRepository;

    public List<InfoNode> getAllInfoNodes() {
        return this.infoNodeRepository.findAll();
    }

    public List<InfoNode> getParentInfoNodes() {
        return this.infoNodeRepository.findParentInfoNodes();
    }

    public InfoNode getInfoNodeById(Long id) {
        return this.infoNodeRepository.findOne(id);
    }

    public void delteInfoNodeById(Long id) {
        this.infoNodeRepository.delete(id);
    }

    public InfoNode saveInfoNode(InfoNode infoNode) {
        return this.infoNodeRepository.save(infoNode);
    }

}
