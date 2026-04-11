package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends a9.a implements j0 {
    @Override // com.google.android.gms.internal.measurement.j0
    public final void beginAdUnitExposure(String str, long j4) {
        Parcel parcelF = f();
        parcelF.writeString(str);
        parcelF.writeLong(j4);
        L(parcelF, 23);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel parcelF = f();
        parcelF.writeString(str);
        parcelF.writeString(str2);
        y.b(parcelF, bundle);
        L(parcelF, 9);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void endAdUnitExposure(String str, long j4) {
        Parcel parcelF = f();
        parcelF.writeString(str);
        parcelF.writeLong(j4);
        L(parcelF, 24);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void generateEventId(l0 l0Var) {
        Parcel parcelF = f();
        y.c(parcelF, l0Var);
        L(parcelF, 22);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void getCachedAppInstanceId(l0 l0Var) {
        Parcel parcelF = f();
        y.c(parcelF, l0Var);
        L(parcelF, 19);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void getConditionalUserProperties(String str, String str2, l0 l0Var) {
        Parcel parcelF = f();
        parcelF.writeString(str);
        parcelF.writeString(str2);
        y.c(parcelF, l0Var);
        L(parcelF, 10);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void getCurrentScreenClass(l0 l0Var) {
        Parcel parcelF = f();
        y.c(parcelF, l0Var);
        L(parcelF, 17);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void getCurrentScreenName(l0 l0Var) {
        Parcel parcelF = f();
        y.c(parcelF, l0Var);
        L(parcelF, 16);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void getGmpAppId(l0 l0Var) {
        Parcel parcelF = f();
        y.c(parcelF, l0Var);
        L(parcelF, 21);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void getMaxUserProperties(String str, l0 l0Var) {
        Parcel parcelF = f();
        parcelF.writeString(str);
        y.c(parcelF, l0Var);
        L(parcelF, 6);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void getUserProperties(String str, String str2, boolean z10, l0 l0Var) {
        Parcel parcelF = f();
        parcelF.writeString(str);
        parcelF.writeString(str2);
        ClassLoader classLoader = y.f2729a;
        parcelF.writeInt(z10 ? 1 : 0);
        y.c(parcelF, l0Var);
        L(parcelF, 5);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void initialize(v8.a aVar, t0 t0Var, long j4) {
        Parcel parcelF = f();
        y.c(parcelF, aVar);
        y.b(parcelF, t0Var);
        parcelF.writeLong(j4);
        L(parcelF, 1);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j4) {
        Parcel parcelF = f();
        parcelF.writeString(str);
        parcelF.writeString(str2);
        y.b(parcelF, bundle);
        parcelF.writeInt(1);
        parcelF.writeInt(1);
        parcelF.writeLong(j4);
        L(parcelF, 2);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void logHealthData(int i, String str, v8.a aVar, v8.a aVar2, v8.a aVar3) {
        Parcel parcelF = f();
        parcelF.writeInt(5);
        parcelF.writeString("Error with data collection. Data lost.");
        y.c(parcelF, aVar);
        y.c(parcelF, aVar2);
        y.c(parcelF, aVar3);
        L(parcelF, 33);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void onActivityCreatedByScionActivityInfo(v0 v0Var, Bundle bundle, long j4) {
        Parcel parcelF = f();
        y.b(parcelF, v0Var);
        y.b(parcelF, bundle);
        parcelF.writeLong(j4);
        L(parcelF, 53);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void onActivityDestroyedByScionActivityInfo(v0 v0Var, long j4) {
        Parcel parcelF = f();
        y.b(parcelF, v0Var);
        parcelF.writeLong(j4);
        L(parcelF, 54);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void onActivityPausedByScionActivityInfo(v0 v0Var, long j4) {
        Parcel parcelF = f();
        y.b(parcelF, v0Var);
        parcelF.writeLong(j4);
        L(parcelF, 55);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void onActivityResumedByScionActivityInfo(v0 v0Var, long j4) {
        Parcel parcelF = f();
        y.b(parcelF, v0Var);
        parcelF.writeLong(j4);
        L(parcelF, 56);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void onActivitySaveInstanceStateByScionActivityInfo(v0 v0Var, l0 l0Var, long j4) {
        Parcel parcelF = f();
        y.b(parcelF, v0Var);
        y.c(parcelF, l0Var);
        parcelF.writeLong(j4);
        L(parcelF, 57);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void onActivityStartedByScionActivityInfo(v0 v0Var, long j4) {
        Parcel parcelF = f();
        y.b(parcelF, v0Var);
        parcelF.writeLong(j4);
        L(parcelF, 51);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void onActivityStoppedByScionActivityInfo(v0 v0Var, long j4) {
        Parcel parcelF = f();
        y.b(parcelF, v0Var);
        parcelF.writeLong(j4);
        L(parcelF, 52);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void registerOnMeasurementEventListener(q0 q0Var) {
        Parcel parcelF = f();
        y.c(parcelF, q0Var);
        L(parcelF, 35);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void retrieveAndUploadBatches(n0 n0Var) {
        Parcel parcelF = f();
        y.c(parcelF, n0Var);
        L(parcelF, 58);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void setConditionalUserProperty(Bundle bundle, long j4) {
        Parcel parcelF = f();
        y.b(parcelF, bundle);
        parcelF.writeLong(j4);
        L(parcelF, 8);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void setCurrentScreenByScionActivityInfo(v0 v0Var, String str, String str2, long j4) {
        Parcel parcelF = f();
        y.b(parcelF, v0Var);
        parcelF.writeString(str);
        parcelF.writeString(str2);
        parcelF.writeLong(j4);
        L(parcelF, 50);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void setDataCollectionEnabled(boolean z10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public final void setUserProperty(String str, String str2, v8.a aVar, boolean z10, long j4) {
        Parcel parcelF = f();
        parcelF.writeString("fcm");
        parcelF.writeString("_ln");
        y.c(parcelF, aVar);
        parcelF.writeInt(1);
        parcelF.writeLong(j4);
        L(parcelF, 4);
    }
}
