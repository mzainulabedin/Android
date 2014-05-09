package com.sandz.mshopping.manager;

import android.content.Context;
import com.sandz.mshopping.beans.MonthItem;

/**
 * Created by mzain on 5/7/2014.
 */
public class MonthItemManager extends BeanManager<MonthItem> {

    public MonthItemManager(Context context) {
        super(context, MonthItem.class);
    }
}
