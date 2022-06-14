package soft.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fechaTabla;
    private LocalDateTime horaLlegada;
    private LocalDateTime horaSalida;
    private String fechaCadena;

    
    private Vehiculo vehiculo;

    public Registro(){

    }
    public Registro( LocalDateTime horaLlegada, Vehiculo vehiculo) {
        DateTimeFormatter formatter= DateTimeFormatter.ISO_DATE_TIME;
        this.fechaTabla = LocalDate.now()+" Hora "+ LocalTime.now().getHour()+":"+LocalTime.now().getMinute();
        this.horaLlegada = horaLlegada;
        this.fechaCadena = horaLlegada.format(formatter);
        this.vehiculo = vehiculo;
    }

    public String getPlaca(){
        return vehiculo.getPlaca();
    }
    public String getTipo(){
        return vehiculo.getTipo().getTipo().getNombre();
    }


    public String getFechaCadena() {
        return fechaCadena;
    }

    public void setFechaCadena(String fechaCadena) {
        this.fechaCadena = fechaCadena;
    }

    public String getFechaTabla() {
        return fechaTabla;
    }

    public void setFechaTabla(String fechaTabla) {
        this.fechaTabla = fechaTabla;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
