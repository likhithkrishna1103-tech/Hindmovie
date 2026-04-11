package o2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l1 implements c1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c1 f9159u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f9160v;

    public l1(c1 c1Var, long j5) {
        this.f9159u = c1Var;
        this.f9160v = j5;
    }

    @Override // o2.c1
    public final void b() {
        this.f9159u.b();
    }

    @Override // o2.c1
    public final int e(h4.z zVar, DecoderInputBuffer decoderInputBuffer, int i) {
        int iE = this.f9159u.e(zVar, decoderInputBuffer, i);
        if (iE == -4) {
            decoderInputBuffer.timeUs += this.f9160v;
        }
        return iE;
    }

    @Override // o2.c1
    public final boolean j() {
        return this.f9159u.j();
    }

    @Override // o2.c1
    public final int q(long j5) {
        return this.f9159u.q(j5 - this.f9160v);
    }
}
