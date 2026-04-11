package g2;

import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z0 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4952v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ e1 f4953w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Pair f4954x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ s2.y f4955y;

    public /* synthetic */ z0(e1 e1Var, Pair pair, s2.y yVar, int i) {
        this.f4952v = i;
        this.f4953w = e1Var;
        this.f4954x = pair;
        this.f4955y = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4952v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h2.f fVar = (h2.f) this.f4953w.f4667w.i;
                Pair pair = this.f4954x;
                int iIntValue = ((Integer) pair.first).intValue();
                s2.c0 c0Var = (s2.c0) pair.second;
                c0Var.getClass();
                fVar.K(iIntValue, c0Var, this.f4955y);
                break;
            default:
                h2.f fVar2 = (h2.f) this.f4953w.f4667w.i;
                Pair pair2 = this.f4954x;
                fVar2.J(((Integer) pair2.first).intValue(), (s2.c0) pair2.second, this.f4955y);
                break;
        }
    }
}
