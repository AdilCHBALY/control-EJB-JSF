/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

import entities.Machine;
import entities.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author adil-
 */
@Stateless
public class MachineFacade extends AbstractFacade<Machine> {
    @PersistenceContext(unitName = "controltestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MachineFacade() {
        super(Machine.class);
    }
    
    public List<Machine> findEmployees(String employeeName){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Machine> criteriaQuery = criteriaBuilder.createQuery(Machine.class);
        Root<Machine> machineRoot = criteriaQuery.from(Machine.class);
        Join<Machine,Employee> join = machineRoot.join("idClient");
        criteriaQuery.select(machineRoot).where(criteriaBuilder.equal(join.get("nom"), employeeName));
        TypedQuery<Machine> tq = em.createQuery(criteriaQuery);
        return tq.getResultList();
    }
    
}
