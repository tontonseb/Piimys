package com.example.yonni.tp_0109;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by Yonni on 01/09/2016.
 */
public class AddPoiActivity extends AppCompatActivity {

    public static final String DATA_POI_KEY = "data_POI";
    EditText label;
    EditText description;
    double longitude;
    double latitude;
    Button addPoi;
    RatingBar score;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpoi);

        addPoi = (Button) findViewById(R.id.add_poi_button);
        label = ((EditText) findViewById(R.id.labelField));
        description = (EditText) findViewById(R.id.descriptionField);
        score = (RatingBar) findViewById(R.id.scoreBar);
        addPoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (label.getText().toString().equals("")) {
                    Toast.makeText(AddPoiActivity.this, "label must not be empty", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    PointOfInterest poi = new PointOfInterest(
                            label.getText().toString(),
                            description.getText().toString(),
                            0.4,
                            2.4,
                            new Date(),
                            score.getNumStars()
                    );
                    Intent intent = new Intent();
                    intent.putExtra(DATA_POI_KEY,poi);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}
