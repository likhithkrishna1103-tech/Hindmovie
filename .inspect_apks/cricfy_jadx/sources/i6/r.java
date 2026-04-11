package i6;

import g6.w;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements j6.a, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f6325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j6.e f6326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n6.k f6327c;

    public r(w wVar, o6.a aVar, n6.j jVar) {
        this.f6325a = wVar;
        j6.e eVarD0 = jVar.f8819a.D0();
        this.f6326b = eVarD0;
        aVar.d(eVarD0);
        eVarD0.a(this);
    }

    public static int d(int i, int i10) {
        int i11 = i / i10;
        if ((i ^ i10) < 0 && i11 * i10 != i) {
            i11--;
        }
        return i - (i11 * i10);
    }

    @Override // j6.a
    public final void b() {
        this.f6325a.invalidateSelf();
    }

    @Override // i6.d
    public final void c(List list, List list2) {
    }
}
