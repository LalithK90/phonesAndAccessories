package scubes.phones_and_accessories.asset.invoice.entity.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InvoicePrintOrNot {
    PRINTED("Printed"),
    NOT_PRINTED("Not Printed");
    private final String invoicePrintOrNot;
}
