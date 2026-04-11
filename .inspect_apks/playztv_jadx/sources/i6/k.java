package i6;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6409a;

    public k(String str) {
        this.f6409a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f6409a.equals(((k) obj).f6409a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6409a.hashCode();
    }

    public final String toString() {
        return l4.a.o(new StringBuilder("StringHeaderFactory{value='"), this.f6409a, "'}");
    }
}
