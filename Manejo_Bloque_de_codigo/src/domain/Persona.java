package domain;

public class Persona {

private final int idPersona;
private static int contadorPersona;

//bloque estatico
//se ejecuta antes del constructor pero solo una vez en la ejecucion
static{
    System.out.println("ejecucion bloque estatico");
    ++Persona.contadorPersona;
}

//bloque no estatico (dinamico)
{
    System.out.println("ejecucion del bloque no estatico");
    this.idPersona = Persona.contadorPersona++;
}

public Persona(){
    System.out.println("Ejecucion del constructor");
}

    public int getIdPersona() {
        return this.idPersona;
    }


    
}
