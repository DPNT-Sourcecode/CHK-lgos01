package befaster.solutions.CHK;

public class BuyXGetXFreeOffer {
  private char sku;
  private int specialQuantity;

  private char freeSku;

  private int freeQuantity;
  public BuyXGetXFreeOffer(char sku, int specialQuantity, char freeSku, int freeQuantity) {
    this.sku = sku;
    this.freeSku = freeSku;
    this.freeQuantity = freeQuantity;
    this.specialQuantity = specialQuantity;
  }

  public char getSku() {
    return sku;
  }

  public int getSpecialQuantity() {
    return specialQuantity;
  }

  public char getFreeSku() {
    return freeSku;
  }

  public int getFreeQuantity() {
    return freeQuantity;
  }
}
