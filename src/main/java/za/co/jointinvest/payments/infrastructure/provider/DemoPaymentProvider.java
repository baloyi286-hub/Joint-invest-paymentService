package za.co.jointinvest.payments.infrastructure.provider;

import java.util.UUID;
import za.co.jointinvest.payments.application.port.PaymentProvider;
import za.co.jointinvest.payments.domain.Money;

public final class DemoPaymentProvider implements PaymentProvider {
    @Override
    public ProviderPayment createDeposit(UUID userId, Money amount, String idempotencyKey) {
        return new ProviderPayment("demo_dep_" + UUID.randomUUID(), "SUCCEEDED");
    }

    @Override
    public ProviderPayout createPayout(UUID userId, Money amount, String idempotencyKey) {
        return new ProviderPayout("demo_pay_" + UUID.randomUUID(), "SUCCEEDED");
    }

    @Override
    public ProviderRefund refund(String providerPaymentId, Money amount, String idempotencyKey) {
        return new ProviderRefund("demo_ref_" + UUID.randomUUID(), "SUCCEEDED");
    }
}
