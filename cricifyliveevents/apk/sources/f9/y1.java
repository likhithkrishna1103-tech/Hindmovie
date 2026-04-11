package f9;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y1 implements Runnable {
    public final /* synthetic */ Object A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4494v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ String f4495w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ w4 f4496x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f4497y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f4498z;

    public /* synthetic */ y1(a2 a2Var, w4 w4Var, Bundle bundle, k0 k0Var, String str) {
        this.f4497y = a2Var;
        this.f4496x = w4Var;
        this.f4498z = bundle;
        this.A = k0Var;
        this.f4495w = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        t3 t3Var;
        i0 i0Var;
        u4 u4Var;
        i0 i0Var2;
        switch (this.f4494v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a2 a2Var = (a2) this.f4497y;
                w4 w4Var = this.f4496x;
                Bundle bundle = (Bundle) this.f4498z;
                k0 k0Var = (k0) this.A;
                String str = this.f4495w;
                q4 q4Var = a2Var.f4001d;
                q4Var.w();
                try {
                    k0Var.E(q4Var.Y(bundle, w4Var));
                    return;
                } catch (RemoteException e9) {
                    q4Var.C().B.c(str, e9, "Failed to return trigger URIs for app");
                    return;
                }
            case 1:
                AtomicReference atomicReference2 = (AtomicReference) this.f4497y;
                synchronized (atomicReference2) {
                    try {
                        try {
                            t3Var = (t3) this.A;
                            i0Var = t3Var.f4420z;
                        } catch (RemoteException e10) {
                            w0 w0Var = ((r1) ((t3) this.A).f307w).A;
                            r1.g(w0Var);
                            w0Var.B.d("(legacy) Failed to get conditional properties; remote exception", null, this.f4495w, e10);
                            ((AtomicReference) this.f4497y).set(Collections.EMPTY_LIST);
                            atomicReference = (AtomicReference) this.f4497y;
                        }
                        if (i0Var == null) {
                            w0 w0Var2 = ((r1) t3Var.f307w).A;
                            r1.g(w0Var2);
                            w0Var2.B.d("(legacy) Failed to get conditional properties; not connected to service", null, this.f4495w, (String) this.f4498z);
                            atomicReference2.set(Collections.EMPTY_LIST);
                            atomicReference2.notify();
                            return;
                        }
                        if (TextUtils.isEmpty(null)) {
                            atomicReference2.set(i0Var.n(this.f4495w, (String) this.f4498z, this.f4496x));
                        } else {
                            atomicReference2.set(i0Var.B(null, this.f4495w, (String) this.f4498z));
                        }
                        t3Var.z1();
                        atomicReference = (AtomicReference) this.f4497y;
                        atomicReference.notify();
                        return;
                    } catch (Throwable th) {
                        ((AtomicReference) this.f4497y).notify();
                        throw th;
                    }
                }
            default:
                com.google.android.gms.internal.measurement.l0 l0Var = (com.google.android.gms.internal.measurement.l0) this.f4498z;
                String str2 = (String) this.f4497y;
                String str3 = this.f4495w;
                t3 t3Var2 = (t3) this.A;
                ArrayList arrayList = new ArrayList();
                try {
                    try {
                        i0Var2 = t3Var2.f4420z;
                    } catch (Throwable th2) {
                        u4 u4Var2 = ((r1) t3Var2.f307w).D;
                        r1.e(u4Var2);
                        u4Var2.b2(l0Var, arrayList);
                        throw th2;
                    }
                } catch (RemoteException e11) {
                    w0 w0Var3 = ((r1) t3Var2.f307w).A;
                    r1.g(w0Var3);
                    w0Var3.B.d("Failed to get conditional properties; remote exception", str3, str2, e11);
                }
                if (i0Var2 != null) {
                    arrayList = u4.c2(i0Var2.n(str3, str2, this.f4496x));
                    t3Var2.z1();
                    u4Var = ((r1) t3Var2.f307w).D;
                    r1.e(u4Var);
                    u4Var.b2(l0Var, arrayList);
                    return;
                }
                r1 r1Var = (r1) t3Var2.f307w;
                w0 w0Var4 = r1Var.A;
                r1.g(w0Var4);
                w0Var4.B.c(str3, str2, "Failed to get conditional properties; not connected to service");
                u4Var = r1Var.D;
                r1.e(u4Var);
                u4Var.b2(l0Var, arrayList);
                return;
        }
    }

    public y1(t3 t3Var, String str, String str2, w4 w4Var, com.google.android.gms.internal.measurement.l0 l0Var) {
        this.f4495w = str;
        this.f4497y = str2;
        this.f4496x = w4Var;
        this.f4498z = l0Var;
        this.A = t3Var;
    }

    public y1(t3 t3Var, AtomicReference atomicReference, String str, String str2, w4 w4Var) {
        this.f4497y = atomicReference;
        this.f4495w = str;
        this.f4498z = str2;
        this.f4496x = w4Var;
        this.A = t3Var;
    }
}
