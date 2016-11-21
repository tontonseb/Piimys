package com.example.yonni.tp_0109;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;

public class POIMainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = POIMainActivity.class.getName();
    static final int ADDPOI_REQUEST = 1;
    private Button btn;
    private ListView listView;
    private ArrayAdapter<PointOfInterest> POIAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poimain);
        initVar();

        POIAdapter.add(new PointOfInterest("couille","bah c'est ma couille",-150,200,new Date(),5));
        POIAdapter.add(new PointOfInterest("cite","bah c'est ma bite",-150,200,new Date(),5));
        POIAdapter.add(new PointOfInterest("cul","bah c'est mon cul",-150,200,new Date(),5));
    }

    @Override
    public void onClick(View v) {
        Log.i(TAG,btn.getText().toString());

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.add_poi:
                Intent intent = new Intent(this, AddPoiActivity.class);
                startActivityForResult(intent, ADDPOI_REQUEST);

                return true;
            case R.id.remove_poi:
                int position = listView.getCheckedItemPosition();
                POIAdapter.remove(POIAdapter.getItem(position));
                return true;
            case R.id.map_poi:
                Log.i(TAG, "click on menu map_poi");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADDPOI_REQUEST){
            if (resultCode == RESULT_OK){
                PointOfInterest poi = (PointOfInterest) data.getSerializableExtra(AddPoiActivity.DATA_POI_KEY);
                POIAdapter.add(poi);
            }else{
                Toast.makeText(POIMainActivity.this, "POI not added", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void initVar(){

        btn = (Button) findViewById(R.id.button1);
        listView = (ListView) findViewById(R.id.list);
        btn.setOnClickListener(this);
        POIAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice);
        listView.setAdapter(POIAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Log.i("PD ",btn.getText().toString());
                Log.i(TAG,POIAdapter.getItem(position).toString());
                listView.setItemChecked(position, true);
            }
        });
    }
}
