package domain;

public class Rectngulo extends Figura{
    
    
    
    public Rectngulo(String tipoFigura){
        super(tipoFigura);
    }
    
    
    /* el override (i) esta indicando lmplementacion de un metodo 
        mas no sobresescribiendo un metodo
     */
    @Override
    public void dibujar(){
        System.out.println("se  imprime un " +this.getClass().getSimpleName());
    }
    
}
