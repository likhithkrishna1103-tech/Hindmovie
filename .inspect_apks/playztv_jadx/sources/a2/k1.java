package a2;

import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k1 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f301u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ q1 f302v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Pair f303w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ o2.z f304x;

    public /* synthetic */ k1(q1 q1Var, Pair pair, o2.z zVar, int i) {
        this.f301u = i;
        this.f302v = q1Var;
        this.f303w = pair;
        this.f304x = zVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f301u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b2.h hVar = (b2.h) this.f302v.f389v.i;
                Pair pair = this.f303w;
                int iIntValue = ((Integer) pair.first).intValue();
                o2.d0 d0Var = (o2.d0) pair.second;
                d0Var.getClass();
                hVar.g(iIntValue, d0Var, this.f304x);
                break;
            default:
                b2.h hVar2 = (b2.h) this.f302v.f389v.i;
                Pair pair2 = this.f303w;
                hVar2.l(((Integer) pair2.first).intValue(), (o2.d0) pair2.second, this.f304x);
                break;
        }
    }
}
