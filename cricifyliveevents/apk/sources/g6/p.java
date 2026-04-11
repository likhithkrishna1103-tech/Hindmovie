package g6;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f5121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5122c;

    public /* synthetic */ p(w wVar, int i, int i10) {
        this.f5120a = i10;
        this.f5121b = wVar;
        this.f5122c = i;
    }

    @Override // g6.v
    public final void run() {
        switch (this.f5120a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f5121b.p(this.f5122c);
                break;
            case 1:
                this.f5121b.s(this.f5122c);
                break;
            default:
                this.f5121b.o(this.f5122c);
                break;
        }
    }
}
