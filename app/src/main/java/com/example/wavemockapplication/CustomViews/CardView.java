package com.example.wavemockapplication.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wavemockapplication.R;
import com.example.wavemockapplication.Wave;

public class CardView extends LinearLayout {

    private TextView integerSpeedTV;
    private TextView fractionSpeedTV;
    private TextView pingTV;

    private TextView dotCaption;
    private TextView mbpsCaption;
    private TextView pingCaption;

    Wave mWave;

    String mStatus;


    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);

        inflate(getContext(), R.layout.card_layout, this);

        init();
        parseAttrs(context, attrs);
    }

    private void init() {
        integerSpeedTV = findViewById(R.id.integer_speed);
        fractionSpeedTV = findViewById(R.id.fraction_speed);

        pingTV = findViewById(R.id.value_ping);

        dotCaption = findViewById(R.id.dot_speed);
        mbpsCaption = findViewById(R.id.caption_speed);
        pingCaption = findViewById(R.id.label_ping);

        mWave = findViewById(R.id.progress_wave);
    }

    private void parseAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CardView);
        int count = typedArray.getIndexCount();

        try {
            for (int i = 0; i < count; ++i) {

                int attr = typedArray.getIndex(i);

                if (attr == R.styleable.CardView_status) {
                    mStatus = typedArray.getString(attr);

                    setStatus(mStatus);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            typedArray.recycle();
        }
    }

    //    status is download or upload for drawable arrow
    private void setStatus(String status) {
        mStatus = status;
    }

    private void setPing(int ping) {
        pingTV.setText(String.valueOf(ping));
    }

    private void setIntegerSpeed(int speed) {
        integerSpeedTV.setText(String.valueOf(speed));
    }

    private void setFractionSpeed(int speed) {
        fractionSpeedTV.setText(String.valueOf(speed));
    }

    private void setDrawableStatus() {
    }

    public void setInstantSpeed(int integerSpeed, int fractionSpeed) {
        setFractionSpeed(fractionSpeed);
        setIntegerSpeed(integerSpeed);
    }


    public void setDefaultCaptions() {
        dotCaption.setText(".");
        pingCaption.setText("ping");
        mbpsCaption.setText("Mbps");

    }

    public void setEmptyCaptions() {
        integerSpeedTV.setText("");
        fractionSpeedTV.setText("");
        pingTV.setText("");

        dotCaption.setText("");
        pingCaption.setText("");
        mbpsCaption.setText("");
    }

    public void setMessage(String msg) {
        integerSpeedTV.setText(msg);
    }

    public String getPing() {
        return pingTV.getText().toString();
    }

    public Wave getWave() {
        return mWave;
    }
}
