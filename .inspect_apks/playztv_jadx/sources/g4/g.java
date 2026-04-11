package g4;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5010h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f5011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f5012k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f5017e;

    static {
        int i10 = s1.b0.f11647a;
        f = Integer.toString(0, 36);
        f5009g = Integer.toString(1, 36);
        f5010h = Integer.toString(2, 36);
        i = Integer.toString(3, 36);
        f5011j = Integer.toString(4, 36);
        f5012k = Integer.toString(5, 36);
    }

    public g(int i10, int i11, String str, int i12, Bundle bundle, int i13) {
        this.f5013a = i10;
        this.f5014b = i11;
        this.f5015c = str;
        this.f5016d = i12;
        this.f5017e = bundle;
    }

    public static g a(Bundle bundle) {
        int i10 = bundle.getInt(f, 0);
        int i11 = bundle.getInt(f5011j, 0);
        String string = bundle.getString(f5009g);
        string.getClass();
        String str = f5010h;
        s1.d.b(bundle.containsKey(str));
        int i12 = bundle.getInt(str);
        Bundle bundle2 = bundle.getBundle(i);
        int i13 = bundle.getInt(f5012k, 0);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new g(i10, i11, string, i12, bundle2, i13);
    }
}
