package j6;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6664b;

    public /* synthetic */ q(int i, Object obj) {
        this.f6663a = i;
        this.f6664b = obj;
    }

    @Override // j6.a
    public final void b() {
        switch (this.f6663a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((r) this.f6664b).f6673k = true;
                break;
            case 1:
                ((r) this.f6664b).f6673k = true;
                break;
            case 2:
                ((r) this.f6664b).f6673k = true;
                break;
            default:
                o6.a aVar = (o6.a) this.f6664b;
                boolean z10 = aVar.f9523r.l() == 1.0f;
                if (z10 != aVar.f9529x) {
                    aVar.f9529x = z10;
                    aVar.f9520o.invalidateSelf();
                }
                break;
        }
    }
}
