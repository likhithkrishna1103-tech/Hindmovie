package s1;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f11659u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ n.p f11660v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f11661w;

    public /* synthetic */ c(n.p pVar, Object obj, int i) {
        this.f11659u = i;
        this.f11660v = pVar;
        this.f11661w = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11659u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                n.p pVar = this.f11660v;
                if (pVar.f8475a == 0) {
                    pVar.B(this.f11661w);
                }
                break;
            default:
                n.p pVar2 = this.f11660v;
                int i = pVar2.f8475a - 1;
                pVar2.f8475a = i;
                if (i == 0) {
                    pVar2.B(this.f11661w);
                }
                break;
        }
    }
}
