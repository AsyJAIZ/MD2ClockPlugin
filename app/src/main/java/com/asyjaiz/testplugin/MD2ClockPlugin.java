package com.asyjaiz.testplugin;

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.systemui.plugins.annotations.Requires;
import com.android.systemui.plugins.clocks.ClockController;
import com.android.systemui.plugins.clocks.ClockMessageBuffers;
import com.android.systemui.plugins.clocks.ClockMetadata;
import com.android.systemui.plugins.clocks.ClockPickerConfig;
import com.android.systemui.plugins.clocks.ClockProviderPlugin;
import com.android.systemui.plugins.clocks.ClockSettings;

import java.util.Collections;
import java.util.List;

@Requires(target = ClockProviderPlugin.class, version = ClockProviderPlugin.VERSION)
public class MD2ClockPlugin implements ClockProviderPlugin {
    String TAG = MD2ClockPlugin.class.getSimpleName();
    static String id = "MATERIAL2";
    Context thisCtx;
    Resources res;

    ClockController clock;
    ClockPickerConfig pickerConfig;

    private void checkAndThrow(ClockSettings clockSettings) {
        String clockId = clockSettings.getClockId();
        if (clockId == null || !clockId.equals(id)) {
            throw new IllegalArgumentException("Clock " + clockId +
                    " is not specified/supported by " + TAG);
        }
    }

    @Nullable
    @Override
    public ClockController createClock(@NonNull ClockSettings clockSettings) {
        checkAndThrow(clockSettings);
        return clock;
    }

    @Override
    public void onCreate(Context sysuiContext, Context pluginContext) {
        ClockProviderPlugin.super.onCreate(sysuiContext, pluginContext);
        thisCtx = pluginContext;
        res = thisCtx.getResources();
        clock = new MD2ClockController(pluginContext, res, sysuiContext);
        /* API wasn't finished yet
        pickerConfig = new ClockPickerConfig(id,
                res.getString(R.string.clock_name),
                res.getString(R.string.clock_desc),
                res.getDrawable(R.drawable.md2_thumbnail, null),
                false);*/
    }

    @Override
    public void initialize(@Nullable ClockMessageBuffers clockMessageBuffers) {

    }

    @NonNull
    @Override
    public List<ClockMetadata> getClocks() {
        return Collections.singletonList(new ClockMetadata(id));
    }

    @NonNull
    @Override
    public ClockPickerConfig getClockPickerConfig(@NonNull ClockSettings clockSettings) {
        checkAndThrow(clockSettings);
        return pickerConfig;
    }
}
