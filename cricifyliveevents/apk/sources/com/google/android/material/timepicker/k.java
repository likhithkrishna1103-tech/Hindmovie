package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ TimePickerView f3013v;

    public k(TimePickerView timePickerView) {
        this.f3013v = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        int i = TimePickerView.M;
        this.f3013v.getClass();
        return false;
    }
}
