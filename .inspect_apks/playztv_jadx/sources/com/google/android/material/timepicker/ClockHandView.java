package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import j9.f0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p8.k;
import p8.l;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {
    public final RectF A;
    public final int B;
    public float C;
    public boolean D;
    public double E;
    public int F;
    public int G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ValueAnimator f3540u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3541v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f3542w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f3543x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f3544y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Paint f3545z;

    /* JADX WARN: Illegal instructions before constructor call */
    public ClockHandView(Context context, AttributeSet attributeSet) {
        int i = p8.b.materialClockStyle;
        super(context, attributeSet, i);
        this.f3540u = new ValueAnimator();
        this.f3542w = new ArrayList();
        Paint paint = new Paint();
        this.f3545z = paint;
        this.A = new RectF();
        this.G = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ClockHandView, i, k.Widget_MaterialComponents_TimePicker_Clock);
        b8.h.x(context, p8.b.motionDurationLong2, 200);
        b8.h.y(context, p8.b.motionEasingEmphasizedInterpolator, q8.a.f11073b);
        this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.ClockHandView_materialCircleRadius, 0);
        this.f3543x = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.ClockHandView_selectorSize, 0);
        this.B = getResources().getDimensionPixelSize(p8.d.material_clock_hand_stroke_width);
        this.f3544y = r0.getDimensionPixelSize(p8.d.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(l.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = o0.f10475a;
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int a(int i) {
        return i == 2 ? Math.round(this.F * 0.66f) : this.F;
    }

    public final void b(float f) {
        ValueAnimator valueAnimator = this.f3540u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float f4 = f % 360.0f;
        this.C = f4;
        this.E = Math.toRadians(f4 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fA = a(this.G);
        float fCos = (((float) Math.cos(this.E)) * fA) + width;
        float fSin = (fA * ((float) Math.sin(this.E))) + height;
        float f10 = this.f3543x;
        this.A.set(fCos - f10, fSin - f10, fCos + f10, fSin + f10);
        ArrayList arrayList = this.f3542w;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ClockFaceView clockFaceView = (ClockFaceView) ((d) obj);
            if (Math.abs(clockFaceView.f3538f0 - f4) > 0.001f) {
                clockFaceView.f3538f0 = f4;
                clockFaceView.n();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f = width;
        float fA = a(this.G);
        float fCos = (((float) Math.cos(this.E)) * fA) + f;
        float f4 = height;
        float fSin = (fA * ((float) Math.sin(this.E))) + f4;
        Paint paint = this.f3545z;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f3543x, paint);
        double dSin = Math.sin(this.E);
        paint.setStrokeWidth(this.B);
        canvas.drawLine(f, f4, width + ((int) (Math.cos(this.E) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f, f4, this.f3544y, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
        if (this.f3540u.isRunning()) {
            return;
        }
        b(this.C);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z10;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        boolean z11 = false;
        if (actionMasked == 0) {
            this.D = false;
            z2 = true;
            z10 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z10 = this.D;
            if (this.f3541v) {
                this.G = ((float) Math.hypot((double) (x10 - ((float) (getWidth() / 2))), (double) (y10 - ((float) (getHeight() / 2))))) <= ((float) a(2)) + f0.b(getContext(), 12) ? 2 : 1;
            }
            z2 = false;
        } else {
            z10 = false;
            z2 = false;
        }
        boolean z12 = this.D;
        int degrees = (int) Math.toDegrees(Math.atan2(y10 - (getHeight() / 2), x10 - (getWidth() / 2)));
        int i = degrees + 90;
        if (i < 0) {
            i = degrees + 450;
        }
        float f = i;
        boolean z13 = this.C != f;
        if (z2 && z13) {
            z11 = true;
        } else if (z13 || z10) {
            b(f);
            z11 = true;
        }
        this.D = z12 | z11;
        return true;
    }
}
