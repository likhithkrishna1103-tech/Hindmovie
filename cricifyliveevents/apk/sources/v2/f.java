package v2;

import v1.g1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends m implements Comparable {
    public final int A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f13091z;

    public f(int i, g1 g1Var, int i10, i iVar, int i11) {
        int i12;
        super(i, g1Var, i10);
        this.f13091z = q4.a.g(i11, iVar.f13101u0) ? 1 : 0;
        v1.p pVar = this.f13110y;
        int i13 = pVar.f12953u;
        int i14 = -1;
        if (i13 != -1 && (i12 = pVar.f12954v) != -1) {
            i14 = i13 * i12;
        }
        this.A = i14;
    }

    @Override // v2.m
    public final int a() {
        return this.f13091z;
    }

    @Override // v2.m
    public final /* bridge */ /* synthetic */ boolean b(m mVar) {
        return false;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Integer.compare(this.A, ((f) obj).A);
    }
}
