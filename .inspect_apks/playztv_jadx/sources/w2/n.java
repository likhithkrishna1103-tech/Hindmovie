package w2;

import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13662a = new byte[4096];

    @Override // w2.h0
    public final void b(s1.u uVar, int i, int i10) {
        uVar.K(i);
    }

    @Override // w2.h0
    public final int c(p1.i iVar, int i, boolean z2) {
        return e(iVar, i, z2);
    }

    @Override // w2.h0
    public final int e(p1.i iVar, int i, boolean z2) throws EOFException {
        byte[] bArr = this.f13662a;
        int i10 = iVar.read(bArr, 0, Math.min(bArr.length, i));
        if (i10 != -1) {
            return i10;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // w2.h0
    public final /* synthetic */ void f(int i, s1.u uVar) {
        e6.j.b(this, uVar, i);
    }

    @Override // w2.h0
    public final void d(p1.q qVar) {
    }

    @Override // w2.h0
    public final void a(long j5, int i, int i10, int i11, g0 g0Var) {
    }
}
