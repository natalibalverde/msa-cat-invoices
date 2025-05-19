package com.cat.msa.msa.invoices.repository;

import com.cat.msa.msa.invoices.domain.InvoiceHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeader, Long> {

    @Query("SELECT i FROM InvoiceHeader i WHERE i.number = :number")
    InvoiceHeader findByNumber(@Param("number") String number);

}

