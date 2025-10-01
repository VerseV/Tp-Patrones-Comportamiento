package Main.Java.Command;



public class SolicitarCertificadoCommand implements Command {
    private AlumnoReceiver alumno;
    private String curso;

    public SolicitarCertificadoCommand(AlumnoReceiver alumno, String curso) {
        this.alumno = alumno;
        this.curso = curso;
    }

    @Override
    public void execute() {
        alumno.solicitarCertificado(curso);
    }
}