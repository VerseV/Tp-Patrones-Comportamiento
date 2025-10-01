package Main.Java.Strategy;

import java.util.List;

public class PromedioPonderado implements CalculoNota{

    @Override
    public double calcular(List<Integer> notas) {
        if (notas.isEmpty()) return 0.0;

        int n=notas.size();
        double suma=0;
        int pesoTotal=0;

        for (int i=0; i < n ; i++){
            int peso = (i == n-1) ? 2:1;
            suma += notas.get(i) * peso;
            pesoTotal += peso;
        }
        return suma / pesoTotal;  //Calculo de notas
    }
}
