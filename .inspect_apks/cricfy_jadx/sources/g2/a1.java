package g2;

import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a1 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4624v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ e1 f4625w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Pair f4626x;

    public /* synthetic */ a1(e1 e1Var, Pair pair, int i) {
        this.f4624v = i;
        this.f4625w = e1Var;
        this.f4626x = pair;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4624v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h2.f fVar = (h2.f) this.f4625w.f4667w.i;
                Pair pair = this.f4626x;
                fVar.t(((Integer) pair.first).intValue(), (s2.c0) pair.second);
                break;
            case 1:
                h2.f fVar2 = (h2.f) this.f4625w.f4667w.i;
                Pair pair2 = this.f4626x;
                fVar2.F(((Integer) pair2.first).intValue(), (s2.c0) pair2.second);
                break;
            default:
                h2.f fVar3 = (h2.f) this.f4625w.f4667w.i;
                Pair pair3 = this.f4626x;
                fVar3.I(((Integer) pair3.first).intValue(), (s2.c0) pair3.second);
                break;
        }
    }
}
