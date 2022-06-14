package soft.persistencia;

import soft.model.Parqueadero;

public class Persistencia {
    public static final String RUTA_ARCHIVO_MODELO_PARQUEADERO_XML = "src/main/resources/model.xml";

    public static Parqueadero cargarRecursoXML() {

        Parqueadero parqueadero = null;

        try {
            parqueadero = (Parqueadero)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PARQUEADERO_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return parqueadero;

    }



    public static void guardarRecursoXML(Parqueadero parqueadero) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PARQUEADERO_XML, parqueadero);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
