package Main.Java.Command;



public class AbandonarCursoCommand implements Command {
    private AlumnoReceiver alumno;
    private String curso;

    public AbandonarCursoCommand(AlumnoReceiver alumno, String curso) {
        this.alumno = alumno;
        this.curso = curso;
    }

    @Override
    public void execute() {
        alumno.abandonarCurso(curso);
    }
}