package za.co.jointinvest.payments.domain;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record LedgerEntry(
        UUID id,
        UUID transactionId,
        UUID ledgerAccountId,
        LedgerEntryType type,
        LedgerSide side,
        Money money,
        Instant createdAt) {
    public LedgerEntry {
        Objects.requireNonNull(id);
        Objects.requireNonNull(transactionId);
        Objects.requireNonNull(ledgerAccountId);
        Objects.requireNonNull(type);
        Objects.requireNonNull(side);
        Objects.requireNonNull(money);
        Objects.requireNonNull(createdAt);
    }
}
