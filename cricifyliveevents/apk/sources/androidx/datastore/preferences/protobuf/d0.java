package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k0[] f694a;

    @Override // androidx.datastore.preferences.protobuf.k0
    public final t0 a(Class cls) {
        for (k0 k0Var : this.f694a) {
            if (k0Var.b(cls)) {
                return k0Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // androidx.datastore.preferences.protobuf.k0
    public final boolean b(Class cls) {
        for (k0 k0Var : this.f694a) {
            if (k0Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
