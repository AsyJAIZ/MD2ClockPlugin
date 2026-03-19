package com.asyjaiz.testplugin;

import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextClock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.systemui.plugins.clocks.ClockAnimations;
import com.android.systemui.plugins.clocks.ClockFaceConfig;
import com.android.systemui.plugins.clocks.ClockFaceController;
import com.android.systemui.plugins.clocks.ClockFaceEvents;
import com.android.systemui.plugins.clocks.ClockFaceLayout;
import com.android.systemui.plugins.clocks.ClockTickRate;
import com.android.systemui.plugins.clocks.ThemeConfig;

public class MD2ClockFaceController implements ClockFaceController {
    View view;
    ThemeConfig theme;
    Context sysUiContext;
    int attrId = 0;
    TypedValue typedValue;


    ClockAnimations animations;
    ClockFaceLayout layout;
    ClockFaceConfig config;

    private void setClockColor() {
        if (attrId == 0)
            attrId = sysUiContext.getResources().getIdentifier("wallpaperTextColor", "attr", "com.android.systemui");
        if (sysUiContext.getTheme().resolveAttribute(
                attrId,
                typedValue, true)) {
            if (typedValue.isColorType()) {
                ((TextClock) view).setTextColor(typedValue.data);
            } else {
                ((TextClock) view).setTextColor(sysUiContext.getColor(typedValue.resourceId));
            }
        } else {
            ((TextClock) view).setTextColor(0xffffff);
        }
    }

    public MD2ClockFaceController(Context context, Context sysUiCtx) {
        view = LayoutInflater.from(context).inflate(R.layout.clock, null);
        sysUiContext = sysUiCtx;
        animations = new MD2ClockAnimationsStub();
        layout = new MD2ClockFaceLayout(view);
        config = new ClockFaceConfig(ClockTickRate.PER_MINUTE,
                false,
                false,
                false);
    }

    @NonNull
    @Override
    public ClockAnimations getAnimations() {
        return animations;
    }

    @NonNull
    @Override
    public View getView() {
        return view;
    }

    @NonNull
    @Override
    public ClockFaceLayout getLayout() {
        return layout;
    }

    @NonNull
    @Override
    public ClockFaceConfig getConfig() {
        return config;
    }

    @NonNull
    @Override
    public ThemeConfig getTheme() {
        return theme;
    }

    @NonNull
    @Override
    public ClockFaceEvents getEvents() {
        return new ClockFaceEvents() {
            @Override
            public void onTimeTick() {

            }

            @Override
            public void onThemeChanged(@NonNull ThemeConfig themeConfig) {
                setTheme(themeConfig);
            }

            @Override
            public void onFontSettingChanged(float v) {

            }

            @Override
            public void onTargetRegionChanged(@Nullable Rect rect) {

            }

            @Override
            public void onSecondaryDisplayChanged(boolean b) {

            }

            public void onRegionDarknessChanged(boolean b) {

            } // Compatibility
        };
    }

    private void setTheme(ThemeConfig themeConfig) {
        theme = themeConfig;
        setClockColor();
    }
}
