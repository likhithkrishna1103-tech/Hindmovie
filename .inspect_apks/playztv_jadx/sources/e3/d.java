package e3;

import w2.a0;
import w2.b0;
import w2.c0;
import w2.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0 f4384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ af.a f4385c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(af.a aVar, b0 b0Var, b0 b0Var2) {
        super(b0Var);
        this.f4385c = aVar;
        this.f4384b = b0Var2;
    }

    @Override // w2.v, w2.b0
    public final a0 i(long j5) {
        a0 a0VarI = this.f4384b.i(j5);
        c0 c0Var = a0VarI.f13569a;
        long j8 = c0Var.f13601a;
        long j10 = c0Var.f13602b;
        long j11 = this.f4385c.f796v;
        c0 c0Var2 = new c0(j8, j10 + j11);
        c0 c0Var3 = a0VarI.f13570b;
        return new a0(c0Var2, new c0(c0Var3.f13601a, c0Var3.f13602b + j11));
    }
}
