package com.asyjaiz.testplugin;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;

import com.android.systemui.plugins.clocks.AodClockBurnInModel;
import com.android.systemui.plugins.clocks.ClockFaceLayout;
import com.android.systemui.plugins.clocks.ClockPreviewConfig;

import java.util.Collections;
import java.util.List;

public class MD2ClockFaceLayout implements ClockFaceLayout {
    View view;
    public MD2ClockFaceLayout(View view) {
        this.view = view;
    }

    @Override
    public void applyAodBurnIn(@NonNull AodClockBurnInModel bim) {
        view.setScaleX(bim.getScale());
        view.setScaleY(bim.getScale());
        view.setTranslationX(bim.getTranslationX());
        view.setTranslationY(bim.getTranslationY());
    }

    @NonNull
    @Override
    public List<View> getViews() {
        return Collections.singletonList(view);
    }

    @NonNull
    @Override
    public ConstraintSet applyConstraints(@NonNull ConstraintSet constraintSet) {
        return constraintSet;
    }

    @NonNull
    @Override
    public ConstraintSet applyPreviewConstraints(@NonNull ClockPreviewConfig clockPreviewConfig, @NonNull ConstraintSet constraintSet) {
        return constraintSet;
    }
}
