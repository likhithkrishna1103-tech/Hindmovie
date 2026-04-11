package f9;

import android.os.Parcel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m3 extends com.google.android.gms.internal.measurement.x implements m0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ t3 f4273e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m3(t3 t3Var, AtomicReference atomicReference) {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
        this.f4272d = atomicReference;
        this.f4273e = t3Var;
    }

    @Override // com.google.android.gms.internal.measurement.x
    public final boolean b(int i, Parcel parcel, Parcel parcel2) {
        if (i != 2) {
            return false;
        }
        k4 k4Var = (k4) com.google.android.gms.internal.measurement.y.a(parcel, k4.CREATOR);
        com.google.android.gms.internal.measurement.y.d(parcel);
        j(k4Var);
        return true;
    }

    @Override // f9.m0
    public final void j(k4 k4Var) {
        AtomicReference atomicReference = this.f4272d;
        synchronized (atomicReference) {
            w0 w0Var = ((r1) this.f4273e.f307w).A;
            r1.g(w0Var);
            w0Var.J.b(Integer.valueOf(k4Var.f4258v.size()), "[sgtm] Got upload batches from service. count");
            atomicReference.set(k4Var);
            atomicReference.notifyAll();
        }
    }
}
