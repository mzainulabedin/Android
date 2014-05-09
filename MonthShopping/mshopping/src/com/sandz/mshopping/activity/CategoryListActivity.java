package com.sandz.mshopping.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.sandz.mshopping.adapter.CategoryListAdapter;
import com.sandz.mshopping.manager.BeanManager;
import com.sandz.mshopping.utility.Constants;
import com.sandz.mshopping.R;
import com.sandz.mshopping.beans.Category;
import com.sandz.mshopping.manager.CategoryManager;

import java.util.List;

/**
 * Created by mzain on 5/5/2014.
 */
public class CategoryListActivity extends BaseActivity {
    private final String TAG = "Service_List_Fragment";
    private static Context context;
    private static ListView categoryList;

    private static List<Category> categories;

    @Override
    public void  onCreate(Bundle savedInstanceState) {

        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.category_list_activity);

            context = this;

            categoryList = (ListView)findViewById(android.R.id.list);
            categories = new CategoryManager(context).get("Name", BeanManager.SortOrder.ASCENDING);

            if(categories.size() > 0){
                CategoryListAdapter categoryListAdapter  = new CategoryListAdapter((Activity)context, R.layout.category_list_item_activity, categories);
                categoryList.setAdapter(categoryListAdapter);
            }
        }
        catch (Exception e){
            Log.e(TAG, Constants.GENERAL_ERROR_MESSAGE, e);
        }
    }
}
