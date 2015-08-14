import org.junit.*;
import static org.junit.Assert.*;

public class AppUnitTest {

  @Test
  public void calculateCoins_userInputReturnsAmountInPennies_5() {
    CoinCalculator testCoinCalculator = new CoinCalculator();
    String results =  "0 Quarter(s), 0 Dime(s), 0 Nickel(s), and 4 Pennie(s)";
    assertEquals(results, testCoinCalculator.calculateCoins(4));
  }

  @Test
  public void calculateCoins_userInputReturnsPenniesAndNickels_OneAndOne() {
    CoinCalculator testCoinCalculator = new CoinCalculator();
    String results =  "0 Quarter(s), 0 Dime(s), 1 Nickel(s), and 1 Pennie(s)";
    assertEquals(results, testCoinCalculator.calculateCoins(6));
  }

  @Test
  public void calculateCoins_userInputReturnsPenniesNickelsAndDimes_OneOneAndOne() {
    CoinCalculator testCoinCalculator = new CoinCalculator();
    String results =  "0 Quarter(s), 1 Dime(s), 1 Nickel(s), and 1 Pennie(s)";
    assertEquals(results, testCoinCalculator.calculateCoins(16));
  }

  @Test
  public void calculateCoins_userInputReturnsAllCoins_OneOneOneAndOne() {
    CoinCalculator testCoinCalculator = new CoinCalculator();
    String results =  "1 Quarter(s), 1 Dime(s), 1 Nickel(s), and 1 Pennie(s)";
    assertEquals(results, testCoinCalculator.calculateCoins(41));
  }

  @Test
  public void calculateCoins_userInputCannotBeNegative_Null() {
    CoinCalculator testCoinCalculator = new CoinCalculator();
    String results =  "Please enter a positive number."
    assertEquals(results, testCoinCalculator.calculateCoins(-1));
  }
}
