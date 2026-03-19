package com.asyjaiz.testplugin;

import androidx.annotation.NonNull;

import com.android.systemui.plugins.clocks.AlarmData;
import com.android.systemui.plugins.clocks.ClockEvents;
import com.android.systemui.plugins.clocks.ClockFontAxisSetting;
import com.android.systemui.plugins.clocks.WeatherData;
import com.android.systemui.plugins.clocks.ZenData;

import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class MD2ClockEventsStub implements ClockEvents {
    @Override
    public boolean isReactiveTouchInteractionEnabled() {
        return false;
    }

    @Override
    public void setReactiveTouchInteractionEnabled(boolean b) {

    }

    @Override
    public void onTimeZoneChanged(@NonNull TimeZone timeZone) {

    }

    @Override
    public void onTimeFormatChanged(boolean b) {

    }

    @Override
    public void onLocaleChanged(@NonNull Locale locale) {

    }

    @Override
    public void onWeatherDataChanged(@NonNull WeatherData weatherData) {

    }

    @Override
    public void onAlarmDataChanged(@NonNull AlarmData alarmData) {

    }

    @Override
    public void onZenDataChanged(@NonNull ZenData zenData) {

    }

    @Override
    public void onFontAxesChanged(@NonNull List<ClockFontAxisSetting> list) {

    }
}
