package com.cat.msa.msa.invoices.controller;

import com.cat.msa.msa.invoices.domain.InvoiceHeader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/invoice-header")
public interface InvoiceHeaderApi {

    @PostMapping
    ResponseEntity<InvoiceHeader> save(@RequestBody InvoiceHeader invoiceHeader);

    @GetMapping
    ResponseEntity<List<InvoiceHeader>> findAll();

}
