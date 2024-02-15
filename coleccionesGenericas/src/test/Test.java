package test;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<String> miLista = new ArrayList<>();
        miLista.add("LUNES");
        miLista.add("MARTES");
        miLista.add("MIERCOLES");
        miLista.add("JUEVES");
        miLista.add("VIERNES");
        miLista.add("SABADO");
        miLista.add("DOMINGO");
        
        /*
        for(Object dia: miLista){
            System.out.println("dia = " + dia);
        }
        */
        
//        miLista.forEach((dia) -> {
//            System.out.println("dia = " + dia);
//        });
        System.out.println("---ARRAY LIST---");
        imprimirColeccion(miLista);
//        System.out.println("----------");
        System.out.println("");
        
        
        //**NOTA: En set no se pueden duplicar elementos
        Set<String> miSet = new HashSet<>();
        miSet.add("LUNES");
         miSet.add("MARTES");
        miSet.add("MIERCOLES");
        miSet.add("JUEVES");
        miSet.add("VIERNES");
        miSet.add("SABADO");
        miSet.add("DOMINGO");
        System.out.println("---SET---");
        imprimirColeccion(miSet);
        System.out.println("");
        System.out.println("MAP");
        
        Map<String, String> miMapa  = new HashMap<>();
        miMapa.put("valor1", "LUNES");
        miMapa.put("valor2", "MARTES");
        miMapa.put("valor3", "MIERCOLES");
        
        String elemento =  miMapa.get("valor1");
        System.out.println("elemento = " + elemento);
        //el metodo KeySet solo devuelve las llaves
        imprimirColeccion(miMapa.keySet());
        
        //el metodo values devuelve los valores relacionados a las llaves
        imprimirColeccion(miMapa.values());
        
    }
    
    
    
    
    
    
    
    public static void imprimirColeccion(Collection coleccion){
        coleccion.forEach((variable)->{
            System.out.println(variable);
    });
    }
    
}
