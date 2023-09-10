package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    Map<Character, Integer> prices = new HashMap<>();
    Map<Character, Integer> skuCount = new HashMap<>();
    public Integer checkout(String skus) {
        buildPrices();

        for (int i = 0; i < skus.length(); i++) {
            char sku = skus.charAt(i);
            if (!prices.containsKey(sku)){
                return -1;
            }
            skuCount.put(sku, skuCount.getOrDefault(sku, 0) + 1);
        }


        int total = 0;
        if (skuCount.containsKey('A')) {
            total += 130 * (skuCount.get('A') / 3);
            skuCount.put('A', skuCount.get('A') % 3);

        }
        if (skuCount.containsKey('B')) {
            total += 45 * (skuCount.get('B') / 2);
            skuCount.put('B', skuCount.get('B') % 2);

        }

        for (Map.Entry<Character, Integer> entry : skuCount.entrySet()){
            total += entry.getValue() * prices.get(entry.getKey());
        }

        return total;
    }

    private void buildPrices(){
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('C', 20);
        prices.put('D', 15);
    }
}
