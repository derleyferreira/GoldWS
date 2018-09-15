/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gold.agenda.service;

import com.gold.agenda.TbAgendamento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Wanderley
 */
@javax.ejb.Stateless
@Path("com.gold.agenda.tbagendamento")
public class TbAgendamentoFacadeREST extends AbstractFacade<TbAgendamento> {

    @PersistenceContext(unitName = "GoldWSPU")
    private EntityManager em;

    public TbAgendamentoFacadeREST() {
        super(TbAgendamento.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TbAgendamento entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TbAgendamento entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TbAgendamento find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TbAgendamento> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TbAgendamento> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("pordata/{ano}/{mes}/{dia}")    
    @Produces({MediaType.APPLICATION_JSON})
    public List<TbAgendamento> findPorData(@PathParam("ano") int ano,
                                           @PathParam("mes") int mes,
                                           @PathParam("dia") int dia) {
        
        List<TbAgendamento> retorno = null;
        
        Calendar c = Calendar.getInstance();
        c.set(c.YEAR, ano);
        c.set(c.MONTH, mes);
        c.set(c.DATE,dia);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Date data = null;
        
        String data1 = sdf.format(c.getTime());
        
        
        
        try {
            data = sdf.parse(data1);
        } catch (ParseException ex) {
            Logger.getLogger(TbAgendamentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
                              
        Query q = getEntityManager().createNamedQuery("TbAgendamento.findByAgeData");
        
        if (data != null){
           q.setParameter("ageData", data, TemporalType.DATE);
        
           retorno = q.getResultList();
        }
        
        return retorno;
        
        
    }
    
    @Override
    protected EntityManager getEntityManager() {
        if (em == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("GoldWSPU");            
            em = emf.createEntityManager();
        }
        
        return em;
    }
    
}
