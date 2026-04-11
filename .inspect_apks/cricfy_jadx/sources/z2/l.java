package z2;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final j f15168x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final GestureDetector f15170z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PointF f15166v = new PointF();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final PointF f15167w = new PointF();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f15169y = 25.0f;
    public volatile float A = 3.1415927f;

    public l(Context context, j jVar) {
        this.f15168x = jVar;
        this.f15170z = new GestureDetector(context, this);
    }

    @Override // z2.c
    public final void a(float[] fArr, float f) {
        this.A = -f;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.f15166v.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f10) {
        float x10 = (motionEvent2.getX() - this.f15166v.x) / this.f15169y;
        float y10 = motionEvent2.getY();
        PointF pointF = this.f15166v;
        float f11 = (y10 - pointF.y) / this.f15169y;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d10 = this.A;
        float fCos = (float) Math.cos(d10);
        float fSin = (float) Math.sin(d10);
        PointF pointF2 = this.f15167w;
        pointF2.x -= (fCos * x10) - (fSin * f11);
        float f12 = (fCos * f11) + (fSin * x10) + pointF2.y;
        pointF2.y = f12;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f12));
        j jVar = this.f15168x;
        PointF pointF3 = this.f15167w;
        synchronized (jVar) {
            float f13 = pointF3.y;
            jVar.B = f13;
            Matrix.setRotateM(jVar.f15160z, 0, -f13, (float) Math.cos(jVar.C), (float) Math.sin(jVar.C), 0.0f);
            Matrix.setRotateM(jVar.A, 0, -pointF3.x, 0.0f, 1.0f, 0.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f15168x.F.performClick();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f15170z.onTouchEvent(motionEvent);
    }
}
