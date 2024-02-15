
import java.util.ArrayList;


public class Test {
    
    public static void main(String[] args) {
        
       ArrayList<Potenciador> pot = new ArrayList<Potenciador>();
       ArrayList<Personaje> per = new ArrayList<Personaje>();
       ArrayList<Personaje> per2 = new ArrayList<Personaje>();
       Potenciador estrella = new Potenciador(50, 50, "Estrella", "El potenciandor mas grande de todos", 0, 50);       
       Potenciador hoja = new Potenciador(0, 25, "Hoja", "Potenciandor de habilidad y vellocidad", 0, 25);
       Potenciador hongo_r = new Potenciador(25, 0, "Hongo Rojo", "Potenciador habilidad y fuerza", 0, 25);
       pot.add(estrella);
       pot.add(hoja);
       pot.add(hongo_r);
        
        
        Arma aj1 = new Arma(10, "Escopeta", "mi escopeta", 80, 60);
        Arma aj2 = new Arma(30, "Rifle", "mi Rifle", 70, 85);
        Jefe j1 = new Jefe(1, aj1, "Jefe 1", 100, 60);
        Jefe j2 = new Jefe(3, aj2, "Jefe 2", 300, 100);
        
        
        
        Heroe mario = new Heroe(100, 100, 3, "Mario", 100, 100);
        mario.setPotencia(pot);
        Heroe luigui = new Heroe(50, 50, 3, "Luigui", 50, 50);
        luigui.setPotencia(pot);
        luigui.eliminaPot(pot, hoja);
        Personaje pe1 = new Personaje();
        Personaje pe2 = new Personaje();
        Personaje pe3 = new Personaje();
        Personaje pe4 = new Personaje();
     
        pe1=mario;
        pe2=luigui;
        pe3=j1;
        pe3=j2;
        per.add(pe1);
        per.add(pe2);
        per2.add(pe3);
        per2.add(pe4);
        
        

        Guardar h = new Guardar();
        Guarda_Jefe j = new Guarda_Jefe();
        Guarda_Potenciador p = new Guarda_Potenciador();
        h.guarda(per);
        j.guarda(per2);
        p.guarda(pot);
        
        LeerHeroe l1 = new LeerHeroe();
        l1.leeHeroe(per);
        
        
            
      
                
        
        
        
    }
    
}
