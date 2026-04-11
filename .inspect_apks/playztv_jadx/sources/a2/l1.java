package a2;

import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l1 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f313u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ q1 f314v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Pair f315w;

    public /* synthetic */ l1(q1 q1Var, Pair pair, int i) {
        this.f313u = i;
        this.f314v = q1Var;
        this.f315w = pair;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f313u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b2.h hVar = (b2.h) this.f314v.f389v.i;
                Pair pair = this.f315w;
                hVar.D(((Integer) pair.first).intValue(), (o2.d0) pair.second);
                break;
            case 1:
                b2.h hVar2 = (b2.h) this.f314v.f389v.i;
                Pair pair2 = this.f315w;
                hVar2.r(((Integer) pair2.first).intValue(), (o2.d0) pair2.second);
                break;
            default:
                b2.h hVar3 = (b2.h) this.f314v.f389v.i;
                Pair pair3 = this.f315w;
                hVar3.Q(((Integer) pair3.first).intValue(), (o2.d0) pair3.second);
                break;
        }
    }
}
