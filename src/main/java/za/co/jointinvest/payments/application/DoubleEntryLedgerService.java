package za.co.jointinvest.payments.application;

import java.time.Clock;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import za.co.jointinvest.payments.application.port.LedgerRepository;
import za.co.jointinvest.payments.domain.LedgerEntry;
import za.co.jointinvest.payments.domain.LedgerEntryType;
import za.co.jointinvest.payments.domain.LedgerSide;
import za.co.jointinvest.payments.domain.Money;

public final class DoubleEntryLedgerService {
    private final LedgerRepository repository;
    private final Clock clock;

    public DoubleEntryLedgerService(LedgerRepository repository, Clock clock) {
        this.repository = repository;
        this.clock = clock;
    }

    public UUID transfer(UUID debitAccount, UUID creditAccount, Money money, LedgerEntryType type) {
        UUID transactionId = UUID.randomUUID();
        Instant now = clock.instant();
        repository.appendAll(List.of(
                new LedgerEntry(UUID.randomUUID(), transactionId, debitAccount, type, LedgerSide.DEBIT, money, now),
                new LedgerEntry(UUID.randomUUID(), transactionId, creditAccount, type, LedgerSide.CREDIT, money, now)));
        return transactionId;
    }
}
