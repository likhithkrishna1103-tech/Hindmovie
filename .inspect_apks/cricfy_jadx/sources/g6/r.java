package g6;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f5128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f5129c;

    public /* synthetic */ r(w wVar, float f, int i) {
        this.f5127a = i;
        this.f5128b = wVar;
        this.f5129c = f;
    }

    @Override // g6.v
    public final void run() {
        switch (this.f5127a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                w wVar = this.f5128b;
                i iVar = wVar.f5152v;
                float f = this.f5129c;
                if (iVar != null) {
                    s6.e eVar = wVar.f5153w;
                    eVar.i(eVar.E, s6.g.f(iVar.f5095l, iVar.f5096m, f));
                } else {
                    wVar.A.add(new r(wVar, f, 0));
                }
                break;
            case 1:
                w wVar2 = this.f5128b;
                i iVar2 = wVar2.f5152v;
                float f10 = this.f5129c;
                if (iVar2 != null) {
                    wVar2.s((int) s6.g.f(iVar2.f5095l, iVar2.f5096m, f10));
                } else {
                    wVar2.A.add(new r(wVar2, f10, 1));
                }
                break;
            default:
                this.f5128b.u(this.f5129c);
                break;
        }
    }
}
