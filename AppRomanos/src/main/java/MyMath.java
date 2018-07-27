public class MyMath {

     public static double abs(double numero){
         return numero < 0 ? numero * -1 : numero;
     }

    public static double maior(double numero1, double numero2){
        return  (numero1 + numero2 + MyMath.abs(numero1 - numero2) )/2;
    }
}

