package f9;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z1 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4512v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f4513w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f4514x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f4515y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f4516z;

    public /* synthetic */ z1(a2 a2Var, Bundle bundle, String str, w4 w4Var) {
        this.f4512v = 2;
        this.f4514x = a2Var;
        this.f4515y = bundle;
        this.f4513w = str;
        this.f4516z = w4Var;
    }

    private final void a() {
        i0 i0Var;
        t3 t3Var = (t3) this.f4514x;
        AtomicReference atomicReference = (AtomicReference) this.f4513w;
        w4 w4Var = (w4) this.f4516z;
        j4 j4Var = (j4) this.f4515y;
        synchronized (atomicReference) {
            try {
                i0Var = t3Var.f4420z;
            } catch (RemoteException e9) {
                w0 w0Var = ((r1) t3Var.f307w).A;
                r1.g(w0Var);
                w0Var.B.b(e9, "[sgtm] Failed to get upload batches; remote exception");
                atomicReference.notifyAll();
            }
            if (i0Var != null) {
                i0Var.z(w4Var, j4Var, new m3(t3Var, atomicReference));
                t3Var.z1();
            } else {
                w0 w0Var2 = ((r1) t3Var.f307w).A;
                r1.g(w0Var2);
                w0Var2.B.a("[sgtm] Failed to get upload batches; not connected to service");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03c4  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.z1.run():void");
    }

    public /* synthetic */ z1(t3 t3Var, AtomicReference atomicReference, w4 w4Var, j4 j4Var) {
        this.f4512v = 7;
        this.f4514x = t3Var;
        this.f4513w = atomicReference;
        this.f4516z = w4Var;
        this.f4515y = j4Var;
    }

    public /* synthetic */ z1(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f4512v = i;
        this.f4514x = obj;
        this.f4513w = obj2;
        this.f4515y = obj3;
        this.f4516z = obj4;
    }

    public /* synthetic */ z1(Object obj, Object obj2, Object obj3, Object obj4, int i, boolean z10) {
        this.f4512v = i;
        this.f4514x = obj2;
        this.f4513w = obj3;
        this.f4515y = obj4;
        this.f4516z = obj;
    }

    public z1(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.l0 l0Var, v vVar, String str) {
        this.f4512v = 1;
        this.f4514x = l0Var;
        this.f4515y = vVar;
        this.f4513w = str;
        this.f4516z = appMeasurementDynamiteService;
    }

    public z1(x2 x2Var, AtomicReference atomicReference, String str, String str2) {
        this.f4512v = 3;
        this.f4514x = atomicReference;
        this.f4513w = str;
        this.f4515y = str2;
        Objects.requireNonNull(x2Var);
        this.f4516z = x2Var;
    }

    public z1(p6.d dVar, String str, String str2, Bundle bundle) {
        this.f4512v = 8;
        this.f4513w = str;
        this.f4514x = str2;
        this.f4515y = bundle;
        this.f4516z = dVar;
    }
}
