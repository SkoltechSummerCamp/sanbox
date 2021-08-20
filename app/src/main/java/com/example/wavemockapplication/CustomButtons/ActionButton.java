package com.example.wavemockapplication.CustomButtons;

import android.content.Context;
import android.util.AttributeSet;

import com.example.wavemockapplication.R;

public class ActionButton extends androidx.appcompat.widget.AppCompatButton {
    //current state is at the content description attr

    public ActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setStop() {
        this.setContentDescription("stop");
        this.setBackground(getContext().getDrawable(R.drawable.ic_stop_btn));
    }

    public void setPlay() { // when continue after stopping
        this.setContentDescription("play");
        this.setBackground(getContext().getDrawable(R.drawable.ic_play_btn));
    }

    public void setStart() { // when start from main menu
        this.setContentDescription("start");
        this.setBackground(getContext().getDrawable(R.drawable.ic_start_btn));
    }

    public void setRestart() {
        this.setContentDescription("start");
        this.setBackground(getContext().getDrawable(R.drawable.ic_restart_btn));
    }


}
