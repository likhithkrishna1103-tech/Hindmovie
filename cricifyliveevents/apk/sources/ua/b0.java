package ua;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b0 extends k0 {
    @Override // ua.k0
    public final d0 d() {
        throw new AssertionError("should never be called");
    }

    @Override // ua.k0
    /* JADX INFO: renamed from: e */
    public final d0 values() {
        y0 y0Var = ((y0) this).C;
        m0 m0Var = y0Var.f12350w;
        if (m0Var != null) {
            return m0Var;
        }
        c1 c1VarC = y0Var.c();
        y0Var.f12350w = c1VarC;
        return c1VarC;
    }

    @Override // ua.k0, java.util.Map
    public final Collection values() {
        y0 y0Var = ((y0) this).C;
        m0 m0Var = y0Var.f12350w;
        if (m0Var != null) {
            return m0Var;
        }
        c1 c1VarC = y0Var.c();
        y0Var.f12350w = c1VarC;
        return c1VarC;
    }
}
