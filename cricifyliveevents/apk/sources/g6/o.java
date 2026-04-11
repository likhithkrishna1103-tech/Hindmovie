package g6;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f5118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5119c;

    public /* synthetic */ o(w wVar, String str, int i) {
        this.f5117a = i;
        this.f5118b = wVar;
        this.f5119c = str;
    }

    @Override // g6.v
    public final void run() {
        switch (this.f5117a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f5118b.r(this.f5119c);
                break;
            case 1:
                this.f5118b.q(this.f5119c);
                break;
            default:
                this.f5118b.t(this.f5119c);
                break;
        }
    }
}
