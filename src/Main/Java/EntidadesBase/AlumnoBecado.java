package Main.Java.EntidadesBase;

import Main.Java.Visitor.Visitor;

public class AlumnoBecado extends Alumno {

    private double porcentajeBeca = 50.0; // Por defecto 50%

    public double getPorcentajeBeca() {
        return porcentajeBeca;
    }

    public void setPorcentajeBeca(double porcentajeBeca) {
        this.porcentajeBeca = porcentajeBeca;
    }

    @Override
    public void aceptar(Visitor v) {
        v.visitar(this);
    }
}
