/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

import entities.Admin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adil-
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> {
    @PersistenceContext(unitName = "controltestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }
    
    public void register(Admin admin){
        em.persist(admin);
    }
    
    public Admin findById(Long id){
        return em.find(Admin.class, id);
    }
    
    public Admin findLoginByUserNameAndPass(String username,String password){
        try{
            return em.createQuery("SELECT a FROM Admin a WHERE a.username = :username AND a.password = :password",Admin.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
}
