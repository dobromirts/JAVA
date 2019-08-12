package softuni.jsonexercise.domain.entities;

public enum Discount {
    DISCOUNT_00  (0.00),
    DISCOUNT_05  (0.05),
    DISCOUNT_10  (0.10),
    DISCOUNT_15  (0.15),
    DISCOUNT_20  (0.20),
    DISCOUNT_30  (0.30),
    DISCOUNT_40  (0.40),
    DISCOUNT_50  (0.50);

    private final double value;

    Discount(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
