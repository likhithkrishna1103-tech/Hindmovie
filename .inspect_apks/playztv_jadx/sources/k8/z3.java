package k8;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z3 implements u0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7575u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ String f7576v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ ArrayList f7577w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ x3 f7578x;

    public /* synthetic */ z3(x3 x3Var, String str, ArrayList arrayList, int i) {
        this.f7575u = i;
        this.f7576v = str;
        this.f7577w = arrayList;
        this.f7578x = x3Var;
    }

    @Override // k8.u0
    public final void k(String str, int i, Throwable th, byte[] bArr, Map map) {
        switch (this.f7575u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f7578x.A(true, i, th, bArr, this.f7576v, this.f7577w);
                break;
            default:
                this.f7578x.A(true, i, th, bArr, this.f7576v, this.f7577w);
                break;
        }
    }
}
