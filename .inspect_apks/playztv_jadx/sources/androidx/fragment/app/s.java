package androidx.fragment.app;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f1350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f1351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j0 f1352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ nc.t f1353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ nc.u f1354e;

    public s(nc.u uVar, r rVar, AtomicReference atomicReference, j0 j0Var, nc.t tVar) {
        this.f1354e = uVar;
        this.f1350a = rVar;
        this.f1351b = atomicReference;
        this.f1352c = j0Var;
        this.f1353d = tVar;
    }

    @Override // androidx.fragment.app.u
    public final void a() {
        StringBuilder sb2 = new StringBuilder("fragment_");
        nc.u uVar = this.f1354e;
        sb2.append(uVar.f1398z);
        sb2.append("_rq#");
        sb2.append(uVar.f1390n0.getAndIncrement());
        String string = sb2.toString();
        nc.u uVar2 = this.f1350a.f1349a;
        z zVar = uVar2.N;
        this.f1351b.set((zVar != null ? zVar.f1426y.C : uVar2.G().C).c(string, uVar, this.f1352c, this.f1353d));
    }
}
