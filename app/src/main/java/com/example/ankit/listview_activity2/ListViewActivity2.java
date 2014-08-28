package com.example.ankit.listview_activity2;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListViewActivity2 extends ListActivity {     ///extends ListActivity coz no need to make object below...

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_view_activity2); ///this part has been commented coz it does not require any view and layout
        //and thus layout has been removed from the .xml file....

        String[] Subjects = new String[]{"C", "C++", "Java", "Android", "iOS", "BlackBerry", "CIT", "ES", "EM", "ME", "RM", "HSSN", "PM", "CCSD", "DP"};

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_view_activity2, Subjects));
        lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position + 1;  // Array indexing starts from 0..so while showing position user should get actual position of item...
                String itemText = (String) lv.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Item's Position: " + itemPosition + " and Item is: " + itemText, Toast.LENGTH_LONG).show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
