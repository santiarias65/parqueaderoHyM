package soft.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Parqueadero implements Serializable {
    private static final long serialVersionUID = 1L;
    ArrayList<Registro> registros = new ArrayList<>();

    public Parqueadero(){}



    public void registarVehiculo(String placa, String cadenaTipo){
        Tipo tipo = new Tipo(asiganarTipo(cadenaTipo));
        Vehiculo vehiculo = new Vehiculo(placa,tipo);
        Registro registro = new Registro(LocalDateTime.now(),vehiculo);
        registros.add(registro);

    }
    public void eliminarRegistro(String placa){
        for (int i = 0; i < registros.size(); i++) {
            if (registros.get(i).getVehiculo().getPlaca().equalsIgnoreCase(placa)){
                getRegistros().remove(registros.get(i));
            }
        }
    }
    public boolean existeRegistro(String placa){
        Boolean bandera=false;
        for (int i = 0; i < registros.size(); i++) {
            if (registros.get(i).getVehiculo().getPlaca().equalsIgnoreCase(placa)){
                bandera = true;
            }
        }
        return bandera;
    }
    public Registro buscarRegistro(String placa){
        Registro registro=null;
        for (int i = 0; i < registros.size(); i++) {
            if (registros.get(i).getVehiculo().getPlaca().equals(placa)){
                registro=registros.get(i);
            }
        }
        return registro;
    }

    public int cobrarHoras(LocalDateTime horaSalida,String placa){
        Registro registro=buscarRegistro(placa);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime horaLlegada = LocalDateTime.parse(registro.getFechaCadena(),formatter);
        int horas = (int) ChronoUnit.HOURS.between(horaLlegada,horaSalida);
        int minutos = (int) ChronoUnit.MINUTES.between(horaLlegada,horaSalida);
        if(minutos>20 && horas>0){
            horas++;
        }
        int precio = horas*registro.getVehiculo().getTipo().getTipo().getPrecio();
        if(horas<1){
            precio=registro.getVehiculo().getTipo().getTipo().getPrecio();
        }
        registros.remove(registro);
        return precio;

    }

    public DatosTipo asiganarTipo(String cadenaTipo){
        if(cadenaTipo.equals(Tipo.getTurboVolqueta().getNombre())){
            return Tipo.getTurboVolqueta();
        }else if(cadenaTipo.equals(Tipo.getMoto().getNombre())){
            return Tipo.getMoto();
        }else if(cadenaTipo.equals(Tipo.getParticular().getNombre())){
            return Tipo.getParticular();
        }else {
            return Tipo.getCamion();
        }

    }

    public ArrayList<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<Registro> registros) {
        this.registros = registros;
    }
}
