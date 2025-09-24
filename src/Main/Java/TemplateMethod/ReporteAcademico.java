package Main.Java.TemplateMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ReporteAcademico {



    // Template Method
    public final void generarReporte() {
        generarEncabezado();
        generarContenido();
        generarPie();
    }

    protected void generarEncabezado() {
        System.out.println("==== REPORTE ACADEMICO ====");
        System.out.println("Fecha: " + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
    }

    // Paso que cada subclase debe implementar
    protected abstract void generarContenido();

    protected void generarPie() {
        System.out.println("==== FIN DEL REPORTE ====\n");
    }
}
