import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean menuPrincipal = true;

        while (menuPrincipal) {

            System.out.println("\n===== SISTEMA DE RENTING =====");
            System.out.println("1. GESTION DE CLIENTES");
            System.out.println("2. GESTION DE VEHICULOS");
            System.out.println("3. GESTION DE CONTRATOS DE RENTING");
            System.out.println("4. IMPRIMIR INFORME GENERAL");
            System.out.println("5. SALIR");

            int opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    boolean menuClientes = true;
                    while (menuClientes) {
                        System.out.println("\n===== GESTION DE CLIENTES =====");
                        System.out.println("1. Registrar cliente");
                        System.out.println("2. Modificar cliente");
                        System.out.println("3. Eliminar cliente");
                        System.out.println("4. Buscar cliente");
                        System.out.println("5. Volver al menu principal");
                        int opCliente = sc.nextInt();

                        switch (opCliente) {
                            case 1:
                                System.out.println("Pagina en mantenimiento");
                                break;
                            case 2:
                                System.out.println("Pagina en mantenimiento");
                                break;
                            case 3:
                                System.out.println("Pagina en mantenimiento");
                                break;
                            case 4:
                                System.out.println("Pagina en mantenimiento");
                                break;
                            case 5:
                                menuClientes = false;
                            default:
                                System.out.println("Opcion invalida");                        
                            }
                    }
                    break;
                case 2:

                    boolean menuVehiculos = true;
                    while (menuVehiculos) {
                        System.out.println("\n===== GESTION DE VEHICULOS =====");
                        System.out.println("1. Registrar vehiculo");
                        System.out.println("2. Modificar vehiculo");
                        System.out.println("3. Eliminar vehiculo");
                        System.out.println("4. Buscar vehiculo");
                        System.out.println("5. Volver al menu principal");

                        int opVehiculo = sc.nextInt();
                        switch (opVehiculo) {
                            case 1:
                                System.out.println("Pagina en mantenimiento");
                                break;
                            case 2:
                                System.out.println("Pagina en mantenimiento");
                                break;
                            case 3:
                                System.out.println("Pagina en mantenimiento");
                                break;
                            case 4:
                                System.out.println("Pagina en mantenimiento");
                                break;
                            case 5:
                                menuVehiculos = false;
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }
                    }
                    break;
                case 3:

                    boolean menuContratos = true;

                    while (menuContratos) {

                        System.out.println("\n===== GESTION DE CONTRATOS =====");
                        System.out.println("1. Registrar nuevo contrato");
                        System.out.println("2. Modificar contrato");
                        System.out.println("3. Finalizar contrato (devolucion)");
                        System.out.println("4. Buscar contrato");
                        System.out.println("5. Volver al menu principal");

                        int opContrato = sc.nextInt();

                        switch (opContrato) {

                            case 1:
                                System.out.println("Pagina en mantenimiento");
                                break;

                            case 2:
                                System.out.println("Pagina en mantenimiento");
                                break;

                            case 3:
                                System.out.println("Pagina en mantenimiento");
                                break;
                            case 4:
                                System.out.println("Pagina en mantenimiento");
                                break;
                            case 5:
                                menuContratos = false;
                                break;

                            default:
                                System.out.println("Opcion invalida");
                        }
                    }
                    break;

                case 4:

                    System.out.println("\n===== INFORME GENERAL =====");
                    System.out.println("Pagina en mantenimiento");
                    break;

                case 5:

                    System.out.println("Gracias por usar el sistema");
                    menuPrincipal = false;
                    break;

                default:

                    System.out.println("Opcion invalida");
            }
        }sc.close();
    }
}