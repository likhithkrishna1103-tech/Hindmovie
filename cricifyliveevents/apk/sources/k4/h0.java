package k4;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h0 implements k0, j9.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ boolean f7035v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f7036w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f7037x;

    public /* synthetic */ h0(Object obj, Object obj2, boolean z10) {
        this.f7036w = obj;
        this.f7037x = obj2;
        this.f7035v = z10;
    }

    @Override // j9.a
    public Object c(j9.p pVar) {
        return (s8.b.d() && ((Integer) pVar.h()).intValue() == 402) ? nc.h.a((Context) this.f7036w, (Intent) this.f7037x, this.f7035v).e(new p.a(1), new r0(28)) : pVar;
    }

    @Override // k4.k0
    public void d(s sVar) {
        l0 l0Var = (l0) this.f7036w;
        ya.c0 c0VarQ = l0Var.f7060g.q(sVar, ua.i0.o((v1.g0) this.f7037x), -1, -9223372036854775807L);
        c0VarQ.h(new ya.s(0, c0VarQ, new com.bumptech.glide.manager.u(l0Var, sVar, this.f7035v)), ya.q.f15009v);
    }
}
