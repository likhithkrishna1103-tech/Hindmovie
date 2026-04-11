package l9;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7934a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimeInterpolator f7936c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7937d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7938e = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7935b = 150;

    public e(long j4) {
        this.f7934a = j4;
    }

    public final void a(ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay(this.f7934a);
        objectAnimator.setDuration(this.f7935b);
        objectAnimator.setInterpolator(b());
        objectAnimator.setRepeatCount(this.f7937d);
        objectAnimator.setRepeatMode(this.f7938e);
    }

    public final TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f7936c;
        return timeInterpolator != null ? timeInterpolator : a.f7926b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f7934a == eVar.f7934a && this.f7935b == eVar.f7935b && this.f7937d == eVar.f7937d && this.f7938e == eVar.f7938e) {
            return b().getClass().equals(eVar.b().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f7934a;
        long j7 = this.f7935b;
        return ((((b().getClass().hashCode() + (((((int) (j4 ^ (j4 >>> 32))) * 31) + ((int) ((j7 >>> 32) ^ j7))) * 31)) * 31) + this.f7937d) * 31) + this.f7938e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(e.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.f7934a);
        sb.append(" duration: ");
        sb.append(this.f7935b);
        sb.append(" interpolator: ");
        sb.append(b().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.f7937d);
        sb.append(" repeatMode: ");
        return q4.a.o(sb, this.f7938e, "}\n");
    }
}
