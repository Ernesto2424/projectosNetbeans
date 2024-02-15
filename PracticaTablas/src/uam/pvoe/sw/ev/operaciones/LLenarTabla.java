
package uam.pvoe.sw.ev.operaciones;

import java.util.LinkedList;
import java.util.Vector;
import uam.pvoe.ws.ev.modelo.Cliente;
import uam.pvoe.ws.ev.modelo.Compra;
import uam.pvoe.ws.ev.modelo.Producto;


public class LLenarTabla {
    
    public LLenarTabla(){}
    
    public Vector<String> tituloColumna(){
       
        Vector<String> listaTitulos = new Vector();
        
        CargaArchivos carga = new CargaArchivos();
        LinkedList<Producto> listaProductos = new LinkedList();
        listaProductos = carga.productos();
        
        for(int i=0; i<listaProductos.size(); ++i){
            Producto productos =  listaProductos.get(i);
            
            listaTitulos.add(productos.getNombre());
            //System.out.println(productos.getNombre());
        }
        
        String cliente = "Cliente";
        String faltante = "Faltante";
        
        listaTitulos.add(0,cliente);
        listaTitulos.add(listaTitulos.size(),faltante);

        return listaTitulos;
        
    }
    
    public Vector elementoCelda(){
       
        Vector filas = new Vector();
        Vector<String> fila;
        CargaArchivos carga = new CargaArchivos();
        
        LinkedList<Cliente> listaClientes = carga.clientes();
        LinkedList<Producto> listaProductos = carga.productos();
        LinkedList<Compra> listaCompras = carga.compras();

        for(int i=0; i<listaClientes.size(); ++i){
            fila = new Vector();
            Cliente cliente = listaClientes.get(i);
            fila.add(cliente.toString());

            
            for(int j=0; j<listaCompras.size(); ++j){
                Compra compras = new Compra();
                compras = listaCompras.get(j);
                String id_cliente = cliente.getId();
                String id_cli_compra = compras.getId_cliente();
                
                if(id_cliente.equals(id_cli_compra) ){
                    
                    System.out.println(id_cliente +" " + id_cli_compra);
                    fila.add(compras.getCantidad());
                    
                      
                          
                }
            }
            
            
            
            
            
            
            
           filas.add(fila);
           
        }
        
        
        
        return filas;
        
    }
    
}
