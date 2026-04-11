package ue;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f12943n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12948e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f12949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f12950h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f12951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f12952k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f12953l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f12954m;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        be.h.e(timeUnit, "timeUnit");
        timeUnit.toSeconds(Integer.MAX_VALUE);
    }

    public c(boolean z2, boolean z10, int i, int i10, boolean z11, boolean z12, boolean z13, int i11, int i12, boolean z14, boolean z15, boolean z16, String str) {
        this.f12944a = z2;
        this.f12945b = z10;
        this.f12946c = i;
        this.f12947d = i10;
        this.f12948e = z11;
        this.f = z12;
        this.f12949g = z13;
        this.f12950h = i11;
        this.i = i12;
        this.f12951j = z14;
        this.f12952k = z15;
        this.f12953l = z16;
        this.f12954m = str;
    }

    public final String toString() {
        String str = this.f12954m;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f12944a) {
            sb2.append("no-cache, ");
        }
        if (this.f12945b) {
            sb2.append("no-store, ");
        }
        int i = this.f12946c;
        if (i != -1) {
            sb2.append("max-age=");
            sb2.append(i);
            sb2.append(", ");
        }
        int i10 = this.f12947d;
        if (i10 != -1) {
            sb2.append("s-maxage=");
            sb2.append(i10);
            sb2.append(", ");
        }
        if (this.f12948e) {
            sb2.append("private, ");
        }
        if (this.f) {
            sb2.append("public, ");
        }
        if (this.f12949g) {
            sb2.append("must-revalidate, ");
        }
        int i11 = this.f12950h;
        if (i11 != -1) {
            sb2.append("max-stale=");
            sb2.append(i11);
            sb2.append(", ");
        }
        int i12 = this.i;
        if (i12 != -1) {
            sb2.append("min-fresh=");
            sb2.append(i12);
            sb2.append(", ");
        }
        if (this.f12951j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f12952k) {
            sb2.append("no-transform, ");
        }
        if (this.f12953l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        String string = sb2.toString();
        be.h.d(string, "StringBuilder().apply(builderAction).toString()");
        this.f12954m = string;
        return string;
    }
}
