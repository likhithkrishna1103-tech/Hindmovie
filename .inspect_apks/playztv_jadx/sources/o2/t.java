package o2;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t implements v1.h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final v1.h f9209u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9210v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final r0 f9211w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final byte[] f9212x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f9213y;

    public t(v1.h hVar, int i, r0 r0Var) {
        s1.d.b(i > 0);
        this.f9209u = hVar;
        this.f9210v = i;
        this.f9211w = r0Var;
        this.f9212x = new byte[1];
        this.f9213y = i;
    }

    @Override // v1.h
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override // v1.h
    public final void g(v1.e0 e0Var) {
        e0Var.getClass();
        this.f9209u.g(e0Var);
    }

    @Override // v1.h
    public final long h(v1.m mVar) {
        throw new UnsupportedOperationException();
    }

    @Override // v1.h
    public final Map k() {
        return this.f9209u.k();
    }

    @Override // v1.h
    public final Uri o() {
        return this.f9209u.o();
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) {
        int i11 = this.f9213y;
        v1.h hVar = this.f9209u;
        if (i11 == 0) {
            byte[] bArr2 = this.f9212x;
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
                        s1.u uVar = new s1.u(i13, bArr3);
                        r0 r0Var = this.f9211w;
                        long jMax = !r0Var.F ? r0Var.C : Math.max(r0Var.G.y(true), r0Var.C);
                        int iA = uVar.a();
                        w2.h0 h0Var = r0Var.E;
                        h0Var.getClass();
                        h0Var.f(iA, uVar);
                        h0Var.a(jMax, 1, iA, 0, null);
                        r0Var.F = true;
                    }
                }
                this.f9213y = this.f9210v;
            }
            return -1;
        }
        int i16 = hVar.read(bArr, i, Math.min(this.f9213y, i10));
        if (i16 != -1) {
            this.f9213y -= i16;
        }
        return i16;
    }
}
