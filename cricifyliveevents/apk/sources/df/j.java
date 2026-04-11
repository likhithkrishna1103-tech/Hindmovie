package df;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements ze.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.a f3710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f3711b;

    public j(ze.a aVar) {
        ge.i.e(aVar, "serializer");
        this.f3710a = aVar;
        this.f3711b = new p(aVar.d());
    }

    @Override // ze.a
    public final Object b(ff.k kVar) {
        ge.i.e(kVar, "decoder");
        if (kVar.l()) {
            return kVar.o(this.f3710a);
        }
        return null;
    }

    @Override // ze.a
    public final void c(ff.l lVar, Object obj) {
        if (obj != null) {
            lVar.i(this.f3710a, obj);
        } else {
            lVar.f();
        }
    }

    @Override // ze.a
    public final bf.d d() {
        return this.f3711b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && j.class == obj.getClass() && ge.i.a(this.f3710a, ((j) obj).f3710a);
    }

    public final int hashCode() {
        return this.f3710a.hashCode();
    }
}
