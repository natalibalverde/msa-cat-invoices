package com.cat.msa.msa.invoices.repository;

import com.cat.msa.msa.invoices.domain.InvoiceHeader;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeader, Long> {

    @Query("SELECT i FROM InvoiceHeader i WHERE i.number = :number")
    InvoiceHeader findByNumber(@Param("number") String number);

    @Modifying
    @Transactional
    @Query("DELETE FROM InvoiceHeader i WHERE i.number = :number")
    void deleteByNumber(@Param("number") String number);

}

