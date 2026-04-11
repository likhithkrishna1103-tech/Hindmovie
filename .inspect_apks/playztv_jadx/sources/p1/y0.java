package p1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y0 extends x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10110e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f10112c;

    static {
        int i = s1.b0.f11647a;
        f10109d = Integer.toString(1, 36);
        f10110e = Integer.toString(2, 36);
    }

    public y0(int i) {
        s1.d.a("maxStars must be a positive integer", i > 0);
        this.f10111b = i;
        this.f10112c = -1.0f;
    }

    @Override // p1.x0
    public final boolean b() {
        return this.f10112c != -1.0f;
    }

    @Override // p1.x0
    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(x0.f10107a, 2);
        bundle.putInt(f10109d, this.f10111b);
        bundle.putFloat(f10110e, this.f10112c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return this.f10111b == y0Var.f10111b && this.f10112c == y0Var.f10112c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f10111b), Float.valueOf(this.f10112c));
    }

    public y0(int i, float f) {
        boolean z2 = false;
        s1.d.a("maxStars must be a positive integer", i > 0);
        if (f >= 0.0f && f <= i) {
            z2 = true;
        }
        s1.d.a("starRating is out of range [0, maxStars]", z2);
        this.f10111b = i;
        this.f10112c = f;
    }
}
