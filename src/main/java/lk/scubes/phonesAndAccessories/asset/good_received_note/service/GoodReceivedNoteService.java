package lk.scubes.phonesAndAccessories.asset.good_received_note.service;

import lk.scubes.phonesAndAccessories.asset.common_asset.model.enums.LiveDead;
import lk.scubes.phonesAndAccessories.asset.good_received_note.dao.GoodReceivedNoteDao;
import lk.scubes.phonesAndAccessories.asset.good_received_note.entity.GoodReceivedNote;
import lk.scubes.phonesAndAccessories.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "goodReceivedNote")
public class GoodReceivedNoteService implements AbstractService<GoodReceivedNote, Integer> {
    private final GoodReceivedNoteDao goodReceivedNoteDao;

    @Autowired
    public GoodReceivedNoteService(GoodReceivedNoteDao goodReceivedNoteDao) {
        this.goodReceivedNoteDao = goodReceivedNoteDao;
    }


    public List<GoodReceivedNote> findAll() {
        return goodReceivedNoteDao.findAll();
    }


    public GoodReceivedNote findById(Integer id) {
        return goodReceivedNoteDao.getOne(id);
    }

    public GoodReceivedNote persist(GoodReceivedNote goodRecevingNote) {
        if(goodRecevingNote.getId()==null){
            goodRecevingNote.setLiveDead(LiveDead.ACTIVE);}
        return goodReceivedNoteDao.save(goodRecevingNote);
    }

    public boolean delete(Integer id) {
        GoodReceivedNote goodRecevingNote =  goodReceivedNoteDao.getOne(id);
        goodRecevingNote.setLiveDead(LiveDead.STOP);
        goodReceivedNoteDao.save(goodRecevingNote);
        return false;
    }

    public List<GoodReceivedNote> search(GoodReceivedNote goodReceivedNote) {
        ExampleMatcher matcher = ExampleMatcher
            .matching()
            .withIgnoreCase()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<GoodReceivedNote> goodReceivedNoteExample = Example.of(goodReceivedNote, matcher);
        return goodReceivedNoteDao.findAll(goodReceivedNoteExample);
    }


    public GoodReceivedNote findByPurchaseOrder(PurchaseOrder purchaseOrder) {
        return goodReceivedNoteDao.findByPurchaseOrder(purchaseOrder);
    }
}
