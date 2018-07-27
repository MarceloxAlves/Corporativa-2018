import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestAlgarismosRomano {

    Romano romano;

    @Before
    public void setup(){
        romano = new Romano("XV");
    }

    @Test
    public void test_algarismo_simples(){
        romano = new Romano("X");
        assertEquals(10,romano.converter());
    }

    @Test
    public void test_dois_algarismo(){
        romano = new Romano("IX");
        assertEquals(9,romano.converter());
    }


    @Test
    public void test_dois_algarismo_iguais(){
        romano = new Romano("XII");
        assertEquals(12,romano.converter());
    }

    @Test
    public void test_tres_algarismo_iguais(){
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

    @Test
    public void test_unidade_milhar(){
        romano = new Romano("MCDLXIX");
        assertEquals(1469,romano.converter());
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_mais_de_tres_algarismos_repetidos(){
        romano = new Romano("XICCXIIVVVVIX");
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_algarismos_invalidos(){
        romano = new Romano("P");
    }
}
