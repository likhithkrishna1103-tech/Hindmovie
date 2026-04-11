package ta;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f11960v;

    public j(Object obj) {
        this.f11960v = obj;
    }

    @Override // ta.g
    public final Object a() {
        return this.f11960v;
    }

    @Override // ta.g
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f11960v.equals(((j) obj).f11960v);
        }
        return false;
    }

    public final int hashCode() {
        return this.f11960v.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.f11960v + ")";
    }
}
