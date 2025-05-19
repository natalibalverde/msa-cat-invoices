package com.cat.msa.msa.invoices.controller;

import com.cat.msa.msa.invoices.domain.InvoiceHeader;
import com.cat.msa.msa.invoices.service.InvoiceHeaderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceHeaderController implements InvoiceHeaderApi {

    private final InvoiceHeaderService invoiceHeaderService;

    public InvoiceHeaderController(InvoiceHeaderService invoiceHeaderService) {
        this.invoiceHeaderService = invoiceHeaderService;
    }

    @Override
    public ResponseEntity<InvoiceHeader> save(InvoiceHeader invoiceHeader) {
        InvoiceHeader savedInvoiceHeader = invoiceHeaderService.createInvoiceHeader(invoiceHeader);
        return new ResponseEntity<>(savedInvoiceHeader, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<InvoiceHeader>> findAll() {
        List<InvoiceHeader> invoiceHeaders = invoiceHeaderService.getAllInvoiceHeaders();
        return new ResponseEntity<>(invoiceHeaders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InvoiceHeader> findByNumber(String number) {
        InvoiceHeader invoiceHeader = invoiceHeaderService.getInvoiceHeaderByNumber(number);
        return new ResponseEntity<>(invoiceHeader, HttpStatus.OK);
    }
}
