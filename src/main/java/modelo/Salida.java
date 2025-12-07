package modelo;

import java.sql.Date;

public class Salida {

    private int idSalida;
    private String numSalida;
    private Date fecha;
    private double subtotal;
    private double igv;
    private double total;

    // Getters y Setters
    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public String getNumSalida() {
        return numSalida;
    }

    public void setNumSalida(String numSalida) {
        this.numSalida = numSalida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
