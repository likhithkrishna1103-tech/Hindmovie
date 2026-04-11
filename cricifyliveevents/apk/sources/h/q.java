package h;

import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import t0.q0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5399v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ a0 f5400w;

    public /* synthetic */ q(a0 a0Var, int i) {
        this.f5399v = i;
        this.f5400w = a0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        switch (this.f5399v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a0 a0Var = this.f5400w;
                if ((a0Var.f5281u0 & 1) != 0) {
                    a0Var.u(0);
                }
                if ((a0Var.f5281u0 & 4096) != 0) {
                    a0Var.u(108);
                }
                a0Var.f5280t0 = false;
                a0Var.f5281u0 = 0;
                break;
            default:
                a0 a0Var2 = this.f5400w;
                a0Var2.R.showAtLocation(a0Var2.Q, 55, 0, 0);
                q0 q0Var = a0Var2.T;
                if (q0Var != null) {
                    q0Var.b();
                }
                if (a0Var2.U && (viewGroup = a0Var2.V) != null && viewGroup.isLaidOut()) {
                    a0Var2.Q.setAlpha(0.0f);
                    q0 q0VarA = t0.m0.a(a0Var2.Q);
                    q0VarA.a(1.0f);
                    a0Var2.T = q0VarA;
                    q0VarA.d(new s(0, this));
                } else {
                    a0Var2.Q.setAlpha(1.0f);
                    a0Var2.Q.setVisibility(0);
                }
                break;
        }
    }
}
