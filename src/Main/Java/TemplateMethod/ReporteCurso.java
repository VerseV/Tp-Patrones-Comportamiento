package Main.Java.TemplateMethod;

import Main.Java.EntidadesBase.Alumno;
import Main.Java.EntidadesBase.Curso;

public class ReporteCurso extends ReporteAcademico {


    private Curso curso;

    public ReporteCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    protected void generarContenido() {
        System.out.println("Curso: " + curso.getTitulo());
        System.out.println("Alumnos inscriptos: " + curso.getAlumnos().size());
        System.out.println("Promedio general: " + curso.getPromedioCurso());

        for (Alumno a : curso.getAlumnos()) {
            System.out.println(" - " + a.getNombre() + " " + a.getApellido()
                    + " | Notas: " + a.getNotas()
                    + " | Promedio: " + a.getPromedio());
        }
    }
}