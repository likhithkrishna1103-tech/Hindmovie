package f9;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4467v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ long f4468w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ d0 f4469x;

    public x(y yVar, long j4) {
        this.f4468w = j4;
        Objects.requireNonNull(yVar);
        this.f4469x = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4467v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((y) this.f4469x).s1(this.f4468w);
                break;
            default:
                j3 j3Var = (j3) this.f4469x;
                y yVar = ((r1) j3Var.f307w).I;
                r1.d(yVar);
                yVar.p1(this.f4468w);
                j3Var.A = null;
                break;
        }
    }

    public x(j3 j3Var, long j4) {
        this.f4468w = j4;
        Objects.requireNonNull(j3Var);
        this.f4469x = j3Var;
    }
}
