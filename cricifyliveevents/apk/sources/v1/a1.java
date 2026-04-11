package v1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12577e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12579c;

    static {
        int i = y1.a0.f14551a;
        f12576d = Integer.toString(1, 36);
        f12577e = Integer.toString(2, 36);
    }

    public a1() {
        this.f12578b = false;
        this.f12579c = false;
    }

    @Override // v1.x0
    public final boolean b() {
        return this.f12578b;
    }

    @Override // v1.x0
    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(x0.f13036a, 3);
        bundle.putBoolean(f12576d, this.f12578b);
        bundle.putBoolean(f12577e, this.f12579c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a1)) {
            return false;
        }
        a1 a1Var = (a1) obj;
        return this.f12579c == a1Var.f12579c && this.f12578b == a1Var.f12578b;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f12578b), Boolean.valueOf(this.f12579c));
    }

    public a1(boolean z10) {
        this.f12578b = true;
        this.f12579c = z10;
    }
}
