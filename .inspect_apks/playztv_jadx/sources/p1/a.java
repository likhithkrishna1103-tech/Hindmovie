package p1;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9610h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9613l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f9614m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9615n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f9616o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f9617p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f9618q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f9619r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri[] f9622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g0[] f9623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f9624e;
    public final long[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f9625g;

    static {
        int i10 = s1.b0.f11647a;
        f9610h = Integer.toString(0, 36);
        i = Integer.toString(1, 36);
        f9611j = Integer.toString(2, 36);
        f9612k = Integer.toString(3, 36);
        f9613l = Integer.toString(4, 36);
        f9614m = Integer.toString(5, 36);
        f9615n = Integer.toString(6, 36);
        f9616o = Integer.toString(7, 36);
        f9617p = Integer.toString(8, 36);
        f9618q = Integer.toString(9, 36);
        f9619r = Integer.toString(10, 36);
    }

    public a(int i10, int i11, int[] iArr, g0[] g0VarArr, long[] jArr, String[] strArr) {
        Uri uri;
        int i12 = 0;
        s1.d.b(iArr.length == g0VarArr.length);
        this.f9620a = i10;
        this.f9621b = i11;
        this.f9624e = iArr;
        this.f9623d = g0VarArr;
        this.f = jArr;
        this.f9622c = new Uri[g0VarArr.length];
        while (true) {
            Uri[] uriArr = this.f9622c;
            if (i12 >= uriArr.length) {
                this.f9625g = strArr;
                return;
            }
            g0 g0Var = g0VarArr[i12];
            if (g0Var == null) {
                uri = null;
            } else {
                c0 c0Var = g0Var.f9757b;
                c0Var.getClass();
                uri = c0Var.f9665a;
            }
            uriArr[i12] = uri;
            i12++;
        }
    }

    public final int a(int i10) {
        int i11;
        int i12 = i10 + 1;
        while (true) {
            int[] iArr = this.f9624e;
            if (i12 >= iArr.length || (i11 = iArr[i12]) == 0 || i11 == 1) {
                break;
            }
            i12++;
        }
        return i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f9620a == aVar.f9620a && this.f9621b == aVar.f9621b && Arrays.equals(this.f9623d, aVar.f9623d) && Arrays.equals(this.f9624e, aVar.f9624e) && Arrays.equals(this.f, aVar.f) && Arrays.equals(this.f9625g, aVar.f9625g);
    }

    public final int hashCode() {
        int i10 = ((this.f9620a * 31) + this.f9621b) * 31;
        int i11 = (int) 0;
        return (((((Arrays.hashCode(this.f) + ((Arrays.hashCode(this.f9624e) + ((Arrays.hashCode(this.f9623d) + ((i10 + i11) * 31)) * 31)) * 31)) * 31) + i11) * 961) + Arrays.hashCode(this.f9625g)) * 31;
    }
}
