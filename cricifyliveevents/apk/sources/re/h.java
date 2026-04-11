package re;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f11036a;

    public h(Throwable th) {
        this.f11036a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return ge.i.a(this.f11036a, ((h) obj).f11036a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f11036a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // re.i
    public final String toString() {
        return "Closed(" + this.f11036a + ')';
    }
}
