package k8;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b3 implements Runnable {
    public final /* synthetic */ Object A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7095u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ String f7096v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ String f7097w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ a4 f7098x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ boolean f7099y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ z2 f7100z;

    public b3(z2 z2Var, String str, String str2, a4 a4Var, boolean z2, com.google.android.gms.internal.measurement.w0 w0Var) {
        this.f7096v = str;
        this.f7097w = str2;
        this.f7098x = a4Var;
        this.f7099y = z2;
        this.A = w0Var;
        this.f7100z = z2Var;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00e7 -> B:51:0x00ee). Please report as a decompilation issue!!! */
    @Override // java.lang.Runnable
    public final void run() {
        z2 z2Var;
        h0 h0Var;
        switch (this.f7095u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a4 a4Var = this.f7098x;
                String str = this.f7097w;
                String str2 = this.f7096v;
                com.google.android.gms.internal.measurement.w0 w0Var = (com.google.android.gms.internal.measurement.w0) this.A;
                z2 z2Var2 = this.f7100z;
                Bundle bundle = new Bundle();
                try {
                    h0 h0Var2 = z2Var2.f7573y;
                    if (h0Var2 == null) {
                        z2Var2.g().A.b(str2, str, "Failed to get user properties; not connected to service");
                    } else {
                        bundle = h4.B1(h0Var2.r(str2, str, this.f7099y, a4Var));
                        z2Var2.H1();
                        z2Var2.o1().L1(w0Var, bundle);
                    }
                } catch (RemoteException e10) {
                    z2Var2.g().A.b(str2, e10, "Failed to get user properties; remote exception");
                } finally {
                    z2Var2.o1().L1(w0Var, bundle);
                }
                return;
            default:
                synchronized (((AtomicReference) this.A)) {
                    try {
                        try {
                            z2Var = this.f7100z;
                            h0Var = z2Var.f7573y;
                        } catch (RemoteException e11) {
                            this.f7100z.g().A.e("(legacy) Failed to get user properties; remote exception", null, this.f7096v, e11);
                            ((AtomicReference) this.A).set(Collections.EMPTY_LIST);
                        }
                        if (h0Var == null) {
                            z2Var.g().A.e("(legacy) Failed to get user properties; not connected to service", null, this.f7096v, this.f7097w);
                            ((AtomicReference) this.A).set(Collections.EMPTY_LIST);
                            return;
                        }
                        if (TextUtils.isEmpty(null)) {
                            ((AtomicReference) this.A).set(h0Var.r(this.f7096v, this.f7097w, this.f7099y, this.f7098x));
                        } else {
                            ((AtomicReference) this.A).set(h0Var.p(null, this.f7096v, this.f7097w, this.f7099y));
                        }
                        this.f7100z.H1();
                        ((AtomicReference) this.A).notify();
                        return;
                    } finally {
                        ((AtomicReference) this.A).notify();
                    }
                }
        }
    }

    public b3(z2 z2Var, AtomicReference atomicReference, String str, String str2, a4 a4Var, boolean z2) {
        this.A = atomicReference;
        this.f7096v = str;
        this.f7097w = str2;
        this.f7098x = a4Var;
        this.f7099y = z2;
        this.f7100z = z2Var;
    }
}
