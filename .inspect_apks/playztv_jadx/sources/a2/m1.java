package a2;

import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m1 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f326u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ q1 f327v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Pair f328w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ o2.u f329x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ o2.z f330y;

    public /* synthetic */ m1(q1 q1Var, Pair pair, o2.u uVar, o2.z zVar, int i) {
        this.f326u = i;
        this.f327v = q1Var;
        this.f328w = pair;
        this.f329x = uVar;
        this.f330y = zVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f326u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b2.h hVar = (b2.h) this.f327v.f389v.i;
                Pair pair = this.f328w;
                hVar.c(((Integer) pair.first).intValue(), (o2.d0) pair.second, this.f329x, this.f330y);
                break;
            default:
                b2.h hVar2 = (b2.h) this.f327v.f389v.i;
                Pair pair2 = this.f328w;
                hVar2.I(((Integer) pair2.first).intValue(), (o2.d0) pair2.second, this.f329x, this.f330y);
                break;
        }
    }
}
