import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallShirtMenTest extends Clothing {

    @Test
    public void testSmallShirtMenProperties() {
        Clothing testShirt = new Clothing(1, Shirt, S, M);

        assertEquals(1750, testShirt.getVolume(), "Volumes should match");
        assertEquals(150, testShirt.getWeight(), "Weights should match");
        assertEquals("M", testShirt.getGender(), "Gender should be M");
        assertEquals("S", testShirt.getSize(), "Size should be S");
        assertEquals(1, testShirt.getValue(), "Value should be 1");
    }
}