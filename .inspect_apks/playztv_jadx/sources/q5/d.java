package q5;

import e6.j;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f11006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f11007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11009e;

    public d(ArrayList arrayList, char c9, double d10, String str, String str2) {
        this.f11005a = arrayList;
        this.f11006b = c9;
        this.f11007c = d10;
        this.f11008d = str;
        this.f11009e = str2;
    }

    public static int a(char c9, String str, String str2) {
        return str2.hashCode() + j.h(c9 * 31, 31, str);
    }

    public final int hashCode() {
        return a(this.f11006b, this.f11009e, this.f11008d);
    }
}
