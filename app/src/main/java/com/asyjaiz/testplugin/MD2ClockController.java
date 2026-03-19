package com.asyjaiz.testplugin;

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.NonNull;

import com.android.systemui.plugins.clocks.ClockConfig;
import com.android.systemui.plugins.clocks.ClockController;
import com.android.systemui.plugins.clocks.ClockEvents;
import com.android.systemui.plugins.clocks.ClockFaceController;

import java.io.PrintWriter;

public class MD2ClockController implements ClockController {
    Resources res;
    ClockEvents events;
    ClockConfig config;
    ClockFaceController clock;
    ClockFaceController clockL;
    public MD2ClockController(Context context, Resources res, Context sysUiContext) {
        this.res = res;
        events = new MD2ClockEventsStub();
        config = new ClockConfig(MD2ClockPlugin.id,
                res.getString(R.string.clock_name),
                res.getString(R.string.clock_desc),
                false,
                false,
                false);
        clock = new MD2ClockFaceController(context, sysUiContext);
        clockL = new MD2ClockFaceController(context, sysUiContext);
    }

    @NonNull
    @Override
    public ClockFaceController getSmallClock() {
        return clock;
    }

    @NonNull
    @Override
    public ClockFaceController getLargeClock() {
        return clockL;
    }

    @NonNull
    @Override
    public ClockConfig getConfig() {
        return config;
    }

    @NonNull
    @Override
    public ClockEvents getEvents() {
        return events;
    }

    @Override
    public void initialize(boolean isDarkTheme, float doseFraction, float foldFraction) {

    }

    public void initialize(Resources res, float doseFraction, float foldFraction) {

    } // Compatibility

    @Override
    public void dump(@NonNull PrintWriter printWriter) {

    }
}
