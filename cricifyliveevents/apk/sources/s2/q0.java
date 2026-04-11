package s2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 implements a1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f11297v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ s0 f11298w;

    public q0(s0 s0Var, int i) {
        this.f11298w = s0Var;
        this.f11297v = i;
    }

    @Override // s2.a1
    public final boolean b() {
        s0 s0Var = this.f11298w;
        return !s0Var.G() && s0Var.P[this.f11297v].x(s0Var.f11318j0);
    }

    @Override // s2.a1
    public final void c() throws IOException {
        int i = this.f11297v;
        s0 s0Var = this.f11298w;
        s0Var.P[i].z();
        w2.o oVar = s0Var.H;
        int iM = s0Var.f11323y.m(s0Var.Z);
        IOException iOException = oVar.f13886c;
        if (iOException != null) {
            throw iOException;
        }
        w2.j jVar = oVar.f13885b;
        if (jVar != null) {
            if (iM == Integer.MIN_VALUE) {
                iM = jVar.f13875v;
            }
            IOException iOException2 = jVar.f13879z;
            if (iOException2 != null && jVar.A > iM) {
                throw iOException2;
            }
        }
    }

    @Override // s2.a1
    public final int e(long j4) {
        s0 s0Var = this.f11298w;
        if (s0Var.G()) {
            return 0;
        }
        int i = this.f11297v;
        s0Var.A(i);
        z0 z0Var = s0Var.P[i];
        int iV = z0Var.v(s0Var.f11318j0, j4);
        z0Var.H(iV);
        if (iV == 0) {
            s0Var.C(i);
        }
        return iV;
    }

    @Override // s2.a1
    public final int p(l4.c0 c0Var, DecoderInputBuffer decoderInputBuffer, int i) {
        s0 s0Var = this.f11298w;
        if (s0Var.G()) {
            return -3;
        }
        int i10 = this.f11297v;
        s0Var.A(i10);
        int iC = s0Var.P[i10].C(c0Var, decoderInputBuffer, i, s0Var.f11318j0);
        if (iC == -3) {
            s0Var.C(i10);
        }
        return iC;
    }
}
