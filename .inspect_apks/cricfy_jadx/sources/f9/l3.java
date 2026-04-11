package f9;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l3 extends com.google.android.gms.internal.measurement.x implements k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4264d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l3(t3 t3Var, AtomicReference atomicReference) {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
        this.f4264d = atomicReference;
    }

    @Override // f9.k0
    public final void E(List list) {
        AtomicReference atomicReference = this.f4264d;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.measurement.x
    public final boolean b(int i, Parcel parcel, Parcel parcel2) {
        if (i != 2) {
            return false;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(f4.CREATOR);
        com.google.android.gms.internal.measurement.y.d(parcel);
        E(arrayListCreateTypedArrayList);
        return true;
    }
}
