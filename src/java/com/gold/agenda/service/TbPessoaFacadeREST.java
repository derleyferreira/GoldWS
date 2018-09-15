/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gold.agenda.service;

import com.gold.agenda.Login;
import com.gold.agenda.TbPessoa;
import com.google.gson.Gson;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Wanderley
 */
@javax.ejb.Stateless
@Path("com.gold.agenda.tbpessoa")
public class TbPessoaFacadeREST extends AbstractFacade<TbPessoa> {

    @PersistenceContext(unitName = "GoldWSPU")
    private EntityManager em;

    public TbPessoaFacadeREST() {
        super(TbPessoa.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TbPessoa entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TbPessoa entity) {
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
    public TbPessoa find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TbPessoa> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TbPessoa> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @Override
    protected EntityManager getEntityManager() {
                
        if (em == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("GoldWSPU");            
            em = emf.createEntityManager();
        }
        
        return em;
    }
    
    @POST
    @Path("{login}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TbPessoa validaLogin(String loginjson ) {
                
        Gson gson = new Gson();
        
        Login login = gson.fromJson(loginjson, Login.class);
        
        String query = "SELECT t FROM TbPessoa t WHERE t.pesEmail = :pesEmail";
        
        if (!login.getSenha().toString().isEmpty()){
            query = query + " and t.pesSenha = :pesSenha";
        }
        
        Query q = getEntityManager().createQuery( query );
        
        q.setParameter("pesEmail", login.getLogin());
        
        if (!login.getSenha().toString().isEmpty()){
           q.setParameter("pesSenha", login.getSenha());
        }
        
        TbPessoa p = null;
        if (!q.getResultList().isEmpty()){
            p = (TbPessoa) q.getResultList().get(0);            
        }
        
        return p;
                                
    }  
    
}
