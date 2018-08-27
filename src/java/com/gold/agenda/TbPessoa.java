/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gold.agenda;

import java.io.Serializable;
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
@Table(name = "tb_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPessoa.findAll", query = "SELECT t FROM TbPessoa t")
    , @NamedQuery(name = "TbPessoa.findByPesId", query = "SELECT t FROM TbPessoa t WHERE t.pesId = :pesId")
    , @NamedQuery(name = "TbPessoa.findByPesNome", query = "SELECT t FROM TbPessoa t WHERE t.pesNome = :pesNome")
    , @NamedQuery(name = "TbPessoa.findByPesEmail", query = "SELECT t FROM TbPessoa t WHERE t.pesEmail = :pesEmail")
    , @NamedQuery(name = "TbPessoa.findByPesSenha", query = "SELECT t FROM TbPessoa t WHERE t.pesSenha = :pesSenha")
    , @NamedQuery(name = "TbPessoa.findByPesPerfil", query = "SELECT t FROM TbPessoa t WHERE t.pesPerfil = :pesPerfil")
    , @NamedQuery(name = "TbPessoa.findByPesCelular", query = "SELECT t FROM TbPessoa t WHERE t.pesCelular = :pesCelular")
    , @NamedQuery(name = "TbPessoa.findByPesEndereco", query = "SELECT t FROM TbPessoa t WHERE t.pesEndereco = :pesEndereco")
    , @NamedQuery(name = "TbPessoa.findByPesBairro", query = "SELECT t FROM TbPessoa t WHERE t.pesBairro = :pesBairro")
    , @NamedQuery(name = "TbPessoa.findByPesEstado", query = "SELECT t FROM TbPessoa t WHERE t.pesEstado = :pesEstado")
    , @NamedQuery(name = "TbPessoa.findByPesCidadeId", query = "SELECT t FROM TbPessoa t WHERE t.pesCidadeId = :pesCidadeId")})
public class TbPessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PES_ID")
    private Integer pesId;
    @Column(name = "PES_NOME")
    private String pesNome;
    @Column(name = "PES_EMAIL")
    private String pesEmail;
    @Column(name = "PES_SENHA")
    private String pesSenha;
    @Column(name = "PES_PERFIL")
    private Integer pesPerfil;
    @Column(name = "PES_CELULAR")
    private String pesCelular;
    @Column(name = "PES_ENDERECO")
    private String pesEndereco;
    @Column(name = "PES_BAIRRO")
    private String pesBairro;
    @Column(name = "PES_ESTADO")
    private String pesEstado;
    @Column(name = "PES_CIDADE_ID")
    private Integer pesCidadeId;

    public TbPessoa() {
    }

    public TbPessoa(Integer pesId) {
        this.pesId = pesId;
    }

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public String getPesEmail() {
        return pesEmail;
    }

    public void setPesEmail(String pesEmail) {
        this.pesEmail = pesEmail;
    }

    public String getPesSenha() {
        return pesSenha;
    }

    public void setPesSenha(String pesSenha) {
        this.pesSenha = pesSenha;
    }

    public Integer getPesPerfil() {
        return pesPerfil;
    }

    public void setPesPerfil(Integer pesPerfil) {
        this.pesPerfil = pesPerfil;
    }

    public String getPesCelular() {
        return pesCelular;
    }

    public void setPesCelular(String pesCelular) {
        this.pesCelular = pesCelular;
    }

    public String getPesEndereco() {
        return pesEndereco;
    }

    public void setPesEndereco(String pesEndereco) {
        this.pesEndereco = pesEndereco;
    }

    public String getPesBairro() {
        return pesBairro;
    }

    public void setPesBairro(String pesBairro) {
        this.pesBairro = pesBairro;
    }

    public String getPesEstado() {
        return pesEstado;
    }

    public void setPesEstado(String pesEstado) {
        this.pesEstado = pesEstado;
    }

    public Integer getPesCidadeId() {
        return pesCidadeId;
    }

    public void setPesCidadeId(Integer pesCidadeId) {
        this.pesCidadeId = pesCidadeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pesId != null ? pesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPessoa)) {
            return false;
        }
        TbPessoa other = (TbPessoa) object;
        if ((this.pesId == null && other.pesId != null) || (this.pesId != null && !this.pesId.equals(other.pesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gold.agenda.TbPessoa[ pesId=" + pesId + " ]";
    }
    
}
