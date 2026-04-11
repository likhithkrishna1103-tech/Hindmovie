package l5;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f7905b;

    public /* synthetic */ u(w wVar, int i) {
        this.f7904a = i;
        this.f7905b = wVar;
    }

    @Override // l5.v
    public final void run() {
        switch (this.f7904a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f7905b.l();
                break;
            default:
                this.f7905b.j();
                break;
        }
    }
}
