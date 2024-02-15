/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package paq;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("calculos")
public class CalculosResource {

    @Context
    private UriInfo context;

    public CalculosResource() {
    }

    /**
     * Retrieves representation of an instance of paq.CalculosResource
     *
     * @param operador
     * @param ope1
     * @param ope2
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml(
            @QueryParam("operador") String operador,
            @QueryParam("ope1") float ope1,
            @QueryParam("ope2") float ope2) 
    {
        String res = "Resultado... ";
        float calc = 0;
        switch (operador) {
            case "suma":
                calc = (float) ope1 + ope2;
                break;
            case "resta":
                calc = (float) ope1 - ope2;
                break;
            case "mult":
                calc = (float) ope1 * ope2;
                break;
            case "div":
                calc = (float) ope1 / ope2;
                break;
            default:
                res = " Error...";
                break;
        }
    return res + calc ;
}

     /**
     * Retrieves representation of an instance of paq.CalculosResource
     *
     * @param operador
     * @param ope1
     * @param ope2
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{operador}/{ope1}/{ope2}")
    @Produces(MediaType.TEXT_HTML)
    public String getHtml2(
            @PathParam("operador") String operador,
            @PathParam("ope1") float ope1,
            @PathParam("ope2") float ope2) 
    {
        String res = "Resultado... ";
        float calc = 0;
        switch (operador) {
            case "suma":
                calc = (float) ope1 + ope2;
                break;
            case "resta":
                calc = (float) ope1 - ope2;
                break;
            case "mult":
                calc = (float) ope1 * ope2;
                break;
            case "div":
                calc = (float) ope1 / ope2;
                break;
            default:
                res = " Error...";
                break;
        }
    return res + calc ;
}
   
}
