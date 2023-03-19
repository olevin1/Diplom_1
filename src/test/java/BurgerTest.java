import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Mock
    private Ingredient ingredient3;

    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Bun actual = burger.bun;
        Bun expected = bun;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        List<Ingredient> actual = burger.ingredients;
        List<Ingredient> expected = List.of(ingredient1, ingredient2, ingredient3);
        assertEquals(expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.removeIngredient(1);
        List<Ingredient> actual = burger.ingredients;
        List<Ingredient> expected = List.of(ingredient1, ingredient3);
        assertEquals(expected, actual);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Ingredient actual = burger.ingredients.get(0);
        Ingredient expected = ingredient2;
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        float priceBun = 100f;
        float priceIngredient1 = 50f;
        float priceIngredient2 = 75f;
        float priceIngredient3 = 80f;
        when(bun.getPrice()).thenReturn(priceBun);
        when(ingredient1.getPrice()).thenReturn(priceIngredient1);
        when(ingredient2.getPrice()).thenReturn(priceIngredient2);
        when(ingredient3.getPrice()).thenReturn(priceIngredient3);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        float actual = burger.getPrice();
        float expected = priceBun * 2 + priceIngredient1 + priceIngredient2 + priceIngredient3;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        String nameBun = "Межгалактическая сырная булка";
        String nameIngredient1 = "Сырный соус";
        String nameIngredient2 = "Сырная котлета";
        float priceBun = 100f;
        float priceIngredient1 = 50f;
        float priceIngredient2 = 75f;

        StringBuilder receiptExpect = new StringBuilder();

        when(bun.getName()).thenReturn(nameBun);
        when(bun.getPrice()).thenReturn(priceBun);
        when(ingredient1.getName()).thenReturn(nameIngredient1);
        when(ingredient1.getType()).thenReturn(SAUCE);
        when(ingredient1.getPrice()).thenReturn(priceIngredient1);
        when(ingredient2.getName()).thenReturn(nameIngredient2);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getPrice()).thenReturn(priceIngredient2);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String bunString = String.format("(==== %s ====)%n", bun.getName());
        String priceString = String.format("%nPrice: %f%n", burger.getPrice());
        String ingredient1String = String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(), nameIngredient1);
        String ingredient2String = String.format("= %s %s =%n", IngredientType.FILLING.toString().toLowerCase(), nameIngredient2);

        receiptExpect.append(bunString);
        receiptExpect.append(ingredient1String);
        receiptExpect.append(ingredient2String);
        receiptExpect.append(bunString);
        receiptExpect.append(priceString);
        String actual = burger.getReceipt();
        String expected = receiptExpect.toString();
        assertEquals(expected, actual);
    }
}