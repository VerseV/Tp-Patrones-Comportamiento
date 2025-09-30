package Main.Java.Iterator;

import Main.Java.EntidadesBase.Curso;
import java.util.List;

public class AlumnoCursoIterator implements CursoIterator {

    private final List<Curso> cursos;
    private int posicion = 0;

    public AlumnoCursoIterator(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public boolean hasNext() {
        return posicion < cursos.size();
    }

    @Override
    public Curso next() {
        return cursos.get(posicion++);
    }
}
