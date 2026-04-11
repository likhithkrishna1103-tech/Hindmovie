package p2;

import p1.q;
import s1.b0;
import s1.u;
import w2.g0;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f10133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w2.n f10134c = new w2.n();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f10135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h0 f10136e;
    public long f;

    public d(int i, int i10, q qVar) {
        this.f10132a = i10;
        this.f10133b = qVar;
    }

    @Override // w2.h0
    public final void a(long j5, int i, int i10, int i11, g0 g0Var) {
        long j8 = this.f;
        if (j8 != -9223372036854775807L && j5 >= j8) {
            this.f10136e = this.f10134c;
        }
        h0 h0Var = this.f10136e;
        int i12 = b0.f11647a;
        h0Var.a(j5, i, i10, i11, g0Var);
    }

    @Override // w2.h0
    public final void b(u uVar, int i, int i10) {
        h0 h0Var = this.f10136e;
        int i11 = b0.f11647a;
        h0Var.f(i, uVar);
    }

    @Override // w2.h0
    public final int c(p1.i iVar, int i, boolean z2) {
        return e(iVar, i, z2);
    }

    @Override // w2.h0
    public final void d(q qVar) {
        q qVar2 = this.f10133b;
        if (qVar2 != null) {
            qVar = qVar.d(qVar2);
        }
        this.f10135d = qVar;
        h0 h0Var = this.f10136e;
        int i = b0.f11647a;
        h0Var.d(qVar);
    }

    @Override // w2.h0
    public final int e(p1.i iVar, int i, boolean z2) {
        h0 h0Var = this.f10136e;
        int i10 = b0.f11647a;
        return h0Var.c(iVar, i, z2);
    }

    @Override // w2.h0
    public final /* synthetic */ void f(int i, u uVar) {
        e6.j.b(this, uVar, i);
    }
}
