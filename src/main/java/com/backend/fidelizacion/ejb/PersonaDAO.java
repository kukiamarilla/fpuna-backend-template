package com.backend.fidelizacion.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.backend.fidelizacion.model.Persona;

@Stateless
public class PersonaDAO {
    
    @PersistenceContext(unitName = "fidelizacion")
    private EntityManager em;

    public List<Persona> listar() {
        return em.createQuery("select p from Persona p", Persona.class).getResultList();
    }

    public Persona obtener(Long id) {
        return em.find(Persona.class, id);
    }
    
    public void crear(Persona persona) {
        this.em.persist(persona);
    }

    public void eliminar(Long id) {
        Persona persona = this.em.find(Persona.class, id);
        this.em.remove(persona);
    }

}
