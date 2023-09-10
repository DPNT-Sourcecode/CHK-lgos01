package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {

  Map<Character, Integer> prices = new HashMap<>();
  List<MultiPricedOffer> multiPricedOffers = new ArrayList<>();
  List<BuyXGetXFreeOffer> buyXGetXFreeOffers = new ArrayList<>();


  public Integer checkout(String skus) {
    buildPrices();
    buildOffers();

    Map<Character, Integer> skuCount = new HashMap<>();
    for (int i = 0; i < skus.length(); i++) {
      char sku = skus.charAt(i);
      if (!prices.containsKey(sku)) {
        return -1;
      }
      skuCount.put(sku, skuCount.getOrDefault(sku, 0) + 1);
    }

    int total = 0;


    for (BuyXGetXFreeOffer offer : buyXGetXFreeOffers) {
      char offerSku = offer.getSku();
      int specialQuantity = offer.getSpecialQuantity();
      char freeSku = offer.getFreeSku();
      int freeQuantity = offer.getFreeQuantity();

      if (skuCount.containsKey(offerSku) && skuCount.containsKey(freeSku)) {
        if (skuCount.get(freeSku) == 0) {
          continue;
        }
        int numOfFree = (skuCount.get(offerSku) / specialQuantity) * freeQuantity;
        System.out.println(numOfFree);
        if (skuCount.get(freeSku) - numOfFree >= 0){
          skuCount.put(freeSku, skuCount.get(freeSku) - numOfFree);
        } else {
          skuCount.put(freeSku, 0);
        }
      }
    }

    System.out.println("skuCount after buyXgetXfree offers: " + skuCount);

    for (MultiPricedOffer multiPricedOffer : multiPricedOffers) {
      char offerSku = multiPricedOffer.getSku();
      if (skuCount.containsKey(offerSku)) {
        int specialQuantity = multiPricedOffer.getSpecialQuantity();
        total += multiPricedOffer.getSpecialPrice() * (skuCount.get(offerSku) / specialQuantity);
        skuCount.put(offerSku, skuCount.get(offerSku) % specialQuantity);
      }
    }

    System.out.println("total after multi priced offers: " + total);

    for (Map.Entry<Character, Integer> entry : skuCount.entrySet()) {
      total += entry.getValue() * prices.get(entry.getKey());
    }

    System.out.println("total after checkout: " + total);

    return total;
  }

  private void buildPrices() {
    prices.put('A', 50);
    prices.put('B', 30);
    prices.put('C', 20);
    prices.put('D', 15);
    prices.put('E', 40);
  }

  private void buildOffers() {
    multiPricedOffers.add(new MultiPricedOffer('A', 200, 5));
    multiPricedOffers.add(new MultiPricedOffer('A', 130, 3));
    multiPricedOffers.add(new MultiPricedOffer('B', 45, 2));
    buyXGetXFreeOffers.add(new BuyXGetXFreeOffer('E', 2, 'B', 1));
  }
}
