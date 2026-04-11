package y4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements a0, w4.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14859b;

    public /* synthetic */ i(int i, Object obj) {
        this.f14858a = i;
        this.f14859b = obj;
    }

    @Override // y4.a0
    public final c5.a b() {
        switch (this.f14858a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((n) this.f14859b).f14867b;
            default:
                return ((z) this.f14859b).f14900b;
        }
    }

    @Override // w4.m
    public final Object c(String str, fe.l lVar, xd.c cVar) {
        switch (this.f14858a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((n) this.f14859b).c(str, lVar, cVar);
            default:
                return ((z) this.f14859b).c(str, lVar, cVar);
        }
    }
}
