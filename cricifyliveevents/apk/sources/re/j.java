package re;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f11037b = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11038a;

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return ge.i.a(this.f11038a, ((j) obj).f11038a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f11038a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f11038a;
        if (obj instanceof h) {
            return ((h) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
