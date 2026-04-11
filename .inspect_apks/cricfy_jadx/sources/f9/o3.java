package f9;

import android.os.RemoteException;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o3 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4309v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ w4 f4310w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ t3 f4311x;

    public /* synthetic */ o3(t3 t3Var, w4 w4Var, int i) {
        this.f4309v = i;
        this.f4310w = w4Var;
        this.f4311x = t3Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f4309v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                t3 t3Var = this.f4311x;
                i0 i0Var = t3Var.f4420z;
                r1 r1Var = (r1) t3Var.f307w;
                if (i0Var != null) {
                    try {
                        i0Var.o(this.f4310w);
                    } catch (RemoteException e9) {
                        w0 w0Var = r1Var.A;
                        r1.g(w0Var);
                        w0Var.B.b(e9, "Failed to reset data on the service: remote exception");
                    }
                    t3Var.z1();
                } else {
                    w0 w0Var2 = r1Var.A;
                    r1.g(w0Var2);
                    w0Var2.B.a("Failed to reset data on the service: not connected to service");
                }
                break;
            case 1:
                t3 t3Var2 = this.f4311x;
                i0 i0Var2 = t3Var2.f4420z;
                r1 r1Var2 = (r1) t3Var2.f307w;
                if (i0Var2 == null) {
                    w0 w0Var3 = r1Var2.A;
                    r1.g(w0Var3);
                    w0Var3.B.a("Discarding data. Failed to send app launch");
                } else {
                    try {
                        w4 w4Var = this.f4310w;
                        g gVar = r1Var2.f4366y;
                        e0 e0Var = f0.c1;
                        if (gVar.w1(null, e0Var)) {
                            t3Var2.E1(i0Var2, null, w4Var);
                        }
                        i0Var2.G(w4Var);
                        r1Var2.i().r1();
                        r1Var2.f4366y.w1(null, e0Var);
                        t3Var2.E1(i0Var2, null, w4Var);
                        t3Var2.z1();
                    } catch (RemoteException e10) {
                        w0 w0Var4 = r1Var2.A;
                        r1.g(w0Var4);
                        w0Var4.B.b(e10, "Failed to send app launch to the service");
                        return;
                    }
                }
                break;
            case 2:
                t3 t3Var3 = this.f4311x;
                i0 i0Var3 = t3Var3.f4420z;
                r1 r1Var3 = (r1) t3Var3.f307w;
                if (i0Var3 == null) {
                    w0 w0Var5 = r1Var3.A;
                    r1.g(w0Var5);
                    w0Var5.E.a("Failed to send app backgrounded");
                } else {
                    try {
                        i0Var3.m(this.f4310w);
                        t3Var3.z1();
                    } catch (RemoteException e11) {
                        w0 w0Var6 = r1Var3.A;
                        r1.g(w0Var6);
                        w0Var6.B.b(e11, "Failed to send app backgrounded to the service");
                        return;
                    }
                }
                break;
            case 3:
                t3 t3Var4 = this.f4311x;
                i0 i0Var4 = t3Var4.f4420z;
                r1 r1Var4 = (r1) t3Var4.f307w;
                if (i0Var4 == null) {
                    w0 w0Var7 = r1Var4.A;
                    r1.g(w0Var7);
                    w0Var7.B.a("Failed to send measurementEnabled to service");
                } else {
                    try {
                        i0Var4.q(this.f4310w);
                        t3Var4.z1();
                    } catch (RemoteException e12) {
                        w0 w0Var8 = r1Var4.A;
                        r1.g(w0Var8);
                        w0Var8.B.b(e12, "Failed to send measurementEnabled to the service");
                        return;
                    }
                }
                break;
            default:
                t3 t3Var5 = this.f4311x;
                i0 i0Var5 = t3Var5.f4420z;
                r1 r1Var5 = (r1) t3Var5.f307w;
                if (i0Var5 == null) {
                    w0 w0Var9 = r1Var5.A;
                    r1.g(w0Var9);
                    w0Var9.B.a("Failed to send consent settings to service");
                } else {
                    try {
                        i0Var5.s(this.f4310w);
                        t3Var5.z1();
                    } catch (RemoteException e13) {
                        w0 w0Var10 = r1Var5.A;
                        r1.g(w0Var10);
                        w0Var10.B.b(e13, "Failed to send consent settings to the service");
                    }
                }
                break;
        }
    }

    public o3(t3 t3Var, w4 w4Var) {
        this.f4309v = 4;
        this.f4310w = w4Var;
        Objects.requireNonNull(t3Var);
        this.f4311x = t3Var;
    }
}
