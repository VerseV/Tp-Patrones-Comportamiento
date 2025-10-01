package Main.Java.Command;


public class InscribirseCursoCommand implements Command {
    private AlumnoReceiver alumno;
    private String curso;

    public InscribirseCursoCommand(AlumnoReceiver alumno, String curso) {
        this.alumno = alumno;
        this.curso = curso;
    }

    @Override
    public void execute() {
        alumno.inscribirseCurso(curso);
    }
}