package com.asyjaiz.testplugin;

import android.content.Context;
import android.util.Log;
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
    Context sysCtx;
    public MD2ClockFaceLayout(View view, Context systemContext) {
        this.view = view;
        sysCtx = systemContext;
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
        //constraintSet.constrainHeight(0, ConstraintSet.WRAP_CONTENT);
        for (int id : constraintSet.getKnownIds()) {
            Log.i("MD2ClockFaceLayout", "ID: " + sysCtx.getResources().getResourceEntryName(id));
        }
        constraintSet.connect(view.getId(), ConstraintSet.TOP, 0, ConstraintSet.TOP);
        constraintSet.connect(view.getId(), ConstraintSet.BOTTOM, 0, ConstraintSet.BOTTOM);
        constraintSet.connect(view.getId(), ConstraintSet.START, 0, ConstraintSet.START);
        constraintSet.connect(view.getId(), ConstraintSet.END, 0, ConstraintSet.END);
        return constraintSet;
    }

    @NonNull
    @Override
    public ConstraintSet applyPreviewConstraints(@NonNull ClockPreviewConfig clockPreviewConfig, @NonNull ConstraintSet constraintSet) {
        return constraintSet;
    }
}
