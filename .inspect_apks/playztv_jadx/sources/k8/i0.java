package k8;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i0 extends com.google.android.gms.internal.measurement.f0 implements h0 {
    public i0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService", 0);
    }

    @Override // k8.h0
    public final void A(a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        H(parcelC, 26);
    }

    @Override // k8.h0
    public final void C(long j5, String str, String str2, String str3) {
        Parcel parcelC = c();
        parcelC.writeLong(j5);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        H(parcelC, 10);
    }

    @Override // k8.h0
    public final List D(String str, String str2, String str3) {
        Parcel parcelC = c();
        parcelC.writeString(null);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        Parcel parcelG = G(parcelC, 17);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(d.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // k8.h0
    public final void E(v vVar, a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, vVar);
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        H(parcelC, 1);
    }

    @Override // k8.h0
    public final void F(a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        H(parcelC, 27);
    }

    @Override // k8.h0
    public final List g(Bundle bundle, a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        com.google.android.gms.internal.measurement.h0.c(parcelC, bundle);
        Parcel parcelG = G(parcelC, 24);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(r3.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // k8.h0
    public final void i(a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        H(parcelC, 20);
    }

    @Override // k8.h0
    public final void k(d dVar, a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, dVar);
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        H(parcelC, 12);
    }

    @Override // k8.h0
    public final String m(a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        Parcel parcelG = G(parcelC, 11);
        String string = parcelG.readString();
        parcelG.recycle();
        return string;
    }

    @Override // k8.h0
    public final void n(e4 e4Var, a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, e4Var);
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        H(parcelC, 2);
    }

    @Override // k8.h0
    public final void o(a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        H(parcelC, 25);
    }

    @Override // k8.h0
    public final List p(String str, String str2, String str3, boolean z2) {
        Parcel parcelC = c();
        parcelC.writeString(null);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.h0.f3033a;
        parcelC.writeInt(z2 ? 1 : 0);
        Parcel parcelG = G(parcelC, 15);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(e4.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // k8.h0
    public final List r(String str, String str2, boolean z2, a4 a4Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.h0.f3033a;
        parcelC.writeInt(z2 ? 1 : 0);
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        Parcel parcelG = G(parcelC, 14);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(e4.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // k8.h0
    public final List t(String str, String str2, a4 a4Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        Parcel parcelG = G(parcelC, 16);
        ArrayList arrayListCreateTypedArrayList = parcelG.createTypedArrayList(d.CREATOR);
        parcelG.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // k8.h0
    public final g u(a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        Parcel parcelG = G(parcelC, 21);
        g gVar = (g) com.google.android.gms.internal.measurement.h0.a(parcelG, g.CREATOR);
        parcelG.recycle();
        return gVar;
    }

    @Override // k8.h0
    public final byte[] w(v vVar, String str) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, vVar);
        parcelC.writeString(str);
        Parcel parcelG = G(parcelC, 9);
        byte[] bArrCreateByteArray = parcelG.createByteArray();
        parcelG.recycle();
        return bArrCreateByteArray;
    }

    @Override // k8.h0
    public final void x(a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        H(parcelC, 18);
    }

    @Override // k8.h0
    public final void y(a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        H(parcelC, 6);
    }

    @Override // k8.h0
    public final void z(a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        H(parcelC, 4);
    }

    @Override // k8.h0
    /* JADX INFO: renamed from: g */
    public final void mo2g(Bundle bundle, a4 a4Var) {
        Parcel parcelC = c();
        com.google.android.gms.internal.measurement.h0.c(parcelC, bundle);
        com.google.android.gms.internal.measurement.h0.c(parcelC, a4Var);
        H(parcelC, 19);
    }
}
