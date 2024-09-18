import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Colaborador> colaboradores = new ArrayList<>();

        try {
            Colaborador juanito = new Colaborador("12.345.678-9", "Juanito, Perez, Lopez", "M", parseDate("01-01-1998"), parseDate("01-01-2020"), "Ejecutivo de Ventas", "Ventas", 800000, true);
            Colaborador amelia = new Colaborador("11.234.567-8", "Amelia, Rodriguez, Garcia", "F", parseDate("01-01-1986"), parseDate("01-01-2010"), "Directora de Marketing", "Marketing", 1200000, true);
            Colaborador marcelo = new Colaborador("10.123.456-7", "Marcelo, Sanchez, Diaz", "M", parseDate("01-01-2004"), parseDate("01-01-2022"), "Asistente Administrativo", "Administracion", 500000, true);
            Colaborador camila = new Colaborador("9.012.345-6", "Camila, Gomez, Hernandez", "F", parseDate("01-01-1996"), parseDate("01-01-2018"), "Soporte Tecnico", "Soporte", 700000, true);
            Colaborador pablo = new Colaborador("8.901.234-5", "Pablo, Martinez, Rodriguez", "M", parseDate("01-01-1993"), parseDate("01-01-2015"), "Gerente General", "Gerencia", 1500000, false);
            Colaborador natalia = new Colaborador("7.890.123-4", "Natalia, Lopez, Garcia", "F", parseDate("01-01-1987"), parseDate("01-01-2012"), "Profesional Administrativo", "Administracion", 900000, false);

            colaboradores.add(juanito);
            colaboradores.add(amelia);
            colaboradores.add(marcelo);
            colaboradores.add(camila);
            colaboradores.add(pablo);
            colaboradores.add(natalia);
        } catch (MyExceptions e) {
            System.out.println(e.getMessage());
        }

        while (true) {
            System.out.println("-----------------------");
            System.out.println("         Menu:         ");
            System.out.println("-----------------------");
            System.out.println("1. Ingresar Colaborador");
            System.out.println("2. Ver Colaborador");
            System.out.println("3. Eliminar Colaborador");
            System.out.println("4. Estado de la Empresa");
            System.out.println("5. Salir");
            System.out.println("-----------------------");

            System.out.print("Ingrese su seleccion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Colaborador colaborador = new Colaborador();
                    System.out.println();
                    System.out.println("--------------------");
                    System.out.println("Ingresar Colaborador");
                    System.out.println("--------------------");

                    while (true) {
                        System.out.print("RUT: ");
                        String rut = scanner.next();
                        scanner.nextLine();
                        try {
                            validarRut(rut);
                            colaborador.setRut(rut);
                            break;
                        } catch (MyExceptions e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    while (true) {
                        String nombre;
                        while (true) {
                            System.out.print("Nombre: ");
                            nombre = scanner.nextLine();
                            try {
                                validarNombre(nombre);
                                break;
                            } catch (MyExceptions e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        String apellidoP;
                        while (true) {
                            System.out.print("Apellido Paterno: ");
                            apellidoP = scanner.nextLine();
                            try {
                                validarNombre(apellidoP);
                                break;
                            } catch (MyExceptions e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        String apellidoM;
                        while (true) {
                            System.out.print("Apellido Materno: ");
                            apellidoM = scanner.nextLine();
                            try {
                                validarNombre(apellidoM);
                                break;
                            } catch (MyExceptions e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        String nombreCompleto = nombre + ", " + apellidoP + ", " + apellidoM;
                        colaborador.setNombre(nombreCompleto);
                        break;
                    }

                    while (true) {
                        System.out.print("Género (M/F/O): ");
                        String genero = scanner.next();
                        scanner.nextLine(); // Consume the newline character
                        try {
                            validarGenero(genero);
                            colaborador.setGenero(genero);
                            break;
                        } catch (MyExceptions e) {
                            System.out.println(e.getMessage());
                        }
                    }




                    while (true) {
                        System.out.print("Fecha de Nacimiento (DD-MM-YYYY): ");
                        try {
                            colaborador.setFechaNacimiento(parseDate(scanner.next()));
                            break;
                        } catch (MyExceptions e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    while (true) {
                        System.out.print("Fecha de Ingreso (DD-MM-YYYY): ");
                        try {
                            colaborador.setFechaIngreso(parseDate(scanner.next()));
                            break;
                        } catch (MyExceptions e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    while (true) {
                        System.out.print("Cargo: ");
                        String cargo = scanner.next();
                        scanner.nextLine(); // Consume the newline character
                        try {
                            validarCargo(cargo);
                            colaborador.setCargo(cargo);
                            break;
                        } catch (MyExceptions e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    while (true) {
                        System.out.print("Departamento: ");
                        String departamento = scanner.next();
                        scanner.nextLine(); // Consume the newline character
                        try {
                            validarDepartamento(departamento);
                            colaborador.setDepartamento(departamento);
                            break;
                        } catch (MyExceptions e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    while (true) {
                        System.out.print("Sueldo Base: ");
                        try {
                            int sueldoBase = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            validarSueldoBase(sueldoBase);
                            colaborador.setSueldobase(sueldoBase);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Sueldo base debe ser numeros solamente.");
                            scanner.nextLine(); // Clear the invalid input
                        } catch (MyExceptions e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    colaborador.setActivo(true); // Seteamos el estado activo por defecto
                    colaboradores.add(colaborador); // Agregamos el colaborador a la lista
                    System.out.println();
                    System.out.println("Colaborador ingresado correctamente.");
                    break;

                case 2:
                    System.out.println();
                    System.out.print("Ingrese el RUT del colaborador a buscar: ");
                    System.out.println();
                    String rutBusqueda = scanner.nextLine();
                    Colaborador colaboradorEncontrado = null;

                    for (Colaborador colab : colaboradores) {
                        if (colab.getRut().equals(rutBusqueda)) {
                            colaboradorEncontrado = colab;
                            break;
                        }
                    }

                    if (colaboradorEncontrado != null) {
                        System.out.println(colaboradorEncontrado);
                    } else {
                        System.out.println("Colaborador no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println();
                    System.out.print("Ingrese el RUT del colaborador a desactivar: ");
                    System.out.println();
                    String rutDesactivar = scanner.nextLine();
                    Colaborador colaboradorADesactivar = null;

                    for (Colaborador colab : colaboradores) {
                        if (colab.getRut().equals(rutDesactivar)) {
                            colaboradorADesactivar = colab;
                            break;
                        }
                    }

                    if (colaboradorADesactivar != null) {
                        colaboradorADesactivar.desactivar();
                        System.out.println("Colaborador desactivado correctamente.");
                    } else {
                        System.out.println("Colaborador no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println();
                    System.out.println("[Colaboradores Activos]");
                    for (Colaborador colab : colaboradores) {
                        if (colab.activoono()) {
                            String firstName = colab.getNombre().split(",")[0];
                            System.out.println(firstName + ", " + colab.calcEdad() + ", " + colab.getCargo());
                        }
                    }

                    System.out.println();
                    System.out.println("[Colaboradores Inactivos]");
                    for (Colaborador colab : colaboradores) {
                        if (!colab.activoono()) {
                            String firstName = colab.getNombre().split(",")[0];
                            System.out.println(firstName + ", " + colab.calcEdad() + ", " + colab.getCargo());
                        }
                    }
                    break;

                case 5:
                    // Salir
                    System.out.println("Saliendo del programa. Adios!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida. Intente denuevo con las opciones del menu (1-5).");
                    break;
            }
        }

    }

    // Validar RUT
    private static void validarRut(String rut) throws MyExceptions {
        if (!rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dkK]") && !rut.matches("\\d\\.\\d{3}\\.\\d{3}-[\\dkK]")) {
            throw new MyExceptions(1);
        }
    }

    // Validar DATE
    private static Date parseDate(String dateStr) throws MyExceptions {
        try {
            if (!dateStr.matches("\\d{2}-\\d{2}-\\d{4}")) {
                throw new MyExceptions(2); // Custom exception for invalid date format
            }
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new MyExceptions(2); // Custom exception for parse error
        }
    }

    //VALIDAR NOMBRE
    private static void validarNombre(String nombre) throws MyExceptions {
        if (nombre.length() < 4) {
            throw new MyExceptions(3); // Custom exception code for invalid name
        }
    }

    //VALIDAR GENERO
    private static void validarGenero(String genero) throws MyExceptions {
        if (!genero.matches("[MFO]")) {
            throw new MyExceptions(4); // Custom exception


        }
    }

    // Validar CARGO
    private static void validarCargo(String cargo) throws MyExceptions {
        if (cargo.length() < 3) {
            throw new MyExceptions(5); // Custom exception code for invalid cargo
        }
    }

    // Validar DEPARTAMENTO
    private static void validarDepartamento(String departamento) throws MyExceptions {
        if (departamento.length() < 3) {
            throw new MyExceptions(6); // Custom exception code for invalid departamento
        }
    }

    // Validar SUELDO BASE
    private static void validarSueldoBase(int sueldoBase) throws MyExceptions {
        if (sueldoBase < 500000) {
            throw new MyExceptions(7); // Custom exception code for invalid sueldo base
        }
    }

}