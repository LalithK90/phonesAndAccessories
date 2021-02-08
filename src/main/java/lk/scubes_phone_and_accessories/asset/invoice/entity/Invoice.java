package lk.scubes_phone_and_accessories.asset.invoice.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.scubes_phone_and_accessories.asset.common_asset.model.enums.LiveDead;
import lk.scubes_phone_and_accessories.asset.customer.entity.Customer;
import lk.scubes_phone_and_accessories.asset.discount_ratio.entity.DiscountRatio;
import lk.scubes_phone_and_accessories.asset.invoice.entity.enums.InvoicePrintOrNot;
import lk.scubes_phone_and_accessories.asset.invoice.entity.enums.InvoiceValidOrNot;
import lk.scubes_phone_and_accessories.asset.invoice.entity.enums.PaymentMethod;
import lk.scubes_phone_and_accessories.asset.invoice_ledger.entity.InvoiceLedger;
import lk.scubes_phone_and_accessories.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Invoice")
@JsonIgnoreProperties(value = {"balance", "discountAmount", "bankName", "cardNumber"}, allowGetters = true)
public class Invoice extends AuditEntity {

    private String bankName;

    private String cardNumber;

    private String remarks;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(precision = 10, scale = 2)
    private BigDecimal discountAmount;

    @Column(precision = 10, scale = 2)
    private BigDecimal amountTendered;

    @Column(precision = 10, scale = 2)
    private BigDecimal balance;
     private InvoicePrintOrNot invoicePrintOrNot;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private InvoiceValidOrNot invoiceValidOrNot;

    @Enumerated(EnumType.STRING)
    private LiveDead liveDead;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private DiscountRatio discountRatio;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "invoice")
    private List< InvoiceLedger > invoiceLedgers;


}
