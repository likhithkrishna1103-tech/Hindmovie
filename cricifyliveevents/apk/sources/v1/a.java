package v1;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12551h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f12552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12553k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12554l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f12555m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f12556n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f12557o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f12558p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f12559q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f12560r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri[] f12563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g0[] f12564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f12565e;
    public final long[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f12566g;

    static {
        int i10 = y1.a0.f14551a;
        f12551h = Integer.toString(0, 36);
        i = Integer.toString(1, 36);
        f12552j = Integer.toString(2, 36);
        f12553k = Integer.toString(3, 36);
        f12554l = Integer.toString(4, 36);
        f12555m = Integer.toString(5, 36);
        f12556n = Integer.toString(6, 36);
        f12557o = Integer.toString(7, 36);
        f12558p = Integer.toString(8, 36);
        f12559q = Integer.toString(9, 36);
        f12560r = Integer.toString(10, 36);
    }

    public a(int i10, int i11, int[] iArr, g0[] g0VarArr, long[] jArr, String[] strArr) {
        Uri uri;
        int i12 = 0;
        y1.d.b(iArr.length == g0VarArr.length);
        this.f12561a = i10;
        this.f12562b = i11;
        this.f12565e = iArr;
        this.f12564d = g0VarArr;
        this.f = jArr;
        this.f12563c = new Uri[g0VarArr.length];
        while (true) {
            Uri[] uriArr = this.f12563c;
            if (i12 >= uriArr.length) {
                this.f12566g = strArr;
                return;
            }
            g0 g0Var = g0VarArr[i12];
            if (g0Var == null) {
                uri = null;
            } else {
                c0 c0Var = g0Var.f12697b;
                c0Var.getClass();
                uri = c0Var.f12605a;
            }
            uriArr[i12] = uri;
            i12++;
        }
    }

    public final int a(int i10) {
        int i11;
        int i12 = i10 + 1;
        while (true) {
            int[] iArr = this.f12565e;
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
        return this.f12561a == aVar.f12561a && this.f12562b == aVar.f12562b && Arrays.equals(this.f12564d, aVar.f12564d) && Arrays.equals(this.f12565e, aVar.f12565e) && Arrays.equals(this.f, aVar.f) && Arrays.equals(this.f12566g, aVar.f12566g);
    }

    public final int hashCode() {
        int i10 = ((this.f12561a * 31) + this.f12562b) * 31;
        int i11 = (int) 0;
        return (((((Arrays.hashCode(this.f) + ((Arrays.hashCode(this.f12565e) + ((Arrays.hashCode(this.f12564d) + ((i10 + i11) * 31)) * 31)) * 31)) * 31) + i11) * 961) + Arrays.hashCode(this.f12566g)) * 31;
    }
}
