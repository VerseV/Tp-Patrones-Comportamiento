package Main;


import Main.Java.EntidadesBase.Alumno;
import Main.Java.EntidadesBase.Curso;
import Main.Java.TemplateMethod.ReporteAcademico;
import Main.Java.TemplateMethod.ReporteAlumno;
import Main.Java.TemplateMethod.ReporteCurso;
import Main.Java.State.Inscripcion;
import Main.Java.Strategy.ExamenExtra;
import Main.Java.Strategy.PromedioPonderado;
import Main.Java.Strategy.PromedioSimple;
import Main.Java.Iterator.CursoIterator;
import Main.Java.Mediator.ChatRoom;
import Main.Java.EntidadesBase.Profesor;
import Main.Java.Memento.Examen;
import Main.Java.Memento.Memento;
import Main.Java.Visitor.AplicarBeca;
import Main.Java.Visitor.Visitor;
import Main.Java.EntidadesBase.AlumnoRegular;
import Main.Java.EntidadesBase.AlumnoBecado;
import Main.Java.ChainOfResponsability.Solicitud;
import Main.Java.ChainOfResponsability.Handler;
import Main.Java.ChainOfResponsability.AsistenteHandler;
//import Main.Java.ChainOfResponsability.ProfesorHandler;
import Main.Java.ChainOfResponsability.CoordinadorHandler;
import Main.Java.Command.AlumnoReceiver;
import Main.Java.Command.Command;
import Main.Java.Command.Invoker;
import Main.Java.Command.InscribirseCursoCommand;
import Main.Java.Command.AbandonarCursoCommand;
import Main.Java.Command.SolicitarCertificadoCommand;







public class Main {
    public static void main(String[] args) {


        //CREACIÓN DE ENTIDADES BASE

        Long id = 0L; //para asignar e incrementar

        Curso curso3k9 = new Curso();
        curso3k9.setTitulo("Curso 3k9");
        curso3k9.setCupoMaximo(4);
        //Otro curso para State
        Curso curso3k10 = new Curso();
        curso3k10.setTitulo("Curso 3k10");
        curso3k10.setCupoMaximo(0);

        Alumno a1 = new Alumno();
        a1.setLegajo(12345);
        a1.setNombre("Paula");
        a1.setApellido("Bomprezzi");
        a1.setEdad(22);
        a1.setId(id);
        a1.agregarNota(8);
        a1.agregarNota(9);
        id++;


        Alumno a2 = new Alumno();
        a2.setLegajo(78901);
        a2.setNombre("Lucas");
        a2.setApellido("Fernández");
        a2.setEdad(24);
        a2.setId(id);
        a2.agregarNota(6);
        a2.agregarNota(7);
        id++;

        Alumno a3 = new Alumno();
        a3.setLegajo(34567);
        a3.setNombre("Martina");
        a3.setApellido("Gómez");
        a3.setEdad(21);
        a3.setId(id);
        a3.agregarNota(10);
        a3.agregarNota(9);
        id++;

        //Agrego alumno para State
        Alumno a4 = new Alumno();
        a4.setLegajo(69567);
        a4.setNombre("Tomas");
        a4.setApellido("Vicente");
        a4.setEdad(21);
        a4.setId(id);

         // ============================================================
        // PATRÓN CHAIN OF RESPONSIBILITY - SOLICITUDES DE TUTORÍAS
        // ============================================================
        System.out.println("\n--- CHAIN OF RESPONSIBILITY ---");

        Handler asistente = new AsistenteHandler();
        Handler profesor = new Profesor();
        Handler coordinador = new CoordinadorHandler();

        // Armamos la cadena: Asistente -> Profesor -> Coordinador
        asistente.setNext(profesor);
        profesor.setNext(coordinador);

        // Creamos solicitudes con distintos niveles
        Solicitud s1 = new Solicitud("Consulta sobre inscripción", 1);
        Solicitud s2 = new Solicitud("Duda técnica de programación", 2);
        Solicitud s3 = new Solicitud("Problema grave con el curso", 3);

        // Procesamos solicitudes
        asistente.handle(s1);
        asistente.handle(s2);
         asistente.handle(s3);

        // ============================================================
       // PATRÓN COMMAND - ACCIONES DE ALUMNO
      // ============================================================
      System.out.println("\n--- COMMAND ---");

      AlumnoReceiver alumnoCmd = new AlumnoReceiver("Juan Pérez");
      Invoker invoker = new Invoker();

      // Creamos los comandos
      Command inscribirse = new InscribirseCursoCommand(alumnoCmd, "Patrones de Diseño");
      Command abandonar = new AbandonarCursoCommand(alumnoCmd, "Base de Datos");
      Command solicitarCert = new SolicitarCertificadoCommand(alumnoCmd, "Matemática");

      // Ejecutamos comandos a través del invoker
      invoker.executeCommand(inscribirse);
      invoker.executeCommand(abandonar);
      invoker.executeCommand(solicitarCert);

      // Mostrar historial
      invoker.showHistory();






        // ============================================================
        // PATRÓN OBSERVER
        // ============================================================
        System.out.println("\n---  OBSERVER ---");
        curso3k9.addObserver(a1);
        curso3k9.addObserver(a2);
        curso3k9.addObserver(a3);
        curso3k10.addObserver(a4);

        curso3k9.cambiarHorario("12:30");
        curso3k10.cambiarHorario("17:45");

        // ============================================================
        // PATRÓN TEMPLATE METHOD
        // ============================================================
        System.out.println("\n--- TEMPLATE METHOD ---");
        // Relacionar alumnos con el curso
        curso3k9.agregarAlumno(a1);
        curso3k9.agregarAlumno(a2);
        curso3k9.agregarAlumno(a3);
        //Agrego para State
        curso3k10.agregarAlumno(a4);

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
    Inscripcion ins4 = new Inscripcion(a4, curso3k10);

        System.out.println("\n--- ESTADOS INICIALES ---");
        ins1.mostrarEstado();
        ins2.mostrarEstado();
        ins3.mostrarEstado();
        ins4.mostrarEstado();

        System.out.println("\n--- CAMBIO DE ESTADOS ---");
        ins1.cambiarEstado();
        ins2.cambiarEstado();
        ins3.cambiarEstado();
        ins4.cambiarEstado();

        System.out.println("\n--- ESTADOS ACTUALES ---");
        ins1.mostrarEstado();
        ins2.mostrarEstado();
        ins3.mostrarEstado();
        ins4.mostrarEstado();

        // ============================================================
        // PATRÓN STRATEGY - CALCULAR NOTA
        // ========================================================

        System.out.println("\n--- STRATEGY ---");

        a1.setNombre("Paula");
        a1.agregarNota(8);
        a1.agregarNota(9);
        a1.agregarNota(7);

        a1.setEstrategia(new PromedioSimple());
        System.out.println("Promedio simple: " + a1.calcularNotaFinal());

        a1.setEstrategia(new PromedioPonderado());
        System.out.println("Promedio ponderado: " + a1.calcularNotaFinal());

        a1.setEstrategia(new ExamenExtra());
        System.out.println("Con examen extra: " + a1.calcularNotaFinal());
        // ============================================================
        // PATRÓN ITERATOR
        // ============================================================
        System.out.println("\n--- ITERATOR ---");

        a1.inscribirCurso(curso3k9);
        a1.inscribirCurso(curso3k10);
        a2.inscribirCurso(curso3k9);
        a3.inscribirCurso(curso3k9);

        CursoIterator it = a1.iterator();
        System.out.println("Cursos de " + a1.getNombre() + ":");
        while (it.hasNext()) {
            System.out.println(" - " + it.next().getTitulo());
        }
        // ============================================================
        // PATRÓN MEDIATOR - CHAT
        // ============================================================
        System.out.println("\n--- MEDIATOR (CHAT) ---");

        ChatRoom chat = new ChatRoom();

        // Registramos participantes en la sala
        chat.registrarUsuario(a1);
        chat.registrarUsuario(a2);
        chat.registrarUsuario(a3);

        // Creamos y registramos un profesor
        Profesor prof = new Profesor();
        prof.setNombre("Diego");
        prof.setApellido("Ramos");
        prof.setEdad(40);
        prof.setId(id++);
        chat.registrarUsuario(prof);

        // Asignamos el mediador a cada usuario
        a1.setChatMediator(chat);
        a2.setChatMediator(chat);
        a3.setChatMediator(chat);
        prof.setChatMediator(chat);

        // Enviamos mensajes
        a1.enviarMensaje("Hola a todos!");
        prof.enviarMensaje("Buen día, bienvenidos al curso.");
        a2.enviarMensaje("Gracias profe!");
        // ============================================================
        // PATRÓN MEMENTO - EXAMEN
        // ============================================================
        System.out.println("\n--- MEMENTO ---");

        Examen examen = new Examen();

        // El alumno responde algunas preguntas
        examen.responder("Respuesta 1: A");
        examen.responder("Respuesta 2: C");
        examen.mostrarRespuestas();

        // Guardamos el estado en un memento
        Memento checkpoint = examen.save();

        // El alumno sigue respondiendo
        examen.responder("Respuesta 3: B");
        examen.mostrarRespuestas();

        // Restauramos al estado guardado
        examen.restore(checkpoint);
        System.out.println("Después de restaurar:");
        examen.mostrarRespuestas();
        // ============================================================
        // PATRÓN VISITOR - APLICAR BECAS
        // ============================================================
        System.out.println("\n--- VISITOR ---");

        AlumnoRegular ar = new AlumnoRegular();
        ar.setNombre("Sofia");
        ar.setApellido("Martinez");
        ar.setEdad(22);

        AlumnoBecado ab = new AlumnoBecado();
        ab.setNombre("Pedro");
        ab.setApellido("Lopez");
        ab.setEdad(21);
        ab.setPorcentajeBeca(75.0);

        Visitor aplicarBeca = new AplicarBeca();

        ar.aceptar(aplicarBeca);
        ab.aceptar(aplicarBeca);

    }

}
