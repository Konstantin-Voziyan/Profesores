package profesores;

import java.util.*;
import static java.lang.System.out;

class Principal {

    public static void main(String[] args) {

        Profesor lista [] = new Profesor[0];
        
        Scanner sc = new Scanner(System.in);
        out.print("Curso: ");
        Profesor.curso = sc.nextLine();
        
        out.print("Importe Horas Extra: ");
        Profesor.pagoHoraExtra = sc.nextDouble();
    }
}
