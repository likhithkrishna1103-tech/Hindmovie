package v2;

import ua.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Comparable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f13092v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f13093w;

    public g(v1.p pVar, int i) {
        this.f13092v = (pVar.f12939e & 1) != 0;
        this.f13093w = q4.a.g(i, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        g gVar = (g) obj;
        return y.f12407a.c(this.f13093w, gVar.f13093w).c(this.f13092v, gVar.f13092v).e();
    }
}
