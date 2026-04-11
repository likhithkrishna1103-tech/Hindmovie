package p1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o0 extends x0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9954c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f9955b;

    static {
        int i = s1.b0.f11647a;
        f9954c = Integer.toString(1, 36);
    }

    public o0() {
        this.f9955b = -1.0f;
    }

    @Override // p1.x0
    public final boolean b() {
        return this.f9955b != -1.0f;
    }

    @Override // p1.x0
    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(x0.f10107a, 1);
        bundle.putFloat(f9954c, this.f9955b);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o0) {
            return this.f9955b == ((o0) obj).f9955b;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Float.valueOf(this.f9955b));
    }

    public o0(float f) {
        s1.d.a("percent must be in the range of [0, 100]", f >= 0.0f && f <= 100.0f);
        this.f9955b = f;
    }
}
