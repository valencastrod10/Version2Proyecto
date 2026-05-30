import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validaciones {

    public int validarEntero(Scanner sc) {

        try {
            int numero = Integer.parseInt(sc.next());
            if (numero > 0) {
                return numero;
            }

            System.out.println("Debe ingresar un numero positivo");

        } catch (Exception e) {
            System.out.println("Dato invalido");
        }

        return validarEntero(sc);
    }

    public float validarFloat(Scanner sc) {
        try {
            float numero = Float.parseFloat(sc.next());
            if (numero > 0) {
                return numero;
            }

            System.out.println("Debe ingresar un valor positivo");

        } catch (Exception e) {
            System.out.println("Dato invalido");
        }
        return validarFloat(sc);
    }

    public String validarTexto(Scanner sc) {

        String texto = sc.nextLine();

        if (texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            return texto;
        }
        System.out.println("Solo se permiten letras");
        return validarTexto(sc);
    }

    public String validarCedula(Scanner sc) {
        String cedula = sc.next().trim();
        if (!cedula.matches("[0-9]+")) {
            System.out.println("Solo se permiten numeros");
            return validarCedula(sc);
        }
        if (cedula.length() < 7 || cedula.length() > 10) {
            System.out.println("La cedula debe tener entre 7 y 10 digitos");
            return validarCedula(sc);
        }

        return cedula;
    }

public String validarTelefono(Scanner sc) {

    String telefono = sc.next();

    if (!telefono.matches("[0-9]+")) {

        System.out.println( "Solo se permiten numeros");

        return validarTelefono(sc);
    }

    if (telefono.length() != 10) {

        System.out.println(
                "El telefono debe tener 10 digitos");

        return validarTelefono(sc);
    }

    return telefono;
}

public String validarPlaca(Scanner sc) {

    String placa = sc.next().trim().toUpperCase();

    if (placa.matches("[A-Z]{3}[0-9]{3}")) {
        return placa;
    }

    System.out.println("La placa debe tener 3 letras y 3 numeros. Ejemplo: ABC123");

    return validarPlaca(sc);
}

    public String validarEstado(Scanner sc) {
        String estado = sc.next();
        if (estado.equalsIgnoreCase("Disponible") || estado.equalsIgnoreCase("Alquilado")) {
            return estado;
        }
        System.out.println("Estado invalido");
        return validarEstado(sc);
    }

 public String validarCombustible(Scanner sc) {

    System.out.println("Seleccione el tipo de combustible:");
    System.out.println("1. Gasolina");
    System.out.println("2. Diesel");
    System.out.println("3. Electrico");

    int opcion = validarEntero(sc);

    switch (opcion) {

        case 1:
            return "Gasolina";

        case 2:
            return "Diesel";

        case 3:
            return "Electrico";

        default:

            System.out.println(
                    "Opcion invalida.");

            return validarCombustible(sc);
    }

}
public String validarTransmision(Scanner sc) {

    System.out.println("Seleccione la transmision:");
    System.out.println("1. Manual");
    System.out.println("2. Automatica");

    int opcion = validarEntero(sc);

    switch (opcion) {

        case 1:
            return "Manual";

        case 2:
            return "Automatica";

        default:

            System.out.println(
                    "Opcion invalida.");

            return validarTransmision(sc);
    }
}

 public String validarTraccion(Scanner sc) {

    System.out.println("Seleccione la traccion:");
    System.out.println("1. 4x2");
    System.out.println("2. 4x4");

    int opcion = validarEntero(sc);

    switch (opcion) {

        case 1:
            return "4x2";

        case 2:
            return "4x4";

        default:

            System.out.println(
                    "Opcion invalida.");

            return validarTraccion(sc);
    }
}
     public String validarIdContrato(Scanner sc) {

        String id = sc.next();

        if (id.matches("[a-zA-Z0-9]+")) {

            return id;
        }

        System.out.println(
                "El ID solo puede contener letras y numeros");

        return validarIdContrato(sc);
    }
    
public String validarFecha(Scanner sc) {

        String fecha = sc.next();

        while (!esFechaValida(fecha, "dd/MM/yyyy")) {

            System.out.println(
                    "Fecha invalida. Ingrese la fecha en formato dd/MM/yyyy");

            fecha = sc.next();
        }

        return fecha;
    }

    public boolean esFechaValida(
            String fecha,
            String formato) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(formato);

        try {

            LocalDate.parse(fecha, formatter);

            return true;

        } catch (DateTimeParseException e) {

            return false;
        }
    }
public String validarLicencia(Scanner sc) {

    String licencia = sc.next();

    if (licencia.matches("[a-zA-Z0-9]+")) {

        return licencia.toUpperCase();
    }

    System.out.println(
            "La licencia solo puede contener letras y numeros");

    return validarLicencia(sc);
}

}
