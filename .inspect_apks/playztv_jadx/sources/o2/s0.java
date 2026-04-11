package o2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements c1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f9207u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ u0 f9208v;

    public s0(u0 u0Var, int i) {
        this.f9208v = u0Var;
        this.f9207u = i;
    }

    @Override // o2.c1
    public final void b() throws IOException {
        int i = this.f9207u;
        u0 u0Var = this.f9208v;
        u0Var.O[i].z();
        s2.m mVar = u0Var.G;
        int iK = u0Var.f9232x.k(u0Var.Y);
        IOException iOException = mVar.f11769w;
        if (iOException != null) {
            throw iOException;
        }
        s2.i iVar = mVar.f11768v;
        if (iVar != null) {
            if (iK == Integer.MIN_VALUE) {
                iK = iVar.f11758u;
            }
            IOException iOException2 = iVar.f11762y;
            if (iOException2 != null && iVar.f11763z > iK) {
                throw iOException2;
            }
        }
    }

    @Override // o2.c1
    public final int e(h4.z zVar, DecoderInputBuffer decoderInputBuffer, int i) {
        u0 u0Var = this.f9208v;
        if (u0Var.G()) {
            return -3;
        }
        int i10 = this.f9207u;
        u0Var.B(i10);
        int iC = u0Var.O[i10].C(zVar, decoderInputBuffer, i, u0Var.f9227i0);
        if (iC == -3) {
            u0Var.C(i10);
        }
        return iC;
    }

    @Override // o2.c1
    public final boolean j() {
        u0 u0Var = this.f9208v;
        return !u0Var.G() && u0Var.O[this.f9207u].x(u0Var.f9227i0);
    }

    @Override // o2.c1
    public final int q(long j5) {
        u0 u0Var = this.f9208v;
        if (u0Var.G()) {
            return 0;
        }
        int i = this.f9207u;
        u0Var.B(i);
        b1 b1Var = u0Var.O[i];
        int iV = b1Var.v(u0Var.f9227i0, j5);
        b1Var.H(iV);
        if (iV == 0) {
            u0Var.C(i);
        }
        return iV;
    }
}
