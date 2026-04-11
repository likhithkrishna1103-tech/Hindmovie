package y1;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f14565v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ ff.k f14566w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f14567x;

    public /* synthetic */ c(ff.k kVar, Object obj, int i) {
        this.f14565v = i;
        this.f14566w = kVar;
        this.f14567x = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f14565v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ff.k kVar = this.f14566w;
                if (kVar.f4586a == 0) {
                    kVar.M(this.f14567x);
                }
                break;
            default:
                ff.k kVar2 = this.f14566w;
                int i = kVar2.f4586a - 1;
                kVar2.f4586a = i;
                if (i == 0) {
                    kVar2.M(this.f14567x);
                }
                break;
        }
    }
}
