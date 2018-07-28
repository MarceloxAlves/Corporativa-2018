import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestAlgarismosRomano {

    Romano romano;
    Map<Character, Integer> algarismoInicial;

    @Before
    public void setup(){
         romano = new Romano("XV");
        algarismoInicial = new HashMap<Character, Integer>();
        algarismoInicial.put('I',1);
        algarismoInicial.put('V',5);
        algarismoInicial.put('X',10);
        algarismoInicial.put('L',50);
        algarismoInicial.put('C',100);
        algarismoInicial.put('D',500);
        algarismoInicial.put('M',1000);
    }

    @Test
    public void deve_converter_romanos_para_arabicos_com_um_caracter_simples(){

         algarismoInicial.forEach((k, v) -> {
             romano = new Romano(String.valueOf(k));
             assertEquals((int)v,romano.converter());
         });
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_rejeitar_caracter_invalidos(){
        romano = new Romano("*");
    }

    @Test
    public void deve_converter_romanos_para_arabicos_com_dois_caracter(){
        romano = new Romano("IX");
        assertEquals(9,romano.converter());
    }


    @Test
    public void deve_converter_romanos_para_arabicos_com_tres_caracter(){
        romano = new Romano("XII");
        assertEquals(12,romano.converter());
    }

    @Test
    public void deve_converter_romanos_para_arabicos_com_tres_caracter_iguais(){
        romano = new Romano("VIII");
        assertEquals(8,romano.converter());
    }

    @Test
    public void test_centenas_simples(){
        romano = new Romano("CCCLIII");
        assertEquals(353,romano.converter());
    }

    @Test
    public void test_centenas_complexa(){
        romano = new Romano("CCCXLIX");
        assertEquals(349,romano.converter());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_mais_de_tres_algarismos_repetidos(){
        romano = new Romano("XICCXIIIIX");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_algarismos_repetidos_invalidos(){
        romano = new Romano("XICCXIIVVIX");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deve_rejeita_pois_ha_uma_sequencia_antes_de_um_numero_maior(){
        romano = new Romano("MMMCCCXXXIIIV");
    }

}
