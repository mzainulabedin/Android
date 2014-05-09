package com.sandz.mshopping.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.sandz.mshopping.R;
import com.sandz.mshopping.beans.Category;
import com.sandz.mshopping.dao.CategoryDao;
import com.sandz.mshopping.dao.DalManager;
import com.sandz.mshopping.dao.DaoSession;

import java.util.Date;

/**
 * Created by mzain on 5/5/2014.
 */
public class CategoryAddActivity extends BaseActivity {

    private Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_add_activity);
        context = this;

        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    EditText txtName = (EditText) findViewById(R.id.txtName);
                    EditText txtDesc = (EditText) findViewById(R.id.txtDesc);

                    Category category = new Category();
                    category.setName(txtName.getText().toString());
                    category.setDescription(txtDesc.getText().toString());
                    category.setCreatedOn(new Date());
                    category.setModifiedOn(new Date());

                    DaoSession daoSession = DalManager.getInstance(context.getApplicationContext()).getDaoSession();
                    CategoryDao categoryDao = daoSession.getCategoryDao();
                    categoryDao.insert(category);

                    ((Activity)context).finish();
                }
                catch (Exception ex){
                    Log.e("CATEGORY", "An error occurred", ex);
                }
            }
        });

    }
}
