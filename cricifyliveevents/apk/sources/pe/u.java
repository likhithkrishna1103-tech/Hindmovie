package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends vd.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final t f10273x = new t();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f10274w;

    public u() {
        super(f10273x);
        this.f10274w = "Room Invalidation Tracker Refresh";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u) && ge.i.a(this.f10274w, ((u) obj).f10274w);
    }

    public final int hashCode() {
        return this.f10274w.hashCode();
    }

    public final String toString() {
        return "CoroutineName(" + this.f10274w + ')';
    }
}
