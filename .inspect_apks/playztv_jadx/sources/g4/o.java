package g4;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5145d;

    static {
        int i = s1.b0.f11647a;
        f5142a = Integer.toString(0, 36);
        f5143b = Integer.toString(1, 36);
        f5144c = Integer.toString(2, 36);
        f5145d = Integer.toString(3, 36);
    }

    public static o a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(f5142a);
        bundle.getBoolean(f5143b, false);
        bundle.getBoolean(f5144c, false);
        bundle.getBoolean(f5145d, false);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        o oVar = new o();
        new Bundle(bundle2);
        return oVar;
    }
}
