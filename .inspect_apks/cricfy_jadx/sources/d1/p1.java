package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p1 implements vd.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p1 f3291v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h0 f3292w;

    public p1(p1 p1Var, h0 h0Var) {
        this.f3291v = p1Var;
        this.f3292w = h0Var;
    }

    @Override // vd.h
    public final vd.f C(vd.g gVar) {
        return w8.e.h(this, gVar);
    }

    @Override // vd.h
    public final Object J(Object obj, fe.p pVar) {
        return pVar.j(obj, this);
    }

    @Override // vd.h
    public final vd.h O(vd.g gVar) {
        return w8.e.i(this, gVar);
    }

    public final void b(h0 h0Var) {
        if (this.f3292w == h0Var) {
            throw new IllegalStateException("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
        }
        p1 p1Var = this.f3291v;
        if (p1Var != null) {
            p1Var.b(h0Var);
        }
    }

    @Override // vd.f
    public final vd.g getKey() {
        return o1.f3287v;
    }

    @Override // vd.h
    public final vd.h q(vd.h hVar) {
        return w8.e.k(this, hVar);
    }
}
