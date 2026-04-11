package o2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h1 implements c1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f9131u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f9132v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ j1 f9133w;

    public h1(j1 j1Var) {
        this.f9133w = j1Var;
    }

    public final void a() {
        if (this.f9132v) {
            return;
        }
        j1 j1Var = this.f9133w;
        j1Var.f9152y.g(p1.m0.i(j1Var.D.f10023n), j1Var.D, 0, null, 0L);
        this.f9132v = true;
    }

    @Override // o2.c1
    public final void b() {
        j1 j1Var = this.f9133w;
        if (j1Var.E) {
            return;
        }
        j1Var.C.b();
    }

    @Override // o2.c1
    public final int e(h4.z zVar, DecoderInputBuffer decoderInputBuffer, int i) {
        a();
        j1 j1Var = this.f9133w;
        boolean z2 = j1Var.F;
        if (z2 && j1Var.G == null) {
            this.f9131u = 2;
        }
        int i10 = this.f9131u;
        if (i10 == 2) {
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        if ((i & 2) != 0 || i10 == 0) {
            zVar.f5868w = j1Var.D;
            this.f9131u = 1;
            return -5;
        }
        if (!z2) {
            return -3;
        }
        j1Var.G.getClass();
        decoderInputBuffer.addFlag(1);
        decoderInputBuffer.timeUs = 0L;
        if ((i & 4) == 0) {
            decoderInputBuffer.ensureSpaceForWrite(j1Var.H);
            decoderInputBuffer.data.put(j1Var.G, 0, j1Var.H);
        }
        if ((i & 1) == 0) {
            this.f9131u = 2;
        }
        return -4;
    }

    @Override // o2.c1
    public final boolean j() {
        return this.f9133w.F;
    }

    @Override // o2.c1
    public final int q(long j5) {
        a();
        if (j5 <= 0 || this.f9131u == 2) {
            return 0;
        }
        this.f9131u = 2;
        return 1;
    }
}
