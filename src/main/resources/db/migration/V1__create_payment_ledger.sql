CREATE TABLE ledger_account (
    id UUID PRIMARY KEY,
    owner_reference UUID,
    account_type VARCHAR(40) NOT NULL,
    currency CHAR(3) NOT NULL DEFAULT 'ZAR',
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ledger_entry (
    id UUID PRIMARY KEY,
    transaction_id UUID NOT NULL,
    ledger_account_id UUID NOT NULL REFERENCES ledger_account(id),
    entry_type VARCHAR(40) NOT NULL,
    side VARCHAR(10) NOT NULL,
    amount NUMERIC(19, 2) NOT NULL CHECK (amount >= 0),
    currency CHAR(3) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL
);

CREATE INDEX idx_ledger_entry_transaction ON ledger_entry(transaction_id);
CREATE INDEX idx_ledger_entry_account ON ledger_entry(ledger_account_id, created_at);
