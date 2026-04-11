package g2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements ta.l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4819v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f4820w;

    public /* synthetic */ o(int i, Object obj) {
        this.f4819v = i;
        this.f4820w = obj;
    }

    @Override // ta.l
    public final Object get() {
        switch (this.f4819v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (q5.d) this.f4820w;
            case 1:
                return (w2.g) this.f4820w;
            case 2:
                return (v2.o) this.f4820w;
            case 3:
                return (s2.p) this.f4820w;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return (l) this.f4820w;
            default:
                try {
                    return (s2.b0) ((Class) this.f4820w).getConstructor(null).newInstance(null);
                } catch (Exception e9) {
                    throw new IllegalStateException(e9);
                }
        }
    }
}
