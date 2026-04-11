package k8;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c4 implements u0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7124u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ String f7125v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ d4 f7126w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ x3 f7127x;

    public /* synthetic */ c4(x3 x3Var, String str, d4 d4Var, int i) {
        this.f7124u = i;
        this.f7125v = str;
        this.f7126w = d4Var;
        this.f7127x = x3Var;
    }

    @Override // k8.u0
    public final void k(String str, int i, Throwable th, byte[] bArr, Map map) {
        switch (this.f7124u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f7127x.p(this.f7125v, i, th, bArr, this.f7126w);
                break;
            default:
                this.f7127x.p(this.f7125v, i, th, bArr, this.f7126w);
                break;
        }
    }
}
