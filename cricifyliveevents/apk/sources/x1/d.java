package x1;

import android.os.Bundle;
import android.text.Spanned;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f14270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f14271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f14273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f14274e;

    static {
        int i = a0.f14551a;
        f14270a = Integer.toString(0, 36);
        f14271b = Integer.toString(1, 36);
        f14272c = Integer.toString(2, 36);
        f14273d = Integer.toString(3, 36);
        f14274e = Integer.toString(4, 36);
    }

    public static Bundle a(Spanned spanned, Object obj, int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f14270a, spanned.getSpanStart(obj));
        bundle2.putInt(f14271b, spanned.getSpanEnd(obj));
        bundle2.putInt(f14272c, spanned.getSpanFlags(obj));
        bundle2.putInt(f14273d, i);
        if (bundle != null) {
            bundle2.putBundle(f14274e, bundle);
        }
        return bundle2;
    }
}
