import static org.junit.jupiter.api.Assertions.assertEquals;

@Test
public void testSmallTshirtMenProperties() {
    SmallTshirtMen testTshirtMen = new SmallTshirtMen();
    assertEquals(130, testTshirtMen.getWeight(), "Weight should match");
    assertEquals(1400, testTshirtMen.getVolume(), "Volume should match");
    assertEquals("Men", testTshirtMen.getGender(), "Gender should match");
    assertEquals("Small", testTshirtMen.getSize(), "Size should match");
}
