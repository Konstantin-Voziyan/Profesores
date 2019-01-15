package profesores;

import java.util.*;
import static java.lang.System.out;

class Principal {
    
    static String red = "\033[31m";
    static String black = "\033[30m";

    public static void main(String[] args) {

        Profesor lista[] = new Profesor[0];

        Scanner sc = new Scanner(System.in);
        out.print("Curso: ");
        Profesor.curso = sc.nextLine();

        out.print("Importe Horas Extra: ");
        Profesor.pagoHoraExtra = sc.nextDouble();

        int opcion;

        do {
            out.println("\nS E L E C C I O N E   U N A   O P C I Ó N");
            out.println("1. ALTA DE UN PROFESOR");
            out.println("2. BAJA DE UN PROFESOR");
            out.println("3. CONSULTA DE DATOS PERSONALES DE UN PROFESOR");
            out.println("4. INTRODUCIR HORAS EXTRAORDINARIAS DE UN MES");
            out.println("5. LISTADO DE PROFESORES");
            out.println("6. LISTADO DE NOMINAS DE UN MES");
            out.println("0. SALIR DEL PROGRAMA\n");

            out.print("OPCIÓN SELECCIONADA: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                Profesor p = new Profesor();
                p.leerProfesores(Profesor.contador);
                lista = altaProfesor(lista, p);
            } 
            
            else if (opcion == 2) {
                out.print("Introduzca el número del profesor para dar de baja: ");
                int numero = sc.nextInt();
                lista = bajaProfesor(lista, numero);
            } 
            
            else if (opcion == 3){
                out.print("Introduzca el número del profesor para consultar los datos: ");
                int n = sc.nextInt();
                lista[n].ImprimeProfesor(n);
            } 
            
            else if (opcion == 4){
                int mes, numero, horas;
                out.print("Introduzca el número del profesor: ");
                numero = sc.nextInt();
                out.print("Introduzca el mes: ");
                mes = sc.nextInt();
                out.print("Introduzca las horas extras realizadas: ");
                horas = sc.nextInt();
                lista[numero].setHorasExtra(mes, horas);
            } 
            
            else if (opcion == 5){
                for (int i = 0; i < lista.length; i++){
                    out.println();
                    out.println("Numero: " + (i+1));
                    out.println("Nombre: " + lista[i].getNombre());
                    out.println("DNI: " + lista[i].getDni());
                    out.println("Sueldo Base: " + lista[i].getSueldoBase());
                    out.println("Tipo IRPF: " + lista[i].getTipoIRPF());
                }
            } else if (opcion == 6){
                int mes;
                out.print("Introduzca un mes ara ver todas las nominas: ");
                mes = sc.nextInt();
                
                out.println();
                for (int i = 0; i < lista.length; i++){
                    lista[0].ImprimirNominas(mes, (i+1));
                    out.println();
                }
                
            } else if (opcion != 0 && opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5 && opcion != 6){
                out.println();
                out.println( red + "La opción intrudcida es incorrecta, vuela a intentarlo" + black);
                out.println();
            }

        } while (opcion != 0);

    }

    static Profesor[] altaProfesor(Profesor[] lista, Profesor p) {
        Profesor lista_nueva[] = new Profesor[lista.length + 1];

        for (int i = 0; i < lista.length; i++) {
            lista_nueva[i] = lista[i];
        }
        lista_nueva[lista_nueva.length - 1] = p;

        return lista_nueva;
    }

    static Profesor[] bajaProfesor(Profesor[] lista, int n) {
        Profesor lista_nueva[] = new Profesor[lista.length - 1];

        int cnt = 0;
        for (int i = 0; i < lista.length; i++) {
            if (i != n-1) {
                lista_nueva[cnt] = lista[i];
                cnt++;
            }
        }
        return lista_nueva;
    }
}
