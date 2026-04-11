package l5;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f7887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7888c;

    public /* synthetic */ o(w wVar, String str, int i) {
        this.f7886a = i;
        this.f7887b = wVar;
        this.f7888c = str;
    }

    @Override // l5.v
    public final void run() {
        switch (this.f7886a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f7887b.p(this.f7888c);
                break;
            case 1:
                this.f7887b.o(this.f7888c);
                break;
            default:
                this.f7887b.r(this.f7888c);
                break;
        }
    }
}
