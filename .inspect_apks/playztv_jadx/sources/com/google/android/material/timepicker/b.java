package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f3547u;

    public b(ClockFaceView clockFaceView) {
        this.f3547u = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f3547u;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.P.f3543x) - clockFaceView.f3533a0;
        if (height != clockFaceView.N) {
            clockFaceView.N = height;
            clockFaceView.m();
            ClockHandView clockHandView = clockFaceView.P;
            clockHandView.F = clockFaceView.N;
            clockHandView.invalidate();
        }
        return true;
    }
}
