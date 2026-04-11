package l2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7666v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ k f7667w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f7668x;

    public /* synthetic */ i(k kVar, l lVar, int i) {
        this.f7666v = i;
        this.f7667w = kVar;
        this.f7668x = lVar;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, l2.l] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, l2.l] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, l2.l] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7666v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = this.f7667w;
                this.f7668x.F(kVar.f7671a, kVar.f7672b);
                break;
            case 1:
                k kVar2 = this.f7667w;
                this.f7668x.I(kVar2.f7671a, kVar2.f7672b);
                break;
            default:
                k kVar3 = this.f7667w;
                this.f7668x.t(kVar3.f7671a, kVar3.f7672b);
                break;
        }
    }
}
