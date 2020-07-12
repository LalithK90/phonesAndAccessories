package lk.scubes.phonesAndAccessories.asset.invoice.service;

import lk.scubes.phonesAndAccessories.asset.employee.entity.Employee;
import lk.scubes.phonesAndAccessories.asset.invoice.dao.DiscountRatioDao;
import lk.scubes.phonesAndAccessories.asset.invoice.entity.DiscountRatio;
import lk.scubes.phonesAndAccessories.util.interfaces.AbstractService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountRatioService implements AbstractService <DiscountRatio,Integer> {
    private final DiscountRatioDao discountRatioDao;


    public DiscountRatioService(DiscountRatioDao discountRatioDao) {
        this.discountRatioDao = discountRatioDao;
    }

    public List<DiscountRatio> findAll() {
        return discountRatioDao.findAll();
    }

    public DiscountRatio findById(Integer id) {
        return discountRatioDao.getOne(id);
    }

    public DiscountRatio persist(DiscountRatio discountRatio) {
        return discountRatioDao.save(discountRatio);

    }

    public boolean delete(Integer id) {
       discountRatioDao.deleteById(id);
        return false;
    }

    public List<DiscountRatio> search(DiscountRatio discountRatio) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<DiscountRatio> discountRatioExample = Example.of(discountRatio, matcher);
        return discountRatioDao.findAll(discountRatioExample);
    }
}
