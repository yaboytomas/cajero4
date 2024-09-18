
public class MyExceptions extends Exception { //hay que extender de Exception para que sea una excepcion

    private String message;
    private int code;

    // Constructor para mis expetions
    public MyExceptions(String message) {
        this.message = message;
    }

    public MyExceptions(int code) {
        this.code = code;
    }

    // Metodo para mis exeptions
    public String getMessage() {
        String message = "Error: ";
        switch(code) {
            case 1:
                message += "RUT invalido. Use el formato XX.XXX.XXX-X.";
                break;
            case 2:
                message += "Fecha invalida. Use el formato DD-MM-YYYY.";
                break;
            case 3:
                message += "El nombre debe tener al menos 4 caracteres.";
                break;
            case 4:
                message += "El genero debe ser M, F u O.";
                break;
            case 5:
                message += "El cargo debe tener al menos 3 caracteres.";
                break;
            case 6:
                message += "El departamento debe tener al menos 3 caracteres.";
                break;
            case 7:
                message += "El sueldo base debe ser al menos 500.000.";
                break;
        }
        return message;
    }







}
