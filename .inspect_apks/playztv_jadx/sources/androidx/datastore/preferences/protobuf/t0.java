package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 implements b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k1 f1135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f1136c;

    public t0(k1 k1Var, o oVar, a aVar) {
        this.f1135b = k1Var;
        oVar.getClass();
        this.f1136c = oVar;
        this.f1134a = aVar;
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final void a(Object obj, k0 k0Var) {
        this.f1136c.getClass();
        l4.a.t(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final int b(w wVar) {
        this.f1135b.getClass();
        return wVar.unknownFields.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final void c(Object obj) {
        this.f1135b.getClass();
        ((w) obj).unknownFields.f1075e = false;
        this.f1136c.getClass();
        l4.a.t(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final int d(a aVar) {
        this.f1135b.getClass();
        j1 j1Var = ((w) aVar).unknownFields;
        int i = j1Var.f1074d;
        if (i != -1) {
            return i;
        }
        int iR = 0;
        for (int i10 = 0; i10 < j1Var.f1071a; i10++) {
            int i11 = j1Var.f1072b[i10] >>> 3;
            iR += k.r(3, (g) j1Var.f1073c[i10]) + k.z(i11) + k.y(2) + (k.y(1) * 2);
        }
        j1Var.f1074d = iR;
        return iR;
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final boolean e(Object obj) {
        this.f1136c.getClass();
        l4.a.t(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final boolean f(w wVar, w wVar2) {
        this.f1135b.getClass();
        return wVar.unknownFields.equals(wVar2.unknownFields);
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final void g(Object obj, i iVar, n nVar) {
        this.f1135b.getClass();
        w wVar = (w) obj;
        if (wVar.unknownFields == j1.f) {
            wVar.unknownFields = j1.b();
        }
        this.f1136c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final void h(w wVar, w wVar2) {
        c1.w(this.f1135b, wVar, wVar2);
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final Object i() {
        return ((u) ((w) this.f1134a).d(5)).b();
    }
}
