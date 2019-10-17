package com.smartlocation.spinnerdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner customSpinner;
    ArrayList<CustomItem> customList;
    int width=150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customSpinner=findViewById(R.id.customIconSpinner);
        customList=getCustomList();
        CustomAdapter adapter= new CustomAdapter(this,customList);
        if(customSpinner !=null) {
            customSpinner.setAdapter(adapter);
            customSpinner.setOnItemSelectedListener(this);
        }


    }

    private ArrayList<CustomItem> getCustomList() {

        customList=new ArrayList<>();
        customList.add(new CustomItem("Notification",R.drawable.ic_notifications_black_24dp));
        customList.add(new CustomItem("Poll",R.drawable.ic_poll_black_24dp));
        return customList;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        try {
            LinearLayout linearLayout=findViewById(R.id.customSpinnerItemLayout);
            width=linearLayout.getWidth();
        }
        catch (Exception e){
        }
        customSpinner.setDropDownWidth(width);
        CustomItem item =(CustomItem) adapterView.getSelectedItem();
        Toast.makeText(this,item.getSpinnerItemName(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
