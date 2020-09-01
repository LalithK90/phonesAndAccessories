package lk.scubes.phonesAndAccessories.asset.brand.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lk.scubes.phonesAndAccessories.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Ledger")
public class Brand extends AuditEntity {
    @NotNull
    @Size(min = 1, message = "This name length should be more than one character")
    private String name;
}
