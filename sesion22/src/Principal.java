
public class Principal {
    
    public static void main(String[] args){
        ReparacionExterna  re = new ReparacionExterna(100, "reparacino1", 2, true);
        ReparacionMecanica rm = new ReparacionMecanica(100, "bujias", 3, true);
        System.out.println(re.toString());
        System.out.println(rm.toString());
    }
    
}
