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
package com.jskno.ws.controller;

import com.jskno.business.service.InfoNodeService;
import com.jskno.persistence.entity.InfoNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jose on 02/12/17.
 */
@RestController
@RequestMapping("workinfo/infonode")
public class InfoNodeController {

    @Autowired
    private InfoNodeService infoNodeService;

    @RequestMapping(path = "/all", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<InfoNode> getAllInfoNodes() {
        return this.infoNodeService.getAllInfoNodes();
    }

    @RequestMapping(path = "/tree", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<InfoNode> getInfoNodesTree() {
        return this.infoNodeService.getParentInfoNodes();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public InfoNode getInfoNodeById(@PathVariable("id") Long id) {
        return this.infoNodeService.getInfoNodeById(id);
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST,
            consumes = { MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveInfoNode(@RequestBody InfoNode infoNode) {
        this.infoNodeService.saveInfoNode(infoNode);
    }

}
