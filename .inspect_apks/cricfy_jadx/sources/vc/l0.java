package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t0 f13661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f13662b;

    public l0(t0 t0Var, b bVar) {
        this.f13661a = t0Var;
        this.f13662b = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return this.f13661a.equals(l0Var.f13661a) && this.f13662b.equals(l0Var.f13662b);
    }

    public final int hashCode() {
        return this.f13662b.hashCode() + ((this.f13661a.hashCode() + (n.f13667w.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "SessionEvent(eventType=" + n.f13667w + ", sessionData=" + this.f13661a + ", applicationInfo=" + this.f13662b + ')';
    }
}
