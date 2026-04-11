package k8;

import android.os.SystemClock;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p3 extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f7375e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p3(Object obj, w1 w1Var, int i) {
        super(w1Var);
        this.f7375e = i;
        this.f = obj;
    }

    @Override // k8.n
    public final void c() {
        switch (this.f7375e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                o3 o3Var = (o3) this.f;
                k3 k3Var = (k3) o3Var.f7359x;
                k3Var.p1();
                k1 k1Var = (k1) k3Var.f2454v;
                k1Var.H.getClass();
                o3Var.a(SystemClock.elapsedRealtime(), false, false);
                q qVarK = k1Var.k();
                k1Var.H.getClass();
                qVarK.t1(SystemClock.elapsedRealtime());
                break;
            default:
                s3 s3Var = (s3) this.f;
                s3Var.w1();
                s3Var.g().I.d("Starting upload from DelayedRunnable");
                s3Var.f7443w.f0();
                break;
        }
    }
}
