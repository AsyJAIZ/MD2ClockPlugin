package com.asyjaiz.testplugin;

import android.graphics.Color;
import android.widget.TextClock;

import androidx.core.graphics.ColorUtils;

import com.android.systemui.plugins.clocks.ClockAnimations;

public class MD2ClockAnimations implements ClockAnimations {
    TextClock clock;
    int color = Color.WHITE;
    public MD2ClockAnimations(TextClock clock) {
        this.clock = clock;
    }

    @Override
    public void charge() {

    }

    @Override
    public void enter() {

    }

    @Override
    public void doze(float fraction) {
        //clock.setTextColor(ColorUtils.blendARGB(color, Color.WHITE, fraction));
    }

    @Override
    public void fold(float fraction) {

    }

    @Override
    public void onPositionUpdated(int fromLeft, int direction, float fraction) {

    }

    @Override
    public void onPositionUpdated(float distance, float fraction) {

    }

    @Override
    public void onPickerCarouselSwiping(float swipingFraction) {

    }
}
