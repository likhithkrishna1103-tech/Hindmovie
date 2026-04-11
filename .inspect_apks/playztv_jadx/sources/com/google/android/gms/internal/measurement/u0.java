package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u0 extends f0 implements s0 {
    @Override // com.google.android.gms.internal.measurement.s0
    public final void beginAdUnitExposure(String str, long j5) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeLong(j5);
        H(parcelC, 23);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        h0.c(parcelC, bundle);
        H(parcelC, 9);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void endAdUnitExposure(String str, long j5) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeLong(j5);
        H(parcelC, 24);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void generateEventId(w0 w0Var) {
        Parcel parcelC = c();
        h0.b(parcelC, w0Var);
        H(parcelC, 22);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void getCachedAppInstanceId(w0 w0Var) {
        Parcel parcelC = c();
        h0.b(parcelC, w0Var);
        H(parcelC, 19);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void getConditionalUserProperties(String str, String str2, w0 w0Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        h0.b(parcelC, w0Var);
        H(parcelC, 10);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void getCurrentScreenClass(w0 w0Var) {
        Parcel parcelC = c();
        h0.b(parcelC, w0Var);
        H(parcelC, 17);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void getCurrentScreenName(w0 w0Var) {
        Parcel parcelC = c();
        h0.b(parcelC, w0Var);
        H(parcelC, 16);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void getGmpAppId(w0 w0Var) {
        Parcel parcelC = c();
        h0.b(parcelC, w0Var);
        H(parcelC, 21);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void getMaxUserProperties(String str, w0 w0Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        h0.b(parcelC, w0Var);
        H(parcelC, 6);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void getUserProperties(String str, String str2, boolean z2, w0 w0Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        ClassLoader classLoader = h0.f3033a;
        parcelC.writeInt(z2 ? 1 : 0);
        h0.b(parcelC, w0Var);
        H(parcelC, 5);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void initialize(a8.a aVar, d1 d1Var, long j5) {
        Parcel parcelC = c();
        h0.b(parcelC, aVar);
        h0.c(parcelC, d1Var);
        parcelC.writeLong(j5);
        H(parcelC, 1);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void logEvent(String str, String str2, Bundle bundle, boolean z2, boolean z10, long j5) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        h0.c(parcelC, bundle);
        parcelC.writeInt(1);
        parcelC.writeInt(1);
        parcelC.writeLong(j5);
        H(parcelC, 2);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void logHealthData(int i, String str, a8.a aVar, a8.a aVar2, a8.a aVar3) {
        Parcel parcelC = c();
        parcelC.writeInt(5);
        parcelC.writeString("Error with data collection. Data lost.");
        h0.b(parcelC, aVar);
        h0.b(parcelC, aVar2);
        h0.b(parcelC, aVar3);
        H(parcelC, 33);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void onActivityCreated(a8.a aVar, Bundle bundle, long j5) {
        Parcel parcelC = c();
        h0.b(parcelC, aVar);
        h0.c(parcelC, bundle);
        parcelC.writeLong(j5);
        H(parcelC, 27);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void onActivityDestroyed(a8.a aVar, long j5) {
        Parcel parcelC = c();
        h0.b(parcelC, aVar);
        parcelC.writeLong(j5);
        H(parcelC, 28);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void onActivityPaused(a8.a aVar, long j5) {
        Parcel parcelC = c();
        h0.b(parcelC, aVar);
        parcelC.writeLong(j5);
        H(parcelC, 29);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void onActivityResumed(a8.a aVar, long j5) {
        Parcel parcelC = c();
        h0.b(parcelC, aVar);
        parcelC.writeLong(j5);
        H(parcelC, 30);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void onActivitySaveInstanceState(a8.a aVar, w0 w0Var, long j5) {
        Parcel parcelC = c();
        h0.b(parcelC, aVar);
        h0.b(parcelC, w0Var);
        parcelC.writeLong(j5);
        H(parcelC, 31);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void onActivityStarted(a8.a aVar, long j5) {
        Parcel parcelC = c();
        h0.b(parcelC, aVar);
        parcelC.writeLong(j5);
        H(parcelC, 25);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void onActivityStopped(a8.a aVar, long j5) {
        Parcel parcelC = c();
        h0.b(parcelC, aVar);
        parcelC.writeLong(j5);
        H(parcelC, 26);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void registerOnMeasurementEventListener(x0 x0Var) {
        Parcel parcelC = c();
        h0.b(parcelC, x0Var);
        H(parcelC, 35);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void setConditionalUserProperty(Bundle bundle, long j5) {
        Parcel parcelC = c();
        h0.c(parcelC, bundle);
        parcelC.writeLong(j5);
        H(parcelC, 8);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void setCurrentScreen(a8.a aVar, String str, String str2, long j5) {
        Parcel parcelC = c();
        h0.b(parcelC, aVar);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeLong(j5);
        H(parcelC, 15);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void setDataCollectionEnabled(boolean z2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void setUserProperty(String str, String str2, a8.a aVar, boolean z2, long j5) {
        Parcel parcelC = c();
        parcelC.writeString("fcm");
        parcelC.writeString("_ln");
        h0.b(parcelC, aVar);
        parcelC.writeInt(1);
        parcelC.writeLong(j5);
        H(parcelC, 4);
    }
}
