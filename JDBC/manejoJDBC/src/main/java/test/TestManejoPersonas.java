package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        Persona personaNueva = new Persona("nombrePrueba", "apellidoPrueba", "emailapellidoPrueba", "telefonoPrueba");
       
        
        
        personaNueva = new Persona(5);
        System.out.println(personaDao.seleccionar(personaNueva));
        personaDao.seleccionar();
      
        
        
//        List<Persona> lista =personaDao.seleccionar();
//        
//        for(Persona personas: lista){
//           System.out.println("persona = " + personas);
//        }

        //personaDao.insertar(personaNueva);

//       personaNueva = new Persona(3);
//       personaDao.eliminar(personaNueva);

// personaNueva = new Persona(4, "Nameactualizado", "Apellidoactualizados", "Emailctualizado", "Telefonoactualizado");
//
//     
//       
//
//        System.out.println(personaDao.actualizar(personaNueva)); 


    }

}
