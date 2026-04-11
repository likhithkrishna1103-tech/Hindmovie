package x5;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Build;
import android.view.Choreographer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import l5.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends ValueAnimator implements Choreographer.FrameCallback {
    public j F;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArraySet f14259u = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CopyOnWriteArraySet f14260v = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CopyOnWriteArraySet f14261w = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f14262x = 1.0f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f14263y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f14264z = 0;
    public float A = 0.0f;
    public float B = 0.0f;
    public int C = 0;
    public float D = -2.1474836E9f;
    public float E = 2.1474836E9f;
    public boolean G = false;
    public boolean H = false;

    public final float a() {
        j jVar = this.F;
        if (jVar == null) {
            return 0.0f;
        }
        float f = this.B;
        float f4 = jVar.f7866l;
        return (f - f4) / (jVar.f7867m - f4);
    }

    @Override // android.animation.Animator
    public final void addListener(Animator.AnimatorListener animatorListener) {
        this.f14260v.add(animatorListener);
    }

    @Override // android.animation.Animator
    public final void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f14261w.add(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public final void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f14259u.add(animatorUpdateListener);
    }

    public final float b() {
        j jVar = this.F;
        if (jVar == null) {
            return 0.0f;
        }
        float f = this.E;
        return f == 2.1474836E9f ? jVar.f7867m : f;
    }

    public final float c() {
        j jVar = this.F;
        if (jVar == null) {
            return 0.0f;
        }
        float f = this.D;
        return f == -2.1474836E9f ? jVar.f7866l : f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        Iterator it = this.f14260v.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
        }
        e(d());
        g(true);
    }

    public final boolean d() {
        return this.f14262x < 0.0f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j5) {
        if (this.G) {
            g(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
        j jVar = this.F;
        if (jVar == null || !this.G) {
            return;
        }
        float fAbs = (this.f14264z != 0 ? j5 - r2 : 0L) / ((1.0E9f / jVar.f7868n) / Math.abs(this.f14262x));
        float f = this.A;
        if (d()) {
            fAbs = -fAbs;
        }
        float f4 = f + fAbs;
        float fC = c();
        float fB = b();
        PointF pointF = f.f14266a;
        boolean z2 = f4 >= fC && f4 <= fB;
        float f10 = this.A;
        float fB2 = f.b(f4, c(), b());
        this.A = fB2;
        if (this.H) {
            fB2 = (float) Math.floor(fB2);
        }
        this.B = fB2;
        this.f14264z = j5;
        if (!this.H || this.A != f10) {
            f();
        }
        if (!z2) {
            if (getRepeatCount() == -1 || this.C < getRepeatCount()) {
                Iterator it = this.f14260v.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationRepeat(this);
                }
                this.C++;
                if (getRepeatMode() == 2) {
                    this.f14263y = !this.f14263y;
                    this.f14262x = -this.f14262x;
                } else {
                    float fB3 = d() ? b() : c();
                    this.A = fB3;
                    this.B = fB3;
                }
                this.f14264z = j5;
            } else {
                float fC2 = this.f14262x < 0.0f ? c() : b();
                this.A = fC2;
                this.B = fC2;
                g(true);
                e(d());
            }
        }
        if (this.F == null) {
            return;
        }
        float f11 = this.B;
        if (f11 < this.D || f11 > this.E) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.D), Float.valueOf(this.E), Float.valueOf(this.B)));
        }
    }

    public final void e(boolean z2) {
        for (Animator.AnimatorListener animatorListener : this.f14260v) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z2);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    public final void f() {
        Iterator it = this.f14259u.iterator();
        while (it.hasNext()) {
            ((ValueAnimator.AnimatorUpdateListener) it.next()).onAnimationUpdate(this);
        }
    }

    public final void g(boolean z2) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z2) {
            this.G = false;
        }
    }

    @Override // android.animation.ValueAnimator
    public final float getAnimatedFraction() {
        float fC;
        float fB;
        float fC2;
        if (this.F == null) {
            return 0.0f;
        }
        if (d()) {
            fC = b() - this.B;
            fB = b();
            fC2 = c();
        } else {
            fC = this.B - c();
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
        j jVar = this.F;
        if (jVar == null) {
            return 0L;
        }
        return (long) jVar.b();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public final void h(float f) {
        if (this.A == f) {
            return;
        }
        float fB = f.b(f, c(), b());
        this.A = fB;
        if (this.H) {
            fB = (float) Math.floor(fB);
        }
        this.B = fB;
        this.f14264z = 0L;
        f();
    }

    public final void i(float f, float f4) {
        if (f > f4) {
            throw new IllegalArgumentException("minFrame (" + f + ") must be <= maxFrame (" + f4 + ")");
        }
        j jVar = this.F;
        float f10 = jVar == null ? -3.4028235E38f : jVar.f7866l;
        float f11 = jVar == null ? Float.MAX_VALUE : jVar.f7867m;
        float fB = f.b(f, f10, f11);
        float fB2 = f.b(f4, f10, f11);
        if (fB == this.D && fB2 == this.E) {
            return;
        }
        this.D = fB;
        this.E = fB2;
        h((int) f.b(this.B, fB, fB2));
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final boolean isRunning() {
        return this.G;
    }

    @Override // android.animation.Animator
    public final void removeAllListeners() {
        this.f14260v.clear();
    }

    @Override // android.animation.ValueAnimator
    public final void removeAllUpdateListeners() {
        this.f14259u.clear();
    }

    @Override // android.animation.Animator
    public final void removeListener(Animator.AnimatorListener animatorListener) {
        this.f14260v.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public final void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f14261w.remove(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public final void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f14259u.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final /* bridge */ /* synthetic */ Animator setDuration(long j5) {
        setDuration(j5);
        throw null;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public final void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.f14263y) {
            return;
        }
        this.f14263y = false;
        this.f14262x = -this.f14262x;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setStartDelay(long j5) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final ValueAnimator setDuration(long j5) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
