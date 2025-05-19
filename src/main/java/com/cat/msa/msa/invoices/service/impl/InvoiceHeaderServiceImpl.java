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
        invoiceHeader.calculateInvoiceAmounts();
        return invoiceHeaderRepository.save(invoiceHeader);
    }

    @Override
    public List<InvoiceHeader> getAllInvoiceHeaders() {
        return invoiceHeaderRepository.findAll();
    }

    @Override
    public InvoiceHeader getInvoiceHeaderByNumber(String number) {
        return invoiceHeaderRepository.findByNumber(number);
    }
}
