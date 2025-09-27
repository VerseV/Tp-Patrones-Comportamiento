package Main;


import Main.Java.EntidadesBase.Alumno;
import Main.Java.EntidadesBase.Curso;
import Main.Java.TemplateMethod.ReporteAcademico;
import Main.Java.TemplateMethod.ReporteAlumno;
import Main.Java.TemplateMethod.ReporteCurso;
import Main.java.State.Inscripcion;


public class Main {
    public static void main(String[] args) {


        //CREACIÓN DE ENTIDADES BASE

        Long id = 0L; //para asignar e incrementar

        Curso curso3k9 = new Curso();
        curso3k9.setTitulo("Curso 3k9");
        curso3k9.setCupoMaximo(2);

        Alumno a1 = new Alumno();
        a1.setLegajo(123456);
        a1.setNombre("Paula");
        a1.setApellido("Bomprezzi");
        a1.setEdad(22);
        a1.setId(id);
        a1.agregarNota(8);
        a1.agregarNota(9);
        id++;


        Alumno a2 = new Alumno();
        a2.setLegajo(789012);
        a2.setNombre("Lucas");
        a2.setApellido("Fernández");
        a2.setEdad(24);
        a2.setId(id);
        a2.agregarNota(6);
        a2.agregarNota(7);
        id++;

        Alumno a3 = new Alumno();
        a3.setLegajo(345678);
        a3.setNombre("Martina");
        a3.setApellido("Gómez");
        a3.setEdad(21);
        a3.setId(id);
        a3.agregarNota(10);
        a3.agregarNota(9);
        id++;




        // ============================================================
        // PATRÓN OBSERVER
        // ============================================================
        System.out.println("\n---  OBSERVER ---");
        curso3k9.addObserver(a1);
        curso3k9.addObserver(a2);
        curso3k9.addObserver(a3);

        curso3k9.cambiarHorario("12:30");

        // ============================================================
        // PATRÓN TEMPLATE METHOD
        // ============================================================
        System.out.println("\n--- TEMPLATE METHOD ---");
        // Relacionar alumnos con el curso
        curso3k9.agregarAlumno(a1);
        curso3k9.agregarAlumno(a2);
        curso3k9.agregarAlumno(a3);

        // Reporte por curso
        ReporteAcademico reporteCurso = new ReporteCurso(curso3k9);
        reporteCurso.generarReporte();

        // Reportes individuales por alumno
        ReporteAcademico reporteAlumno1 = new ReporteAlumno(a1);
        reporteAlumno1.generarReporte();

        ReporteAcademico reporteAlumno2 = new ReporteAlumno(a2);
        reporteAlumno2.generarReporte();

        ReporteAcademico reporteAlumno3 = new ReporteAlumno(a3);
        reporteAlumno3.generarReporte();

    // ============================================================
    // PATRÓN STATE - INSCRIPCIONES
    // ============================================================
        System.out.println("\n--- STATE (INSCRIPCIONES) ---");

    Inscripcion ins1 = new Inscripcion(a1, curso3k9);
    Inscripcion ins2 = new Inscripcion(a2, curso3k9);
    Inscripcion ins3 = new Inscripcion(a3, curso3k9);

        System.out.println("\n--- ESTADOS INICIALES ---");
        ins1.mostrarEstado();
        ins2.mostrarEstado();
        ins3.mostrarEstado();

        System.out.println("\n--- CAMBIO DE ESTADOS ---");
        ins1.cambiarEstado();
        ins2.cambiarEstado();
        ins3.cambiarEstado();

        ins1.mostrarEstado();
        ins2.mostrarEstado();
        ins3.mostrarEstado();
}

}