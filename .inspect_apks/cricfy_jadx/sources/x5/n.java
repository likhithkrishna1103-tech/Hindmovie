package x5;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f14368v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ p f14369w;

    public /* synthetic */ n(p pVar, int i) {
        this.f14368v = i;
        this.f14369w = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f14368v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                p pVar = this.f14369w;
                pVar.f14373x0 = (List) ab.b.s((w4.t) pVar.f14371v0.q().f1800w, true, false, new b6.a(0));
                pVar.J().runOnUiThread(new n(pVar, 1));
                break;
            case 1:
                this.f14369w.V();
                break;
            default:
                ab.b.s((w4.t) this.f14369w.f14371v0.q().f1800w, false, true, new b6.a(2));
                break;
        }
    }
}
