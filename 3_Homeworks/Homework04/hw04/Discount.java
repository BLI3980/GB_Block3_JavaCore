package hw04;

public enum Discount {
    ZERO(0.0f),
    FIVE(0.05f),
    TEN(0.1f),
    FIFTEEN(0.15f),
    TWENTY(0.2f);

    private float discount;
    Discount(float discount) {
        this.discount = discount;
    }

    public float getDiscount() {
        return discount;
    }
}
