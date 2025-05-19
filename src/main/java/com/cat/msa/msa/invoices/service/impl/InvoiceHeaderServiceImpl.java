package com.cat.msa.msa.invoices.service.impl;

import com.cat.msa.msa.invoices.domain.InvoiceHeader;
import com.cat.msa.msa.invoices.repository.InvoiceHeaderRepository;
import com.cat.msa.msa.invoices.service.InvoiceHeaderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceHeaderServiceImpl implements InvoiceHeaderService {

    private final InvoiceHeaderRepository invoiceHeaderRepository;

    public InvoiceHeaderServiceImpl(InvoiceHeaderRepository invoiceHeaderRepository) {
        this.invoiceHeaderRepository = invoiceHeaderRepository;
    }

    @Override
    public InvoiceHeader createInvoiceHeader(InvoiceHeader invoiceHeader) {
        InvoiceHeader expectedInvoiceHeader = invoiceHeaderRepository.findByNumber(invoiceHeader.getNumber());
        if (expectedInvoiceHeader != null) {
            throw new RuntimeException("An invoice with this number already exists");
        }
        invoiceHeader.calculateInvoiceAmounts();
        return invoiceHeaderRepository.save(invoiceHeader);
    }

    @Override
    public List<InvoiceHeader> getAllInvoiceHeaders() {
        List<InvoiceHeader> expectedInvoiceHeaders = invoiceHeaderRepository.findAll();
        if (expectedInvoiceHeaders.isEmpty()) {
            throw new RuntimeException("No invoices found");
        }
        return expectedInvoiceHeaders;
    }

    @Override
    public InvoiceHeader getInvoiceHeaderByNumber(String number) {
        InvoiceHeader expectedInvoiceHeader = invoiceHeaderRepository.findByNumber(number);
        if (expectedInvoiceHeader == null) {
            throw new RuntimeException("Invoice number not found");
        }
        return expectedInvoiceHeader;
    }

    @Override
    public void deleteInvoiceHeaderByNumber(String number) {
        InvoiceHeader expectedInvoiceHeader = this.getInvoiceHeaderByNumber(number);
        invoiceHeaderRepository.deleteByNumber(number);
    }
}
