package za.co.jointinvest.payments.application.port;

import java.util.List;
import java.util.UUID;
import za.co.jointinvest.payments.domain.LedgerEntry;

public interface LedgerRepository {
    void appendAll(List<LedgerEntry> entries);
    List<LedgerEntry> findByTransactionId(UUID transactionId);
}
