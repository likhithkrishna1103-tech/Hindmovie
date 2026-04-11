package com.google.android.material.timepicker;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends t0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f3009d;

    public c(ClockFaceView clockFaceView) {
        this.f3009d = clockFaceView;
    }

    @Override // t0.b
    public final void d(View view, u0.e eVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = eVar.f12062a;
        this.f11731a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        int iIntValue = ((Integer) view.getTag(k9.f.material_value_index)).intValue();
        if (iIntValue > 0) {
            accessibilityNodeInfo.setTraversalAfter((View) this.f3009d.S.get(iIntValue - 1));
        }
        eVar.j(u0.d.a(0, 1, iIntValue, 1, false, view.isSelected()));
        accessibilityNodeInfo.setClickable(true);
        eVar.b(u0.c.f12047g);
    }

    @Override // t0.b
    public final boolean g(View view, int i, Bundle bundle) {
        if (i != 16) {
            return super.g(view, i, bundle);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        ClockFaceView clockFaceView = this.f3009d;
        view.getHitRect(clockFaceView.P);
        float fCenterX = clockFaceView.P.centerX();
        float fCenterY = clockFaceView.P.centerY();
        clockFaceView.O.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
        clockFaceView.O.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
        return true;
    }
}
