package vc;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements xc.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f13689v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final qd.a f13690w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final xc.c f13691x;

    public /* synthetic */ s0(xc.c cVar, xc.c cVar2, int i) {
        this.f13689v = i;
        this.f13690w = cVar;
        this.f13691x = cVar2;
    }

    @Override // qd.a
    public final Object get() {
        switch (this.f13689v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new r0((e1) this.f13690w.get(), (f1) this.f13691x.get());
            default:
                return new yc.j((yc.o) this.f13690w.get(), (yc.o) this.f13691x.get());
        }
    }
}
