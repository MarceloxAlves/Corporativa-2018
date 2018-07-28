import java.util.HashMap;
import java.util.Map;

public class Romano {
    private char[] algarismos;


    private Map<Character, Integer> algarismosBase;

    public Romano(String algarismos) {
        this.algarismos = algarismos.toUpperCase().toCharArray();
        algarismosBase = initializeAlgarismoBase();
        this.validarNumero();
    }

    private void validarNumero() {
        this.noEmpty();
        this.caracterValidos();
        this.noSequencia();
        this.maiorSequenciaValida();
        this.sequenciaAntesNumeroMaior();
    }

    private void caracterValidos(){
        for (int i=0; i < algarismos.length; i++) {
            if (!algarismosBase.containsKey(algarismos[i])) throw new IllegalArgumentException("Algarismo (" + algarismos[i] + ") inválido" );
        }
    }

    private void noEmpty(){

        if (algarismos.length == 0) throw new IllegalArgumentException("Romano vazio");
    }

    private void noSequencia(){
        int maiorSequencia = 1;
        int temp = 1;
        for (int i=0; i < algarismos.length-1; i++) {
            if (String.valueOf(algarismosBase.get(algarismos[i])).charAt(0) != '5') {
                temp = 1;
                continue;
            }
            if (algarismos[i] == algarismos[i + 1]) {
                temp++;
            } else {
                temp = 1;
            }
            maiorSequencia = (int) MyMath.maior((double) maiorSequencia,(double) temp);
            if (maiorSequencia > 1) throw new IllegalArgumentException("Seguencia de caracter repetidos eh inválidos!");

        }
    }

    private void sequenciaAntesNumeroMaior(){
        if(algarismos.length < 2) return;
        int sequencia = 1;
        int valorSequencia = algarismosBase.get(algarismos[0]);
        for (int i=1; i < algarismos.length; i++) {
            if (valorSequencia == algarismosBase.get(algarismos[i])){
                sequencia++;
            }else{
                if(algarismosBase.get(algarismos[i]) > valorSequencia && sequencia > 1) throw new IllegalArgumentException("Seguencia  de caracteres repetidos antes de um numero maior eh inválida !");
                valorSequencia =  algarismosBase.get(algarismos[i]);
                sequencia = 1;
            }
        }
    }

    private void maiorSequenciaValida(){
        int maiorSequencia = 1;
        int temp = 1;
        for (int i=0; i < algarismos.length-1; i++) {
            if(algarismos[i] == algarismos[i+1]) {
                temp++;
            }else {
                temp = 1;
            }
            maiorSequencia = (int) MyMath.maior((double) maiorSequencia,(double) temp);
            if (maiorSequencia > 3) throw new IllegalArgumentException("Seguencia de caracter repetidos eh inválidos!");
        }
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