package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class v0 extends i0 implements s0 {
    public static s0 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof s0 ? (s0) iInterfaceQueryLocalInterface : new u0(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService", 0);
    }

    @Override // com.google.android.gms.internal.measurement.i0
    public final boolean c(int i, Parcel parcel, Parcel parcel2) {
        boolean z2;
        w0 y0Var = null;
        w0 y0Var2 = null;
        w0 y0Var3 = null;
        w0 y0Var4 = null;
        x0 z0Var = null;
        x0 z0Var2 = null;
        x0 z0Var3 = null;
        w0 y0Var5 = null;
        w0 y0Var6 = null;
        w0 y0Var7 = null;
        w0 y0Var8 = null;
        w0 y0Var9 = null;
        w0 y0Var10 = null;
        b1 a1Var = null;
        w0 y0Var11 = null;
        w0 y0Var12 = null;
        w0 y0Var13 = null;
        w0 y0Var14 = null;
        w0 y0Var15 = null;
        switch (i) {
            case 1:
                a8.a aVarH = a8.b.H(parcel.readStrongBinder());
                d1 d1Var = (d1) h0.a(parcel, d1.CREATOR);
                long j5 = parcel.readLong();
                h0.d(parcel);
                initialize(aVarH, d1Var, j5);
                break;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) h0.a(parcel, Bundle.CREATOR);
                boolean z10 = parcel.readInt() != 0;
                boolean z11 = parcel.readInt() != 0;
                long j8 = parcel.readLong();
                h0.d(parcel);
                logEvent(string, string2, bundle, z10, z11, j8);
                break;
            case 3:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                Bundle bundle2 = (Bundle) h0.a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var = iInterfaceQueryLocalInterface instanceof w0 ? (w0) iInterfaceQueryLocalInterface : new y0(strongBinder);
                }
                w0 w0Var = y0Var;
                long j10 = parcel.readLong();
                h0.d(parcel);
                logEventAndBundle(string3, string4, bundle2, w0Var, j10);
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                a8.a aVarH2 = a8.b.H(parcel.readStrongBinder());
                ClassLoader classLoader = h0.f3033a;
                z2 = parcel.readInt() != 0;
                long j11 = parcel.readLong();
                h0.d(parcel);
                setUserProperty(string5, string6, aVarH2, z2, j11);
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                ClassLoader classLoader2 = h0.f3033a;
                z2 = parcel.readInt() != 0;
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var15 = iInterfaceQueryLocalInterface2 instanceof w0 ? (w0) iInterfaceQueryLocalInterface2 : new y0(strongBinder2);
                }
                h0.d(parcel);
                getUserProperties(string7, string8, z2, y0Var15);
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                String string9 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var14 = iInterfaceQueryLocalInterface3 instanceof w0 ? (w0) iInterfaceQueryLocalInterface3 : new y0(strongBinder3);
                }
                h0.d(parcel);
                getMaxUserProperties(string9, y0Var14);
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                String string10 = parcel.readString();
                long j12 = parcel.readLong();
                h0.d(parcel);
                setUserId(string10, j12);
                break;
            case 8:
                Bundle bundle3 = (Bundle) h0.a(parcel, Bundle.CREATOR);
                long j13 = parcel.readLong();
                h0.d(parcel);
                setConditionalUserProperty(bundle3, j13);
                break;
            case 9:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                Bundle bundle4 = (Bundle) h0.a(parcel, Bundle.CREATOR);
                h0.d(parcel);
                clearConditionalUserProperty(string11, string12, bundle4);
                break;
            case 10:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var13 = iInterfaceQueryLocalInterface4 instanceof w0 ? (w0) iInterfaceQueryLocalInterface4 : new y0(strongBinder4);
                }
                h0.d(parcel);
                getConditionalUserProperties(string13, string14, y0Var13);
                break;
            case 11:
                ClassLoader classLoader3 = h0.f3033a;
                z2 = parcel.readInt() != 0;
                long j14 = parcel.readLong();
                h0.d(parcel);
                setMeasurementEnabled(z2, j14);
                break;
            case 12:
                long j15 = parcel.readLong();
                h0.d(parcel);
                resetAnalyticsData(j15);
                break;
            case 13:
                long j16 = parcel.readLong();
                h0.d(parcel);
                setMinimumSessionDuration(j16);
                break;
            case 14:
                long j17 = parcel.readLong();
                h0.d(parcel);
                setSessionTimeoutDuration(j17);
                break;
            case 15:
                a8.a aVarH3 = a8.b.H(parcel.readStrongBinder());
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                long j18 = parcel.readLong();
                h0.d(parcel);
                setCurrentScreen(aVarH3, string15, string16, j18);
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var12 = iInterfaceQueryLocalInterface5 instanceof w0 ? (w0) iInterfaceQueryLocalInterface5 : new y0(strongBinder5);
                }
                h0.d(parcel);
                getCurrentScreenName(y0Var12);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var11 = iInterfaceQueryLocalInterface6 instanceof w0 ? (w0) iInterfaceQueryLocalInterface6 : new y0(strongBinder6);
                }
                h0.d(parcel);
                getCurrentScreenClass(y0Var11);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    a1Var = iInterfaceQueryLocalInterface7 instanceof b1 ? (b1) iInterfaceQueryLocalInterface7 : new a1(strongBinder7, "com.google.android.gms.measurement.api.internal.IStringProvider", 0);
                }
                h0.d(parcel);
                setInstanceIdProvider(a1Var);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var10 = iInterfaceQueryLocalInterface8 instanceof w0 ? (w0) iInterfaceQueryLocalInterface8 : new y0(strongBinder8);
                }
                h0.d(parcel);
                getCachedAppInstanceId(y0Var10);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var9 = iInterfaceQueryLocalInterface9 instanceof w0 ? (w0) iInterfaceQueryLocalInterface9 : new y0(strongBinder9);
                }
                h0.d(parcel);
                getAppInstanceId(y0Var9);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var8 = iInterfaceQueryLocalInterface10 instanceof w0 ? (w0) iInterfaceQueryLocalInterface10 : new y0(strongBinder10);
                }
                h0.d(parcel);
                getGmpAppId(y0Var8);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var7 = iInterfaceQueryLocalInterface11 instanceof w0 ? (w0) iInterfaceQueryLocalInterface11 : new y0(strongBinder11);
                }
                h0.d(parcel);
                generateEventId(y0Var7);
                break;
            case 23:
                String string17 = parcel.readString();
                long j19 = parcel.readLong();
                h0.d(parcel);
                beginAdUnitExposure(string17, j19);
                break;
            case 24:
                String string18 = parcel.readString();
                long j20 = parcel.readLong();
                h0.d(parcel);
                endAdUnitExposure(string18, j20);
                break;
            case 25:
                a8.a aVarH4 = a8.b.H(parcel.readStrongBinder());
                long j21 = parcel.readLong();
                h0.d(parcel);
                onActivityStarted(aVarH4, j21);
                break;
            case 26:
                a8.a aVarH5 = a8.b.H(parcel.readStrongBinder());
                long j22 = parcel.readLong();
                h0.d(parcel);
                onActivityStopped(aVarH5, j22);
                break;
            case 27:
                a8.a aVarH6 = a8.b.H(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) h0.a(parcel, Bundle.CREATOR);
                long j23 = parcel.readLong();
                h0.d(parcel);
                onActivityCreated(aVarH6, bundle5, j23);
                break;
            case 28:
                a8.a aVarH7 = a8.b.H(parcel.readStrongBinder());
                long j24 = parcel.readLong();
                h0.d(parcel);
                onActivityDestroyed(aVarH7, j24);
                break;
            case 29:
                a8.a aVarH8 = a8.b.H(parcel.readStrongBinder());
                long j25 = parcel.readLong();
                h0.d(parcel);
                onActivityPaused(aVarH8, j25);
                break;
            case 30:
                a8.a aVarH9 = a8.b.H(parcel.readStrongBinder());
                long j26 = parcel.readLong();
                h0.d(parcel);
                onActivityResumed(aVarH9, j26);
                break;
            case 31:
                a8.a aVarH10 = a8.b.H(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var6 = iInterfaceQueryLocalInterface12 instanceof w0 ? (w0) iInterfaceQueryLocalInterface12 : new y0(strongBinder12);
                }
                long j27 = parcel.readLong();
                h0.d(parcel);
                onActivitySaveInstanceState(aVarH10, y0Var6, j27);
                break;
            case 32:
                Bundle bundle6 = (Bundle) h0.a(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var5 = iInterfaceQueryLocalInterface13 instanceof w0 ? (w0) iInterfaceQueryLocalInterface13 : new y0(strongBinder13);
                }
                long j28 = parcel.readLong();
                h0.d(parcel);
                performAction(bundle6, y0Var5, j28);
                break;
            case 33:
                int i10 = parcel.readInt();
                String string19 = parcel.readString();
                a8.a aVarH11 = a8.b.H(parcel.readStrongBinder());
                a8.a aVarH12 = a8.b.H(parcel.readStrongBinder());
                a8.a aVarH13 = a8.b.H(parcel.readStrongBinder());
                h0.d(parcel);
                logHealthData(i10, string19, aVarH11, aVarH12, aVarH13);
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    z0Var3 = iInterfaceQueryLocalInterface14 instanceof x0 ? (x0) iInterfaceQueryLocalInterface14 : new z0(strongBinder14);
                }
                h0.d(parcel);
                setEventInterceptor(z0Var3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    z0Var2 = iInterfaceQueryLocalInterface15 instanceof x0 ? (x0) iInterfaceQueryLocalInterface15 : new z0(strongBinder15);
                }
                h0.d(parcel);
                registerOnMeasurementEventListener(z0Var2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    z0Var = iInterfaceQueryLocalInterface16 instanceof x0 ? (x0) iInterfaceQueryLocalInterface16 : new z0(strongBinder16);
                }
                h0.d(parcel);
                unregisterOnMeasurementEventListener(z0Var);
                break;
            case 37:
                HashMap hashMap = parcel.readHashMap(h0.f3033a);
                h0.d(parcel);
                initForTests(hashMap);
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var4 = iInterfaceQueryLocalInterface17 instanceof w0 ? (w0) iInterfaceQueryLocalInterface17 : new y0(strongBinder17);
                }
                int i11 = parcel.readInt();
                h0.d(parcel);
                getTestFlag(y0Var4, i11);
                break;
            case 39:
                ClassLoader classLoader4 = h0.f3033a;
                z2 = parcel.readInt() != 0;
                h0.d(parcel);
                setDataCollectionEnabled(z2);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var3 = iInterfaceQueryLocalInterface18 instanceof w0 ? (w0) iInterfaceQueryLocalInterface18 : new y0(strongBinder18);
                }
                h0.d(parcel);
                isDataCollectionEnabled(y0Var3);
                break;
            case 41:
            case 47:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) h0.a(parcel, Bundle.CREATOR);
                h0.d(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long j29 = parcel.readLong();
                h0.d(parcel);
                clearMeasurementEnabled(j29);
                break;
            case 44:
                Bundle bundle8 = (Bundle) h0.a(parcel, Bundle.CREATOR);
                long j30 = parcel.readLong();
                h0.d(parcel);
                setConsent(bundle8, j30);
                break;
            case 45:
                Bundle bundle9 = (Bundle) h0.a(parcel, Bundle.CREATOR);
                long j31 = parcel.readLong();
                h0.d(parcel);
                setConsentThirdParty(bundle9, j31);
                break;
            case 46:
                IBinder strongBinder19 = parcel.readStrongBinder();
                if (strongBinder19 != null) {
                    IInterface iInterfaceQueryLocalInterface19 = strongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    y0Var2 = iInterfaceQueryLocalInterface19 instanceof w0 ? (w0) iInterfaceQueryLocalInterface19 : new y0(strongBinder19);
                }
                h0.d(parcel);
                getSessionId(y0Var2);
                break;
            case 48:
                Intent intent = (Intent) h0.a(parcel, Intent.CREATOR);
                h0.d(parcel);
                setSgtmDebugInfo(intent);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
