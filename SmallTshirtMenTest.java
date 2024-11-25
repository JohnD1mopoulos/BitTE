import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class SmallTshirtMenTest {

    @Test 
    public void testSmallTshirtMenProperties() {
        SmallTshirtMen testTshirtMen = new SmallTshirtMen();

        assertequals(130, SmallTshirtMen.getWeight);
        assertequals(1400, SmallTshirtMen.getVolume);
        assertequals("Men", SmallTshirtMen.getGender);
        assertequals("Small", SmallTshirtMen.getSize);
    }
}
