package com.example.iii.customersystem;

import android.app.ListActivity;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by iii on 2017/9/19.
 */

public class CustomerList extends ListActivity {
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Bundle bundle = new Bundle();
        bundle.putInt(Key.customerDataIndex, position);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(0, intent);
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] strArr_Customer =getIntent().getExtras().getStringArray(Key.customerData);
        ListAdapter listadapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, strArr_Customer);
        setListAdapter(listadapter);
    }
}
