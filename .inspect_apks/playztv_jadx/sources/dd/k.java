package dd;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4168u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ p f4169v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ zc.e f4170w;

    public /* synthetic */ k(p pVar, zc.e eVar, int i) {
        this.f4168u = i;
        this.f4169v = pVar;
        this.f4170w = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4168u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f4169v.k(this.f4170w);
                break;
            case 1:
                this.f4169v.c(this.f4170w);
                break;
            default:
                this.f4169v.a(this.f4170w);
                break;
        }
    }
}
