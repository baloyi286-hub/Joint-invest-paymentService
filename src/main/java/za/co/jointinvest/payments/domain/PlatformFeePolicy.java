package za.co.jointinvest.payments.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class PlatformFeePolicy {
    private static final BigDecimal FEE_RATE = new BigDecimal("0.10");

    public Money calculate(Money grossAmount) {
        BigDecimal fee = grossAmount.amount()
                .multiply(FEE_RATE)
                .setScale(2, RoundingMode.HALF_EVEN);
        return new Money(fee, grossAmount.currency());
    }
}
