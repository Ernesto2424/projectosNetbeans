
package uam.pvoe.sw.ev.operaciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import uam.pvoe.ws.ev.modelo.Cliente;
import uam.pvoe.ws.ev.modelo.Compra;
import uam.pvoe.ws.ev.modelo.Producto;


public class CargaArchivos {
    
    public LinkedList<Cliente> clientes(){
        
        LinkedList<Cliente> listaClientes = new LinkedList();
   
        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("cliente.dat");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            
            
            while (cadenaLeida != null) {
                Cliente cliente = new Cliente();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                
                cliente.setId(st.nextToken());
                cliente.setNombre(st.nextToken());
                cliente.setApellidoP(st.nextToken());
                cliente.setApellidoM(st.nextToken());
                
                
                listaClientes.add(cliente);
                cadenaLeida = archivoLectura.readLine();
            }
            archivoLectura.close();
            
            
            
            
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }
        return listaClientes;
    }
    
    public LinkedList<Producto> productos(){
        
        LinkedList<Producto> listaProductos = new LinkedList();
   
        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("productos.dat");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {
                Producto producto = new Producto();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                
                producto.setId(st.nextToken());
                producto.setNombre(st.nextToken());

                listaProductos.add(producto);
                cadenaLeida = archivoLectura.readLine();
            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }
        return listaProductos;
    }
    
    public LinkedList<Compra> compras(){
        
        LinkedList<Compra> listaCompras = new LinkedList();
   
        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("compras_cliente_producto.dat");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {
                Compra compra = new Compra();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                
                compra.setId_cliente(st.nextToken());
                compra.setId_producto(st.nextToken());
                compra.setCantidad(st.nextToken());
                
                listaCompras.add(compra);
                cadenaLeida = archivoLectura.readLine();
            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }
        return listaCompras;
    }
    
    
}
