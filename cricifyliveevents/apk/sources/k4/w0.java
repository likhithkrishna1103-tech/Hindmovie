package k4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w0 implements c1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7187v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ c1 f7188w;

    public /* synthetic */ w0(c1 c1Var, int i) {
        this.f7187v = i;
        this.f7188w = c1Var;
    }

    @Override // k4.c1
    public final Object i(b0 b0Var, s sVar, int i) {
        switch (this.f7187v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (b0Var != null) {
                    throw new ClassCastException();
                }
                d1.L(null, sVar, i, this.f7188w, new g2.s(i, 2, sVar));
                throw null;
            default:
                return d1.L(b0Var, sVar, i, this.f7188w, new d8.f(i, b0Var, sVar));
        }
    }
}
