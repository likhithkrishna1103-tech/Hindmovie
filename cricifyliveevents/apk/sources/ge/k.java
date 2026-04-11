package ge;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f5251a;

    public k(Class cls) {
        this.f5251a = cls;
    }

    @Override // ge.e
    public final Class a() {
        return this.f5251a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return i.a(this.f5251a, ((k) obj).f5251a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5251a.hashCode();
    }

    public final String toString() {
        return this.f5251a.toString() + " (Kotlin reflection is not available)";
    }
}
