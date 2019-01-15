package profesores;

import java.util.*;
import static java.lang.System.out;

public class Profesor {

    static int contador = 0;
    static String curso;
    static double pagoHoraExtra;
    private String dni;
    private String nombre;
    private double sueldoBase;
    private int[] horasExtra = new int[12];
    private double tipoIRPF;

    public Profesor() {
        contador++;
    }

    public static String getCurso() {
        return curso;
    }

    public static void setCurso(String aCurso) {
        curso = aCurso;
    }

    public static double getPagoHoraExtra() {
        return pagoHoraExtra;
    }

    public static void setPagoHoraExtra(double aPagoHoraExtra) {
        pagoHoraExtra = aPagoHoraExtra;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getHorasExtra(int mes) {
        return horasExtra[mes];
    }

    public void setHorasExtra(int mes, int horas) {
        this.horasExtra[mes] = horas;
    }

    public double getTipoIRPF() {
        return tipoIRPF;
    }

    public void setTipoIRPF(double tipoIRPF) {
        this.tipoIRPF = tipoIRPF;
    }

    public double calcularImporteHorasExtras(int mes) {
        return (double) this.getHorasExtra(mes) * pagoHoraExtra;
    }

    public double calcularSueldoBruto(int mes) {
        return this.getSueldoBase() + this.calcularImporteHorasExtras(mes);
    }

    public double calcularRetencionIrpf(int mes) {
        return ((this.calcularSueldoBruto(mes) * this.getTipoIRPF()) / 100);
    }

    public double calcularSueldo(int mes) {
        return this.calcularSueldoBruto(mes) - this.calcularRetencionIrpf(mes);
    }

    public void ImprimeProfesor(int n) {
        out.println("\nNombre: " + this.getNombre());
        out.println("DNI: " + this.getDni());
        out.println("Sueldo base: " + this.getSueldoBase());
        out.println("Tipo IRPF: " + this.getTipoIRPF());
    }

    public void leerProfesores(int n) {

       out.println("\nNumero del profesor: " + n); 
       
       Scanner sc = new Scanner (System.in);
       out.print("Nombre: ");
       String nom = sc.nextLine();
       this.setNombre(nom);
       
       out.print("DNI: ");
       String DNI = sc.nextLine();
       this.setDni(DNI);
       
       out.print("Sueldo base: ");
       double sueldo_b = sc.nextDouble();
       this.setSueldoBase(sueldo_b);
       
       out.print("Tipo IRPF: ");
       double irpf = sc.nextDouble();
       this.setTipoIRPF(irpf);
    }
    
    public void ImprimirNominas(int mes, int n){
        out.println("Número del profesor: " + n );
        out.println("Nombre: " + this.getNombre());
        out.println("Curso: " + curso);
        out.println("Nomina mes: " + getMes(mes));
        out.println("Horas Extras" + this.getHorasExtra(mes));
        out.println("Tipo IRPF: " + this.getTipoIRPF());
        out.println("Sueldo bruto: " + this.calcularSueldoBruto(mes));
        out.println("Retención por IRPF: " + this.calcularRetencionIrpf(mes));
        out.println("Sueldo Neto: " + this.calcularSueldo(mes));
    }
    
    public String getMes(int n){
        switch(n){
            case 1  : return "Enero";
            case 2  : return "Febrero";
            case 3  : return "Marzo";
            case 4  : return "Abril";
            case 5  : return "Mayo";
            case 6  : return "Junio";
            case 7  : return "Julio";
            case 8  : return "Agosto";
            case 9  : return "Septiembre";
            case 10 : return "Octubre";
            case 11 : return "Nomviebre";
            default : return "Diciembre";
        }
    }

}
