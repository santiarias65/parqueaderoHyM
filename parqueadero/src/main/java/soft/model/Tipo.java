package soft.model;

import java.io.Serializable;

public class Tipo implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final DatosTipo turboVolqueta = new DatosTipo("turboVolqueta",2000,9000);
    private static final DatosTipo moto = new DatosTipo("moto",700,4000);
    private static final DatosTipo particular = new DatosTipo("particular",1500,8000);
    private static final DatosTipo camion = new DatosTipo("camion",2000,10000);
    private DatosTipo tipo;

    public Tipo(){

    }
    public Tipo(DatosTipo tipo) {
        this.tipo = tipo;
    }
    public void setTipo(DatosTipo tipo){
        this.tipo = tipo;
    }

    public static DatosTipo getTurboVolqueta() {
        return turboVolqueta;
    }

    public static DatosTipo getMoto() {
        return moto;
    }

    public static DatosTipo getParticular() {
        return particular;
    }

    public static DatosTipo getCamion() {
        return camion;
    }

    public DatosTipo getTipo() {
        return tipo;
    }

}
