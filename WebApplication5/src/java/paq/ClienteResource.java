/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package paq;

import java.net.URI;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;


/**
 * REST Web Service
 *
 * @author MaricelaClaudiaBravo
 */
@Path("cliente")
public class ClienteResource {
    private static int idContador = 0;
    private static Map<Integer, Cliente> clienteDB = new ConcurrentHashMap<>();

    @Context
    private UriInfo context;
    
    public ClienteResource() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getCliente() {
        return clienteDB.toString();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    public String getCliente(@PathParam("id") int id) 
    {
        final Cliente cli = clienteDB.get(id);
        if (cli == null) 
        {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return cli.toString();
    }


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public Response crearCliente(@FormParam("nombre") String nombre, 
                                 @FormParam("apellido") String apellido) 
    {
        Cliente cliente = new Cliente();
        idContador++;
        cliente.setId(idContador);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        clienteDB.put(cliente.getId(), cliente);
        System.out.println("Cliente creado " + cliente.getId());
        return Response.created(URI.create("/cliente/"+ cliente.getId())).build();
    }

}
