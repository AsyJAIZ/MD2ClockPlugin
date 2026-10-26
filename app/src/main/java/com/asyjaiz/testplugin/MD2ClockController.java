package com.asyjaiz.testplugin;

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.NonNull;

import com.android.systemui.plugins.clocks.ClockConfig;
import com.android.systemui.plugins.clocks.ClockController;
import com.android.systemui.plugins.clocks.ClockEvents;
import com.android.systemui.plugins.clocks.ClockFaceController;
import com.android.systemui.plugins.clocks.ThemeConfig;

import java.io.PrintWriter;

public class MD2ClockController implements ClockController {
    ClockEvents events;
    ClockConfig config;
    ClockFaceController clock;
    ClockFaceController largeClock;
    public MD2ClockController(Context context, Context sysUiContext) {
        Resources res = context.getResources();
        events = new MD2ClockEventsStub();
        config = new ClockConfig(MD2ClockPlugin.id,
                res.getString(R.string.clock_name),
                res.getString(R.string.clock_desc),
                false,
                false,
                false);
        clock = new MD2ClockFaceController(context, sysUiContext, false);
        largeClock = new MD2ClockFaceController(context, sysUiContext, true);
    }

    @NonNull
    @Override
    public ClockFaceController getSmallClock() {
        return clock;
    }

    @NonNull
    @Override
    public ClockFaceController getLargeClock() {
        return largeClock;
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
        ThemeConfig t = new ThemeConfig(isDarkTheme, null);
        clock.getEvents().onThemeChanged(t);
        largeClock.getEvents().onThemeChanged(t);
    }

    public void initialize(Resources res, float doseFraction, float foldFraction) {

    } // Compatibility

    @Override
    public void dump(@NonNull PrintWriter printWriter) {

    }
}
