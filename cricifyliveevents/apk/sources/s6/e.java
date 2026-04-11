package s6;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Build;
import android.view.Choreographer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends ValueAnimator implements Choreographer.FrameCallback {
    public g6.i G;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CopyOnWriteArraySet f11552v = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CopyOnWriteArraySet f11553w = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CopyOnWriteArraySet f11554x = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f11555y = 1.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f11556z = false;
    public long A = 0;
    public float B = 0.0f;
    public float C = 0.0f;
    public int D = 0;
    public float E = -2.1474836E9f;
    public float F = 2.1474836E9f;
    public boolean H = false;
    public boolean I = false;

    public final float a() {
        g6.i iVar = this.G;
        if (iVar == null) {
            return 0.0f;
        }
        float f = this.C;
        float f10 = iVar.f5095l;
        return (f - f10) / (iVar.f5096m - f10);
    }

    @Override // android.animation.Animator
    public final void addListener(Animator.AnimatorListener animatorListener) {
        this.f11553w.add(animatorListener);
    }

    @Override // android.animation.Animator
    public final void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f11554x.add(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public final void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f11552v.add(animatorUpdateListener);
    }

    public final float b() {
        g6.i iVar = this.G;
        if (iVar == null) {
            return 0.0f;
        }
        float f = this.F;
        return f == 2.1474836E9f ? iVar.f5096m : f;
    }

    public final float c() {
        g6.i iVar = this.G;
        if (iVar == null) {
            return 0.0f;
        }
        float f = this.E;
        return f == -2.1474836E9f ? iVar.f5095l : f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        Iterator it = this.f11553w.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
        }
        e(d());
        g(true);
    }

    public final boolean d() {
        return this.f11555y < 0.0f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j4) {
        if (this.H) {
            g(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
        g6.i iVar = this.G;
        if (iVar == null || !this.H) {
            return;
        }
        float fAbs = (this.A != 0 ? j4 - r2 : 0L) / ((1.0E9f / iVar.f5097n) / Math.abs(this.f11555y));
        float f = this.B;
        if (d()) {
            fAbs = -fAbs;
        }
        float f10 = f + fAbs;
        float fC = c();
        float fB = b();
        PointF pointF = g.f11558a;
        boolean z10 = f10 >= fC && f10 <= fB;
        float f11 = this.B;
        float fB2 = g.b(f10, c(), b());
        this.B = fB2;
        if (this.I) {
            fB2 = (float) Math.floor(fB2);
        }
        this.C = fB2;
        this.A = j4;
        if (z10) {
            if (!this.I || this.B != f11) {
                f();
            }
        } else if (getRepeatCount() == -1 || this.D < getRepeatCount()) {
            if (getRepeatMode() == 2) {
                this.f11556z = !this.f11556z;
                this.f11555y = -this.f11555y;
            } else {
                float fB3 = d() ? b() : c();
                this.B = fB3;
                this.C = fB3;
            }
            this.A = j4;
            if (!this.I || this.B != f11) {
                f();
            }
            Iterator it = this.f11553w.iterator();
            while (it.hasNext()) {
                ((Animator.AnimatorListener) it.next()).onAnimationRepeat(this);
            }
            this.D++;
        } else {
            float fC2 = this.f11555y < 0.0f ? c() : b();
            this.B = fC2;
            this.C = fC2;
            g(true);
            if (!this.I || this.B != f11) {
                f();
            }
            e(d());
        }
        if (this.G == null) {
            return;
        }
        float f12 = this.C;
        if (f12 < this.E || f12 > this.F) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.E), Float.valueOf(this.F), Float.valueOf(this.C)));
        }
    }

    public final void e(boolean z10) {
        for (Animator.AnimatorListener animatorListener : this.f11553w) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z10);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    public final void f() {
        Iterator it = this.f11552v.iterator();
        while (it.hasNext()) {
            ((ValueAnimator.AnimatorUpdateListener) it.next()).onAnimationUpdate(this);
        }
    }

    public final void g(boolean z10) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z10) {
            this.H = false;
        }
    }

    @Override // android.animation.ValueAnimator
    public final float getAnimatedFraction() {
        float fC;
        float fB;
        float fC2;
        if (this.G == null) {
            return 0.0f;
        }
        if (d()) {
            fC = b() - this.C;
            fB = b();
            fC2 = c();
        } else {
            fC = this.C - c();
            fB = b();
            fC2 = c();
        }
        return fC / (fB - fC2);
    }

    @Override // android.animation.ValueAnimator
    public final Object getAnimatedValue() {
        return Float.valueOf(a());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getDuration() {
        g6.i iVar = this.G;
        if (iVar == null) {
            return 0L;
        }
        return (long) iVar.b();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public final void h(float f) {
        if (this.B == f) {
            return;
        }
        float fB = g.b(f, c(), b());
        this.B = fB;
        if (this.I) {
            fB = (float) Math.floor(fB);
        }
        this.C = fB;
        this.A = 0L;
        f();
    }

    public final void i(float f, float f10) {
        if (f > f10) {
            throw new IllegalArgumentException("minFrame (" + f + ") must be <= maxFrame (" + f10 + ")");
        }
        g6.i iVar = this.G;
        float f11 = iVar == null ? -3.4028235E38f : iVar.f5095l;
        float f12 = iVar == null ? Float.MAX_VALUE : iVar.f5096m;
        float fB = g.b(f, f11, f12);
        float fB2 = g.b(f10, f11, f12);
        if (fB == this.E && fB2 == this.F) {
            return;
        }
        this.E = fB;
        this.F = fB2;
        h((int) g.b(this.C, fB, fB2));
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final boolean isRunning() {
        return this.H;
    }

    @Override // android.animation.Animator
    public final void removeAllListeners() {
        this.f11553w.clear();
    }

    @Override // android.animation.ValueAnimator
    public final void removeAllUpdateListeners() {
        this.f11552v.clear();
    }

    @Override // android.animation.Animator
    public final void removeListener(Animator.AnimatorListener animatorListener) {
        this.f11553w.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public final void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f11554x.remove(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public final void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f11552v.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final /* bridge */ /* synthetic */ Animator setDuration(long j4) {
        setDuration(j4);
        throw null;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public final void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.f11556z) {
            return;
        }
        this.f11556z = false;
        this.f11555y = -this.f11555y;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setStartDelay(long j4) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final ValueAnimator setDuration(long j4) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
