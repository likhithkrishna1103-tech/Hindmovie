package l5;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f7890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7891c;

    public /* synthetic */ p(w wVar, int i, int i10) {
        this.f7889a = i10;
        this.f7890b = wVar;
        this.f7891c = i;
    }

    @Override // l5.v
    public final void run() {
        switch (this.f7889a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f7890b.n(this.f7891c);
                break;
            case 1:
                this.f7890b.q(this.f7891c);
                break;
            default:
                this.f7890b.m(this.f7891c);
                break;
        }
    }
}
