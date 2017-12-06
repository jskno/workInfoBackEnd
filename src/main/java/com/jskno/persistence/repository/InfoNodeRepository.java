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

import com.jskno.persistence.entity.InfoNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Jose on 02/12/17.
 */
public interface InfoNodeRepository extends JpaRepository<InfoNode, Long> {

    @Query("SELECT d FROM InfoNode d WHERE d.parentNode IS NULL ORDER BY d.nodeOrder")
    List<InfoNode> findParentInfoNodes();

    @Query("SELECT d FROM InfoNode d ORDER BY d.parentNode, d.nodeOrder")
    List<InfoNode> findAllNodesOrdered();

    @Query("SELECT d FROM InfoNode d WHERE d.title = :nodeTitle")
    InfoNode findInfoNodeByTitle(@Param("nodeTitle") String nodeTitle);

}
