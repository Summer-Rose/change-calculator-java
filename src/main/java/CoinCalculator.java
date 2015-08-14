import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class CoinCalculator {
    public static void main(String[] args) {

      String layout="templates/layout.vtl";
      staticFileLocation("/public");

      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/coinChangeForm.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/coinChangeResults", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/coinChangeResults.vtl");

        String stringUserAmount = request.queryParams("userAmount");
        Integer userAmount = Integer.parseInt(stringUserAmount);
        String changeCalculated = calculateCoins(userAmount);


        model.put("userAmount", userAmount);
        model.put("changeCalculated", changeCalculated);

        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

}
      public static String calculateCoins(Integer amount) {
        Integer quarters = 0;
        Integer dimes = 0;
        Integer nickels = 0;
        Integer pennies = 0;
        Integer availableQuarters = 1;
        Integer availableDimes = 5;
        Integer availableNickels = 3;

        while (amount > 0) {

          if (amount >= 25 && availableQuarters > 0) {
            amount -= 25;
            availableQuarters -= 1;
            quarters += 1;
          } else if (amount >= 10 && availableDimes > 0) {
            amount -= 10;
            availableDimes -= 1;
            dimes += 1;
          } else if (amount >= 5 && availableNickels > 0) {
            amount -= 5;
            availableNickels -= 1;
            nickels += 1;
          } else {
            amount -= 1;
            pennies += 1;
          }
        }

        String changeCalculated = String.format("%d Quarter(s), %d Dime(s), %d Nickel(s), and %d Pennie(s)", quarters, dimes, nickels, pennies);
        return changeCalculated;
      }

}
