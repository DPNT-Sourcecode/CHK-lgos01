package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    Map<Character, Integer> prices = new HashMap<>();
    Map<Character, Integer> count = new HashMap<>();
    public Integer checkout(String skus) {
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('C', 20);
        prices.put('D', 15);

        int total = 0;
        for (int i = 0; i < skus.length(); i++) {
            char sku = skus.charAt(i);
            count.put(sku, count.getOrDefault(sku, 0) + 1);
        }

        total += 130 * count.get('A') / 3;
        total += 45 * count.get('B') / 2;

        for (int i = 0; i < ; i++) {
            
        }
        total += count.get('A') % 3;
        int remainingBs = count.get('B') % 3;

        // get number of 3A's and subtract from total number of As
        // get number of 2B's and subtract from total number of B



        return total;
    }
}


