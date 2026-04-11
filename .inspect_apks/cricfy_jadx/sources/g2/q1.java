package g2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q1 f4886b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ua.m0 f4887a;

    static {
        p6.d dVar = new p6.d(19, false);
        dVar.f10037w = ua.m0.j(2, 1, 5);
        f4886b = new q1(dVar);
    }

    public q1(p6.d dVar) {
        this.f4887a = (ua.m0) dVar.f10037w;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof q1) && this.f4887a.equals(((q1) obj).f4887a);
    }

    public final int hashCode() {
        Boolean bool = Boolean.TRUE;
        return Objects.hash(this.f4887a, null, null, bool, bool, bool, bool);
    }
}
