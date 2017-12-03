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

import com.jskno.persistence.entity.InfoAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jose on 02/12/17.
 */
public interface InfoAttributeRepository extends JpaRepository<InfoAttribute, Long> {
}
