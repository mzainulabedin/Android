package com.sandz.mshopping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.sandz.mshopping.R;

public class MainActivity extends BaseActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button btnHistory = (Button) findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(new ButtonClickListener());
//        btnHistory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent historyIntent = new Intent(MainActivity.this, HistoryActivity.class);
//                startActivity(historyIntent);
//            }
//        });

        Button btnShopping = (Button) findViewById(R.id.btnShopping);
        btnShopping.setOnClickListener(new ButtonClickListener());

        Button btnSetting = (Button) findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(new ButtonClickListener());
    }

    class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Button btn = (Button)v;
            Class<?> cls;
            switch (btn.getId()){
                case R.id.btnHistory:
                    cls = HistoryActivity.class;
                    break;
                case R.id.btnShopping:
                    cls = ShoppingActivity.class;
                    break;
                case R.id.btnSetting:
                    //cls = SettingActivity.class;
                    cls = CategoryListActivity.class;
                    break;
                default:
                    cls = null;
                    break;
            }
            if(cls!=null) {
                Intent historyIntent = new Intent(MainActivity.this, cls);
                startActivity(historyIntent);
            }
        }
    }
}
