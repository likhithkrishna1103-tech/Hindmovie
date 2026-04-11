package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 implements u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f763c;

    public n0(c1 c1Var, o oVar, a aVar) {
        this.f762b = c1Var;
        oVar.getClass();
        this.f763c = oVar;
        this.f761a = aVar;
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final void a(Object obj, Object obj2) {
        v0.k(this.f762b, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final void b(Object obj, e0 e0Var) {
        this.f763c.getClass();
        q4.a.u(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final int c(v vVar) {
        this.f762b.getClass();
        return vVar.unknownFields.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final void d(Object obj) {
        this.f762b.getClass();
        b1 b1Var = ((v) obj).unknownFields;
        if (b1Var.f685e) {
            b1Var.f685e = false;
        }
        this.f763c.getClass();
        q4.a.u(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final boolean e(Object obj) {
        this.f763c.getClass();
        q4.a.u(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final boolean f(v vVar, v vVar2) {
        this.f762b.getClass();
        return vVar.unknownFields.equals(vVar2.unknownFields);
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final void g(Object obj, k kVar, n nVar) {
        this.f762b.getClass();
        c1.a(obj);
        this.f763c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final int h(v vVar) {
        this.f762b.getClass();
        b1 b1Var = vVar.unknownFields;
        int i = b1Var.f684d;
        if (i != -1) {
            return i;
        }
        int iE = 0;
        for (int i10 = 0; i10 < b1Var.f681a; i10++) {
            int i11 = b1Var.f682b[i10] >>> 3;
            iE += l.E(3, (g) b1Var.f683c[i10]) + l.H(i11) + l.G(2) + (l.G(1) * 2);
        }
        b1Var.f684d = iE;
        return iE;
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final v i() {
        a aVar = this.f761a;
        return aVar instanceof v ? ((v) aVar).i() : ((t) ((v) aVar).c(5)).b();
    }
}
