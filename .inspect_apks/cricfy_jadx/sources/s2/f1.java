package s2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 implements a1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11197v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f11198w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ h1 f11199x;

    public f1(h1 h1Var) {
        this.f11199x = h1Var;
    }

    public final void a() {
        if (this.f11198w) {
            return;
        }
        h1 h1Var = this.f11199x;
        h1Var.f11226z.f(v1.m0.i(h1Var.E.f12946n), h1Var.E, 0, null, 0L);
        this.f11198w = true;
    }

    @Override // s2.a1
    public final boolean b() {
        return this.f11199x.G;
    }

    @Override // s2.a1
    public final void c() throws IOException {
        h1 h1Var = this.f11199x;
        if (h1Var.F) {
            return;
        }
        h1Var.D.c();
    }

    @Override // s2.a1
    public final int e(long j4) {
        a();
        if (j4 <= 0 || this.f11197v == 2) {
            return 0;
        }
        this.f11197v = 2;
        return 1;
    }

    @Override // s2.a1
    public final int p(l4.c0 c0Var, DecoderInputBuffer decoderInputBuffer, int i) {
        a();
        h1 h1Var = this.f11199x;
        boolean z10 = h1Var.G;
        if (z10 && h1Var.H == null) {
            this.f11197v = 2;
        }
        int i10 = this.f11197v;
        if (i10 == 2) {
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        if ((i & 2) != 0 || i10 == 0) {
            c0Var.f7706x = h1Var.E;
            this.f11197v = 1;
            return -5;
        }
        if (!z10) {
            return -3;
        }
        h1Var.H.getClass();
        decoderInputBuffer.addFlag(1);
        decoderInputBuffer.timeUs = 0L;
        if ((i & 4) == 0) {
            decoderInputBuffer.ensureSpaceForWrite(h1Var.I);
            decoderInputBuffer.data.put(h1Var.H, 0, h1Var.I);
        }
        if ((i & 1) == 0) {
            this.f11197v = 2;
        }
        return -4;
    }
}
