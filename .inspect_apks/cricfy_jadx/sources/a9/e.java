package a9;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends g {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient g f364x;

    public e(g gVar) {
        this.f364x = gVar;
    }

    @Override // a9.g, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.f364x.contains(obj);
    }

    @Override // a9.g
    public final g f() {
        return this.f364x;
    }

    @Override // a9.g, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final g subList(int i, int i10) {
        g gVar = this.f364x;
        sd.i.K(i, i10, gVar.size());
        return gVar.subList(gVar.size() - i10, gVar.size() - i).f();
    }

    @Override // java.util.List
    public final Object get(int i) {
        g gVar = this.f364x;
        sd.i.J(i, gVar.size());
        return gVar.get((gVar.size() - 1) - i);
    }

    @Override // a9.g, java.util.List
    public final int indexOf(Object obj) {
        int iLastIndexOf = this.f364x.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return (r0.size() - 1) - iLastIndexOf;
        }
        return -1;
    }

    @Override // a9.g, java.util.List
    public final int lastIndexOf(Object obj) {
        int iIndexOf = this.f364x.indexOf(obj);
        if (iIndexOf >= 0) {
            return (r0.size() - 1) - iIndexOf;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f364x.size();
    }
}
