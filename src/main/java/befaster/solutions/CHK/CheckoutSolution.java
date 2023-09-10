package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {

    Map<Character, Integer> prices = new HashMap<>();
    List<Offer> offers = new ArrayList<>();


    public Integer checkout(String skus) {
        buildPrices();

        Map<Character, Integer> skuCount = new HashMap<>();
        for (int i = 0; i < skus.length(); i++) {
            char sku = skus.charAt(i);
            if (!prices.containsKey(sku)){
                return -1;
            }
            skuCount.put(sku, skuCount.getOrDefault(sku, 0) + 1);
        }


        int total = 0;

        for (Offer offer : offers){
            if (skuCount.containsKey(offer.getSku())){
                total += offer.getSpecialPrice() * (skuCount.get(offer.getSku()) / offer.getSpecialQuantity());
                skuCount.put(offer.getSku(), skuCount.get(offer.getSku()) % offer.getSpecialQuantity());
            }
        }


        if (skuCount.containsKey('E')) {
            int freeBs = skuCount.get('E') / 2;
            if (skuCount.containsKey('B')){
                if (freeBs >= skuCount.get('B')) {
                    skuCount.remove('B');
                }
                else {
                    skuCount.put('B', skuCount.get('B') - freeBs);
                }
            }
        }

        System.out.println(skuCount);


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
        prices.put('E', 40);
    }

    private void buildOffers(){
        offers.add(new Offer('A', 130, 3));
        offers.add(new Offer('B', 130, 3));
    }
}
