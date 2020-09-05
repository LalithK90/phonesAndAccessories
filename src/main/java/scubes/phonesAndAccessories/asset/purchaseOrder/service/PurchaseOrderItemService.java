package scubes.phonesAndAccessories.asset.purchaseOrder.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import scubes.phonesAndAccessories.asset.item.entity.Item;
import scubes.phonesAndAccessories.asset.purchaseOrder.dao.PurchaseOrderItemDao;
import scubes.phonesAndAccessories.asset.purchaseOrder.entity.PurchaseOrder;
import scubes.phonesAndAccessories.asset.purchaseOrder.entity.PurchaseOrderItem;
import scubes.phonesAndAccessories.util.interfaces.AbstractService;

import java.util.List;

@Service
@CacheConfig(cacheNames = "purchaseOrderItem")
public class PurchaseOrderItemService implements AbstractService< PurchaseOrderItem, Integer> {
    private final PurchaseOrderItemDao purchaseOrderItemDao;

    @Autowired
    public PurchaseOrderItemService(PurchaseOrderItemDao purchaseOrderItemDao) {
        this.purchaseOrderItemDao = purchaseOrderItemDao;
    }

    public List<PurchaseOrderItem> findAll() {
        return purchaseOrderItemDao.findAll();
    }

    public PurchaseOrderItem findById(Integer id) {
        return purchaseOrderItemDao.getOne(id);
    }

    public PurchaseOrderItem persist(PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemDao.save(purchaseOrderItem);
    }

    public boolean delete(Integer id) {
        purchaseOrderItemDao.deleteById(id);
        return false;
    }

    public List<PurchaseOrderItem> search(PurchaseOrderItem purchaseOrderItem) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<PurchaseOrderItem> purchaseRequestExample = Example.of(purchaseOrderItem, matcher);
        return purchaseOrderItemDao.findAll(purchaseRequestExample);
    }

    public PurchaseOrderItem findByPurchaseOrderAndItem(PurchaseOrder purchaseOrder, Item item) {
        return purchaseOrderItemDao.findByPurchaseOrderAndItem(purchaseOrder, item);
    }

    public List<PurchaseOrderItem> findByPurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderItemDao.findByPurchaseOrder(purchaseOrder);
    }



}
