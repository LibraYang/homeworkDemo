package com.example.iii.customersystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityMain extends Activity {
    CustomerFactory Factory = new CustomerFactory();

    private View.OnClickListener btnTop_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Factory.moveToFirst();
            data();
        }
    };

    private void data() {
        editNum.setText(Factory.customerData().getId());
        editName.setText(Factory.customerData().getName());
        editPhone.setText(Factory.customerData().getPhone());
        editMail.setText(Factory.customerData().getEmail());
        editAddress.setText(Factory.customerData().getAddress());
    }

    private View.OnClickListener btnBefore_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Factory.moveToPrevious();
            data();
        }
    };
    private View.OnClickListener btnAfter_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Factory.moveToNext();
            data();
        }
    };
    private View.OnClickListener btnBottom_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Factory.moveToLast();
            data();
        }
    };
    private View.OnClickListener btnList_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String[] strData = new String[Factory.allData().length];

            int i=0;
            for(Customer c : Factory.allData()){
                strData[i] = c.getId() + '/' + c.getName() + '/' + c.getPhone() + '/' + c.getEmail() + '/' + c.getAddress();
                i++;
            }

            Bundle bundle = new Bundle();
            bundle.putStringArray(Key.customerData, strData);
            Intent intent = new Intent(ActivityMain.this, CustomerList.class);
            intent.putExtras(bundle);
            startActivityForResult(intent, Key.actList);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Key.actList)
        {
            if(data == null || data.getExtras() == null)
                return;
            int index=data.getExtras().getInt(Key.customerDataIndex);
            Factory.moveTo(index);
            data();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);
        element();
    }

    private void element() {
        editNum = (EditText)findViewById(R.id.editNum);
        editName = (EditText)findViewById(R.id.editName);
        editPhone = (EditText)findViewById(R.id.editPhone);
        editMail = (EditText)findViewById(R.id.editMail);
        editAddress = (EditText)findViewById(R.id.editAddress);

        btnTop = (Button)findViewById(R.id.btnTop);
        btnTop.setOnClickListener(btnTop_click);
        btnBefore = (Button)findViewById(R.id.btnBefore);
        btnBefore.setOnClickListener(btnBefore_click);
        btnAfter = (Button)findViewById(R.id.btnAfter);
        btnAfter.setOnClickListener(btnAfter_click);
        btnBottom = (Button)findViewById(R.id.btnBottom);
        btnBottom.setOnClickListener(btnBottom_click);
        btnList = (Button)findViewById(R.id.btnList);
        btnList.setOnClickListener(btnList_click);
    }

    EditText editNum;
    EditText editName;
    EditText editPhone;
    EditText editMail;
    EditText editAddress;

    Button btnTop;
    Button btnBefore;
    Button btnAfter;
    Button btnBottom;
    Button btnList;
}
