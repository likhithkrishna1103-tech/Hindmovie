package k8;

import android.os.RemoteException;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d3 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7136u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ a4 f7137v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ z2 f7138w;

    public /* synthetic */ d3(z2 z2Var, a4 a4Var, int i) {
        this.f7136u = i;
        this.f7137v = a4Var;
        this.f7138w = z2Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f7136u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a4 a4Var = this.f7137v;
                z2 z2Var = this.f7138w;
                h0 h0Var = z2Var.f7573y;
                if (h0Var != null) {
                    try {
                        h0Var.x(a4Var);
                    } catch (RemoteException e10) {
                        z2Var.g().A.c(e10, "Failed to reset data on the service: remote exception");
                    }
                    z2Var.H1();
                } else {
                    z2Var.g().A.d("Failed to reset data on the service: not connected to service");
                }
                break;
            case 1:
                a4 a4Var2 = this.f7137v;
                z2 z2Var2 = this.f7138w;
                h0 h0Var2 = z2Var2.f7573y;
                if (h0Var2 == null) {
                    z2Var2.g().A.d("Discarding data. Failed to send app launch");
                } else {
                    try {
                        h0Var2.z(a4Var2);
                        ((k1) z2Var2.f2454v).n().z1();
                        z2Var2.z1(h0Var2, null, a4Var2);
                        z2Var2.H1();
                    } catch (RemoteException e11) {
                        z2Var2.g().A.c(e11, "Failed to send app launch to the service");
                        return;
                    }
                }
                break;
            case 2:
                a4 a4Var3 = this.f7137v;
                z2 z2Var3 = this.f7138w;
                h0 h0Var3 = z2Var3.f7573y;
                if (h0Var3 == null) {
                    z2Var3.g().D.d("Failed to send app backgrounded");
                } else {
                    try {
                        h0Var3.F(a4Var3);
                        z2Var3.H1();
                    } catch (RemoteException e12) {
                        z2Var3.g().A.c(e12, "Failed to send app backgrounded to the service");
                        return;
                    }
                }
                break;
            case 3:
                a4 a4Var4 = this.f7137v;
                z2 z2Var4 = this.f7138w;
                h0 h0Var4 = z2Var4.f7573y;
                if (h0Var4 == null) {
                    z2Var4.g().A.d("Failed to send measurementEnabled to service");
                } else {
                    try {
                        h0Var4.y(a4Var4);
                        z2Var4.H1();
                    } catch (RemoteException e13) {
                        z2Var4.g().A.c(e13, "Failed to send measurementEnabled to the service");
                        return;
                    }
                }
                break;
            default:
                a4 a4Var5 = this.f7137v;
                z2 z2Var5 = this.f7138w;
                h0 h0Var5 = z2Var5.f7573y;
                if (h0Var5 == null) {
                    z2Var5.g().A.d("Failed to send consent settings to service");
                } else {
                    try {
                        h0Var5.i(a4Var5);
                        z2Var5.H1();
                    } catch (RemoteException e14) {
                        z2Var5.g().A.c(e14, "Failed to send consent settings to the service");
                    }
                }
                break;
        }
    }
}
