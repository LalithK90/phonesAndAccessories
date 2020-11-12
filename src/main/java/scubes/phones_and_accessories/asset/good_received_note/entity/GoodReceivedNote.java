package scubes.phones_and_accessories.asset.good_received_note.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;
import scubes.phones_and_accessories.asset.good_received_note.entity.Enum.GoodReceivedNoteState;
import scubes.phones_and_accessories.asset.ledger.entity.Ledger;
import scubes.phones_and_accessories.asset.purchase_order.entity.PurchaseOrder;
import scubes.phones_and_accessories.util.audit.AuditEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "GoodReceivedNote" )
@ToString
public class GoodReceivedNote extends AuditEntity {

    private String remarks;

    @Column( precision = 10, scale = 2 )
    private BigDecimal totalAmount;

    @Enumerated( EnumType.STRING )
    private GoodReceivedNoteState goodReceivedNoteState;

    @ManyToOne
    private PurchaseOrder purchaseOrder;

    @OneToMany( mappedBy = "goodReceivedNote", cascade = CascadeType.PERSIST)
    private List< Ledger > ledgers;


}
