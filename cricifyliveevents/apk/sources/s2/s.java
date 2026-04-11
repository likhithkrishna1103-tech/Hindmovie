package s2;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements b2.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b2.h f11302v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11303w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p0 f11304x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final byte[] f11305y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11306z;

    public s(b2.h hVar, int i, p0 p0Var) {
        y1.d.b(i > 0);
        this.f11302v = hVar;
        this.f11303w = i;
        this.f11304x = p0Var;
        this.f11305y = new byte[1];
        this.f11306z = i;
    }

    @Override // b2.h
    public final long B(b2.o oVar) {
        throw new UnsupportedOperationException();
    }

    @Override // b2.h
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override // b2.h
    public final void d(b2.h0 h0Var) {
        h0Var.getClass();
        this.f11302v.d(h0Var);
    }

    @Override // b2.h
    public final Map j() {
        return this.f11302v.j();
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) {
        int i11 = this.f11306z;
        b2.h hVar = this.f11302v;
        if (i11 == 0) {
            byte[] bArr2 = this.f11305y;
            int i12 = 0;
            if (hVar.read(bArr2, 0, 1) != -1) {
                int i13 = (bArr2[0] & 255) << 4;
                if (i13 != 0) {
                    byte[] bArr3 = new byte[i13];
                    int i14 = i13;
                    while (i14 > 0) {
                        int i15 = hVar.read(bArr3, i12, i14);
                        if (i15 != -1) {
                            i12 += i15;
                            i14 -= i15;
                        }
                    }
                    while (i13 > 0 && bArr3[i13 - 1] == 0) {
                        i13--;
                    }
                    if (i13 > 0) {
                        y1.t tVar = new y1.t(i13, bArr3);
                        p0 p0Var = this.f11304x;
                        long jMax = !p0Var.G ? p0Var.D : Math.max(p0Var.H.x(true), p0Var.D);
                        int iA = tVar.a();
                        a3.i0 i0Var = p0Var.F;
                        i0Var.getClass();
                        i0Var.a(iA, tVar);
                        i0Var.e(jMax, 1, iA, 0, null);
                        p0Var.G = true;
                    }
                }
                this.f11306z = this.f11303w;
            }
            return -1;
        }
        int i16 = hVar.read(bArr, i, Math.min(this.f11306z, i10));
        if (i16 != -1) {
            this.f11306z -= i16;
        }
        return i16;
    }

    @Override // b2.h
    public final Uri t() {
        return this.f11302v.t();
    }
}
