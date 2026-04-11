package f9;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h3 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4213v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ j3 f4214w;

    public h3(j3 j3Var, int i) {
        this.f4213v = i;
        switch (i) {
            case 1:
                Objects.requireNonNull(j3Var);
                this.f4214w = j3Var;
                break;
            default:
                Objects.requireNonNull(j3Var);
                this.f4214w = j3Var;
                break;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4213v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j3 j3Var = this.f4214w;
                j3Var.A = j3Var.F;
                break;
            default:
                this.f4214w.F = null;
                break;
        }
    }
}
