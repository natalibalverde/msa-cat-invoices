package com.cat.msa.msa.invoices.service;

import com.cat.msa.msa.invoices.domain.InvoiceHeader;

import java.util.List;

public interface InvoiceHeaderService {

    InvoiceHeader createInvoiceHeader(InvoiceHeader invoiceHeader);

    List<InvoiceHeader> getAllInvoiceHeaders();

}
