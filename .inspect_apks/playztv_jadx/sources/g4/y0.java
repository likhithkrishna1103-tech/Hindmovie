package g4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y0 implements e1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5255u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ e1 f5256v;

    public /* synthetic */ y0(e1 e1Var, int i) {
        this.f5255u = i;
        this.f5256v = e1Var;
    }

    @Override // g4.e1
    public final Object g(b0 b0Var, s sVar, int i) {
        switch (this.f5255u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (b0Var != null) {
                    throw new ClassCastException();
                }
                f1.f(null, sVar, i, this.f5256v, new a2.x(i, 2, sVar));
                throw null;
            default:
                return f1.f(b0Var, sVar, i, this.f5256v, new a2.h0(b0Var, i, sVar));
        }
    }
}
