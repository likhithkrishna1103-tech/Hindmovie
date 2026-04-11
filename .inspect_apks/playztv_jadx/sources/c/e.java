package c;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2159u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ h.j f2160v;

    public /* synthetic */ e(h.j jVar, int i) {
        this.f2159u = i;
        this.f2160v = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2159u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                l.g(this.f2160v);
                break;
            default:
                this.f2160v.invalidateOptionsMenu();
                break;
        }
    }
}
