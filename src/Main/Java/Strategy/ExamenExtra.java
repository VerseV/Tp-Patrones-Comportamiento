package Main.Java.Strategy;

import java.util.List;

public class ExamenExtra implements CalculoNota{

    @Override
    public double calcular(List<Integer> notas) {
        double promedio = notas.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        return promedio + 1; //Calculo de notas
    }
}
