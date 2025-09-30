package Main.Java.Visitor;

import Main.Java.EntidadesBase.AlumnoRegular;
import Main.Java.EntidadesBase.AlumnoBecado;

public interface Visitor {
    void visitar(AlumnoRegular a);
    void visitar(AlumnoBecado a);
}
