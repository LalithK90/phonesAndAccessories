package scubes.phones_and_accessories.asset.supplier_item.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scubes.phones_and_accessories.asset.item.entity.Item;
import scubes.phones_and_accessories.asset.supplier.entity.Supplier;
import scubes.phones_and_accessories.asset.supplier_item.entity.Enum.ItemSupplierStatus;
import scubes.phones_and_accessories.util.audit.AuditEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("SupplierItem")
public class SupplierItem extends AuditEntity {

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ItemSupplierStatus itemSupplierStatus;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Supplier supplier;

}
