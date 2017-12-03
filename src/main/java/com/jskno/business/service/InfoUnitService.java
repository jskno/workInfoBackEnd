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

import com.jskno.persistence.entity.InfoUnit;
import com.jskno.persistence.repository.InfoUnitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jose on 02/12/17.
 */
@Service
public class InfoUnitService {

    private static final Logger log = LoggerFactory.getLogger(InfoUnitService.class);

    @Autowired
    private InfoUnitRepository infoUnitRepository;

    public List<InfoUnit> getAllInfoUnits() {
        return this.infoUnitRepository.findAll();
    }

    public InfoUnit getInfoUnitById(Long id) {
        return this.infoUnitRepository.findOne(id);
    }

    public void deleteInfoUnitById(Long id) {
        this.infoUnitRepository.delete(id);
    }

    public InfoUnit saveInfoUnit(InfoUnit infoUnit) {
        return this.infoUnitRepository.save(infoUnit);
    }

}
