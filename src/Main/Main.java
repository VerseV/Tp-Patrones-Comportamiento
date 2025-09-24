package Main;


import Main.Java.EntidadesBase.Alumno;
import Main.Java.EntidadesBase.Curso;
import Main.Java.TemplateMethod.ReporteAlumno;
import Main.Java.TemplateMethod.ReporteCurso;


public class Main {
    public static void main(String[] args) {


        //CREACIÓN DE ENTIDADES BASE


        Long id = 0L; //para asignar e incrementar

        Curso curso3k9 = new Curso();
        curso3k9.setTitulo("Curso 3k9");

        Alumno a1 = new Alumno();
        a1.setLegajo(123456);
        a1.setNombre("Paula");
        a1.setApellido("Bomprezzi");
        a1.setEdad(22);
        a1.setId(id);
        id++;


        Alumno a2 = new Alumno();
        a2.setLegajo(789012);
        a2.setNombre("Lucas");
        a2.setApellido("Fernández");
        a2.setEdad(24);
        a2.setId(id);
        id++;

        Alumno a3 = new Alumno();
        a3.setLegajo(345678);
        a3.setNombre("Martina");
        a3.setApellido("Gómez");
        a3.setEdad(21);
        a3.setId(id);
        id++;




        //PATRÓN OBSERVER
        curso3k9.addObserver(a1);
        curso3k9.addObserver(a2);
        curso3k9.addObserver(a3);

        curso3k9.cambiarHorario("12:30");

        //PATRON TEMPLATE METHOD
        System.out.println("\n--- TEMPLATE METHOD ---");
        ReporteCurso rc = new ReporteCurso(curso3k9);
        rc.generarReporte();

        ReporteAlumno ra = new ReporteAlumno(a1);
        ra.generarReporte();



    }
}