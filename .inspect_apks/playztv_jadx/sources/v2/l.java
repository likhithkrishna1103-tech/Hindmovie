package v2;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final j f13223w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final GestureDetector f13225y;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final PointF f13221u = new PointF();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PointF f13222v = new PointF();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f13224x = 25.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile float f13226z = 3.1415927f;

    public l(Context context, j jVar) {
        this.f13223w = jVar;
        this.f13225y = new GestureDetector(context, this);
    }

    @Override // v2.c
    public final void a(float[] fArr, float f) {
        this.f13226z = -f;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.f13221u.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
        float x10 = (motionEvent2.getX() - this.f13221u.x) / this.f13224x;
        float y10 = motionEvent2.getY();
        PointF pointF = this.f13221u;
        float f10 = (y10 - pointF.y) / this.f13224x;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d10 = this.f13226z;
        float fCos = (float) Math.cos(d10);
        float fSin = (float) Math.sin(d10);
        PointF pointF2 = this.f13222v;
        pointF2.x -= (fCos * x10) - (fSin * f10);
        float f11 = (fCos * f10) + (fSin * x10) + pointF2.y;
        pointF2.y = f11;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f11));
        j jVar = this.f13223w;
        PointF pointF3 = this.f13222v;
        synchronized (jVar) {
            float f12 = pointF3.y;
            jVar.A = f12;
            Matrix.setRotateM(jVar.f13213y, 0, -f12, (float) Math.cos(jVar.B), (float) Math.sin(jVar.B), 0.0f);
            Matrix.setRotateM(jVar.f13214z, 0, -pointF3.x, 0.0f, 1.0f, 0.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f13223w.E.performClick();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f13225y.onTouchEvent(motionEvent);
    }
}
