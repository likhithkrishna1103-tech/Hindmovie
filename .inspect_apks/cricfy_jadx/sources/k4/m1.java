package k4;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7087e;
    public static final String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f7090c;

    static {
        int i = y1.a0.f14551a;
        f7086d = Integer.toString(0, 36);
        f7087e = Integer.toString(1, 36);
        f = Integer.toString(2, 36);
    }

    public m1(int i) {
        this(i, "no error message provided", Bundle.EMPTY);
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(f7086d, this.f7088a);
        bundle.putString(f7087e, this.f7089b);
        Bundle bundle2 = this.f7090c;
        if (!bundle2.isEmpty()) {
            bundle.putBundle(f, bundle2);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return this.f7088a == m1Var.f7088a && Objects.equals(this.f7089b, m1Var.f7089b);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f7088a), this.f7089b);
    }

    public m1(int i, String str, Bundle bundle) {
        boolean z10 = true;
        if (i >= 0 && i != 1) {
            z10 = false;
        }
        y1.d.b(z10);
        this.f7088a = i;
        this.f7089b = str;
        this.f7090c = bundle;
    }
}
