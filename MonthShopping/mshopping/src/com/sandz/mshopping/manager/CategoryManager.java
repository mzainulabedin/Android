package com.sandz.mshopping.manager;

import android.content.Context;
import com.sandz.mshopping.beans.Category;
import com.sandz.mshopping.dao.CategoryDao;
import de.greenrobot.dao.Property;

/**
 * Created by mzain on 5/7/2014.
 */
public class CategoryManager extends BeanManager<Category> {

    public CategoryManager(Context context) {
        super(context, Category.class);
        setDefaultSort(CategoryDao.Properties.Name);
    }

}
