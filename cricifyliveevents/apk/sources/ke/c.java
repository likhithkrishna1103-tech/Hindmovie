package ke;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final c f7425y = new c(1, 0, 1);

    @Override // ke.a
    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (isEmpty() && ((c) obj).isEmpty()) {
            return true;
        }
        c cVar = (c) obj;
        return this.f7418v == cVar.f7418v && this.f7419w == cVar.f7419w;
    }

    @Override // ke.a
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f7418v * 31) + this.f7419w;
    }

    @Override // ke.a
    public final boolean isEmpty() {
        return this.f7418v > this.f7419w;
    }

    @Override // ke.a
    public final String toString() {
        return this.f7418v + ".." + this.f7419w;
    }
}
