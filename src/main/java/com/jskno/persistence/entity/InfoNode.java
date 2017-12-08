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
package com.jskno.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jskno.persistence.entity.base.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Jose on 02/12/17.
 */
@Entity
@Table(name = "INFO_NODE")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class InfoNode extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "NODE_ORDER")
    private Integer nodeOrder;

    @ManyToOne
    @JoinColumn(name = "PARENT_NODE_ID")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private InfoNode parentNode;

    @OneToMany(mappedBy = "parentNode")
    private List<InfoNode> childrenNodes;

    @OneToMany(mappedBy = "infoNode")
    private List<InfoUnit> infoUnits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNodeOrder() {
        return nodeOrder;
    }

    public void setNodeOrder(Integer nodeOrder) {
        this.nodeOrder = nodeOrder;
    }

    public InfoNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(InfoNode parentNode) {
        this.parentNode = parentNode;
    }

    public List<InfoNode> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(List<InfoNode> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }

    public List<InfoUnit> getInfoUnits() {
        return infoUnits;
    }

    public void setInfoUnits(List<InfoUnit> infoUnits) {
        this.infoUnits = infoUnits;
    }
}
