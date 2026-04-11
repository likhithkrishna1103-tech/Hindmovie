package v1;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q0 f12966d = new q0(1.0f, 1.0f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12967e;
    public static final String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f12968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f12969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12970c;

    static {
        int i = y1.a0.f14551a;
        f12967e = Integer.toString(0, 36);
        f = Integer.toString(1, 36);
    }

    public q0(float f10, float f11) {
        y1.d.b(f10 > 0.0f);
        y1.d.b(f11 > 0.0f);
        this.f12968a = f10;
        this.f12969b = f11;
        this.f12970c = Math.round(f10 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && q0.class == obj.getClass()) {
            q0 q0Var = (q0) obj;
            if (this.f12968a == q0Var.f12968a && this.f12969b == q0Var.f12969b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f12969b) + ((Float.floatToRawIntBits(this.f12968a) + 527) * 31);
    }

    public final String toString() {
        Object[] objArr = {Float.valueOf(this.f12968a), Float.valueOf(this.f12969b)};
        int i = y1.a0.f14551a;
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", objArr);
    }
}
