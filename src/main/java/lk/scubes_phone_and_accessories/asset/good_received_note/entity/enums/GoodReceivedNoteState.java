package lk.scubes_phone_and_accessories.asset.good_received_note.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodReceivedNoteState {
    NOT_PAID(" Not paid"),
    PAID(" Paid");
    private final String goodReceivedNoteState;
}
