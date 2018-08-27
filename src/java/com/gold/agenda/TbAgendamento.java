/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gold.agenda;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wanderley
 */
@Entity
@Table(name = "tb_agendamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAgendamento.findAll", query = "SELECT t FROM TbAgendamento t")
    , @NamedQuery(name = "TbAgendamento.findByAgeId", query = "SELECT t FROM TbAgendamento t WHERE t.ageId = :ageId")
    , @NamedQuery(name = "TbAgendamento.findByAgeData", query = "SELECT t FROM TbAgendamento t WHERE t.ageData = :ageData")
    , @NamedQuery(name = "TbAgendamento.findByAgeHora", query = "SELECT t FROM TbAgendamento t WHERE t.ageHora = :ageHora")
    , @NamedQuery(name = "TbAgendamento.findByAgeCliente", query = "SELECT t FROM TbAgendamento t WHERE t.ageCliente = :ageCliente")
    , @NamedQuery(name = "TbAgendamento.findByAgeProfissional", query = "SELECT t FROM TbAgendamento t WHERE t.ageProfissional = :ageProfissional")
    , @NamedQuery(name = "TbAgendamento.findByAgeSituacao", query = "SELECT t FROM TbAgendamento t WHERE t.ageSituacao = :ageSituacao")
    , @NamedQuery(name = "TbAgendamento.findByAgeFormapgto", query = "SELECT t FROM TbAgendamento t WHERE t.ageFormapgto = :ageFormapgto")
    , @NamedQuery(name = "TbAgendamento.findByAgeObservacoes", query = "SELECT t FROM TbAgendamento t WHERE t.ageObservacoes = :ageObservacoes")})
public class TbAgendamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AGE_ID")
    private Integer ageId;
    @Column(name = "AGE_DATA")
    @Temporal(TemporalType.DATE)
    private Date ageData;
    @Column(name = "AGE_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ageHora;
    @Column(name = "AGE_CLIENTE")
    private Integer ageCliente;
    @Column(name = "AGE_PROFISSIONAL")
    private Integer ageProfissional;
    @Column(name = "AGE_SITUACAO")
    private Integer ageSituacao;
    @Column(name = "AGE_FORMAPGTO")
    private Integer ageFormapgto;
    @Column(name = "AGE_OBSERVACOES")
    private String ageObservacoes;

    public TbAgendamento() {
    }

    public TbAgendamento(Integer ageId) {
        this.ageId = ageId;
    }

    public Integer getAgeId() {
        return ageId;
    }

    public void setAgeId(Integer ageId) {
        this.ageId = ageId;
    }

    public Date getAgeData() {
        return ageData;
    }

    public void setAgeData(Date ageData) {
        this.ageData = ageData;
    }

    public Date getAgeHora() {
        return ageHora;
    }

    public void setAgeHora(Date ageHora) {
        this.ageHora = ageHora;
    }

    public Integer getAgeCliente() {
        return ageCliente;
    }

    public void setAgeCliente(Integer ageCliente) {
        this.ageCliente = ageCliente;
    }

    public Integer getAgeProfissional() {
        return ageProfissional;
    }

    public void setAgeProfissional(Integer ageProfissional) {
        this.ageProfissional = ageProfissional;
    }

    public Integer getAgeSituacao() {
        return ageSituacao;
    }

    public void setAgeSituacao(Integer ageSituacao) {
        this.ageSituacao = ageSituacao;
    }

    public Integer getAgeFormapgto() {
        return ageFormapgto;
    }

    public void setAgeFormapgto(Integer ageFormapgto) {
        this.ageFormapgto = ageFormapgto;
    }

    public String getAgeObservacoes() {
        return ageObservacoes;
    }

    public void setAgeObservacoes(String ageObservacoes) {
        this.ageObservacoes = ageObservacoes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ageId != null ? ageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAgendamento)) {
            return false;
        }
        TbAgendamento other = (TbAgendamento) object;
        if ((this.ageId == null && other.ageId != null) || (this.ageId != null && !this.ageId.equals(other.ageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gold.agenda.TbAgendamento[ ageId=" + ageId + " ]";
    }
    
}
