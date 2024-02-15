package operaciones;

import java.io.*;

public class Operacion {

    public static String[] cargarProtocolos() {

        String protocolos[] = new String[19];
        int contador = 0;
        File archivo = new File("protocolos.txt");
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {
                //System.out.println("lectura = " + lectura);
                protocolos[contador] = lectura;
                ++contador;
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return protocolos;

    }

    public static String convierteBinario(String cadena) {

        String resultado = "";

        for (int i = 0; i < cadena.length(); ++i) {
            var caracter = cadena.charAt(i);
            switch (caracter) {
                case '0' ->
                    resultado += "0000";
                case '1' ->
                    resultado += "0001";
                case '2' ->
                    resultado += "0010";
                case '3' ->
                    resultado += "0011";
                case '4' ->
                    resultado += "0100";
                case '5' ->
                    resultado += "0101";
                case '6' ->
                    resultado += "0110";
                case '7' ->
                    resultado += "0111";
                case '8' ->
                    resultado += "1000";
                case '9' ->
                    resultado += "1001";
                case 'a' ->
                    resultado += "1010";
                case 'b' ->
                    resultado += "1011";
                case 'c' ->
                    resultado += "1100";
                case 'd' ->
                    resultado += "1101";
                case 'e' ->
                    resultado += "1110";
                case 'f' ->
                    resultado += "1111";
            }
        }
        //System.out.println(cadena.length());
        return resultado;
    }

    public static int convierteDecimal(String cadena) {

        final String DIGITOS = "0123456789abcdef";
        cadena = cadena.toLowerCase();
        int decimal = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            int digito = DIGITOS.indexOf(caracter);
            decimal = 16 * decimal + digito;
        }
        return decimal;
    }

    public static String TipoServicio(String cadena) {
        final int MAS_SIGNIFICATIVOS = 3;
        String servicio = "Tipo Servicio: ";
        String significativos = "";
        char fiabilidad = 0;
        char rendimiento = 0;
        char retardo = 0;

        String cadenaBinario = convierteBinario(cadena);

        for (int i = 0; i < cadenaBinario.length() - 4; i++) {

            if (i < MAS_SIGNIFICATIVOS) {
                significativos += cadenaBinario.charAt(i);
            } else {
                fiabilidad = cadenaBinario.charAt(i);
                rendimiento = cadenaBinario.charAt(i + 1);
                retardo = cadenaBinario.charAt(i + 2);
            }
        }

        switch (significativos) {
            case "000" ->
                servicio += "De rutina, ";

            case "001" ->
                servicio += "Prioritario, ";

            case "010" ->
                servicio += "Inmediato, ";

            case "011" ->
                servicio += "Relampago, ";

            case "100" ->
                servicio += "Invalidacion relampago, ";

            case "101" ->
                servicio += "Proceso de llamada critica y de emergencia, ";

        }

        if (fiabilidad == '0') {
            servicio += "Fiabilidad: normal, ";
        } else {
            servicio += "Fiabilidad: alto, ";
        }

        if (rendimiento == '0') {
            servicio += "Rendimiento: normal, ";
        } else {
            servicio += "Rendimiento: alto, ";
        }

        if (retardo == '0') {
            servicio += "Retardo: normal ";
        } else {
            servicio += "Retardo: bajo ";
        }

        return servicio;

    }

    public static String Direccion(String direccion) {

        // direccion = 93 53 07 97
        //147.83.7.151
        direccion += " ";
        String dir = "";
        String aConvertir = "";
        for (int j = 0; j < direccion.length(); ++j) {

            char caracter = direccion.charAt(j);
            if (Character.isDigit(caracter)) {

                aConvertir += caracter;

            } else {

                dir += convierteDecimal(aConvertir);
                if (j != direccion.length() - 1) {
                    dir += '.';
                    aConvertir = "";
                }

            }

        }
        return dir;
    }

    public static String direccion(String dir) {

        String direccionDecimal = "";
        String aConvertir = "";
        int contador = 0;
        int tamañoCadena = dir.length();

        for (int i = 0; i < tamañoCadena; i++) {

            char caracter = dir.charAt(i);

            aConvertir += caracter;
            ++contador;
            if (contador == 2) {

                direccionDecimal += convierteDecimal(aConvertir);
                aConvertir = "";
                contador = 0;
                if (i != tamañoCadena - 1) {
                    direccionDecimal += '.';
                }

            }

        }
        return direccionDecimal;

    }

    public static String longitudTotal(String longitud) {
        String total = "Longitud Total: ";
        total = convierteDecimal(longitud) + " octetos";
        return total;
    }

    public static int identificador(String id) {

        int iden = convierteDecimal(id);

        return iden;
    }

    public static String flags_fragmentacion(String cadena) {
        String binario = convierteBinario(cadena);

        String bandera = "";
        int potencia = 4096;
        int pos = 0;

        if (binario.charAt(0) == '0') {
            bandera += "ultimo fragmento, ";
        } else {
            bandera += "fragmento intermedio, ";
        }

        if (binario.charAt(1) == '0') {
            bandera += "Divisible, ";
        } else {
            bandera += "No divisible, ";
        }

        bandera += "Posicion: ";

        for (int i = 3; i < binario.length(); i++) {
            if (binario.charAt(i) == '1') {

                pos += potencia;
            }
            potencia = potencia / 2;
        }

        bandera += pos;
        return bandera;
    }

    public static int tiempoVida(String tiempo) {
        int vida = convierteDecimal(tiempo);

        return vida;
    }

    public static String protocolo(String prot) {
        int indice = convierteDecimal(prot);
        String protocolos[] = cargarProtocolos();

        return protocolos[indice];
    }

    public static String checkSum(String valor) {

        String suma_total = "suma Total: " + convierteDecimal(valor);

        return suma_total;
    }

    public static void decodificacion(String str) {
        //45 00 00 2c 1f e8 40 00 f8 06 41 7a c1 92 c4 ec 93 53 07 97
        int L4 = 4, L2 = 2, L8 = 8;
        int contador = 0;
        String tipoServicio = "", longTotal = "", flags = "", protocolo = "", ipFuente = "", ipDestino = "", suma = "";
        String id = "", tiempoVida = "", longH = "";
        boolean ts = false, lt = false, flag = false, protocol = false, ipf = false, ipd = false,
                identificador = false, ttl = false, sum = false;
        //String pedazo="";
        for (int i = 3; i < str.length(); i++) {
            char caracter = str.charAt(i);

            if (Character.isLetterOrDigit(caracter)) {

                //tipo servicio
                if (ts == false) {
                    tipoServicio += caracter;
                    ++contador;
                    if (contador == L2) {
                        ts = true;
                        contador = 0;
                    }
                    //longitud Total
                } else if (lt == false) {
                    longTotal += caracter;
                    ++contador;
                    if (contador == L4) {
                        lt = true;
                        contador = 0;
                    }
                    //identificador
                } else if (identificador == false) {
                    id += caracter;
                    ++contador;
                    if (contador == L4) {
                        identificador = true;
                        contador = 0;
                    }
                    //flag Fragmentacion
                } else if (flag == false) {
                    flags += caracter;
                    ++contador;
                    if (contador == L4) {
                        flag = true;
                        contador = 0;
                    }
                    //tiempo de vida
                } else if (ttl == false) {
                    tiempoVida += caracter;
                    ++contador;
                    if (contador == L2) {
                        ttl = true;
                        contador = 0;
                    }
                    //protocolo
                } else if (protocol == false) {
                    protocolo += caracter;
                    ++contador;
                    if (contador == L2) {
                        protocol = true;
                        contador = 0;
                    }
                    //cheksum
                } else if (sum == false) {
                    suma += caracter;
                    ++contador;
                    if (contador == L4) {
                        sum = true;
                        contador = 0;
                    }
                    //ip fuente
                } else if (ipf == false) {
                    ipFuente += caracter;
                    ++contador;
                    if (contador == L8) {
                        ipf = true;
                        contador = 0;
                    }
                    //ip Destino
                } else if (ipd == false) {
                    ipDestino += caracter;
                    ++contador;
                    if (contador == L8) {
                        ipd = true;
                        contador = 0;
                    }
                }

            }

        }
        longH += str.charAt(1);
        System.out.println("Version: " + str.charAt(0));
        System.out.println("Longitud Cabecera: " + convierteDecimal(longH));
        System.out.println(TipoServicio(tipoServicio));
        System.out.println(longitudTotal(longTotal));
        System.out.println("Id: " + identificador(id));
        System.out.println(flags_fragmentacion(flags));
        System.out.println("Tiempo de Vida: " + tiempoVida(tiempoVida));
        System.out.println("Protocolo: " + protocolo(protocolo));
        System.out.println(checkSum(suma));
        System.out.println("Direccion IP Origen: " + direccion(ipFuente));
        System.out.println("Direccion IP Destino: " + direccion(ipDestino));

    }

}
