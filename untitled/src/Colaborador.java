import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Colaborador {

    //Atributos
    private String rut;
    private String nombre;
    private String genero;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private String cargo;
    private String departamento;
    private int sueldobase;
    private boolean activo;
    private static SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    private String apellidoM;
    private String apellidoP;


    //Constructor
    public Colaborador() {
        this.rut = "";
        this.nombre = "";
        this.genero = "";
        this.fechaNacimiento = null;
        this.fechaIngreso = null;
        this.cargo = "";
        this.departamento = "";
        this.sueldobase = 0;
        this.activo = true;
    }

    public Colaborador(String rut, String nombre, String genero, Date fechaNacimiento, Date fechaIngreso, String cargo, String departamento, int sueldobase, boolean activo) {
        this.rut = rut;
        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        this.departamento = departamento;
        this.sueldobase = sueldobase;
        this.activo = activo;
    }

    //GETTERS Y SETTERS
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getSueldobase() {
        return sueldobase;
    }

    public void setSueldobase(int sueldobase) {
        this.sueldobase = sueldobase;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    //ToString
    @Override
    public String toString() {
        return  "-----------------------------------\n" +
                "Colaborador\n" +
                "-----------------------------------\n" +
                "RUT= " + formatoRut(rut) + "\n" +
                "Nombre= " + nombre + "\n" +
                "Edad= " + calcEdad(fechaNacimiento) + " años\n" +
                "Género= " + calcGenero(genero) + "\n" +
                "Cargo= " + calcAntiguedad(fechaIngreso) + " días - " + cargo + "\n" +
                "Departamento= " + departamento + "\n" +
                "-----------------------------------\n" +
                "Sueldo Líquido\n" +
                "-----------------------------------\n" +
                "Base: $" + sueldobase + "\n" +
                "Gratificación: $75000\n" +
                "Colación: $20000\n" +
                "Locomoción: $35000\n" +
                "Salud: -$" + String.format("%.0f", sueldobase * 0.07) + "\n" +
                "AFP: -$" + String.format("%.0f", sueldobase * 0.10) + "\n" +
                "TOTAL: $" + calcSalario(sueldobase) + "\n" +
                "\n";
    }

    // Formatear RUT
    private static String formatoRut(String rut) {
        String rutLimpio = rut.replaceAll("[^\\dKk]", ""); // Eliminar caracteres no numéricos excepto K/k
        int longitud = rutLimpio.length();
        if (longitud < 8 || longitud > 9) {
            return rut; // Devolver original si la longitud no es válida
        }
        String rutFormateado = rutLimpio.substring(0, longitud - 1) + "-" + rutLimpio.substring(longitud - 1);
        return rutFormateado.replaceAll("(\\d)(?=(\\d{3})+(?!\\d))", "$1.");
    }

    // Calcular edad
    private static int calcEdad(Date fechaNacimiento) {
        Calendar nacimiento = Calendar.getInstance();
        nacimiento.setTime(fechaNacimiento);
        Calendar hoy = Calendar.getInstance();
        int edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);
        if (hoy.get(Calendar.DAY_OF_YEAR) < nacimiento.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }
        return edad;
    }

    //getter calculo de edad
    public int calcEdad(){
        return calcEdad(fechaNacimiento);
    }

    // Calcular género
    private static String calcGenero(String genero) {
        switch (genero.toUpperCase()) {
            case "M":
                return "Masculino";
            case "F":
                return "Femenino";
            case "O":
                return "Otro";
            default:
                return genero;
        }
    }

    // Calcular antigüedad
    private static long calcAntiguedad(Date fechaIngreso) {
        long diferencia = new Date().getTime() - fechaIngreso.getTime();
        return diferencia / (1000 * 60 * 60 * 24);
    }

    // Calcular salario
    private static int calcSalario(int sueldoBase) {
        int gratificacion = 75000;
        int colacion = 20000;
        int locomocion = 35000;
        double salud = sueldoBase * 0.07;
        double afp = sueldoBase * 0.10;
        return (int) (sueldoBase + gratificacion + colacion + locomocion - salud - afp);
    }

    //desactivar colaborador
    public void desactivar() {
        this.activo = false;
    }

    // verficar si esta activo
    public boolean activoono() {
        return activo;
    }





}
