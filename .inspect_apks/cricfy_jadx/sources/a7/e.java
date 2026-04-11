package a7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class f315c;

    public e(f fVar) {
        this.f313a = fVar;
    }

    @Override // a7.j
    public final void a() {
        this.f313a.e1(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f314b == eVar.f314b && this.f315c == eVar.f315c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f314b * 31;
        Class cls = this.f315c;
        return i + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "Key{size=" + this.f314b + "array=" + this.f315c + '}';
    }
}
