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
import da.e0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {
    public static final /* synthetic */ int I = 0;
    public final Paint A;
    public final RectF B;
    public final int C;
    public float D;
    public boolean E;
    public double F;
    public int G;
    public int H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ValueAnimator f3002v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3003w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList f3004x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3005y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f3006z;

    /* JADX WARN: Illegal instructions before constructor call */
    public ClockHandView(Context context, AttributeSet attributeSet) {
        int i = k9.b.materialClockStyle;
        super(context, attributeSet, i);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f3002v = valueAnimator;
        this.f3004x = new ArrayList();
        Paint paint = new Paint();
        this.A = paint;
        this.B = new RectF();
        this.H = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k9.l.ClockHandView, i, k9.k.Widget_MaterialComponents_TimePicker_Clock);
        sd.i.C(context, k9.b.motionDurationLong2, 200);
        sd.i.D(context, k9.b.motionEasingEmphasizedInterpolator, l9.a.f7926b);
        this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(k9.l.ClockHandView_materialCircleRadius, 0);
        this.f3005y = typedArrayObtainStyledAttributes.getDimensionPixelSize(k9.l.ClockHandView_selectorSize, 0);
        this.C = getResources().getDimensionPixelSize(k9.d.material_clock_hand_stroke_width);
        this.f3006z = r0.getDimensionPixelSize(k9.d.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(k9.l.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int i10 = ClockHandView.I;
                this.f3010a.c(((Float) valueAnimator2.getAnimatedValue()).floatValue());
            }
        });
        valueAnimator.addListener(new e());
    }

    public final int a(int i) {
        return i == 2 ? Math.round(this.G * 0.66f) : this.G;
    }

    public final void b(float f) {
        this.f3002v.cancel();
        c(f);
    }

    public final void c(float f) {
        float f10 = f % 360.0f;
        this.D = f10;
        this.F = Math.toRadians(f10 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fA = a(this.H);
        float fCos = (((float) Math.cos(this.F)) * fA) + width;
        float fSin = (fA * ((float) Math.sin(this.F))) + height;
        float f11 = this.f3005y;
        this.B.set(fCos - f11, fSin - f11, fCos + f11, fSin + f11);
        ArrayList arrayList = this.f3004x;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ClockFaceView clockFaceView = (ClockFaceView) ((f) obj);
            if (Math.abs(clockFaceView.f3000e0 - f10) > 0.001f) {
                clockFaceView.f3000e0 = f10;
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
        float fA = a(this.H);
        float fCos = (((float) Math.cos(this.F)) * fA) + f;
        float f10 = height;
        float fSin = (fA * ((float) Math.sin(this.F))) + f10;
        Paint paint = this.A;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f3005y, paint);
        double dSin = Math.sin(this.F);
        paint.setStrokeWidth(this.C);
        canvas.drawLine(f, f10, width + ((int) (Math.cos(this.F) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f, f10, this.f3006z, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
        if (this.f3002v.isRunning()) {
            return;
        }
        b(this.D);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        boolean z12 = false;
        if (actionMasked == 0) {
            this.E = false;
            z10 = true;
            z11 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z11 = this.E;
            if (this.f3003w) {
                this.H = ((float) Math.hypot((double) (x10 - ((float) (getWidth() / 2))), (double) (y10 - ((float) (getHeight() / 2))))) <= ((float) a(2)) + e0.a(getContext(), 12) ? 2 : 1;
            }
            z10 = false;
        } else {
            z11 = false;
            z10 = false;
        }
        boolean z13 = this.E;
        int degrees = (int) Math.toDegrees(Math.atan2(y10 - (getHeight() / 2), x10 - (getWidth() / 2)));
        int i = degrees + 90;
        if (i < 0) {
            i = degrees + 450;
        }
        float f = i;
        boolean z14 = this.D != f;
        if (z10 && z14) {
            z12 = true;
        } else if (z14 || z11) {
            b(f);
            z12 = true;
        }
        this.E = z13 | z12;
        return true;
    }
}
