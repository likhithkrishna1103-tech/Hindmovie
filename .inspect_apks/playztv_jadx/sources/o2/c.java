package o2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements c1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c1 f9081u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f9082v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ d f9083w;

    public c(d dVar, c1 c1Var) {
        this.f9083w = dVar;
        this.f9081u = c1Var;
    }

    @Override // o2.c1
    public final void b() {
        this.f9081u.b();
    }

    @Override // o2.c1
    public final int e(h4.z zVar, DecoderInputBuffer decoderInputBuffer, int i) {
        d dVar = this.f9083w;
        if (dVar.b()) {
            return -3;
        }
        if (this.f9082v) {
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        long jR = dVar.r();
        int iE = this.f9081u.e(zVar, decoderInputBuffer, i);
        if (iE != -5) {
            long j5 = dVar.f9089z;
            if (j5 == Long.MIN_VALUE || ((iE != -4 || decoderInputBuffer.timeUs < j5) && !(iE == -3 && jR == Long.MIN_VALUE && !decoderInputBuffer.waitingForKeys))) {
                return iE;
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.setFlags(4);
            this.f9082v = true;
            return -4;
        }
        p1.q qVar = (p1.q) zVar.f5868w;
        qVar.getClass();
        int i10 = qVar.J;
        int i11 = qVar.I;
        if (i11 == 0 && i10 == 0) {
            return -5;
        }
        if (dVar.f9088y != 0) {
            i11 = 0;
        }
        if (dVar.f9089z != Long.MIN_VALUE) {
            i10 = 0;
        }
        p1.p pVarA = qVar.a();
        pVarA.H = i11;
        pVarA.I = i10;
        zVar.f5868w = new p1.q(pVarA);
        return -5;
    }

    @Override // o2.c1
    public final boolean j() {
        return !this.f9083w.b() && this.f9081u.j();
    }

    @Override // o2.c1
    public final int q(long j5) {
        if (this.f9083w.b()) {
            return -3;
        }
        return this.f9081u.q(j5);
    }
}
