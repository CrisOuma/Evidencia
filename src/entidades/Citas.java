package entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Citas implements Serializable {
    private Date fecha;
    private Time hora;
    private String motivo;
    private int idC;

    public Citas(Date fecha, Time hora, String motivo, int idC){
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.idC = idC;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }
}
