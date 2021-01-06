package lk.scubes.phonesAndAccessories.asset.purchase_order_item.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.scubes.phonesAndAccessories.asset.common_asset.model.enums.LiveDead;
import lk.scubes.phonesAndAccessories.asset.item.entity.Item;
import lk.scubes.phonesAndAccessories.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "PurchaseOrderItem" )
public class PurchaseOrderItem extends AuditEntity {

    @Column( nullable = false )
    private String quantity;

    @Column( nullable = false, precision = 10, scale = 2 )
    private BigDecimal buyingPrice;

    @Column( nullable = false, precision = 10, scale = 2 )
    private BigDecimal lineTotal;

    @Enumerated( EnumType.STRING)
    private LiveDead liveDead;

    @ManyToOne
    private PurchaseOrderItem purchaseOrder;

    @ManyToOne
    private Item item;

}
