package l5;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f7897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f7898c;

    public /* synthetic */ r(w wVar, float f, int i) {
        this.f7896a = i;
        this.f7897b = wVar;
        this.f7898c = f;
    }

    @Override // l5.v
    public final void run() {
        switch (this.f7896a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                w wVar = this.f7897b;
                j jVar = wVar.f7918u;
                float f = this.f7898c;
                if (jVar != null) {
                    x5.d dVar = wVar.f7919v;
                    dVar.i(dVar.D, x5.f.e(jVar.f7866l, jVar.f7867m, f));
                } else {
                    wVar.f7923z.add(new r(wVar, f, 0));
                }
                break;
            case 1:
                w wVar2 = this.f7897b;
                j jVar2 = wVar2.f7918u;
                float f4 = this.f7898c;
                if (jVar2 != null) {
                    wVar2.q((int) x5.f.e(jVar2.f7866l, jVar2.f7867m, f4));
                } else {
                    wVar2.f7923z.add(new r(wVar2, f4, 1));
                }
                break;
            default:
                this.f7897b.s(this.f7898c);
                break;
        }
    }
}
