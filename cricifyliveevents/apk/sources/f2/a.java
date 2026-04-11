package f2;

import androidx.media3.decoder.av1.Dav1dDecoder;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Thread {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3929v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f3930w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ boolean f3931x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Dav1dDecoder f3932y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Dav1dDecoder dav1dDecoder, int i, int i10, boolean z10) {
        super("ExoPlayer:Dav1dDecoder");
        this.f3932y = dav1dDecoder;
        this.f3929v = i;
        this.f3930w = i10;
        this.f3931x = z10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Dav1dDecoder dav1dDecoder = this.f3932y;
        dav1dDecoder.dav1dDecoderContext = dav1dDecoder.dav1dInit(this.f3929v, this.f3930w, this.f3931x);
        Dav1dDecoder dav1dDecoder2 = this.f3932y;
        if (dav1dDecoder2.dav1dCheckError(dav1dDecoder2.dav1dDecoderContext) != 0) {
            this.f3932y.run();
            Dav1dDecoder dav1dDecoder3 = this.f3932y;
            dav1dDecoder3.releaseUnusedInputBuffers(dav1dDecoder3.dav1dDecoderContext, this.f3932y);
            Dav1dDecoder dav1dDecoder4 = this.f3932y;
            dav1dDecoder4.dav1dClose(dav1dDecoder4.dav1dDecoderContext);
            return;
        }
        synchronized (this.f3932y.lock) {
            Dav1dDecoder dav1dDecoder5 = this.f3932y;
            StringBuilder sb = new StringBuilder("Failed to initialize decoder. Error: ");
            Dav1dDecoder dav1dDecoder6 = this.f3932y;
            sb.append(dav1dDecoder6.dav1dGetErrorMessage(dav1dDecoder6.dav1dDecoderContext));
            dav1dDecoder5.exception = new b(sb.toString());
        }
        Dav1dDecoder dav1dDecoder7 = this.f3932y;
        dav1dDecoder7.dav1dClose(dav1dDecoder7.dav1dDecoderContext);
    }
}
