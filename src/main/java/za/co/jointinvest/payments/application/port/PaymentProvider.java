package za.co.jointinvest.payments.application.port;

import java.util.UUID;
import za.co.jointinvest.payments.domain.Money;

public interface PaymentProvider {
    ProviderPayment createDeposit(UUID userId, Money amount, String idempotencyKey);

    ProviderPayout createPayout(UUID userId, Money amount, String idempotencyKey);

    ProviderRefund refund(String providerPaymentId, Money amount, String idempotencyKey);

    record ProviderPayment(String providerReference, String status) {}
    record ProviderPayout(String providerReference, String status) {}
    record ProviderRefund(String providerReference, String status) {}
}
