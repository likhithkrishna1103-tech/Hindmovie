package p1;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e1 {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final String E;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f9703q = new Object();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final g0 f9704r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f9705s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f9706t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f9707u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f9708v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f9709w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f9710x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f9711y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f9712z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9714b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f9716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9717e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f9718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9719h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b0 f9720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f9721k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f9722l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f9723m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9724n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9725o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f9726p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f9713a = f9703q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g0 f9715c = f9704r;

    static {
        c0 c0Var;
        w wVar = new w();
        z zVar = new z();
        List list = Collections.EMPTY_LIST;
        aa.c1 c1Var = aa.c1.f650y;
        e2.t tVar = new e2.t();
        d0 d0Var = d0.f9694d;
        Uri uri = Uri.EMPTY;
        s1.d.g(zVar.f10114b == null || zVar.f10113a != null);
        a0 a0Var = null;
        if (uri != null) {
            if (zVar.f10113a != null) {
                a0Var = new a0(zVar);
            }
            c0Var = new c0(uri, null, a0Var, null, list, null, c1Var, -9223372036854775807L);
        } else {
            c0Var = null;
        }
        f9704r = new g0("androidx.media3.common.Timeline", new y(wVar), c0Var, new b0(tVar), j0.K, d0Var);
        f9705s = Integer.toString(1, 36);
        f9706t = Integer.toString(2, 36);
        f9707u = Integer.toString(3, 36);
        f9708v = Integer.toString(4, 36);
        f9709w = Integer.toString(5, 36);
        f9710x = Integer.toString(6, 36);
        f9711y = Integer.toString(7, 36);
        f9712z = Integer.toString(8, 36);
        A = Integer.toString(9, 36);
        B = Integer.toString(10, 36);
        C = Integer.toString(11, 36);
        D = Integer.toString(12, 36);
        E = Integer.toString(13, 36);
    }

    public final boolean a() {
        return this.f9720j != null;
    }

    public final void b(Object obj, g0 g0Var, Object obj2, long j5, long j8, long j10, boolean z2, boolean z10, b0 b0Var, long j11, long j12, int i, int i10, long j13) {
        this.f9713a = obj;
        this.f9715c = g0Var != null ? g0Var : f9704r;
        if (g0Var != null) {
            c0 c0Var = g0Var.f9757b;
        }
        this.f9714b = null;
        this.f9716d = obj2;
        this.f9717e = j5;
        this.f = j8;
        this.f9718g = j10;
        this.f9719h = z2;
        this.i = z10;
        this.f9720j = b0Var;
        this.f9722l = j11;
        this.f9723m = j12;
        this.f9724n = i;
        this.f9725o = i10;
        this.f9726p = j13;
        this.f9721k = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e1.class.equals(obj.getClass())) {
            e1 e1Var = (e1) obj;
            if (Objects.equals(this.f9713a, e1Var.f9713a) && Objects.equals(this.f9715c, e1Var.f9715c) && Objects.equals(this.f9716d, e1Var.f9716d) && Objects.equals(this.f9720j, e1Var.f9720j) && this.f9717e == e1Var.f9717e && this.f == e1Var.f && this.f9718g == e1Var.f9718g && this.f9719h == e1Var.f9719h && this.i == e1Var.i && this.f9721k == e1Var.f9721k && this.f9722l == e1Var.f9722l && this.f9723m == e1Var.f9723m && this.f9724n == e1Var.f9724n && this.f9725o == e1Var.f9725o && this.f9726p == e1Var.f9726p) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f9715c.hashCode() + ((this.f9713a.hashCode() + 217) * 31)) * 31;
        Object obj = this.f9716d;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        b0 b0Var = this.f9720j;
        int iHashCode3 = (iHashCode2 + (b0Var != null ? b0Var.hashCode() : 0)) * 31;
        long j5 = this.f9717e;
        int i = (iHashCode3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j8 = this.f;
        int i10 = (i + ((int) (j8 ^ (j8 >>> 32)))) * 31;
        long j10 = this.f9718g;
        int i11 = (((((((i10 + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (this.f9719h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.f9721k ? 1 : 0)) * 31;
        long j11 = this.f9722l;
        int i12 = (i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f9723m;
        int i13 = (((((i12 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.f9724n) * 31) + this.f9725o) * 31;
        long j13 = this.f9726p;
        return i13 + ((int) (j13 ^ (j13 >>> 32)));
    }
}
