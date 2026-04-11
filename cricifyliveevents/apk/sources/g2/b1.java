package g2;

import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b1 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4630v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ e1 f4631w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Pair f4632x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ s2.t f4633y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ s2.y f4634z;

    public /* synthetic */ b1(e1 e1Var, Pair pair, s2.t tVar, s2.y yVar, int i) {
        this.f4630v = i;
        this.f4631w = e1Var;
        this.f4632x = pair;
        this.f4633y = tVar;
        this.f4634z = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4630v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h2.f fVar = (h2.f) this.f4631w.f4667w.i;
                Pair pair = this.f4632x;
                fVar.L(((Integer) pair.first).intValue(), (s2.c0) pair.second, this.f4633y, this.f4634z);
                break;
            default:
                h2.f fVar2 = (h2.f) this.f4631w.f4667w.i;
                Pair pair2 = this.f4632x;
                fVar2.G(((Integer) pair2.first).intValue(), (s2.c0) pair2.second, this.f4633y, this.f4634z);
                break;
        }
    }
}
