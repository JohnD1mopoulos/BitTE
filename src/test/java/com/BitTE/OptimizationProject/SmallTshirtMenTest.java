import org.junit.jupiter.api.Test;  // For JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals;  // For assert methods in JUnit 5

@Test
public void testSmallTshirtMenProperties() {
    SmallTshirtMen testTshirtMen = new SmallTshirtMen();
    assertEquals(130, testTshirtMen.getWeight(), "Weight should match");
    assertEquals(1400, testTshirtMen.getVolume(), "Volume should match");
    assertEquals("Men", testTshirtMen.getGender(), "Gender should match");
    assertEquals("Small", testTshirtMen.getSize(), "Size should match");
    assertEquals("TshirtMen [value=0, weight=130.0, volume=1400.0, gender=Men, size=Small]Small Tshirt Men []", testTshirtMen.toString(), "toString should match");
}