package profesores;

import java.util.*;
import static java.lang.System.out;

class Principal {

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
            } else if (opcion == 2) {
                out.print("Introduzca el número del profesor para dar de baja: ");
                int numero = sc.nextInt();
                lista = bajaProfesor(lista, numero);
                
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
