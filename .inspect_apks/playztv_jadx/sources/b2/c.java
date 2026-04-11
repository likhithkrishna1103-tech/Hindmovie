package b2;

import g4.b0;
import g4.c1;
import g4.e1;
import g4.f1;
import g4.j1;
import g4.s;
import java.util.HashMap;
import java.util.List;
import k8.a0;
import o2.d0;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements s1.m, c1, e1, s1.h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f1730u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ long f1731v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f1732w;

    public /* synthetic */ c(int i, long j5, Object obj) {
        this.f1732w = obj;
        this.f1730u = i;
        this.f1731v = j5;
    }

    @Override // s1.m
    public void a(Object obj) {
        a aVar = (a) this.f1732w;
        n nVar = (n) obj;
        HashMap map = nVar.f1769h;
        HashMap map2 = nVar.i;
        d0 d0Var = aVar.f1722d;
        if (d0Var != null) {
            String strD = nVar.f1765c.d(aVar.f1720b, d0Var);
            Long l10 = (Long) map2.get(strD);
            Long l11 = (Long) map.get(strD);
            map2.put(strD, Long.valueOf((l10 == null ? 0L : l10.longValue()) + this.f1731v));
            map.put(strD, Long.valueOf((l11 != null ? l11.longValue() : 0L) + ((long) this.f1730u)));
        }
    }

    @Override // s1.h
    public void accept(Object obj) {
        t3.n nVar = (t3.n) this.f1732w;
        t3.a aVar = (t3.a) obj;
        s1.d.h(nVar.f12102h);
        byte[] bArrH = a0.h(aVar.f12071a, aVar.f12073c);
        u uVar = nVar.f12098c;
        uVar.getClass();
        uVar.H(bArrH.length, bArrH);
        nVar.f12096a.f(bArrH.length, uVar);
        long j5 = aVar.f12072b;
        long j8 = this.f1731v;
        if (j5 == -9223372036854775807L) {
            s1.d.g(nVar.f12102h.f10028s == Long.MAX_VALUE);
        } else {
            long j10 = nVar.f12102h.f10028s;
            j8 = j10 == Long.MAX_VALUE ? j8 + j5 : j5 + j10;
        }
        nVar.f12096a.a(j8, this.f1730u | 1, bArrH.length, 0, null);
    }

    @Override // g4.e1
    public Object g(b0 b0Var, s sVar, int i) {
        List list = (List) this.f1732w;
        int i10 = this.f1730u;
        return b0Var.q(sVar, list, i10 == -1 ? b0Var.f4973t.d0() : i10, i10 == -1 ? b0Var.f4973t.T0() : this.f1731v);
    }

    @Override // g4.c1
    public void j(j1 j1Var, s sVar) {
        f1 f1Var = (f1) this.f1732w;
        j1Var.u(f1Var.H(sVar, j1Var, this.f1730u), this.f1731v);
    }

    public /* synthetic */ c(a aVar, int i, long j5, long j8) {
        this.f1732w = aVar;
        this.f1730u = i;
        this.f1731v = j5;
    }

    public /* synthetic */ c(t3.n nVar, long j5, int i) {
        this.f1732w = nVar;
        this.f1731v = j5;
        this.f1730u = i;
    }
}
