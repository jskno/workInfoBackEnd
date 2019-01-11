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
package com.jskno.persistence.entity.listener;

import com.jskno.persistence.entity.base.AbstractEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created by Jose on 02/12/17.
 */
public class EntityListener {

    @PrePersist
    public void onCreate(final AbstractEntity entity) {
        //final String currentUser = SecurityContextHolder.getContext().getAuthentication().
    //                                      getName();
        final String currentUser = "SYSTEM";
        final Date currentDate = new Date();
        entity.setCreatedByUser(currentUser);
        entity.setCreatedAt(currentDate);
        entity.setUpdatedByUser(currentUser);
        entity.setUpdatedAt(currentDate);
    }

    @PreUpdate
    public void onUpdate(final AbstractEntity entity) {
        final String currentUser = "SYSTEM";
        final Date currentDate = new Date();
        entity.setUpdatedByUser(currentUser);
        entity.setUpdatedAt(currentDate);
    }
}
