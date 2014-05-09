package com.sandz.mshopping.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sandz.mshopping.R;
import com.sandz.mshopping.beans.Category;

import java.util.List;

/**
 * Created by mzain on 5/7/2014.
 */
public class CategoryListAdapter extends BaseArrayAdapter<Category> {
    public CategoryListAdapter(Activity context, int service_item, List<Category> categories) {
        super(context, service_item, categories);
    }

    @Override
    public void onListItemGetView(View itemView, Category item, int position) {

        if (item != null) {
            ImageView imgThumb = (ImageView) itemView.findViewById(R.id.imgThumb);
            TextView txtName = (TextView) itemView.findViewById(R.id.txtName);
            TextView txtDesc = (TextView) itemView.findViewById(R.id.txtDesc);

            txtName.setText(item.getName());
            txtDesc.setText(item.getDescription());
        }
    }
}
