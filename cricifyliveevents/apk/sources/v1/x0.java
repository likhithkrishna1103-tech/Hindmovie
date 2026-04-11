package v1;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13036a;

    static {
        int i = y1.a0.f14551a;
        f13036a = Integer.toString(0, 36);
    }

    public static x0 a(Bundle bundle) {
        String str = f13036a;
        int i = bundle.getInt(str, -1);
        if (i == 0) {
            String str2 = r.f12972d;
            y1.d.b(bundle.getInt(str, -1) == 0);
            return bundle.getBoolean(r.f12972d, false) ? new r(bundle.getBoolean(r.f12973e, false)) : new r();
        }
        if (i == 1) {
            String str3 = o0.f12907c;
            y1.d.b(bundle.getInt(str, -1) == 1);
            float f = bundle.getFloat(o0.f12907c, -1.0f);
            return f == -1.0f ? new o0() : new o0(f);
        }
        if (i != 2) {
            if (i != 3) {
                throw new IllegalArgumentException(l0.e.g(i, "Unknown RatingType: "));
            }
            String str4 = a1.f12576d;
            y1.d.b(bundle.getInt(str, -1) == 3);
            return bundle.getBoolean(a1.f12576d, false) ? new a1(bundle.getBoolean(a1.f12577e, false)) : new a1();
        }
        String str5 = y0.f13044d;
        y1.d.b(bundle.getInt(str, -1) == 2);
        int i10 = bundle.getInt(y0.f13044d, 5);
        float f10 = bundle.getFloat(y0.f13045e, -1.0f);
        return f10 == -1.0f ? new y0(i10) : new y0(i10, f10);
    }

    public abstract boolean b();

    public abstract Bundle c();
}
