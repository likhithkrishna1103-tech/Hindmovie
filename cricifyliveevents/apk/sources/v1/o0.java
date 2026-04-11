package v1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 extends x0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12907c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f12908b;

    static {
        int i = y1.a0.f14551a;
        f12907c = Integer.toString(1, 36);
    }

    public o0() {
        this.f12908b = -1.0f;
    }

    @Override // v1.x0
    public final boolean b() {
        return this.f12908b != -1.0f;
    }

    @Override // v1.x0
    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(x0.f13036a, 1);
        bundle.putFloat(f12907c, this.f12908b);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o0) {
            return this.f12908b == ((o0) obj).f12908b;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Float.valueOf(this.f12908b));
    }

    public o0(float f) {
        y1.d.a("percent must be in the range of [0, 100]", f >= 0.0f && f <= 100.0f);
        this.f12908b = f;
    }
}
