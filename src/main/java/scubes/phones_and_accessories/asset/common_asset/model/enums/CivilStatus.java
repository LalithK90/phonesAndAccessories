package scubes.phones_and_accessories.asset.common_asset.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CivilStatus {

    MARRIED("Married"),
    UNMARRIED("UnMarried");

    private final String civilStatus;


}
