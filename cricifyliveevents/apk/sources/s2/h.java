package s2;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends m1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f11208l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f11209m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f11210n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f11211o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f11212p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f11213q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList f11214r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final v1.e1 f11215s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public f f11216t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public g f11217u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f11218v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f11219w;

    public h(e eVar) {
        super(eVar.f11169a);
        this.f11208l = eVar.f11170b;
        this.f11209m = eVar.f11171c;
        this.f11210n = eVar.f11172d;
        this.f11211o = eVar.f11173e;
        this.f11212p = eVar.f;
        this.f11213q = eVar.f11174g;
        this.f11214r = new ArrayList();
        this.f11215s = new v1.e1();
    }

    @Override // s2.m1
    public final void A(v1.f1 f1Var) {
        if (this.f11217u != null) {
            return;
        }
        D(f1Var);
    }

    public final void D(v1.f1 f1Var) {
        long j4;
        long j7;
        long j10;
        v1.e1 e1Var = this.f11215s;
        f1Var.n(0, e1Var);
        long j11 = e1Var.f12656p;
        f fVar = this.f11216t;
        long j12 = this.f11209m;
        ArrayList arrayList = this.f11214r;
        if (fVar == null || arrayList.isEmpty() || this.f11211o) {
            boolean z10 = this.f11212p;
            j4 = this.f11208l;
            if (z10) {
                long j13 = e1Var.f12652l;
                j4 += j13;
                j7 = j13 + j12;
            } else {
                j7 = j12;
            }
            this.f11218v = j11 + j4;
            this.f11219w = j12 != Long.MIN_VALUE ? j11 + j7 : Long.MIN_VALUE;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) arrayList.get(i);
                long j14 = this.f11218v;
                long j15 = this.f11219w;
                dVar.f11165z = j14;
                dVar.A = j15;
            }
            j10 = j7;
        } else {
            j4 = this.f11218v - j11;
            j10 = j12 != Long.MIN_VALUE ? this.f11219w - j11 : Long.MIN_VALUE;
        }
        try {
            f fVar2 = new f(f1Var, j4, j10, this.f11213q);
            this.f11216t = fVar2;
            n(fVar2);
        } catch (g e9) {
            this.f11217u = e9;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                ((d) arrayList.get(i10)).B = this.f11217u;
            }
        }
    }

    @Override // s2.a
    public final boolean a(v1.g0 g0Var) {
        a aVar = this.f11276k;
        return aVar.i().f12700e.equals(g0Var.f12700e) && aVar.a(g0Var);
    }

    @Override // s2.a
    public final a0 c(c0 c0Var, w2.e eVar, long j4) {
        d dVar = new d(this.f11276k.c(c0Var, eVar, j4), this.f11210n, this.f11218v, this.f11219w);
        this.f11214r.add(dVar);
        return dVar;
    }

    @Override // s2.l, s2.a
    public final void k() throws g {
        g gVar = this.f11217u;
        if (gVar != null) {
            throw gVar;
        }
        super.k();
    }

    @Override // s2.a
    public final void o(a0 a0Var) {
        ArrayList arrayList = this.f11214r;
        y1.d.g(arrayList.remove(a0Var));
        this.f11276k.o(((d) a0Var).f11161v);
        if (!arrayList.isEmpty() || this.f11211o) {
            return;
        }
        f fVar = this.f11216t;
        fVar.getClass();
        D(fVar.f11299e);
    }

    @Override // s2.l, s2.a
    public final void q() {
        super.q();
        this.f11217u = null;
        this.f11216t = null;
    }
}
