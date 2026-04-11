package k4;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f6995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f6996h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f6997j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f6998k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f7003e;

    static {
        int i10 = y1.a0.f14551a;
        f = Integer.toString(0, 36);
        f6995g = Integer.toString(1, 36);
        f6996h = Integer.toString(2, 36);
        i = Integer.toString(3, 36);
        f6997j = Integer.toString(4, 36);
        f6998k = Integer.toString(5, 36);
    }

    public g(int i10, int i11, String str, int i12, Bundle bundle, int i13) {
        this.f6999a = i10;
        this.f7000b = i11;
        this.f7001c = str;
        this.f7002d = i12;
        this.f7003e = bundle;
    }

    public static g a(Bundle bundle) {
        int i10 = bundle.getInt(f, 0);
        int i11 = bundle.getInt(f6997j, 0);
        String string = bundle.getString(f6995g);
        string.getClass();
        String str = f6996h;
        y1.d.b(bundle.containsKey(str));
        int i12 = bundle.getInt(str);
        Bundle bundle2 = bundle.getBundle(i);
        int i13 = bundle.getInt(f6998k, 0);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new g(i10, i11, string, i12, bundle2, i13);
    }
}
