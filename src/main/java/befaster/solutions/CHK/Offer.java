package befaster.solutions.CHK;

public class Offer {
  private char sku;
  private int specialPrice;
  private int specialQuantity;
  public Offer(char sku, int specialPrice, int specialQuantity) {
    this.sku = sku;
    this.specialPrice = specialPrice;
    this.specialQuantity = specialQuantity;
  }

  public char getSku() {
    return sku;
  }

  public int getSpecialPrice() {
    return specialPrice;
  }

  public int getSpecialQuantity() {
    return specialQuantity;
  }
}
