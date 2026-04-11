package p1;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q0 f10036d = new q0(1.0f, 1.0f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10037e;
    public static final String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f10038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f10039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10040c;

    static {
        int i = s1.b0.f11647a;
        f10037e = Integer.toString(0, 36);
        f = Integer.toString(1, 36);
    }

    public q0(float f4, float f10) {
        s1.d.b(f4 > 0.0f);
        s1.d.b(f10 > 0.0f);
        this.f10038a = f4;
        this.f10039b = f10;
        this.f10040c = Math.round(f4 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && q0.class == obj.getClass()) {
            q0 q0Var = (q0) obj;
            if (this.f10038a == q0Var.f10038a && this.f10039b == q0Var.f10039b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f10039b) + ((Float.floatToRawIntBits(this.f10038a) + 527) * 31);
    }

    public final String toString() {
        Object[] objArr = {Float.valueOf(this.f10038a), Float.valueOf(this.f10039b)};
        int i = s1.b0.f11647a;
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", objArr);
    }
}
