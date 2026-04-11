package k8;

import android.os.RemoteException;
import android.text.TextUtils;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e3 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7157u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ String f7158v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ String f7159w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ a4 f7160x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ z2 f7161y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f7162z;

    public e3(z2 z2Var, String str, String str2, a4 a4Var, com.google.android.gms.internal.measurement.w0 w0Var) {
        this.f7158v = str;
        this.f7159w = str2;
        this.f7160x = a4Var;
        this.f7162z = w0Var;
        this.f7161y = z2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z2 z2Var;
        h0 h0Var;
        switch (this.f7157u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                synchronized (((AtomicReference) this.f7162z)) {
                    try {
                        try {
                            z2Var = this.f7161y;
                            h0Var = z2Var.f7573y;
                        } catch (RemoteException e10) {
                            this.f7161y.g().A.e("(legacy) Failed to get conditional properties; remote exception", null, this.f7158v, e10);
                            ((AtomicReference) this.f7162z).set(Collections.EMPTY_LIST);
                        }
                        if (h0Var == null) {
                            z2Var.g().A.e("(legacy) Failed to get conditional properties; not connected to service", null, this.f7158v, this.f7159w);
                            ((AtomicReference) this.f7162z).set(Collections.EMPTY_LIST);
                            return;
                        }
                        if (TextUtils.isEmpty(null)) {
                            ((AtomicReference) this.f7162z).set(h0Var.t(this.f7158v, this.f7159w, this.f7160x));
                        } else {
                            ((AtomicReference) this.f7162z).set(h0Var.D(null, this.f7158v, this.f7159w));
                        }
                        this.f7161y.H1();
                        ((AtomicReference) this.f7162z).notify();
                        return;
                    } finally {
                        ((AtomicReference) this.f7162z).notify();
                    }
                }
            default:
                a4 a4Var = this.f7160x;
                String str = this.f7159w;
                String str2 = this.f7158v;
                com.google.android.gms.internal.measurement.w0 w0Var = (com.google.android.gms.internal.measurement.w0) this.f7162z;
                z2 z2Var2 = this.f7161y;
                ArrayList arrayList = new ArrayList();
                try {
                    h0 h0Var2 = z2Var2.f7573y;
                    if (h0Var2 == null) {
                        z2Var2.g().A.b(str2, str, "Failed to get conditional properties; not connected to service");
                    } else {
                        arrayList = h4.k2(h0Var2.t(str2, str, a4Var));
                        z2Var2.H1();
                        z2Var2.o1().M1(w0Var, arrayList);
                    }
                    return;
                } catch (RemoteException e11) {
                    z2Var2.g().A.e("Failed to get conditional properties; remote exception", str2, str, e11);
                    return;
                } finally {
                    z2Var2.o1().M1(w0Var, arrayList);
                }
        }
    }

    public e3(z2 z2Var, AtomicReference atomicReference, String str, String str2, a4 a4Var) {
        this.f7162z = atomicReference;
        this.f7158v = str;
        this.f7159w = str2;
        this.f7160x = a4Var;
        this.f7161y = z2Var;
    }
}
