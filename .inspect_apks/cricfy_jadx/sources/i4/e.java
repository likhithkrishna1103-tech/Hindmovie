package i4;

import a3.q;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6207b;

    public /* synthetic */ e(int i, long j4, boolean z10) {
        this.f6206a = i;
        this.f6207b = j4;
    }

    public static e b(q qVar, t tVar) {
        qVar.z(tVar.f14609a, 0, 8);
        tVar.J(0);
        return new e(tVar.j(), tVar.o(), false);
    }

    public boolean a() {
        int i = this.f6206a;
        return i == 0 || i == 1;
    }

    public e(int i, long j4) {
        y1.d.b(j4 >= 0);
        this.f6206a = i;
        this.f6207b = j4;
    }
}
