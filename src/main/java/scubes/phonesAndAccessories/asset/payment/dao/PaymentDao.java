package scubes.phonesAndAccessories.asset.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import scubes.phonesAndAccessories.asset.payment.entity.Payment;
import scubes.phonesAndAccessories.asset.purchaseOrder.entity.PurchaseOrder;

import java.util.List;

public interface PaymentDao extends JpaRepository< Payment,Integer> {
    List< Payment> findByPurchaseOrder(PurchaseOrder purchaseOrder);

    Payment findFirstByOrderByIdDesc();
}
