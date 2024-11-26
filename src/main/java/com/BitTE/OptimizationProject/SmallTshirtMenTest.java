import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class SmallTshirtMenTest {

    @Test
    public void testSmallTshirtMenProperties() {
        SmallTshirtMen testTshirtMen = new SmallTshirtMen();

        assert.equals(130, testTshirtMen.getWeight());
        assert.equals(1400, testTshirtMen.getVolume());
        assert.equals("Men", testTshirtMen.getGender());
        assert.equals("Small", testTshirtMen.getSize());
    }
}
