public class CachedFraction extends Fraction {
    private Double cachedValue = null;

    public CachedFraction(int numerator, int denominator) {
        super(numerator, denominator);
    }

    @Override
    public double getRealValue() {
        if (cachedValue == null) {
            cachedValue = super.getRealValue();
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        super.setNumerator(numerator);
        cachedValue = null;
    }

    @Override
    public void setDenominator(int denominator) {
        super.setDenominator(denominator);
        cachedValue = null;
    }
}