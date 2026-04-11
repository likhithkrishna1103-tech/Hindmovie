package q8;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f11081a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimeInterpolator f11083c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11084d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11085e = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11082b = 150;

    public e(long j5) {
        this.f11081a = j5;
    }

    public final void a(ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay(this.f11081a);
        objectAnimator.setDuration(this.f11082b);
        objectAnimator.setInterpolator(b());
        objectAnimator.setRepeatCount(this.f11084d);
        objectAnimator.setRepeatMode(this.f11085e);
    }

    public final TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f11083c;
        return timeInterpolator != null ? timeInterpolator : a.f11073b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f11081a == eVar.f11081a && this.f11082b == eVar.f11082b && this.f11084d == eVar.f11084d && this.f11085e == eVar.f11085e) {
            return b().getClass().equals(eVar.b().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f11081a;
        long j8 = this.f11082b;
        return ((((b().getClass().hashCode() + (((((int) (j5 ^ (j5 >>> 32))) * 31) + ((int) ((j8 >>> 32) ^ j8))) * 31)) * 31) + this.f11084d) * 31) + this.f11085e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("\n");
        sb2.append(e.class.getName());
        sb2.append('{');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" delay: ");
        sb2.append(this.f11081a);
        sb2.append(" duration: ");
        sb2.append(this.f11082b);
        sb2.append(" interpolator: ");
        sb2.append(b().getClass());
        sb2.append(" repeatCount: ");
        sb2.append(this.f11084d);
        sb2.append(" repeatMode: ");
        return x.c.a(sb2, this.f11085e, "}\n");
    }
}
