package f9;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s2 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4395v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ g2 f4396w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ long f4397x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ boolean f4398y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ x2 f4399z;

    public /* synthetic */ s2(x2 x2Var, g2 g2Var, long j4, boolean z10, int i) {
        this.f4395v = i;
        this.f4396w = g2Var;
        this.f4397x = j4;
        this.f4398y = z10;
        this.f4399z = x2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4395v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x2 x2Var = this.f4399z;
                g2 g2Var = this.f4396w;
                x2Var.q1(g2Var);
                x2Var.C1(g2Var, this.f4397x, this.f4398y);
                break;
            default:
                x2 x2Var2 = this.f4399z;
                g2 g2Var2 = this.f4396w;
                x2Var2.q1(g2Var2);
                x2Var2.C1(g2Var2, this.f4397x, this.f4398y);
                break;
        }
    }
}
