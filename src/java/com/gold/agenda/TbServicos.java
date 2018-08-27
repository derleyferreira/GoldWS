/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gold.agenda;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wanderley
 */
@Entity
@Table(name = "tb_servicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbServicos.findAll", query = "SELECT t FROM TbServicos t")
    , @NamedQuery(name = "TbServicos.findBySerId", query = "SELECT t FROM TbServicos t WHERE t.serId = :serId")
    , @NamedQuery(name = "TbServicos.findBySerDescricao", query = "SELECT t FROM TbServicos t WHERE t.serDescricao = :serDescricao")
    , @NamedQuery(name = "TbServicos.findBySerTempopadrao", query = "SELECT t FROM TbServicos t WHERE t.serTempopadrao = :serTempopadrao")
    , @NamedQuery(name = "TbServicos.findBySerValorpadrao", query = "SELECT t FROM TbServicos t WHERE t.serValorpadrao = :serValorpadrao")})
public class TbServicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ser_id")
    private Integer serId;
    @Column(name = "ser_descricao")
    private String serDescricao;
    @Column(name = "ser_tempopadrao")
    private Integer serTempopadrao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ser_valorpadrao")
    private BigDecimal serValorpadrao;

    public TbServicos() {
    }

    public TbServicos(Integer serId) {
        this.serId = serId;
    }

    public Integer getSerId() {
        return serId;
    }

    public void setSerId(Integer serId) {
        this.serId = serId;
    }

    public String getSerDescricao() {
        return serDescricao;
    }

    public void setSerDescricao(String serDescricao) {
        this.serDescricao = serDescricao;
    }

    public Integer getSerTempopadrao() {
        return serTempopadrao;
    }

    public void setSerTempopadrao(Integer serTempopadrao) {
        this.serTempopadrao = serTempopadrao;
    }

    public BigDecimal getSerValorpadrao() {
        return serValorpadrao;
    }

    public void setSerValorpadrao(BigDecimal serValorpadrao) {
        this.serValorpadrao = serValorpadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serId != null ? serId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbServicos)) {
            return false;
        }
        TbServicos other = (TbServicos) object;
        if ((this.serId == null && other.serId != null) || (this.serId != null && !this.serId.equals(other.serId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gold.agenda.TbServicos[ serId=" + serId + " ]";
    }
    
}
