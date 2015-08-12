package me.fahadalrabbani.funfacts;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {

    //public static final String TAG = FunFactsActivity.class.getSimpleName();
    private static final String KEY_FACT = "KEY_FACT"           ;
    private static final String KEY_COLOR = "KEY_COLOR";
    private TextView factLabel;
    private RelativeLayout background;
    private Button showFactButton;
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private String mFact =  mFactBook.mFacts[0];
    private int mColor = Color.parseColor(mColorWheel.mColors[8]);

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR,mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mFact = savedInstanceState.getString(KEY_FACT);
        factLabel.setText(mFact);
        mColor = savedInstanceState.getInt(KEY_COLOR);
        background.setBackgroundColor(mColor);
        showFactButton.setTextColor(mColor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);
        //Declare our View variables and assign them the Views from layout file.
        factLabel = (TextView) findViewById(R.id.funFactsTextView);
        showFactButton = (Button) findViewById(R.id.showFactsButton);
        background = (RelativeLayout)findViewById(R.id.relativeLayout);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //The button was clicked, update the factLabel with a new fact.
                mFact = mFactBook.getFact();
                //Update the label with our dynamic fact.
                factLabel.setText(mFact);
                //get the color from mColorWheel and set it as color.
                mColor = mColorWheel.getColor();
                //change the background to value of color.
                background.setBackgroundColor(mColor);
                showFactButton.setTextColor(mColor);
            }
        };

        showFactButton.setOnClickListener(listener);

        //Toast.makeText(this,"Activity was created.", Toast.LENGTH_LONG).show();
        //Log.d(TAG,"We are logging from the OnCreate() method.");
    }

}
