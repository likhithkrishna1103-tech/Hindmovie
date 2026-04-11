package h2;

import java.util.HashMap;
import java.util.List;
import k4.a1;
import k4.b0;
import k4.c1;
import k4.d1;
import k4.h1;
import k4.s;
import s2.c0;
import x3.q;
import y1.m;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements m, a1, c1, y1.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5489v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ long f5490w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f5491x;

    public /* synthetic */ c(long j4, Object obj, int i) {
        this.f5491x = obj;
        this.f5489v = i;
        this.f5490w = j4;
    }

    @Override // y1.m
    public void a(Object obj) {
        a aVar = (a) this.f5491x;
        k kVar = (k) obj;
        HashMap map = kVar.f5518h;
        HashMap map2 = kVar.i;
        c0 c0Var = aVar.f5483d;
        if (c0Var != null) {
            String strD = kVar.f5514c.d(aVar.f5481b, c0Var);
            Long l10 = (Long) map2.get(strD);
            Long l11 = (Long) map.get(strD);
            map2.put(strD, Long.valueOf((l10 == null ? 0L : l10.longValue()) + this.f5490w));
            map.put(strD, Long.valueOf((l11 != null ? l11.longValue() : 0L) + ((long) this.f5489v)));
        }
    }

    @Override // y1.h
    public void accept(Object obj) {
        q qVar = (q) this.f5491x;
        x3.c cVar = (x3.c) obj;
        y1.d.h(qVar.f14323h);
        byte[] bArrB = x3.b.b(cVar.f14292a, cVar.f14294c);
        t tVar = qVar.f14319c;
        tVar.getClass();
        tVar.H(bArrB.length, bArrB);
        qVar.f14317a.a(bArrB.length, tVar);
        long j4 = cVar.f14293b;
        long j7 = this.f5490w;
        if (j4 == -9223372036854775807L) {
            y1.d.g(qVar.f14323h.f12951s == Long.MAX_VALUE);
        } else {
            long j10 = qVar.f14323h.f12951s;
            j7 = j10 == Long.MAX_VALUE ? j7 + j4 : j4 + j10;
        }
        qVar.f14317a.e(j7, this.f5489v | 1, bArrB.length, 0, null);
    }

    @Override // k4.a1
    public void h(h1 h1Var, s sVar) {
        d1 d1Var = (d1) this.f5491x;
        h1Var.s(d1Var.N(sVar, h1Var, this.f5489v), this.f5490w);
    }

    @Override // k4.c1
    public Object i(b0 b0Var, s sVar, int i) {
        List list = (List) this.f5491x;
        int i10 = this.f5489v;
        return b0Var.q(sVar, list, i10 == -1 ? b0Var.f6924t.Y() : i10, i10 == -1 ? b0Var.f6924t.V0() : this.f5490w);
    }

    public /* synthetic */ c(a aVar, int i, long j4, long j7) {
        this.f5491x = aVar;
        this.f5489v = i;
        this.f5490w = j4;
    }

    public /* synthetic */ c(q qVar, long j4, int i) {
        this.f5491x = qVar;
        this.f5490w = j4;
        this.f5489v = i;
    }
}
