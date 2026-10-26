package com.asyjaiz.testplugin;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

    private final boolean large;
    View view;
    TextClock clock;
    ThemeConfig theme;
    Context sysUiContext;

    private int color = Color.WHITE;


    ClockAnimations animations;
    ClockFaceEvents events;
    ClockFaceLayout layout;
    ClockFaceConfig config;

    public MD2ClockFaceController(Context context, Context sysUiCtx, boolean large) {
        view = LayoutInflater.from(context).inflate(R.layout.clock, new FrameLayout(context), false);
        view.setId(sysId(sysUiCtx, large ? "lockscreen_clock_view_large" : "lockscreen_clock_view"));
        this.large = large;

        clock = view.findViewById(R.id.clock_view);
        clock.setTypeface(context.getResources().getFont(R.font.google_sans_regular));

        sysUiContext = sysUiCtx;
        animations = new MD2ClockAnimations(clock);
        events = new ClockFaceEvents() {
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
                ViewGroup.LayoutParams lp = view.getLayoutParams();
                if (rect == null || !(lp instanceof FrameLayout.LayoutParams) || view.getHeight() == 0) return;
                if (large) ((FrameLayout.LayoutParams) lp).topMargin = rect.centerY() - view.getHeight() / 2;
                else ((FrameLayout.LayoutParams) lp).gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
                view.setLayoutParams(lp);
            }

            @Override
            public void onSecondaryDisplayChanged(boolean b) {

            }

            public void onRegionDarknessChanged(boolean b) {

            } // Compatibility
        };
        layout = new MD2ClockFaceLayout(view, sysUiCtx);
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
        return events;
    }

    private void setTheme(ThemeConfig themeConfig) {
        theme = themeConfig;
        Integer seed = themeConfig.getSeedColor();
        color = seed != null ? seed
                : sysUiContext.getResources().getColor(
                themeConfig.isDarkTheme() ? android.R.color.system_accent1_100
                        : android.R.color.system_accent2_600, null);
        clock.setTextColor(color);
    }

    static int sysId(Context sys, String name) {
        return sys.getResources().getIdentifier(name, "id", "com.android.systemui");
    }
}
