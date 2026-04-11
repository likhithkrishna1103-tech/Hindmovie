package v1;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final String E;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f12633q = new Object();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final g0 f12634r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f12635s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f12636t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f12637u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f12638v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f12639w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f12640x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f12641y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f12642z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f12644b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f12646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12647e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f12648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12649h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a0 f12650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12651k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f12652l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f12653m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12654n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12655o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f12656p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f12643a = f12633q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g0 f12645c = f12634r;

    static {
        c0 c0Var;
        v vVar = new v();
        y yVar = new y();
        List list = Collections.EMPTY_LIST;
        ua.z0 z0Var = ua.z0.f12413z;
        k2.t tVar = new k2.t();
        d0 d0Var = d0.f12622d;
        Uri uri = Uri.EMPTY;
        y1.d.g(yVar.f13038b == null || yVar.f13037a != null);
        z zVar = null;
        if (uri != null) {
            if (yVar.f13037a != null) {
                zVar = new z(yVar);
            }
            c0Var = new c0(uri, null, zVar, null, list, null, z0Var, -9223372036854775807L);
        } else {
            c0Var = null;
        }
        f12634r = new g0("androidx.media3.common.Timeline", new x(vVar), c0Var, new a0(tVar), j0.K, d0Var);
        f12635s = Integer.toString(1, 36);
        f12636t = Integer.toString(2, 36);
        f12637u = Integer.toString(3, 36);
        f12638v = Integer.toString(4, 36);
        f12639w = Integer.toString(5, 36);
        f12640x = Integer.toString(6, 36);
        f12641y = Integer.toString(7, 36);
        f12642z = Integer.toString(8, 36);
        A = Integer.toString(9, 36);
        B = Integer.toString(10, 36);
        C = Integer.toString(11, 36);
        D = Integer.toString(12, 36);
        E = Integer.toString(13, 36);
    }

    public final boolean a() {
        return this.f12650j != null;
    }

    public final void b(Object obj, g0 g0Var, Object obj2, long j4, long j7, long j10, boolean z10, boolean z11, a0 a0Var, long j11, long j12, int i, int i10, long j13) {
        this.f12643a = obj;
        this.f12645c = g0Var != null ? g0Var : f12634r;
        if (g0Var != null) {
            c0 c0Var = g0Var.f12697b;
        }
        this.f12644b = null;
        this.f12646d = obj2;
        this.f12647e = j4;
        this.f = j7;
        this.f12648g = j10;
        this.f12649h = z10;
        this.i = z11;
        this.f12650j = a0Var;
        this.f12652l = j11;
        this.f12653m = j12;
        this.f12654n = i;
        this.f12655o = i10;
        this.f12656p = j13;
        this.f12651k = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e1.class.equals(obj.getClass())) {
            e1 e1Var = (e1) obj;
            if (Objects.equals(this.f12643a, e1Var.f12643a) && Objects.equals(this.f12645c, e1Var.f12645c) && Objects.equals(this.f12646d, e1Var.f12646d) && Objects.equals(this.f12650j, e1Var.f12650j) && this.f12647e == e1Var.f12647e && this.f == e1Var.f && this.f12648g == e1Var.f12648g && this.f12649h == e1Var.f12649h && this.i == e1Var.i && this.f12651k == e1Var.f12651k && this.f12652l == e1Var.f12652l && this.f12653m == e1Var.f12653m && this.f12654n == e1Var.f12654n && this.f12655o == e1Var.f12655o && this.f12656p == e1Var.f12656p) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f12645c.hashCode() + ((this.f12643a.hashCode() + 217) * 31)) * 31;
        Object obj = this.f12646d;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        a0 a0Var = this.f12650j;
        int iHashCode3 = (iHashCode2 + (a0Var != null ? a0Var.hashCode() : 0)) * 31;
        long j4 = this.f12647e;
        int i = (iHashCode3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j7 = this.f;
        int i10 = (i + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j10 = this.f12648g;
        int i11 = (((((((i10 + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (this.f12649h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.f12651k ? 1 : 0)) * 31;
        long j11 = this.f12652l;
        int i12 = (i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f12653m;
        int i13 = (((((i12 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.f12654n) * 31) + this.f12655o) * 31;
        long j13 = this.f12656p;
        return i13 + ((int) (j13 ^ (j13 >>> 32)));
    }
}
