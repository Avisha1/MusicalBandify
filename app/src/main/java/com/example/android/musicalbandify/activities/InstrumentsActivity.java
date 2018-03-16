package com.example.android.musicalbandify.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodSession;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.musicalbandify.R;

public class InstrumentsActivity extends AppCompatActivity {


    Button btnDrums;
    Button btnVocals;
    Button btnLeadGuitar;
    Button btnBass;

    Button btnPlay;

    private int resourceChosen = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruments);

        setButtons();
    }

    private void setButtons(){
        btnBass = (Button)findViewById(R.id.btn_bass);
        btnDrums = (Button)findViewById(R.id.btn_drums);
        btnLeadGuitar = (Button)findViewById(R.id.btn_guitar);
        btnVocals = (Button)findViewById(R.id.btn_vocals);

        btnPlay = (Button) findViewById(R.id.btn_play);
        btnPlay.setEnabled(false);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (resourceChosen == -1) {
                    return;
                }

                Intent intent = new Intent(InstrumentsActivity.this, PlayActivity.class);
                intent.putExtra("SONG_RESOURCE_ID", resourceChosen);
                startActivity(intent);
            }
        });
        setButtonsEvents();
    }

    private void setButtonsEvents(){
        btnBass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnPlay.setEnabled(true);
                resourceChosen = getResourceIdByButton((Button)view);
                Toast.makeText(getApplicationContext(),"Chosen Bass", Toast.LENGTH_SHORT).show();
            }
        });
        btnLeadGuitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnPlay.setEnabled(true);
                resourceChosen = getResourceIdByButton((Button)view);
                Toast.makeText(getApplicationContext(),"Chosen LeadGuitar", Toast.LENGTH_SHORT).show();
            }
        });
        btnDrums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnPlay.setEnabled(true);
                resourceChosen = getResourceIdByButton((Button)view);
                Toast.makeText(getApplicationContext(),"Chosen Drums", Toast.LENGTH_SHORT).show();
            }
        });
        btnVocals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnPlay.setEnabled(true);
                resourceChosen = getResourceIdByButton((Button)view);
                Toast.makeText(getApplicationContext(),"Chosen Vocals", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private int getResourceIdByButton(Button btn){
        if(btn == btnBass){
            return R.raw.ed_sheeran_shape_of_you_bass_only;
        }
        else if(btn == btnDrums){
            return R.raw.ed_sheeran_shape_of_you_drums_only;
        }
        else if(btn == btnLeadGuitar){
            return R.raw.ed_sheeran_shape_of_you_lead_guitar_only;
        }
        else{
            return R.raw.ed_sheeran_shape_of_you_vocal_only;
        }
    }

}
