package androidx.navigation;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f1377a;

    public o(b0 b0Var) {
        this.f1377a = b0Var;
    }

    @Override // androidx.navigation.a0
    public final l a() {
        return new n(this);
    }

    @Override // androidx.navigation.a0
    public final l b(l lVar, Bundle bundle, r rVar) {
        String str;
        n nVar = (n) lVar;
        int i = nVar.E;
        if (i != 0) {
            l lVarG = nVar.g(i, false);
            if (lVarG != null) {
                return this.f1377a.c(lVarG.f1369v).b(lVarG, lVarG.a(bundle), rVar);
            }
            if (nVar.F == null) {
                nVar.F = Integer.toString(nVar.E);
            }
            throw new IllegalArgumentException(l0.e.k("navigation destination ", nVar.F, " is not a direct child of this NavGraph"));
        }
        StringBuilder sb = new StringBuilder("no start destination defined via app:startDestination for ");
        int i10 = nVar.f1371x;
        if (i10 != 0) {
            if (nVar.f1372y == null) {
                nVar.f1372y = Integer.toString(i10);
            }
            str = nVar.f1372y;
        } else {
            str = "the root navigation";
        }
        sb.append(str);
        throw new IllegalStateException(sb.toString());
    }

    @Override // androidx.navigation.a0
    public final boolean e() {
        return true;
    }
}
