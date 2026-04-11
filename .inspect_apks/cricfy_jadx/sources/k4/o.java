package k4;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7117d;

    static {
        int i = y1.a0.f14551a;
        f7114a = Integer.toString(0, 36);
        f7115b = Integer.toString(1, 36);
        f7116c = Integer.toString(2, 36);
        f7117d = Integer.toString(3, 36);
    }

    public static o a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(f7114a);
        bundle.getBoolean(f7115b, false);
        bundle.getBoolean(f7116c, false);
        bundle.getBoolean(f7117d, false);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        o oVar = new o();
        new Bundle(bundle2);
        return oVar;
    }
}
