package soft.controladores;

import soft.model.Parqueadero;
import soft.persistencia.Persistencia;

import java.time.LocalDateTime;

public class ModelFactoryController {
    Parqueadero parqueadero;


    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aqu� al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // M�todo para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        parqueadero = new Parqueadero();

        //1. inicializar datos y luego guardarlo en archivos
//		iniciarSalvarDatosPrueba();

        //2. Cargar los datos de los archivos
        //cargarDatosDesdeArchivos();


        //3. Guardar y Cargar el recurso serializable binario
//		guardarResourceBinario();
//		cargarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
		//guardarResourceXML();
        cargarResourceXML();


        //Siempre se debe verificar si la raiz del recurso es null

    }
    public String calcularTotalSalida(String placaSalida){
        if(parqueadero.existeRegistro(placaSalida)){
            int precio=  parqueadero.cobrarHoras(LocalDateTime.now(),placaSalida);
            parqueadero.eliminarRegistro(placaSalida);
            guardarResourceXML();
            return "El precio a Cobrar es : $"+precio;
        }
        return "No se encontro un Vehiculo con la Placa "+placaSalida;

    }
    public String ingresarVehiculo(String placaIngreso,String tipo){

        if (!parqueadero.existeRegistro(placaIngreso)) {
            parqueadero.registarVehiculo(placaIngreso, tipo);
            guardarResourceXML();
            return "Se ingreso Correctamente el vehiculo con Placa : " + placaIngreso;
        }else return "El vehiculo ya se encuentra en el parqueadero";

    }
    public void cargarResourceXML() {

        parqueadero = Persistencia.cargarRecursoXML();
    }


    public void guardarResourceXML() {

        Persistencia.guardarRecursoXML(parqueadero);
    }


    //Registrar la accion de incio de sesi�n
    //Persistencia.guardaRegistroLog("Inicio de sesi�n del usuario:pedro", 1, "inicioSesion");


    // }



    /*private void iniciarSalvarDatosPrueba() {

        inicializarDatos();

        try {

            Persistencia.guardarEmpleados(getBanco().getListaEmpleados());
            Persistencia.guardarClientes(getBanco().getListaClientes());

            //Persistencia.cargarDatosArchivos(getBanco());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private void cargarDatosDesdeArchivos() {

        banco = new Banco();

        try {

            Persistencia.cargarDatosArchivos(getBanco());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void cargarResourceBinario() {

        banco = Persistencia.cargarRecursoBancoBinario();
    }


    public void guardarResourceBinario() {

        Persistencia.guardarRecursoBancoBinario(banco);
    }






    private void inicializarDatos() {

        banco = new Banco();

        Cliente cliente = new Cliente();
        cliente.setNombre("juan");
        cliente.setApellido("arias");
        cliente.setCedula("125454");
        cliente.setDireccion("Armenia");
        cliente.setCorreo("uni1@");
        cliente.setFechaNacimiento("12454");
        cliente.setTelefono("125444");

        banco.getListaClientes().add(cliente);

        cliente = new Cliente();
        cliente.setNombre("Pedro");
        cliente.setApellido("Perez");
        cliente.setCedula("77787");
        cliente.setDireccion("Pererira");
        cliente.setCorreo("uni2@");
        cliente.setFechaNacimiento("12454");
        cliente.setTelefono("125444");

        banco.getListaClientes().add(cliente);

        cliente = new Cliente();
        cliente.setNombre("Alberto");
        cliente.setApellido("Arias");
        cliente.setCedula("12555");
        cliente.setDireccion("Pererira");
        cliente.setCorreo("uni3@");
        cliente.setFechaNacimiento("12454");
        cliente.setTelefono("125444");

        banco.getListaClientes().add(cliente);


        Empleado empleado = new Empleado();
        empleado.setNombre("juan");
        empleado.setApellido("arias");
        empleado.setCedula("125454");
        empleado.setFechaNacimiento("12454");
        banco.getListaEmpleados().add(empleado);


        empleado = new Empleado();
        empleado.setNombre("Ana");
        empleado.setApellido("alzate");
        empleado.setCedula("125454");
        empleado.setFechaNacimiento("12454");
        banco.getListaEmpleados().add(empleado);

        empleado = new Empleado();
        empleado.setNombre("Pedro");
        empleado.setApellido("perez");
        empleado.setCedula("125454");
        empleado.setFechaNacimiento("12454");
        banco.getListaEmpleados().add(empleado);

        System.out.println("Banco inicializado "+banco );

    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }


    @Override
    public Empleado crearEmpleado(String nombre, String apellido, String cedula, String fechaNacimiento) {


        Empleado empleado = null;

        try {
            empleado = getBanco().crearEmpleado(nombre, apellido, cedula, fechaNacimiento);
        } catch (EmpleadoException e) {
            e.getMessage();
        }

        return empleado;

    }

    @Override
    public boolean actualizarEmpleado(String cedulaActual, String nombre, String apellido, String cedula, String fechaNacimiento) {

        return getBanco().actualizarEmpleado(cedulaActual, nombre, apellido, cedula, fechaNacimiento);
    }

    @Override
    public Boolean eliminarEmpleado(String cedula) {

        boolean flagEmpleadoExiste = false;

        try {
            flagEmpleadoExiste = getBanco().eliminarEmpleado(cedula);
        } catch (EmpleadoException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        return flagEmpleadoExiste;
    }

    @Override
    public Empleado obtenerEmpleado(String cedula) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Empleado> obtenerEmpleados() {

        return banco.getListaEmpleados();
    }*/

}


