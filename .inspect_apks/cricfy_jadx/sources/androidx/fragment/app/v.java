package androidx.fragment.app;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f1082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f1083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m0 f1084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x5.q f1085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ x5.r f1086e;

    public v(x5.r rVar, u uVar, AtomicReference atomicReference, m0 m0Var, x5.q qVar) {
        this.f1086e = rVar;
        this.f1082a = uVar;
        this.f1083b = atomicReference;
        this.f1084c = m0Var;
        this.f1085d = qVar;
    }

    @Override // androidx.fragment.app.x
    public final void a() {
        StringBuilder sb = new StringBuilder("fragment_");
        x5.r rVar = this.f1086e;
        sb.append(rVar.A);
        sb.append("_rq#");
        sb.append(rVar.o0.getAndIncrement());
        String string = sb.toString();
        x5.r rVar2 = this.f1082a.f1076v;
        c0 c0Var = rVar2.O;
        this.f1083b.set((c0Var != null ? c0Var.A.D : rVar2.J().D).c(string, rVar, this.f1084c, this.f1085d));
    }
}
