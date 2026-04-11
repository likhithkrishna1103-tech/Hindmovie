package t2;

import a3.h0;
import a3.i0;
import a3.o;
import v1.p;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f11839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f11840c = new o();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f11841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i0 f11842e;
    public long f;

    public c(int i, int i10, p pVar) {
        this.f11838a = i10;
        this.f11839b = pVar;
    }

    @Override // a3.i0
    public final /* synthetic */ void a(int i, t tVar) {
        q4.a.a(this, tVar, i);
    }

    @Override // a3.i0
    public final int b(v1.h hVar, int i, boolean z10) {
        return d(hVar, i, z10);
    }

    @Override // a3.i0
    public final void c(t tVar, int i, int i10) {
        i0 i0Var = this.f11842e;
        int i11 = a0.f14551a;
        i0Var.a(i, tVar);
    }

    @Override // a3.i0
    public final int d(v1.h hVar, int i, boolean z10) {
        i0 i0Var = this.f11842e;
        int i10 = a0.f14551a;
        return i0Var.b(hVar, i, z10);
    }

    @Override // a3.i0
    public final void e(long j4, int i, int i10, int i11, h0 h0Var) {
        long j7 = this.f;
        if (j7 != -9223372036854775807L && j4 >= j7) {
            this.f11842e = this.f11840c;
        }
        i0 i0Var = this.f11842e;
        int i12 = a0.f14551a;
        i0Var.e(j4, i, i10, i11, h0Var);
    }

    @Override // a3.i0
    public final void f(p pVar) {
        p pVar2 = this.f11839b;
        if (pVar2 != null) {
            pVar = pVar.d(pVar2);
        }
        this.f11841d = pVar;
        i0 i0Var = this.f11842e;
        int i = a0.f14551a;
        i0Var.f(pVar);
    }
}
