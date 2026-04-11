package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f3008v;

    public b(ClockFaceView clockFaceView) {
        this.f3008v = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f3008v;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.O.f3005y) - clockFaceView.W;
        if (height != clockFaceView.M) {
            clockFaceView.M = height;
            clockFaceView.m();
            ClockHandView clockHandView = clockFaceView.O;
            clockHandView.G = clockFaceView.M;
            clockHandView.invalidate();
        }
        return true;
    }
}
