import java.util.LinkedList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Metodos {
    // -------------------------------------- Clientes----------------------
    public LinkedList<Cliente> registrarCliente(LinkedList<Cliente> clientes, Scanner sc) {

        Validaciones v = new Validaciones();
        Cliente c = new Cliente();
        System.out.println("Cedula");
        String cedula = v.validarCedula(sc);

        for (Cliente cli : clientes) {
            if (cli.getCedula().equals(cedula)) {

                System.out.println("Ya existe un cliente con esa cedula.");
                return clientes;
            }
        }

        c.setCedula(cedula);

        sc.nextLine();

        System.out.println("Nombre");
        c.setNombre(v.validarTexto(sc));

        System.out.println("Apellido");
        c.setApellido(v.validarTexto(sc));

        System.out.println("Telefono");
        c.setTelefono(v.validarTelefono(sc));
        sc.nextLine();
        System.out.println("Direccion");

        String direccion = sc.nextLine();

        while (direccion.trim().isEmpty()) {
            System.out.println("La direccion no puede estar vacia");

            direccion = sc.nextLine();
        }

        c.setDireccion(direccion);
        c.setLicenciaConduccion(cedula);
        System.out.println("\n Licencia registrada con el mismo numero de la cedula.");

        clientes.add(c);

        System.out.println("\n Cliente registrado correctamente. :)");

        return clientes;
    }

    // ----------------------------------------------------------------------
    public void buscarCliente(LinkedList<Cliente> clientes, Scanner sc) {
        Validaciones v = new Validaciones();
        System.out.println("Ingrese la cedula:");
        String cedula = v.validarCedula(sc);
        boolean encontrado = false;
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                encontrado = true;
                System.out.println("Cedula: " + c.getCedula());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                System.out.println("Telefono: " + c.getTelefono());
                System.out.println("Direccion: " + c.getDireccion());
                System.out.println("Licencia: " + c.getLicenciaConduccion());
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Cliente no encontrado");
        }
    }

    // ---------------------------------------------------------------
    public LinkedList<Cliente> modificarCliente(
            LinkedList<Cliente> clientes,
            Scanner sc) {

        Validaciones v = new Validaciones();

        if (clientes.isEmpty()) {

            System.out.println(
                    "No hay clientes registrados.");

            return clientes;
        }

        System.out.println(
                "Ingrese la cedula del cliente a modificar:");

        String cedula = v.validarCedula(sc);

        for (Cliente c : clientes) {

            if (c.getCedula()
                    .equals(cedula)) {

                System.out.println(
                        "Nuevo nombre:");

                sc.nextLine();

                String nombre = v.validarTexto(sc);

                while (nombre.trim().length() < 3) {

                    System.out.println(
                            "El nombre debe tener al menos 3 caracteres.");

                    nombre = v.validarTexto(sc);
                }

                c.setNombre(nombre);

                System.out.println(
                        "Nuevo apellido:");

                String apellido = v.validarTexto(sc);

                while (apellido.trim().length() < 3) {

                    System.out.println(
                            "El apellido debe tener al menos 3 caracteres.");

                    apellido = v.validarTexto(sc);
                }

                c.setApellido(apellido);

                System.out.println(
                        "Nuevo telefono:");

                c.setTelefono(
                        v.validarTelefono(sc));

                sc.nextLine();

                System.out.println(
                        "Nueva direccion:");

                String direccion = sc.nextLine();

                while (direccion.trim().isEmpty()) {

                    System.out.println(
                            "La direccion no puede estar vacia.");

                    direccion = sc.nextLine();
                }

                c.setDireccion(direccion);

                // La licencia siempre será igual a la cédula
                c.setLicenciaConduccion(
                        c.getCedula());

                System.out.println("\n Cliente modificado correctamente.:)");

                return clientes;
            }
        }

        System.out.println(
                "No existe un cliente con esa cedula. :(");

        return clientes;
    }

    // ------------------------------------------------------------------
    public LinkedList<Cliente> eliminarCliente(
            LinkedList<Cliente> clientes,
            LinkedList<ContratoRenting> contratos,
            Scanner sc) {

        Validaciones v = new Validaciones();

        if (clientes.isEmpty()) {

            System.out.println(
                    "No hay clientes registrados.");

            return clientes;
        }

        System.out.println(
                "Ingrese la cedula del cliente a eliminar:");

        String cedula = v.validarCedula(sc);

        Cliente clienteEliminar = null;

        for (Cliente c : clientes) {

            if (c.getCedula()
                    .equals(cedula)) {

                clienteEliminar = c;
                break;
            }
        }

        if (clienteEliminar == null) {

            System.out.println(
                    "No existe un cliente con esa cedula.");

            return clientes;
        }

        for (ContratoRenting contrato : contratos) {

            if (contrato.getCedulaCliente()
                    .equals(cedula)) {

                System.out.println(
                        "No se puede eliminar el cliente porque tiene un contrato activo.");

                return clientes;
            }
        }

        clientes.remove(clienteEliminar);

        System.out.println(
                " \n Cliente eliminado correctamente.");

        return clientes;
    }

    // ------------------------------ VEHICULO--------------------
    // ------------------registrar vehiculo
    public LinkedList<vehiculo> registrarVehiculo(LinkedList<vehiculo> vehiculos, Scanner sc) {

        Validaciones v = new Validaciones();
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados. Se creara el primero.");
        }

        System.out.println("Ingrese la placa:");

        String placa = v.validarPlaca(sc);
        // Validar placa repetida
        for (vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {

                System.out.println("Ya existe un vehiculo con esa placa.");

                return vehiculos;
            }
        }

        System.out.println("Seleccione el tipo de vehiculo");
        System.out.println("1. Carro Sedan");
        System.out.println("2. Camioneta SUV");

        int tipo = v.validarEntero(sc);
        while (tipo != 1 && tipo != 2) {

            System.out.println("Seleccione 1 para Carro Sedan o 2 para Camioneta SUV");
            tipo = v.validarEntero(sc);
        }

        System.out.println("Ingrese la marca:");

        sc.nextLine();

        String marca = v.validarTexto(sc);

        while (marca.trim().length() < 2) {
            System.out.println("La marca debe tener al menos 2 caracteres");

            marca = v.validarTexto(sc);
        }

        System.out.println("Ingrese el modelo:");
        int modelo = v.validarEntero(sc);

        int anioActual = java.time.LocalDate.now().getYear();

        while (modelo < 1900 || modelo > anioActual + 1) {
            System.out.println("Ingrese un año de modelo valido entre 1900 y " + (anioActual + 1));
            modelo = v.validarEntero(sc);
        }

        System.out.println("Ingrese el precio diario:");
        float precioDiario = v.validarFloat(sc);

        String estado = "Disponible";

        if (tipo == 1) {
            String combustible = v.validarCombustible(sc);
            String transmision = v.validarTransmision(sc);
            CarroSedan carro = new CarroSedan(placa, marca, modelo, precioDiario, estado, combustible, transmision);
            vehiculos.add(carro);

            System.out.println("Carro Sedan " + placa + " registrado correctamente.");

        } else {
            String traccion = v.validarTraccion(sc);
            System.out.println("Ingrese la capacidad del maletero:");
            float capacidad = v.validarFloat(sc);
            CamionetaSUV suv = new CamionetaSUV(traccion, capacidad, placa, marca, modelo, precioDiario, estado);
            vehiculos.add(suv);
            System.out.println("Camioneta SUV " + placa + " registrada correctamente.");
        }

        return vehiculos;
    }

    // -----------------------------------modificar
    // vehiculo-----------------------------------------------
    public LinkedList<vehiculo> modificarVehiculo(LinkedList<vehiculo> vehiculos, Scanner sc) {
        Validaciones val = new Validaciones();
        System.out.println("Ingrese la placa del vehiculo a modificar:");
        String placa = val.validarPlaca(sc);
        boolean encontrado = false;
        for (vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                encontrado = true;
                System.out.println("Nueva marca:");
                sc.nextLine();
                v.setMarca(val.validarTexto(sc));
                System.out.println("Nuevo modelo:");

                int modelo = val.validarEntero(sc);

                int anioActual = java.time.LocalDate.now().getYear();

                while (modelo < 1900
                        || modelo > anioActual + 1) {

                    System.out.println(
                            "Ingrese un año de modelo valido entre 1900 y "
                                    + (anioActual + 1));

                    modelo = val.validarEntero(sc);
                }

                v.setModelo(modelo);
                System.out.println("Nuevo precio diario:");
                v.setPrecioDiario(val.validarFloat(sc));
                if (v instanceof CarroSedan) {
                    CarroSedan carro = (CarroSedan) v;
                    System.out.println("Nuevo tipo de combustible:");
                    carro.setTipoCombustible(val.validarCombustible(sc));
                    System.out.println("Nueva transmision:");
                    carro.setTransmision(val.validarTransmision(sc));
                } else if (v instanceof CamionetaSUV) {
                    CamionetaSUV suv = (CamionetaSUV) v;
                    System.out.println("Nueva traccion:");
                    suv.setTraccion(val.validarTraccion(sc));
                    System.out.println("Nueva capacidad del maletero:");
                    suv.setCapacidadMaletero(val.validarFloat(sc));
                }
                System.out.println("Vehiculo modificado correctamente.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No existe un vehiculo con esa placa.");
        }
        return vehiculos;
    }

    // ----------------------------------------------eliminrar vehiculo
public LinkedList<vehiculo> eliminarVehiculo(
        LinkedList<vehiculo> vehiculos,
        LinkedList<ContratoRenting> contratos,
        Scanner sc) {

    Validaciones val = new Validaciones();

    System.out.println(
            "Ingrese la placa del vehiculo a eliminar:");

    String placa =
            val.validarPlaca(sc);

    for (ContratoRenting c : contratos) {

        if (c.getPlacaVehiculo()
                .equalsIgnoreCase(placa)) {

            System.out.println(
                    "No se puede eliminar el vehiculo porque tiene un contrato activo.");

            return vehiculos;
        }
    }

    boolean eliminado =
            vehiculos.removeIf(
                    x -> x.getPlaca()
                            .equalsIgnoreCase(placa));

    if (eliminado) {

        System.out.println(
                "Vehiculo eliminado correctamente.");

    } else {

        System.out.println(
                "No existe un vehiculo con esa placa.");
    }

    return vehiculos;
}

    /// -------------busacar vehiculo
    public void buscarVehiculo(LinkedList<vehiculo> vehiculos, Scanner sc) {
        Validaciones val = new Validaciones();
        System.out.println("Ingrese la placa del vehiculo:");
        String placa = val.validarPlaca(sc);
        boolean encontrado = false;
        for (vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                encontrado = true;

                System.out.println("Placa: " + v.getPlaca());
                System.out.println("Marca: " + v.getMarca());
                System.out.println("Modelo: " + v.getModelo());
                System.out.println("Precio Diario: " + v.getPrecioDiario());
                System.out.println("Estado: " + v.getEstado());

                if (v instanceof CarroSedan) {
                    System.out.println("Tipo: Carro Sedan");

                    CarroSedan carro = (CarroSedan) v;

                    System.out.println("Tipo Combustible: " + carro.getTipoCombustible());
                    System.out.println("Transmision: " + carro.getTransmision());

                } else if (v instanceof CamionetaSUV) {

                    System.out.println("Tipo: Camioneta SUV");

                    CamionetaSUV suv = (CamionetaSUV) v;

                    System.out.println("Traccion: " + suv.getTraccion());
                    System.out.println("Capacidad Maletero: " + suv.getCapacidadMaletero());

                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No existe un vehiculo con esa placa.");
        }
    }

    // -------------------------------------------------- contrato renting
    // -----------------------------registar
    public LinkedList<ContratoRenting> registrarContrato(LinkedList<ContratoRenting> contratos,
            LinkedList<Cliente> clientes, LinkedList<vehiculo> vehiculos, Scanner sc) {

        Validaciones val = new Validaciones();

        if (clientes.isEmpty()) {

            System.out.println("No hay clientes registrados.");

            return contratos;
        }
        if (vehiculos.isEmpty()) {

            System.out.println("No hay vehiculos registrados.");

            return contratos;
        }

        ContratoRenting contrato = new ContratoRenting();

        System.out.println("Ingrese ID del contrato:");

        String idContrato = val.validarIdContrato(sc);

        for (ContratoRenting c : contratos) {

            if (c.getIdContrato().equalsIgnoreCase(idContrato)) {

                System.out.println("Ya existe un contrato con ese ID.");

                return contratos;
            }
        }

        contrato.setIdContrato(idContrato);

        System.out.println("Ingrese cedula del cliente:");

        String cedula = val.validarCedula(sc);

        boolean clienteExiste = false;
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                clienteExiste = true;
                break;
            }
        }

        if (!clienteExiste) {

            System.out.println("El cliente no existe.");
            return contratos;
        }

        for (ContratoRenting c : contratos) {
            if (c.getCedulaCliente().equals(cedula)) {

                System.out.println("El cliente ya tiene un contrato activo.");

                return contratos;
            }
        }

        contrato.setCedulaCliente(cedula);
        System.out.println("Ingrese placa del vehiculo:");
        String placa = val.validarPlaca(sc);
        vehiculo vehiculoEncontrado = null;
        for (vehiculo v : vehiculos) {

            if (v.getPlaca().equalsIgnoreCase(placa)) {
                vehiculoEncontrado = v;
                break;
            }
        }

        if (vehiculoEncontrado == null) {
            System.out.println("El vehiculo no existe.");
            return contratos;
        }

        if (vehiculoEncontrado.getEstado().equalsIgnoreCase("Alquilado")) {
            System.out.println("El vehiculo ya esta alquilado.");
            return contratos;
        }

        contrato.setPlacaVehiculo(placa);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd/MM/yyyy");

        System.out.println("Ingrese fecha inicio (dd/MM/yyyy):");

        String fechaInicio = val.validarFecha(sc);
        System.out.println("Ingrese fecha fin (dd/MM/yyyy):");
        String fechaFin = val.validarFecha(sc);
        LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
        LocalDate fin = LocalDate.parse(fechaFin, formatter);

        while (!fin.isAfter(inicio)) {

            System.out.println("La fecha fin debe ser posterior a la fecha inicio.");
            fechaFin = val.validarFecha(sc);
            fin = LocalDate.parse(fechaFin, formatter);
        }

        contrato.setFechaInicio(fechaInicio);
        contrato.setFechaFin(fechaFin);

        int dias = (int) ChronoUnit.DAYS.between(inicio, fin);

        contrato.setTotalDias(dias);
        float valorTotal = vehiculoEncontrado.getPrecioDiario() * dias;
        contrato.setValorTotal(valorTotal);
        vehiculoEncontrado.setEstado("Alquilado");

        contratos.add(contrato);

        System.out.println("Contrato registrado correctamente.");
        System.out.println("Vehiculo asignado: " + placa);
        System.out.println("Total de dias: " + dias);

        System.out.println("Valor total: " + valorTotal);

        return contratos;
    }

    // -------------------------------modificar contrato
    public LinkedList<ContratoRenting> modificarContrato(LinkedList<ContratoRenting> contratos,
            LinkedList<vehiculo> vehiculos, Scanner sc) {
        Validaciones val = new Validaciones();
        if (contratos.isEmpty()) {
            System.out.println("No hay contratos registrados.");
            return contratos;
        }

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return contratos;
        }

        System.out.println("Ingrese el ID del contrato a modificar:");
        String idContrato = val.validarIdContrato(sc);

        for (ContratoRenting c : contratos) {

            if (c.getIdContrato().equalsIgnoreCase(idContrato)) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                System.out.println("Nueva fecha inicio (dd/MM/yyyy):");
                String fechaInicio = val.validarFecha(sc);

                System.out.println("Nueva fecha fin (dd/MM/yyyy):");
                String fechaFin = val.validarFecha(sc);
                LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
                LocalDate fin = LocalDate.parse(fechaFin, formatter);

                while (!fin.isAfter(inicio)) {
                    System.out.println("La fecha fin debe ser posterior a la fecha inicio.");
                    fechaFin = val.validarFecha(sc);
                    fin = LocalDate.parse(fechaFin, formatter);
                }

                c.setFechaInicio(fechaInicio);
                c.setFechaFin(fechaFin);

                // Calcular días automáticamente
                long dias = java.time.temporal.ChronoUnit.DAYS
                        .between(inicio, fin);

                c.setTotalDias((int) dias);

                vehiculo vehiculoContrato = null;

                for (vehiculo v : vehiculos) {

                    if (v.getPlaca().equalsIgnoreCase(
                            c.getPlacaVehiculo())) {

                        vehiculoContrato = v;
                        break;
                    }
                }

                if (vehiculoContrato == null) {
                    System.out.println("No se encontro el vehiculo asociado al contrato.");
                    return contratos;
                }

                float valorTotal = vehiculoContrato.getPrecioDiario()
                        * (int) dias;

                c.setValorTotal(valorTotal);

                System.out.println("Contrato modificado correctamente.");
                System.out.println("Total de dias calculado: " + dias);
                System.out.println("Nuevo valor total: " + valorTotal);

                return contratos;
            }
        }

        System.out.println("No existe un contrato con ese ID.");

        return contratos;
    }

    // --------------Finalizar contrato/-----
    public LinkedList<ContratoRenting> finalizarContrato(
            LinkedList<ContratoRenting> contratos,
            LinkedList<vehiculo> vehiculos,
            Scanner sc) {

        Validaciones val = new Validaciones();

        if (contratos.isEmpty()) {

            System.out.println(
                    "No hay contratos registrados.");

            return contratos;
        }

        if (vehiculos.isEmpty()) {

            System.out.println(
                    "No hay vehiculos registrados.");

            return contratos;
        }

        System.out.println(
                "Ingrese el ID del contrato a finalizar:");

        String idContrato = val.validarIdContrato(sc);

        ContratoRenting contratoEliminar = null;

        for (ContratoRenting c : contratos) {

            if (c.getIdContrato()
                    .equalsIgnoreCase(idContrato)) {

                contratoEliminar = c;

                break;
            }
        }

        if (contratoEliminar == null) {

            System.out.println(
                    "No existe un contrato con ese ID.");

            return contratos;
        }

        boolean vehiculoEncontrado = false;

        for (vehiculo v : vehiculos) {

            if (v.getPlaca()
                    .equalsIgnoreCase(
                            contratoEliminar.getPlacaVehiculo())) {

                v.setEstado(
                        "Disponible");

                vehiculoEncontrado = true;

                break;
            }
        }

        if (!vehiculoEncontrado) {

            System.out.println(
                    "No se encontro el vehiculo asociado al contrato.");

            return contratos;
        }

        contratos.remove(contratoEliminar);

        System.out.println(
                "Contrato finalizado correctamente.");

        System.out.println(
                "Vehiculo "
                        + contratoEliminar.getPlacaVehiculo()
                        + " disponible nuevamente.");

        return contratos;
    }

    // ---------------------------buscar
    // contrato------------------------------------------------------
    // Buscar contrato rentiing
    public void buscarContrato(
            LinkedList<ContratoRenting> contratos,
            Scanner sc) {

        Validaciones val = new Validaciones();

        if (contratos.isEmpty()) {

            System.out.println(
                    "No hay contratos registrados.");

            return;
        }

        System.out.println(
                "Ingrese el ID del contrato:");

        String idContrato = val.validarIdContrato(sc);

        boolean encontrado = false;

        for (ContratoRenting c : contratos) {

            if (c.getIdContrato()
                    .equalsIgnoreCase(idContrato)) {

                encontrado = true;

                System.out.println(
                        "---------------------------------------");

                System.out.println(
                        "ID Contrato: "
                                + c.getIdContrato());

                System.out.println(
                        "Cedula Cliente: "
                                + c.getCedulaCliente());

                System.out.println(
                        "Placa Vehiculo: "
                                + c.getPlacaVehiculo());

                System.out.println(
                        "Fecha Inicio: "
                                + c.getFechaInicio());

                System.out.println(
                        "Fecha Fin: "
                                + c.getFechaFin());

                System.out.println(
                        "Total Dias: "
                                + c.getTotalDias());

                System.out.println(
                        "Valor Total: "
                                + c.getValorTotal());

                System.out.println(
                        "------------------------------------------");

                break;
            }
        }

        if (!encontrado) {

            System.out.println(
                    "No existe un contrato con ese ID.");
        }
    }
}
