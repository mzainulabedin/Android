package com.sandz.mshopping.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sandz.mshopping.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzain on 5/7/2014.
 */
public class BaseArrayAdapter<T> extends ArrayAdapter<T> {

    Context context;
    List<T> itemList;
    private final String TAG = "BaseArrayAdapter";
    private int itemLayout;

    public BaseArrayAdapter(Context context, int textViewResourceId, List<T> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.itemList = objects;
        this.itemLayout =  textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = null;
        try {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(this.itemLayout, parent, false);
            T item = itemList.get(position);

            onListItemGetView(itemView, item, position);

        } catch (Exception e) {
            Log.e(TAG, "Error ", e);
        }

        return itemView;
    }


    public void onListItemGetView(View itemView, T item, int position){

    }
}
