package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {
    public static final /* synthetic */ int M = 0;
    public final Chip L;

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        j jVar = new j(this);
        LayoutInflater.from(context).inflate(k9.h.material_timepicker, this);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(k9.f.material_clock_period_toggle);
        materialButtonToggleGroup.G.add(new i());
        Chip chip = (Chip) findViewById(k9.f.material_minute_tv);
        Chip chip2 = (Chip) findViewById(k9.f.material_hour_tv);
        this.L = chip2;
        l lVar = new l(new GestureDetector(getContext(), new k(this)));
        chip.setOnTouchListener(lVar);
        chip2.setOnTouchListener(lVar);
        chip.setTag(k9.f.selection_type, 12);
        chip2.setTag(k9.f.selection_type, 10);
        chip.setOnClickListener(jVar);
        chip2.setOnClickListener(jVar);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            this.L.sendAccessibilityEvent(8);
        }
    }
}
