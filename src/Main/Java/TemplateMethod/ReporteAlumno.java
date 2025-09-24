package Main.Java.TemplateMethod;

import Main.Java.EntidadesBase.Alumno;

public class ReporteAlumno extends ReporteAcademico{

    private Alumno alumno;

    public ReporteAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    protected void generarContenido() {
        System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getApellido());
        System.out.println("Edad: " + alumno.getEdad() + " años");
        System.out.println("Notas: " + alumno.getNotas());
        System.out.println("Promedio general: " + alumno.getPromedio());
    }
}
