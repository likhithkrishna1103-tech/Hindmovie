package s2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f0 implements y1.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f11193v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ f3.a f11194w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ t f11195x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ y f11196y;

    public /* synthetic */ f0(f3.a aVar, t tVar, y yVar, int i) {
        this.f11193v = i;
        this.f11194w = aVar;
        this.f11195x = tVar;
        this.f11196y = yVar;
    }

    @Override // y1.h
    public final void accept(Object obj) {
        i0 i0Var = (i0) obj;
        switch (this.f11193v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                f3.a aVar = this.f11194w;
                i0Var.G(aVar.f3935w, (c0) aVar.f3936x, this.f11195x, this.f11196y);
                break;
            default:
                f3.a aVar2 = this.f11194w;
                i0Var.L(aVar2.f3935w, (c0) aVar2.f3936x, this.f11195x, this.f11196y);
                break;
        }
    }
}
