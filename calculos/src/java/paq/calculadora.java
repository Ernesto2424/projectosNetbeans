/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package paq;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Personal
 */
@Path("generic")
public class calculadora {

    @Context
    private UriInfo context;

    
    public calculadora() {
    }

    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml( @QueryParam("operador") String operador, @QueryParam("op1") float op1, @QueryParam("op2") float op2 ) {
        
        String resultado="resultado... ";
        float calculo = 0;
        
        switch (operador) {
            case "suma":
                 calculo = op1+op2;
                break;
                
            case "resta":
                calculo = op1-op2;
                break;
                
            case "mul":
                calculo = op1*op2;
                break;
                
            case "div":
                calculo = op1/op2;
                break;
                
            default:
                resultado = "ERROR!";
                break;
        }
        return resultado+calculo;
    }

    
    
    
    
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
