package Main.Java.EntidadesBase;

import Main.Java.Visitor.Visitor;

public class AlumnoRegular extends Alumno {

    @Override
    public void aceptar(Visitor v) {
        v.visitar(this);
    }
}
