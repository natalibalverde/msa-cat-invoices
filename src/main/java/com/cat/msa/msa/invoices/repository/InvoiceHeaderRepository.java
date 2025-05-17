package com.cat.msa.msa.invoices.repository;

import com.cat.msa.msa.invoices.domain.InvoiceHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeader, Long> {
}
