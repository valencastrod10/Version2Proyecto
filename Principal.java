import java.util.LinkedList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // LINEA POR LINEA: Creamos el lector de consola y la instancia de tus métodos
        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();
        Validaciones val = new Validaciones(); 
        
        // Estructuras de datos globales para almacenar la información en memoria
        LinkedList<Cliente> clientes = new LinkedList<>();
        LinkedList<vehiculo> vehiculos = new LinkedList<>();
        LinkedList<ContratoRenting> contratos = new LinkedList<>();
        
        // Variable de control para mantener el programa corriendo
        boolean ejecutar = true;
        
        while (ejecutar) {
            // Dibujamos visualmente el menú principal en la consola
            System.out.println("\n----------------------------------------");
            System.out.println("   SISTEMA DE RENTING - MENU PRINCIPAL    ");
            System.out.println("____________________________________________");
            System.out.println(" ");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Vehiculos");
            System.out.println("3. Gestionar Contratos");
            System.out.println("4. Salir del Sistema");
            System.out.print("Seleccione una opcion (1-4): ");
            
            // ¡OJO AQUÍ!: Usamos val.validarEntero(sc) que internamente usa sc.nextLine().
            // Esto garantiza que el búfer quede vacío al presionar Enter.
            int opcionPrincipal = val.validarEntero(sc);
            
            switch (opcionPrincipal) {
                case 1:
                    // Navega al submenú de clientes pasando las listas y el scanner
                    menuClientes(m, clientes, contratos, sc, val);
                    break;
                case 2:
                    // Navega al submenú de vehículos
                    menuVehiculos(m, vehiculos, contratos, sc, val);
                    break;
                case 3:
                    // Navega al submenú de contratos
                    menuContratos(m, contratos, clientes, vehiculos, sc, val);
                    break;
                case 4:
                    // Rompe el bucle para cerrar el programa de forma ordenada
                    System.out.println("Apagando el sistema... ¡Hasta luego!");
                    ejecutar = false;
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo (1-4).");
            }
        }
        sc.close(); // Cerramos el scanner al finalizar por buena práctica
    }

    // =========================================================================
    // SUBMENÚ: GESTIÓN DE CLIENTES
    // =========================================================================
    private static void menuClientes(Metodos m, LinkedList<Cliente> clientes, LinkedList<ContratoRenting> contratos, Scanner sc,Validaciones val) {
        System.out.println("\n--- SUBMENU: GESTION DE CLIENTES ---");
        System.out.println("1. Registrar Cliente");
        System.out.println("2. Buscar Cliente");
        System.out.println("3. Modificar Cliente");
        System.out.println("4. Eliminar Cliente"); // <-- Tu zona de trabajo
        System.out.println("5. Volver al Menu Principal");
        System.out.print("Seleccione una opcion (1-5): ");
        
        int op = val.validarEntero(sc);
        
        switch (op) {
            case 1:
                clientes = m.registrarCliente(clientes, sc);
                break;
            case 2:
                m.buscarCliente(clientes, sc);
                break;
            case 3:
                clientes = m.modificarCliente(clientes, sc);
                break;
            case 4:
                // LLAMADO A TU MÉTODO: Le pasas la lista actual y el scanner limpio.
                    clientes = m.eliminarCliente(clientes,contratos,sc);
                break;
            case 5:
                // No hace nada, simplemente sale del switch y regresa al menú principal
                break;
            default:
                System.out.println("Opcion invalida.");
        }
    }

    // =========================================================================
    // SUBMENÚ: GESTIÓN DE VEHÍCULOS
    // =========================================================================
    private static void menuVehiculos(Metodos m, LinkedList<vehiculo> vehiculos, LinkedList<ContratoRenting> contratos, Scanner sc, Validaciones val) {
        System.out.println("\n--- SUBMENU: GESTION DE VEHICULOS ---");
        System.out.println("1. Registrar Vehiculo");
        System.out.println("2. Buscar Vehiculo");
        System.out.println("3. Modificar Vehiculo");
        System.out.println("4. Eliminar Vehiculo");
        System.out.println("5. Volver al Menu Principal");
        System.out.print("Seleccione una opcion (1-5): ");
        
        int op = val.validarEntero(sc);
        
        switch (op) {
            case 1:
                vehiculos = m.registrarVehiculo(vehiculos, sc);
                break;
            case 2:
                m.buscarVehiculo(vehiculos, sc);
                break;
            case 3:
                vehiculos = m.modificarVehiculo(vehiculos, sc);
                break;
            case 4:
                vehiculos = m.eliminarVehiculo(vehiculos,contratos,sc);
                break;
            case 5:
                break;
            default:
                System.out.println("Opcion invalida.");
        }
    }

    // =========================================================================
    // SUBMENÚ: GESTIÓN DE CONTRATOS (RENTING)
    // =========================================================================
    private static void menuContratos(Metodos m, LinkedList<ContratoRenting> contratos, LinkedList<Cliente> clientes, LinkedList<vehiculo> vehiculos, Scanner sc, Validaciones val) {
        System.out.println("\n--- SUBMENU: GESTION DE CONTRATOS ---");
        System.out.println("1. Registrar Contrato (Renting)");
        System.out.println("2. Buscar Contrato");
        System.out.println("3. Modificar Contrato");
        System.out.println("4. Finalizar Contrato");
        System.out.println("5. Volver al Menu Principal");
        System.out.print("Seleccione una opcion (1-5): ");
        
        int op = val.validarEntero(sc);
        
        switch (op) {
            case 1:
                contratos = m.registrarContrato(contratos, clientes, vehiculos, sc);
                break;
            case 2:
                m.buscarContrato(contratos, sc);
                break;
            case 3:
                contratos = m.modificarContrato(contratos, vehiculos, sc);
                break;
            case 4:
                contratos = m.finalizarContrato(contratos, vehiculos, sc);
                break;
            case 5:
                break;
            default:
                System.out.println("Opcion invalida.");
        }
    }
}