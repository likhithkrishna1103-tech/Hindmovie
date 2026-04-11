package f9;

import android.os.RemoteException;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r3 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4371v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ t3 f4372w;

    public /* synthetic */ r3(t3 t3Var, int i) {
        this.f4371v = i;
        this.f4372w = t3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4371v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f4372w.s1();
                break;
            case 1:
                t3 t3Var = this.f4372w;
                r1 r1Var = (r1) t3Var.f307w;
                i0 i0Var = t3Var.f4420z;
                if (i0Var == null) {
                    w0 w0Var = r1Var.A;
                    r1.g(w0Var);
                    w0Var.B.a("Failed to send Dma consent settings to service");
                } else {
                    try {
                        i0Var.p(t3Var.C1(false));
                        t3Var.z1();
                    } catch (RemoteException e9) {
                        w0 w0Var2 = r1Var.A;
                        r1.g(w0Var2);
                        w0Var2.B.b(e9, "Failed to send Dma consent settings to the service");
                        return;
                    }
                }
                break;
            default:
                t3 t3Var2 = this.f4372w;
                r1 r1Var2 = (r1) t3Var2.f307w;
                i0 i0Var2 = t3Var2.f4420z;
                if (i0Var2 == null) {
                    w0 w0Var3 = r1Var2.A;
                    r1.g(w0Var3);
                    w0Var3.B.a("Failed to send storage consent settings to service");
                } else {
                    try {
                        i0Var2.h(t3Var2.C1(false));
                        t3Var2.z1();
                    } catch (RemoteException e10) {
                        w0 w0Var4 = r1Var2.A;
                        r1.g(w0Var4);
                        w0Var4.B.b(e10, "Failed to send storage consent settings to the service");
                    }
                }
                break;
        }
    }
}
