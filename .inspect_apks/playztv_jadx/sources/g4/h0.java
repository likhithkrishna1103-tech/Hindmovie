package g4;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h0 implements l0, o8.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ boolean f5046u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f5047v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f5048w;

    public /* synthetic */ h0(Object obj, Object obj2, boolean z2) {
        this.f5047v = obj;
        this.f5048w = obj2;
        this.f5046u = z2;
    }

    @Override // o8.a
    public Object b(o8.o oVar) {
        return (x7.b.d() && ((Integer) oVar.h()).intValue() == 402) ? ub.i.a((Context) this.f5047v, (Intent) this.f5048w, this.f5046u).e(new n4.b(0), new r2.h(5)) : oVar;
    }

    @Override // g4.l0
    public void d(s sVar) {
        m0 m0Var = (m0) this.f5047v;
        ea.e0 e0VarQ = m0Var.f5115g.q(sVar, aa.j0.v((p1.g0) this.f5048w), -1, -9223372036854775807L);
        e0VarQ.f(new ea.t(e0VarQ, 0, new com.bumptech.glide.manager.s(m0Var, sVar, this.f5046u)), ea.r.f4628u);
    }
}
