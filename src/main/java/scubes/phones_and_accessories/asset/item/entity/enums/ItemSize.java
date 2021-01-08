package scubes.phones_and_accessories.asset.item.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemSize {
    S("Small"),
    M("Medium"),
    L("Large");

    private final String itemSize;
}
