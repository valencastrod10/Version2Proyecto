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
        if (telefono.matches("[0-9]+")) {
            return telefono;
        }
        System.out.println("Telefono invalido");
        return validarTelefono(sc);
    }

    public String validarPlaca(Scanner sc) {
        String placa = sc.next();
        if (placa.matches("[a-zA-Z0-9]+")) {
            return placa.toUpperCase();
        }
        System.out.println("Placa invalida");
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
        String combustible = sc.next();
        if (combustible.equalsIgnoreCase("Gasolina") || combustible.equalsIgnoreCase("Diesel")|| combustible.equalsIgnoreCase("Electrico")) {
            return combustible;
        }

        System.out.println("Combustible invalido");
        return validarCombustible(sc);
    }

    public String validarTransmision(
            Scanner sc) {

        String transmision = sc.next();
        if (transmision.equalsIgnoreCase(
                "Manual") || transmision.equalsIgnoreCase("Automatica")) {

            return transmision;
        }

        System.out.println("Transmision invalida");
        return validarTransmision(sc);
    }

    public String validarTraccion(Scanner sc) {
        String traccion = sc.next();
        if (traccion.equals("4x2") || traccion.equals("4x4")) {
            return traccion;
        }

        System.out.println("Traccion invalida");
        return validarTraccion(sc);
    }

}
