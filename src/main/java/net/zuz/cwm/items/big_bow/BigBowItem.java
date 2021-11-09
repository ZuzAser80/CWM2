package net.zuz.cwm.items.big_bow;

import net.minecraft.item.BowItem;
import net.minecraft.item.Item;

public class BigBowItem extends BowItem {

    public BigBowItem(Item.Settings settings) {
        super(settings);
    }
    @Override
    public int getRange() {
        return 20;
    }
}
