package com.cat.msa.msa.invoices.domain;

import com.cat.msa.msa.invoices.constant.Constant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "T_INVOICE_HEADERS")
public class InvoiceHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INH_ID", nullable = false)
    private Long id;

    @Column(name = "INH_NUMBER", nullable = false)
    private String number;

    @Column(name = "INH_CUS_NAME", nullable = false)
    private String customerName;

    @Column(name = "INH_DATE", nullable = false)
    private Date date;

    @Column(name = "INH_SUB_TOTAL", nullable = false)
    private BigDecimal subTotalAmount;

    @Column(name = "INH_VAT_AMOUNT", nullable = false)
    private BigDecimal vatAmount;

    @Column(name = "INH_TOTAL", nullable = false)
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "invoiceHeader", cascade = CascadeType.ALL)
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