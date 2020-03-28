package lk.scubes.phonesAndAccessories.asset.message.dao;

import lk.scubes.phonesAndAccessories.asset.message.entity.EmailMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailMessageDao extends JpaRepository<EmailMessage, Integer > {
}
