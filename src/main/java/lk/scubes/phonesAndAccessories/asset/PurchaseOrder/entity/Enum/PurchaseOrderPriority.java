package lk.scubes.phonesAndAccessories.asset.PurchaseOrder.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PurchaseOrderPriority {
    HIGH("Immediate"),
    MEDIUM("Medium"),
    NORMAL("Normal");
    private final String purchaseOrderPriority;
}
