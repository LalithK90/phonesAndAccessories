package scubes.phones_and_accessories.asset.supplier.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import scubes.phones_and_accessories.asset.supplier.entity.Supplier;
import scubes.phones_and_accessories.asset.supplier_item.entity.enums.ItemSupplierStatus;

@Repository
public interface SupplierDao extends JpaRepository< Supplier, Integer> {
    Supplier findFirstByOrderByIdDesc();

    Supplier findByIdAndItemSupplierStatus(Integer supplierId, ItemSupplierStatus itemSupplierStatus);
}
