package aa;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b0 extends m0 {
    @Override // aa.m0
    public final e0 d() {
        throw new AssertionError("should never be called");
    }

    @Override // aa.m0
    /* JADX INFO: renamed from: e */
    public final e0 values() {
        b1 b1Var = ((b1) this).B;
        o0 o0Var = b1Var.f711v;
        if (o0Var != null) {
            return o0Var;
        }
        f1 f1VarC = b1Var.c();
        b1Var.f711v = f1VarC;
        return f1VarC;
    }

    @Override // aa.m0, java.util.Map
    public final Collection values() {
        b1 b1Var = ((b1) this).B;
        o0 o0Var = b1Var.f711v;
        if (o0Var != null) {
            return o0Var;
        }
        f1 f1VarC = b1Var.c();
        b1Var.f711v = f1VarC;
        return f1VarC;
    }
}
