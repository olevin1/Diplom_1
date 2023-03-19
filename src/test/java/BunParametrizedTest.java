import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParametrizedTest {
    private final String name;
    private final float price;

    private final static String LONG_STRING = RandomStringUtils.randomAlphanumeric(300);

    public BunParametrizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"", 1},
                {"п", -1},
                {null, 1},
                {LONG_STRING, Float.NaN},
                {"Virtual_bun", Float.MAX_VALUE + 1},
                {"Марсинская булка", Float.MIN_VALUE},
                {"677hg%^&*#%%%$$#", Float.MAX_VALUE}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals(bun.getName(), name);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals(bun.getPrice(), price, 0);
    }
}