package Main.Java.Visitor;

import Main.Java.EntidadesBase.AlumnoRegular;
import Main.Java.EntidadesBase.AlumnoBecado;

public class AplicarBeca implements Visitor {

    @Override
    public void visitar(AlumnoRegular a) {
        System.out.println(a.getNombre() + " es alumno regular, debe abonar matrícula completa.");
    }

    @Override
    public void visitar(AlumnoBecado a) {
        System.out.println(a.getNombre() + " es alumno becado con " + a.getPorcentajeBeca() + "% de descuento en la matrícula.");
    }
}
