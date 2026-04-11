package f9;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends a9.a implements i0 {
    public g0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService", 1);
    }

    @Override // f9.i0
    public final i A(w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        Parcel parcelE = e(parcelF, 21);
        i iVar = (i) com.google.android.gms.internal.measurement.y.a(parcelE, i.CREATOR);
        parcelE.recycle();
        return iVar;
    }

    @Override // f9.i0
    public final List B(String str, String str2, String str3) {
        Parcel parcelF = f();
        parcelF.writeString(null);
        parcelF.writeString(str2);
        parcelF.writeString(str3);
        Parcel parcelE = e(parcelF, 17);
        ArrayList arrayListCreateTypedArrayList = parcelE.createTypedArrayList(e.CREATOR);
        parcelE.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // f9.i0
    public final void C(Bundle bundle, w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, bundle);
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        L(parcelF, 19);
    }

    @Override // f9.i0
    public final void D(w4 w4Var, d dVar) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        com.google.android.gms.internal.measurement.y.b(parcelF, dVar);
        L(parcelF, 30);
    }

    @Override // f9.i0
    public final void G(w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        L(parcelF, 4);
    }

    @Override // f9.i0
    public final void H(s4 s4Var, w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, s4Var);
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        L(parcelF, 2);
    }

    @Override // f9.i0
    public final void I(v vVar, w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, vVar);
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        L(parcelF, 1);
    }

    @Override // f9.i0
    public final void K(w4 w4Var, Bundle bundle, k0 k0Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        com.google.android.gms.internal.measurement.y.b(parcelF, bundle);
        com.google.android.gms.internal.measurement.y.c(parcelF, k0Var);
        L(parcelF, 31);
    }

    @Override // f9.i0
    public final void h(w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        L(parcelF, 25);
    }

    @Override // f9.i0
    public final List i(String str, String str2, String str3, boolean z10) {
        Parcel parcelF = f();
        parcelF.writeString(null);
        parcelF.writeString(str2);
        parcelF.writeString(str3);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.y.f2729a;
        parcelF.writeInt(z10 ? 1 : 0);
        Parcel parcelE = e(parcelF, 15);
        ArrayList arrayListCreateTypedArrayList = parcelE.createTypedArrayList(s4.CREATOR);
        parcelE.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // f9.i0
    public final List k(String str, String str2, boolean z10, w4 w4Var) {
        Parcel parcelF = f();
        parcelF.writeString(str);
        parcelF.writeString(str2);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.y.f2729a;
        parcelF.writeInt(z10 ? 1 : 0);
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        Parcel parcelE = e(parcelF, 14);
        ArrayList arrayListCreateTypedArrayList = parcelE.createTypedArrayList(s4.CREATOR);
        parcelE.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // f9.i0
    public final void l(e eVar, w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, eVar);
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        L(parcelF, 12);
    }

    @Override // f9.i0
    public final void m(w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        L(parcelF, 27);
    }

    @Override // f9.i0
    public final List n(String str, String str2, w4 w4Var) {
        Parcel parcelF = f();
        parcelF.writeString(str);
        parcelF.writeString(str2);
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        Parcel parcelE = e(parcelF, 16);
        ArrayList arrayListCreateTypedArrayList = parcelE.createTypedArrayList(e.CREATOR);
        parcelE.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // f9.i0
    public final void o(w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        L(parcelF, 18);
    }

    @Override // f9.i0
    public final void p(w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        L(parcelF, 26);
    }

    @Override // f9.i0
    public final void q(w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        L(parcelF, 6);
    }

    @Override // f9.i0
    public final byte[] r(v vVar, String str) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, vVar);
        parcelF.writeString(str);
        Parcel parcelE = e(parcelF, 9);
        byte[] bArrCreateByteArray = parcelE.createByteArray();
        parcelE.recycle();
        return bArrCreateByteArray;
    }

    @Override // f9.i0
    public final void s(w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        L(parcelF, 20);
    }

    @Override // f9.i0
    public final String v(w4 w4Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        Parcel parcelE = e(parcelF, 11);
        String string = parcelE.readString();
        parcelE.recycle();
        return string;
    }

    @Override // f9.i0
    public final void w(long j4, String str, String str2, String str3) {
        Parcel parcelF = f();
        parcelF.writeLong(j4);
        parcelF.writeString(str);
        parcelF.writeString(str2);
        parcelF.writeString(str3);
        L(parcelF, 10);
    }

    @Override // f9.i0
    public final void z(w4 w4Var, j4 j4Var, m0 m0Var) {
        Parcel parcelF = f();
        com.google.android.gms.internal.measurement.y.b(parcelF, w4Var);
        com.google.android.gms.internal.measurement.y.b(parcelF, j4Var);
        com.google.android.gms.internal.measurement.y.c(parcelF, m0Var);
        L(parcelF, 29);
    }
}
