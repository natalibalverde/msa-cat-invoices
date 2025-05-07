package com.cat.msa.msa.invoices.domain;

import com.cat.msa.msa.invoices.constant.Constant;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class InvoiceHeader {

    private Long id;
    private String number;
    private String customerName;
    private Date date;
    private BigDecimal subTotalAmount;
    private BigDecimal vatAmount;
    private BigDecimal totalAmount;
    private List<InvoiceDetail> invoiceDetails;

    public void calculateSubTotalAmount(){
        subTotalAmount = BigDecimal.ZERO;
        for (InvoiceDetail invoiceDetail: invoiceDetails){
            invoiceDetail.calculateSubTotal();
            subTotalAmount= subTotalAmount.add(invoiceDetail.getSubTotal());
        }
    }

    public void calculateVatAmount(){
        vatAmount = subTotalAmount.multiply(Constant.VAT_RATE);
    }

    public void calculateTotaltAmount(){
        totalAmount = subTotalAmount.add(vatAmount);
    }

}
