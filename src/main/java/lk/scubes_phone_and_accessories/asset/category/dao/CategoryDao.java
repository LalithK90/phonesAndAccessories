package lk.scubes_phone_and_accessories.asset.category.dao;

import lk.scubes_phone_and_accessories.asset.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
}
