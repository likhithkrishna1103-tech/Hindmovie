package androidx.navigation;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f1402b = new s(2, false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f1403c = new s(3, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s f1404d = new s(4, true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final s f1405e = new s(5, false);
    public static final s f = new s(6, true);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final s f1406g = new s(7, false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final s f1407h = new s(8, true);
    public static final s i = new s(9, false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final s f1408j = new s(10, true);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final s f1409k = new s(0, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final s f1410l = new s(1, true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1411a;

    public y(boolean z10) {
        this.f1411a = z10;
    }

    public abstract Object a(String str, Bundle bundle);

    public abstract String b();

    public abstract Object c(String str);

    public abstract void d(Bundle bundle, String str, Object obj);

    public final String toString() {
        return b();
    }
}
