package y2;

import aa.c1;
import aa.h0;
import aa.j0;
import java.util.List;
import k8.b0;
import s1.u;
import w2.o;
import w2.p;
import w2.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f14478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b8.d f14479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f14481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14482e;
    public q f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f14483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14484h;
    public e[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f14485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f14486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f14488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f14489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f14491p;

    public b(int i, b0 b0Var) {
        this.f14481d = b0Var;
        this.f14480c = (i & 1) == 0;
        this.f14478a = new u(12);
        this.f14479b = new b8.d();
        this.f = new v8.c();
        this.i = new e[0];
        this.f14488m = -1L;
        this.f14489n = -1L;
        this.f14487l = -1;
        this.f14484h = -9223372036854775807L;
    }

    @Override // w2.o
    public final void c(q qVar) {
        this.f14482e = 0;
        if (this.f14480c) {
            qVar = new a2.c(qVar, this.f14481d);
        }
        this.f = qVar;
        this.f14485j = -1L;
    }

    @Override // w2.o
    public final boolean e(p pVar) {
        u uVar = this.f14478a;
        pVar.w(uVar.f11709a, 0, 12);
        uVar.J(0);
        if (uVar.l() == 1179011410) {
            uVar.K(4);
            if (uVar.l() == 541677121) {
                return true;
            }
        }
        return false;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        this.f14485j = -1L;
        this.f14486k = null;
        for (e eVar : this.i) {
            if (eVar.f14508k == 0) {
                eVar.i = 0;
            } else {
                eVar.i = eVar.f14511n[s1.b0.e(eVar.f14510m, j5, true)];
            }
        }
        if (j5 != 0) {
            this.f14482e = 6;
        } else if (this.i.length == 0) {
            this.f14482e = 0;
        } else {
            this.f14482e = 3;
        }
    }

    @Override // w2.o
    public final List g() {
        h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010d  */
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(w2.p r24, w2.s r25) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 1102
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.b.l(w2.p, w2.s):int");
    }

    @Override // w2.o
    public final o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
