package g4;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o0 implements c1, d1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5146u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ f1 f5147v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f5148w;

    public /* synthetic */ o0(f1 f1Var, int i, int i10) {
        this.f5146u = i10;
        this.f5147v = f1Var;
        this.f5148w = i;
    }

    @Override // g4.d1
    public void b(j1 j1Var, s sVar, List list) {
        switch (this.f5146u) {
            case 1:
                j1Var.v(this.f5147v.H(sVar, j1Var, this.f5148w), list);
                break;
            case 2:
                f1 f1Var = this.f5147v;
                f1Var.getClass();
                int size = list.size();
                int i = this.f5148w;
                if (size != 1) {
                    j1Var.t0(f1Var.H(sVar, j1Var, i), f1Var.H(sVar, j1Var, i + 1), list);
                } else {
                    j1Var.U0(f1Var.H(sVar, j1Var, i), (p1.g0) list.get(0));
                }
                break;
            default:
                j1Var.v(this.f5147v.H(sVar, j1Var, this.f5148w), list);
                break;
        }
    }

    @Override // g4.c1
    public void j(j1 j1Var, s sVar) {
        switch (this.f5146u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j1Var.p(this.f5147v.H(sVar, j1Var, this.f5148w));
                break;
            default:
                j1Var.A0(this.f5147v.H(sVar, j1Var, this.f5148w));
                break;
        }
    }
}
