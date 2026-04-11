package zb;

import androidx.media3.decoder.DecoderInputBuffer;
import bc.d;
import qa.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f14940u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ b f14941v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ d f14942w;

    public /* synthetic */ a(b bVar, d dVar, int i) {
        this.f14940u = i;
        this.f14941v = bVar;
        this.f14942w = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f14940u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f14941v.a(this.f14942w);
                break;
            default:
                this.f14941v.a(this.f14942w);
                break;
        }
    }
}
