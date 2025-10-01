package Main.Java.Command;

public class AlumnoReceiver {
    private String nombre;

    public AlumnoReceiver(String nombre) {
        this.nombre = nombre;
    }

    public void inscribirseCurso(String curso) {
        System.out.println(nombre + " se inscribió en el curso: " + curso);
    }

    public void abandonarCurso(String curso) {
        System.out.println(nombre + " abandonó el curso: " + curso);
    }

    public void solicitarCertificado(String curso) {
        System.out.println(nombre + " solicitó certificado del curso: " + curso);
    }
}