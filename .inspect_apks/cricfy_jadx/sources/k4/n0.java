package k4;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n0 implements a1, b1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7091v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ d1 f7092w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f7093x;

    public /* synthetic */ n0(d1 d1Var, int i, int i10) {
        this.f7091v = i10;
        this.f7092w = d1Var;
        this.f7093x = i;
    }

    @Override // k4.b1
    public void b(h1 h1Var, s sVar, List list) {
        switch (this.f7091v) {
            case 1:
                h1Var.t(this.f7092w.N(sVar, h1Var, this.f7093x), list);
                break;
            case 2:
                d1 d1Var = this.f7092w;
                d1Var.getClass();
                int size = list.size();
                int i = this.f7093x;
                if (size != 1) {
                    h1Var.s0(d1Var.N(sVar, h1Var, i), d1Var.N(sVar, h1Var, i + 1), list);
                } else {
                    h1Var.I(d1Var.N(sVar, h1Var, i), (v1.g0) list.get(0));
                }
                break;
            default:
                h1Var.t(this.f7092w.N(sVar, h1Var, this.f7093x), list);
                break;
        }
    }

    @Override // k4.a1
    public void h(h1 h1Var, s sVar) {
        switch (this.f7091v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h1Var.m(this.f7092w.N(sVar, h1Var, this.f7093x));
                break;
            default:
                h1Var.z0(this.f7092w.N(sVar, h1Var, this.f7093x));
                break;
        }
    }
}
