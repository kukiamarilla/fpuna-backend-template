package com.backend.fidelizacion.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.backend.fidelizacion.ejb.PersonaDAO;
import com.backend.fidelizacion.model.Persona;

import org.json.JSONObject;

@Path("/personas")
@Consumes("application/json")
@Produces("application/json")
public class PersonaResource {

    @Inject
    private PersonaDAO personaDAO;

    @GET
    public Response listar() {
        return Response.ok(personaDAO.listar()).build();
    }

    @POST
    public Response crear(Persona p) {
        personaDAO.crear(p);
        return Response.ok(p).build();
    }

    @GET
    @Path("/{id}")
    public Response obtener(@PathParam("id") Long id) {
        return Response.ok(personaDAO.obtener(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        personaDAO.eliminar(id);
        JSONObject response = new JSONObject();
        response.put("message", "Persona eliminada");
        return Response.ok(response.toString()).build();
    }
}
