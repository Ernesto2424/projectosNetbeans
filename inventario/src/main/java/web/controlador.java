/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import datos.EntradaDao;
import datos.ProductoDao;
import datos.SalidaDao;
import datos.StockDao;
import dominio.EntradaSalida;
import dominio.Producto;
import interfaces.OperacionesDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Esta clase (servlet controlador)
 * contiene los metodos para recibir y atender peticiones por los usuarios,
 * ademas, contiene metodos especificos para realizar ciertas acciones con 
 * base a el inventario.
 * 
 * @author Ernesto F.
 */

@WebServlet(name = "controlador", urlPatterns = {"/controlador"})

public class controlador extends HttpServlet {
    /**
     * metodo constructor por defecto
     */
    public controlador(){}

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void menu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        request.getRequestDispatcher("menu.jsp").forward(request, response);

    }

    /**
     * Permite recuperar y mostrar al usuario las Entradas de productos
     * Existentes que se han realizado.
     * 
    * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void ListarEntradas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OperacionesDatos op = new EntradaDao();
        List<EntradaSalida> entradas = op.SELECT();
        op = new ProductoDao();
        List<Producto> productos = op.SELECT();
        request.setAttribute("entradas", entradas);
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("entradas.jsp").forward(request, response);

    }
    
     /**
     * Permite recuperar y mostrar al usuario las Salidas de productos
     * Existentes que se han realizado.
     * 
    * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void ListarSalidas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OperacionesDatos op = new SalidaDao();
        List<EntradaSalida> salidas = op.SELECT();
        op = new ProductoDao();
        List<Producto> productos = op.SELECT();
        request.setAttribute("salidas", salidas);
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("salidas.jsp").forward(request, response);

    }
    
    /**
     * Permite recuperar y mostrar al usuario el Stock total existente.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void ListarInventario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OperacionesDatos op = new StockDao();
        List<EntradaSalida> inventario = op.SELECT();
        request.setAttribute("stock", inventario);
        request.getRequestDispatcher("inventario.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "entradas":
                    this.ListarEntradas(request, response);
                    break;
                    
                case "salidas":
                    this.ListarSalidas(request, response);
                    break;
                    
                case "inventario":
                    this.ListarInventario(request, response);
                    break;
                    
                case "menu":
                    this.menu(request, response);
                    break;
                
            }
        }

    }

    /**
     * Permite obtener los valores de un producto ingresados por el usuario
     * para que posteriormente sean almacenados en la BD.
     * 
    * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void insertarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1 recuperar los valores del forulario Agregar actividad
        String descripcion = request.getParameter("descripcion");
        double costoUnitario = Double.parseDouble(request.getParameter("costo"));

        //creamos el objeto actividad (MODELO)
        Producto producto = new Producto(descripcion, costoUnitario);

        //insertamos la tarea en la base de datos
        OperacionesDatos op = new ProductoDao();
        int rows = (int) op.INSERT(producto);

        //redirifimos al inicio
        //request.getRequestDispatcher("index.jsp").forward(request, response);
        response.sendRedirect("index.jsp");

    }
  

    /**
     * Permite obtener los valores de una Entrada ingresados por el usuario
     * para que posteriormente sea almacenada en la BD.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void insertarEntrada(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        //1 recuperar los valores del forulario Agregar actividad
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        String fecha = request.getParameter("fecha");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        
        //creamos el objeto EntradaSalida (MODELO)
        
        EntradaSalida es = new EntradaSalida(new Producto(idProducto), fecha, cantidad);
        
       //insertamos la entrada en la base de datos
        OperacionesDatos op = new EntradaDao();
        int rows = (int) op.INSERT(es);

       this.ListarEntradas(request, response);
        

    }
    
     /**
     * Permite obtener los valores de una Salida ingresados por el usuario
     * para que posteriormente sea almacenada en la BD.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void insertarSalida(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        //1 recuperar los valores del forulario
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        String fecha = request.getParameter("fecha");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        
        //creamos el objeto EntradaSalida (MODELO)
        
        EntradaSalida es = new EntradaSalida(new Producto(idProducto), fecha, cantidad);
        
       //insertamos la entrada en la base de datos
        OperacionesDatos op = new SalidaDao();
        int rows = (int) op.INSERT(es);

       this.ListarSalidas(request, response);
        

    }
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "insertarProducto":
                    this.insertarProducto(request, response);
                    break;

                case "insertarEntrada":
                    this.insertarEntrada(request, response);
                    break;
                    
                case "insertarSalida":
                    this.insertarSalida(request, response);
                    break;
                    


            }

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
