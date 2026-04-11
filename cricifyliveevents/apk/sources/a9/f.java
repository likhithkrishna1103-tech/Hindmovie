package a9;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends g {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient int f365x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient int f366y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ g f367z;

    public f(g gVar, int i, int i10) {
        this.f367z = gVar;
        this.f365x = i;
        this.f366y = i10;
    }

    @Override // a9.c
    public final Object[] a() {
        return this.f367z.a();
    }

    @Override // a9.c
    public final int b() {
        return this.f367z.b() + this.f365x;
    }

    @Override // a9.c
    public final int c() {
        return this.f367z.b() + this.f365x + this.f366y;
    }

    @Override // a9.g, java.util.List
    /* JADX INFO: renamed from: g */
    public final g subList(int i, int i10) {
        sd.i.K(i, i10, this.f366y);
        int i11 = this.f365x;
        return this.f367z.subList(i + i11, i10 + i11);
    }

    @Override // java.util.List
    public final Object get(int i) {
        sd.i.J(i, this.f366y);
        return this.f367z.get(i + this.f365x);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f366y;
    }
}
