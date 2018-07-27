import java.util.HashMap;
import java.util.Map;

public class Romano {
    private char[] algarismos;


    private Map<Character, Integer> algarismosBase;

    public Romano(String algarismos) {
        this.algarismos = algarismos.toCharArray();
        algarismosBase = initializeAlgarismoBase();
        this.validar();
    }

    private void validar() {
        for (int i=0; i < algarismos.length; i++) {
            if (!algarismosBase.containsKey(algarismos[i])) throw new IllegalArgumentException("Algarismo (" + algarismos[i] + ") inválido" );
        }
        if (!sequenciaValida()) throw new IllegalArgumentException("Número de algarismos repetidos inválidos!");
    }

    private boolean sequenciaValida(){
        if(algarismos.length <= 3) return true;
        if (maiorSequencia() <= 3) return true;
        return false;
    }

    private int maiorSequencia(){
        int maiorSequencia = 1;
        int temp = 1;
        for (int i=0; i < algarismos.length-1; i++) {
            if(algarismos[i] == algarismos[i+1]) {
                temp++;
            }else {
                temp = 1;
            }
            maiorSequencia = (int) MyMath.maior((double) maiorSequencia,(double) temp);
        }
        return maiorSequencia;
    }

    public int converter() {
        int valor = 0;
        for (int i=0; i < algarismos.length; i++) {
            if( (i + 1) < algarismos.length){
                if(algarismosBase.get(algarismos[i]) < algarismosBase.get(algarismos[i+1])) {
                    valor += (algarismosBase.get(algarismos[i + 1]) - algarismosBase.get(algarismos[i]));
                    ++i;
                    continue;
                }
            }
            valor += algarismosBase.get(algarismos[i]);

        }
        return (int) MyMath.abs(valor);
    }

    private Map<Character, Integer> initializeAlgarismoBase(){
            Map<Character, Integer> algoInicial = new HashMap<Character, Integer>();
            algoInicial.put('I',1);
            algoInicial.put('V',5);
            algoInicial.put('X',10);
            algoInicial.put('L',50);
            algoInicial.put('C',100);
            algoInicial.put('D',500);
            algoInicial.put('M',1000);

            return algoInicial;
    }
}
