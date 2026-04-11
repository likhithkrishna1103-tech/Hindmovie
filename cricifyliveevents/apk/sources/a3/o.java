package a3;

import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f225a = new byte[4096];

    @Override // a3.i0
    public final /* synthetic */ void a(int i, y1.t tVar) {
        q4.a.a(this, tVar, i);
    }

    @Override // a3.i0
    public final int b(v1.h hVar, int i, boolean z10) {
        return d(hVar, i, z10);
    }

    @Override // a3.i0
    public final void c(y1.t tVar, int i, int i10) {
        tVar.K(i);
    }

    @Override // a3.i0
    public final int d(v1.h hVar, int i, boolean z10) throws EOFException {
        byte[] bArr = this.f225a;
        int i10 = hVar.read(bArr, 0, Math.min(bArr.length, i));
        if (i10 != -1) {
            return i10;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // a3.i0
    public final void f(v1.p pVar) {
    }

    @Override // a3.i0
    public final void e(long j4, int i, int i10, int i11, h0 h0Var) {
    }
}
