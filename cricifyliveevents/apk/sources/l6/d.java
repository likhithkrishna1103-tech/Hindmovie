package l6;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f7853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f7854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f7856e;

    public d(ArrayList arrayList, char c9, double d10, String str, String str2) {
        this.f7852a = arrayList;
        this.f7853b = c9;
        this.f7854c = d10;
        this.f7855d = str;
        this.f7856e = str2;
    }

    public static int a(char c9, String str, String str2) {
        return str2.hashCode() + l0.e.e(c9 * 31, 31, str);
    }

    public final int hashCode() {
        return a(this.f7853b, this.f7856e, this.f7855d);
    }
}
