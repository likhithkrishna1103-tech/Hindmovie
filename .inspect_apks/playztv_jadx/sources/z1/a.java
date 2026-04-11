package z1;

import androidx.media3.decoder.av1.Dav1dDecoder;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Thread {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f14808u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f14809v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ boolean f14810w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Dav1dDecoder f14811x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Dav1dDecoder dav1dDecoder, int i, int i10, boolean z2) {
        super("ExoPlayer:Dav1dDecoder");
        this.f14811x = dav1dDecoder;
        this.f14808u = i;
        this.f14809v = i10;
        this.f14810w = z2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Dav1dDecoder dav1dDecoder = this.f14811x;
        dav1dDecoder.dav1dDecoderContext = dav1dDecoder.dav1dInit(this.f14808u, this.f14809v, this.f14810w);
        Dav1dDecoder dav1dDecoder2 = this.f14811x;
        if (dav1dDecoder2.dav1dCheckError(dav1dDecoder2.dav1dDecoderContext) != 0) {
            this.f14811x.run();
            Dav1dDecoder dav1dDecoder3 = this.f14811x;
            dav1dDecoder3.releaseUnusedInputBuffers(dav1dDecoder3.dav1dDecoderContext, this.f14811x);
            Dav1dDecoder dav1dDecoder4 = this.f14811x;
            dav1dDecoder4.dav1dClose(dav1dDecoder4.dav1dDecoderContext);
            return;
        }
        synchronized (this.f14811x.lock) {
            Dav1dDecoder dav1dDecoder5 = this.f14811x;
            StringBuilder sb2 = new StringBuilder("Failed to initialize decoder. Error: ");
            Dav1dDecoder dav1dDecoder6 = this.f14811x;
            sb2.append(dav1dDecoder6.dav1dGetErrorMessage(dav1dDecoder6.dav1dDecoderContext));
            dav1dDecoder5.exception = new b(sb2.toString());
        }
        Dav1dDecoder dav1dDecoder7 = this.f14811x;
        dav1dDecoder7.dav1dClose(dav1dDecoder7.dav1dDecoderContext);
    }
}
