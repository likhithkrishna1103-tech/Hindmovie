package g5;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5311a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f5312b;

    public /* synthetic */ u() {
    }

    @Override // g5.n
    public final void e(p pVar) {
        switch (this.f5311a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f5312b.z();
                pVar.x(this);
                break;
            default:
                a aVar = (a) this.f5312b;
                int i = aVar.W - 1;
                aVar.W = i;
                if (i == 0) {
                    aVar.X = false;
                    aVar.m();
                }
                pVar.x(this);
                break;
        }
    }

    @Override // g5.q, g5.n
    public void f(p pVar) {
        switch (this.f5311a) {
            case 1:
                a aVar = (a) this.f5312b;
                if (!aVar.X) {
                    aVar.G();
                    aVar.X = true;
                }
                break;
        }
    }

    public u(p pVar) {
        this.f5312b = pVar;
    }
}
