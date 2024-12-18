import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class ClothingTest {

    @Test
    public void testClothingProperties() {
        Clothing testClothe = new Clothing(1, T-shirt, Small, Man);

        assertequals(130, testClothe.getWeight());
        assertequals(1400, testClothe.getVolume());
        assert.equals("Men", testClothe.getGender());
        assert.equals("Small", testClothe.getSize());
    }
}
