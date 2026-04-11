package f9;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k3 implements Runnable {
    public final /* synthetic */ t3 A;
    public final /* synthetic */ Object B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4253v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ String f4254w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ String f4255x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ w4 f4256y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ boolean f4257z;

    public k3(t3 t3Var, String str, String str2, w4 w4Var, boolean z10, com.google.android.gms.internal.measurement.l0 l0Var) {
        this.f4254w = str;
        this.f4255x = str2;
        this.f4256y = w4Var;
        this.f4257z = z10;
        this.B = l0Var;
        this.A = t3Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        u4 u4Var;
        i0 i0Var;
        r1 r1Var;
        AtomicReference atomicReference;
        t3 t3Var;
        i0 i0Var2;
        switch (this.f4253v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = this.f4255x;
                String str2 = this.f4254w;
                com.google.android.gms.internal.measurement.l0 l0Var = (com.google.android.gms.internal.measurement.l0) this.B;
                t3 t3Var2 = this.A;
                Bundle bundle = new Bundle();
                try {
                    try {
                        i0Var = t3Var2.f4420z;
                        r1Var = (r1) t3Var2.f307w;
                    } catch (RemoteException e9) {
                        e = e9;
                    }
                    if (i0Var == null) {
                        w0 w0Var = r1Var.A;
                        r1.g(w0Var);
                        w0Var.B.c(str2, str, "Failed to get user properties; not connected to service");
                        u4Var = r1Var.D;
                        r1.e(u4Var);
                        u4Var.a2(l0Var, bundle);
                        return;
                    }
                    List<s4> listK = i0Var.k(str2, str, this.f4257z, this.f4256y);
                    Bundle bundle2 = new Bundle();
                    if (listK != null) {
                        for (s4 s4Var : listK) {
                            String str3 = s4Var.f4407z;
                            String str4 = s4Var.f4404w;
                            if (str3 != null) {
                                bundle2.putString(str4, str3);
                            } else {
                                Long l10 = s4Var.f4406y;
                                if (l10 != null) {
                                    bundle2.putLong(str4, l10.longValue());
                                } else {
                                    Double d10 = s4Var.B;
                                    if (d10 != null) {
                                        bundle2.putDouble(str4, d10.doubleValue());
                                    }
                                }
                            }
                        }
                    }
                    try {
                        t3Var2.z1();
                        u4 u4Var2 = r1Var.D;
                        r1.e(u4Var2);
                        u4Var2.a2(l0Var, bundle2);
                        return;
                    } catch (RemoteException e10) {
                        e = e10;
                        bundle = bundle2;
                        w0 w0Var2 = ((r1) t3Var2.f307w).A;
                        r1.g(w0Var2);
                        w0Var2.B.c(str2, e, "Failed to get user properties; remote exception");
                        u4Var = ((r1) t3Var2.f307w).D;
                        r1.e(u4Var);
                        u4Var.a2(l0Var, bundle);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bundle = bundle2;
                        u4 u4Var3 = ((r1) t3Var2.f307w).D;
                        r1.e(u4Var3);
                        u4Var3.a2(l0Var, bundle);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                break;
            default:
                AtomicReference atomicReference2 = (AtomicReference) this.B;
                synchronized (atomicReference2) {
                    try {
                        try {
                            t3Var = this.A;
                            i0Var2 = t3Var.f4420z;
                        } catch (RemoteException e11) {
                            w0 w0Var3 = ((r1) this.A.f307w).A;
                            r1.g(w0Var3);
                            w0Var3.B.d("(legacy) Failed to get user properties; remote exception", null, this.f4254w, e11);
                            ((AtomicReference) this.B).set(Collections.EMPTY_LIST);
                            atomicReference = (AtomicReference) this.B;
                        }
                        if (i0Var2 == null) {
                            w0 w0Var4 = ((r1) t3Var.f307w).A;
                            r1.g(w0Var4);
                            w0Var4.B.d("(legacy) Failed to get user properties; not connected to service", null, this.f4254w, this.f4255x);
                            atomicReference2.set(Collections.EMPTY_LIST);
                            atomicReference2.notify();
                            return;
                        }
                        if (TextUtils.isEmpty(null)) {
                            atomicReference2.set(i0Var2.k(this.f4254w, this.f4255x, this.f4257z, this.f4256y));
                        } else {
                            atomicReference2.set(i0Var2.i(null, this.f4254w, this.f4255x, this.f4257z));
                        }
                        t3Var.z1();
                        atomicReference = (AtomicReference) this.B;
                        atomicReference.notify();
                        return;
                    } catch (Throwable th3) {
                        ((AtomicReference) this.B).notify();
                        throw th3;
                    }
                }
        }
    }

    public k3(t3 t3Var, AtomicReference atomicReference, String str, String str2, w4 w4Var, boolean z10) {
        this.B = atomicReference;
        this.f4254w = str;
        this.f4255x = str2;
        this.f4256y = w4Var;
        this.f4257z = z10;
        this.A = t3Var;
    }
}
