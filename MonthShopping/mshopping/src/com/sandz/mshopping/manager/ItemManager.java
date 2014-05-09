package com.sandz.mshopping.manager;

import android.content.Context;
import com.sandz.mshopping.beans.Item;

/**
 * Created by mzain on 5/7/2014.
 */
public class ItemManager extends BeanManager<Item> {

    public ItemManager(Context context) {
        super(context, Item.class);
    }
}
