package s2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements a1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a1 f11153v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f11154w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ d f11155x;

    public c(d dVar, a1 a1Var) {
        this.f11155x = dVar;
        this.f11153v = a1Var;
    }

    @Override // s2.a1
    public final boolean b() {
        return !this.f11155x.b() && this.f11153v.b();
    }

    @Override // s2.a1
    public final void c() {
        this.f11153v.c();
    }

    @Override // s2.a1
    public final int e(long j4) {
        if (this.f11155x.b()) {
            return -3;
        }
        return this.f11153v.e(j4);
    }

    @Override // s2.a1
    public final int p(l4.c0 c0Var, DecoderInputBuffer decoderInputBuffer, int i) {
        d dVar = this.f11155x;
        if (dVar.b()) {
            return -3;
        }
        if (this.f11154w) {
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        long jQ = dVar.q();
        int iP = this.f11153v.p(c0Var, decoderInputBuffer, i);
        if (iP != -5) {
            long j4 = dVar.A;
            if (j4 == Long.MIN_VALUE || ((iP != -4 || decoderInputBuffer.timeUs < j4) && !(iP == -3 && jQ == Long.MIN_VALUE && !decoderInputBuffer.waitingForKeys))) {
                return iP;
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.setFlags(4);
            this.f11154w = true;
            return -4;
        }
        v1.p pVar = (v1.p) c0Var.f7706x;
        pVar.getClass();
        int i10 = pVar.J;
        int i11 = pVar.I;
        if (i11 == 0 && i10 == 0) {
            return -5;
        }
        if (dVar.f11165z != 0) {
            i11 = 0;
        }
        if (dVar.A != Long.MIN_VALUE) {
            i10 = 0;
        }
        v1.o oVarA = pVar.a();
        oVarA.H = i11;
        oVarA.I = i10;
        c0Var.f7706x = new v1.p(oVarA);
        return -5;
    }
}
