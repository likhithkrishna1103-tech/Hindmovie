package v1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 extends x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13045e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f13047c;

    static {
        int i = y1.a0.f14551a;
        f13044d = Integer.toString(1, 36);
        f13045e = Integer.toString(2, 36);
    }

    public y0(int i) {
        y1.d.a("maxStars must be a positive integer", i > 0);
        this.f13046b = i;
        this.f13047c = -1.0f;
    }

    @Override // v1.x0
    public final boolean b() {
        return this.f13047c != -1.0f;
    }

    @Override // v1.x0
    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(x0.f13036a, 2);
        bundle.putInt(f13044d, this.f13046b);
        bundle.putFloat(f13045e, this.f13047c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return this.f13046b == y0Var.f13046b && this.f13047c == y0Var.f13047c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f13046b), Float.valueOf(this.f13047c));
    }

    public y0(int i, float f) {
        boolean z10 = false;
        y1.d.a("maxStars must be a positive integer", i > 0);
        if (f >= 0.0f && f <= i) {
            z10 = true;
        }
        y1.d.a("starRating is out of range [0, maxStars]", z10);
        this.f13046b = i;
        this.f13047c = f;
    }
}
