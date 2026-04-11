package v1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12973e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12975c;

    static {
        int i = y1.a0.f14551a;
        f12972d = Integer.toString(1, 36);
        f12973e = Integer.toString(2, 36);
    }

    public r() {
        this.f12974b = false;
        this.f12975c = false;
    }

    @Override // v1.x0
    public final boolean b() {
        return this.f12974b;
    }

    @Override // v1.x0
    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(x0.f13036a, 0);
        bundle.putBoolean(f12972d, this.f12974b);
        bundle.putBoolean(f12973e, this.f12975c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f12975c == rVar.f12975c && this.f12974b == rVar.f12974b;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f12974b), Boolean.valueOf(this.f12975c));
    }

    public r(boolean z10) {
        this.f12974b = true;
        this.f12975c = z10;
    }
}
