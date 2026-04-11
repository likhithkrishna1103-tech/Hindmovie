package r1;

import android.os.Bundle;
import android.text.Spanned;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f11276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f11277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f11278e;

    static {
        int i = b0.f11647a;
        f11274a = Integer.toString(0, 36);
        f11275b = Integer.toString(1, 36);
        f11276c = Integer.toString(2, 36);
        f11277d = Integer.toString(3, 36);
        f11278e = Integer.toString(4, 36);
    }

    public static Bundle a(Spanned spanned, Object obj, int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f11274a, spanned.getSpanStart(obj));
        bundle2.putInt(f11275b, spanned.getSpanEnd(obj));
        bundle2.putInt(f11276c, spanned.getSpanFlags(obj));
        bundle2.putInt(f11277d, i);
        if (bundle != null) {
            bundle2.putBundle(f11278e, bundle);
        }
        return bundle2;
    }
}
