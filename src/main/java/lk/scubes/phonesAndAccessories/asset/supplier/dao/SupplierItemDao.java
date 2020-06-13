package lk.scubes.phonesAndAccessories.asset.supplier.dao;


import lk.scubes.phonesAndAccessories.asset.supplier.entity.SupplierItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierItemDao extends JpaRepository<SupplierItem, Integer> {
}
