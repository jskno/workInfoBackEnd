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
package com.jskno.persistence.repository;

import com.jskno.persistence.entity.InfoUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jose on 02/12/17.
 */
@Repository
public interface InfoUnitRepository extends JpaRepository<InfoUnit, Long> {

    @Query("SELECT d FROM InfoUnit d WHERE d.infoNode.id = :nodeId ORDER BY d.name")
    List<InfoUnit> findInfoUnitsByNodeId(@Param("nodeId")Long nodeId);

    @Query("SELECT d FROM InfoUnit d INNER JOIN d.infoNode n WHERE n.title = :nodeTitle ORDER BY d.name")
    List<InfoUnit> findInfoUnitsByNodeTitle(@Param("nodeTitle") String nodeTitle);

    @Query("SELECT d FROM InfoUnit d INNER JOIN d.infoNode n WHERE n.id In (:nodesIds) ORDER BY d.name")
    List<InfoUnit> findInfoUnitsByNodeIds(@Param("nodesIds") List<Long> nodesIds);
}
