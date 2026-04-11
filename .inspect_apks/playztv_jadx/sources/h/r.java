package h;

import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import q0.o0;
import q0.t0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5556u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ b0 f5557v;

    public /* synthetic */ r(b0 b0Var, int i) {
        this.f5556u = i;
        this.f5557v = b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        switch (this.f5556u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b0 b0Var = this.f5557v;
                if ((b0Var.f5434u0 & 1) != 0) {
                    b0Var.w(0);
                }
                if ((b0Var.f5434u0 & 4096) != 0) {
                    b0Var.w(108);
                }
                b0Var.f5433t0 = false;
                b0Var.f5434u0 = 0;
                break;
            default:
                b0 b0Var2 = this.f5557v;
                b0Var2.Q.showAtLocation(b0Var2.P, 55, 0, 0);
                t0 t0Var = b0Var2.S;
                if (t0Var != null) {
                    t0Var.b();
                }
                if (b0Var2.U && (viewGroup = b0Var2.V) != null && viewGroup.isLaidOut()) {
                    b0Var2.P.setAlpha(0.0f);
                    t0 t0VarA = o0.a(b0Var2.P);
                    t0VarA.a(1.0f);
                    b0Var2.S = t0VarA;
                    t0VarA.d(new s(0, this));
                } else {
                    b0Var2.P.setAlpha(1.0f);
                    b0Var2.P.setVisibility(0);
                }
                break;
        }
    }
}
