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

import com.jskno.business.service.InfoUnitService;
import com.jskno.persistence.entity.InfoUnit;
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
@RequestMapping("workinfo/infounit")
public class InfoUnitController {

    @Autowired
    private InfoUnitService infoUnitService;

    @RequestMapping(path = "/all", method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<InfoUnit> getAllInfoUnits() {
        return this.infoUnitService.getAllInfoUnits();
    }

    @RequestMapping(path = "/bynode/{id}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<InfoUnit> getInfoUnitByNode(@PathVariable("id") Long nodeId) {
        return this.infoUnitService.getInfoUnitsByNode(nodeId);
    }

    @RequestMapping(path = "/bynodetitle", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<InfoUnit> getInfoUnitByNodeTitle(@RequestBody String nodeTitle) {
        return this.infoUnitService.getInfoUnitsByNodeTitle(nodeTitle);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public InfoUnit getInfoUnitById(@PathVariable("id") Long id) {
        return this.infoUnitService.getInfoUnitById(id);
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST,
            consumes = { MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveInfoUnit(@RequestBody InfoUnit infoUnit) {
        this.infoUnitService.saveInfoUnit(infoUnit);
    }
}
