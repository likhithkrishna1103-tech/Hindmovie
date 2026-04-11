package vc;

import android.content.Context;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements xc.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f13663v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ma.e f13664w;

    public /* synthetic */ m(ma.e eVar, int i) {
        this.f13663v = i;
        this.f13664w = eVar;
    }

    @Override // qd.a
    public final Object get() {
        switch (this.f13663v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new l((hc.b) this.f13664w.f8417v);
            default:
                return new yc.a((Context) this.f13664w.f8417v);
        }
    }
}
