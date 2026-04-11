package k8;

import android.os.RemoteException;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y2 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7560u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public /* synthetic */ z2 f7561v;

    public /* synthetic */ y2(int i) {
        this.f7560u = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7560u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z2 z2Var = this.f7561v;
                h0 h0Var = z2Var.f7573y;
                if (h0Var == null) {
                    z2Var.g().A.d("Failed to send storage consent settings to service");
                } else {
                    try {
                        h0Var.o(z2Var.I1(false));
                        z2Var.H1();
                    } catch (RemoteException e10) {
                        z2Var.g().A.c(e10, "Failed to send storage consent settings to the service");
                        return;
                    }
                }
                break;
            default:
                z2 z2Var2 = this.f7561v;
                h0 h0Var2 = z2Var2.f7573y;
                if (h0Var2 == null) {
                    z2Var2.g().A.d("Failed to send Dma consent settings to service");
                } else {
                    try {
                        h0Var2.A(z2Var2.I1(false));
                        z2Var2.H1();
                    } catch (RemoteException e11) {
                        z2Var2.g().A.c(e11, "Failed to send Dma consent settings to the service");
                    }
                }
                break;
        }
    }
}
