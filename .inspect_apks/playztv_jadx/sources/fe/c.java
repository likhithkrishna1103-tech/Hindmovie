package fe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final c f4824x = new c(1, 0, 1);

    @Override // fe.a
    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (isEmpty() && ((c) obj).isEmpty()) {
            return true;
        }
        c cVar = (c) obj;
        return this.f4817u == cVar.f4817u && this.f4818v == cVar.f4818v;
    }

    @Override // fe.a
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f4817u * 31) + this.f4818v;
    }

    @Override // fe.a
    public final boolean isEmpty() {
        return this.f4817u > this.f4818v;
    }

    @Override // fe.a
    public final String toString() {
        return this.f4817u + ".." + this.f4818v;
    }
}
