package c3;

import a3.p;
import a3.q;
import a3.r;
import com.bumptech.glide.l;
import java.util.List;
import ua.g0;
import ua.i0;
import ua.z0;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f2056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a3.d f2057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x3.e f2059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2060e;
    public r f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f2061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2062h;
    public e[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f2063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f2064k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2065l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f2066m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f2067n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2068o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2069p;

    public b(int i, x3.e eVar) {
        this.f2059d = eVar;
        this.f2058c = (i & 1) == 0;
        this.f2056a = new t(12);
        this.f2057b = new a3.d();
        this.f = new ka.f(1);
        this.i = new e[0];
        this.f2066m = -1L;
        this.f2067n = -1L;
        this.f2065l = -1;
        this.f2062h = -9223372036854775807L;
    }

    @Override // a3.p
    public final void c(r rVar) {
        this.f2060e = 0;
        if (this.f2058c) {
            rVar = new l(rVar, this.f2059d);
        }
        this.f = rVar;
        this.f2063j = -1L;
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        this.f2063j = -1L;
        this.f2064k = null;
        for (e eVar : this.i) {
            if (eVar.f2086k == 0) {
                eVar.i = 0;
            } else {
                eVar.i = eVar.f2089n[a0.e(eVar.f2088m, j4, true)];
            }
        }
        if (j4 != 0) {
            this.f2060e = 6;
        } else if (this.i.length == 0) {
            this.f2060e = 0;
        } else {
            this.f2060e = 3;
        }
    }

    @Override // a3.p
    public final List f() {
        g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(q qVar) {
        t tVar = this.f2056a;
        qVar.z(tVar.f14609a, 0, 12);
        tVar.J(0);
        if (tVar.l() == 1179011410) {
            tVar.K(4);
            if (tVar.l() == 541677121) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010d  */
    @Override // a3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(a3.q r24, a3.t r25) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 1102
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.b.i(a3.q, a3.t):int");
    }

    @Override // a3.p
    public final p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
