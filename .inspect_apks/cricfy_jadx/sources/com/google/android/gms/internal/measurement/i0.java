package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i0 extends x implements j0 {
    public static j0 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof j0 ? (j0) iInterfaceQueryLocalInterface : new h0(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService", 1);
    }

    @Override // com.google.android.gms.internal.measurement.x
    public final boolean b(int i, Parcel parcel, Parcel parcel2) {
        boolean z10;
        l0 k0Var = null;
        n0 m0Var = null;
        l0 k0Var2 = null;
        l0 k0Var3 = null;
        l0 k0Var4 = null;
        l0 k0Var5 = null;
        q0 o0Var = null;
        q0 o0Var2 = null;
        q0 o0Var3 = null;
        l0 k0Var6 = null;
        l0 k0Var7 = null;
        l0 k0Var8 = null;
        l0 k0Var9 = null;
        l0 k0Var10 = null;
        l0 k0Var11 = null;
        s0 r0Var = null;
        l0 k0Var12 = null;
        l0 k0Var13 = null;
        l0 k0Var14 = null;
        l0 k0Var15 = null;
        l0 k0Var16 = null;
        switch (i) {
            case 1:
                v8.a aVarM = v8.b.M(parcel.readStrongBinder());
                t0 t0Var = (t0) y.a(parcel, t0.CREATOR);
                long j4 = parcel.readLong();
                y.d(parcel);
                initialize(aVarM, t0Var, j4);
                break;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) y.a(parcel, Bundle.CREATOR);
                boolean z11 = parcel.readInt() != 0;
                boolean z12 = parcel.readInt() != 0;
                long j7 = parcel.readLong();
                y.d(parcel);
                logEvent(string, string2, bundle, z11, z12, j7);
                break;
            case 3:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                Bundle bundle2 = (Bundle) y.a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var = iInterfaceQueryLocalInterface instanceof l0 ? (l0) iInterfaceQueryLocalInterface : new k0(strongBinder);
                }
                l0 l0Var = k0Var;
                long j10 = parcel.readLong();
                y.d(parcel);
                logEventAndBundle(string3, string4, bundle2, l0Var, j10);
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                v8.a aVarM2 = v8.b.M(parcel.readStrongBinder());
                ClassLoader classLoader = y.f2729a;
                z10 = parcel.readInt() != 0;
                long j11 = parcel.readLong();
                y.d(parcel);
                setUserProperty(string5, string6, aVarM2, z10, j11);
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                ClassLoader classLoader2 = y.f2729a;
                z10 = parcel.readInt() != 0;
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var16 = iInterfaceQueryLocalInterface2 instanceof l0 ? (l0) iInterfaceQueryLocalInterface2 : new k0(strongBinder2);
                }
                y.d(parcel);
                getUserProperties(string7, string8, z10, k0Var16);
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                String string9 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var15 = iInterfaceQueryLocalInterface3 instanceof l0 ? (l0) iInterfaceQueryLocalInterface3 : new k0(strongBinder3);
                }
                y.d(parcel);
                getMaxUserProperties(string9, k0Var15);
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                String string10 = parcel.readString();
                long j12 = parcel.readLong();
                y.d(parcel);
                setUserId(string10, j12);
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                Bundle bundle3 = (Bundle) y.a(parcel, Bundle.CREATOR);
                long j13 = parcel.readLong();
                y.d(parcel);
                setConditionalUserProperty(bundle3, j13);
                break;
            case 9:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                Bundle bundle4 = (Bundle) y.a(parcel, Bundle.CREATOR);
                y.d(parcel);
                clearConditionalUserProperty(string11, string12, bundle4);
                break;
            case 10:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var14 = iInterfaceQueryLocalInterface4 instanceof l0 ? (l0) iInterfaceQueryLocalInterface4 : new k0(strongBinder4);
                }
                y.d(parcel);
                getConditionalUserProperties(string13, string14, k0Var14);
                break;
            case 11:
                ClassLoader classLoader3 = y.f2729a;
                z10 = parcel.readInt() != 0;
                long j14 = parcel.readLong();
                y.d(parcel);
                setMeasurementEnabled(z10, j14);
                break;
            case 12:
                long j15 = parcel.readLong();
                y.d(parcel);
                resetAnalyticsData(j15);
                break;
            case 13:
                long j16 = parcel.readLong();
                y.d(parcel);
                setMinimumSessionDuration(j16);
                break;
            case 14:
                long j17 = parcel.readLong();
                y.d(parcel);
                setSessionTimeoutDuration(j17);
                break;
            case 15:
                v8.a aVarM3 = v8.b.M(parcel.readStrongBinder());
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                long j18 = parcel.readLong();
                y.d(parcel);
                setCurrentScreen(aVarM3, string15, string16, j18);
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var13 = iInterfaceQueryLocalInterface5 instanceof l0 ? (l0) iInterfaceQueryLocalInterface5 : new k0(strongBinder5);
                }
                y.d(parcel);
                getCurrentScreenName(k0Var13);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var12 = iInterfaceQueryLocalInterface6 instanceof l0 ? (l0) iInterfaceQueryLocalInterface6 : new k0(strongBinder6);
                }
                y.d(parcel);
                getCurrentScreenClass(k0Var12);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    r0Var = iInterfaceQueryLocalInterface7 instanceof s0 ? (s0) iInterfaceQueryLocalInterface7 : new r0(strongBinder7, "com.google.android.gms.measurement.api.internal.IStringProvider", 1);
                }
                y.d(parcel);
                setInstanceIdProvider(r0Var);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var11 = iInterfaceQueryLocalInterface8 instanceof l0 ? (l0) iInterfaceQueryLocalInterface8 : new k0(strongBinder8);
                }
                y.d(parcel);
                getCachedAppInstanceId(k0Var11);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var10 = iInterfaceQueryLocalInterface9 instanceof l0 ? (l0) iInterfaceQueryLocalInterface9 : new k0(strongBinder9);
                }
                y.d(parcel);
                getAppInstanceId(k0Var10);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var9 = iInterfaceQueryLocalInterface10 instanceof l0 ? (l0) iInterfaceQueryLocalInterface10 : new k0(strongBinder10);
                }
                y.d(parcel);
                getGmpAppId(k0Var9);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var8 = iInterfaceQueryLocalInterface11 instanceof l0 ? (l0) iInterfaceQueryLocalInterface11 : new k0(strongBinder11);
                }
                y.d(parcel);
                generateEventId(k0Var8);
                break;
            case 23:
                String string17 = parcel.readString();
                long j19 = parcel.readLong();
                y.d(parcel);
                beginAdUnitExposure(string17, j19);
                break;
            case 24:
                String string18 = parcel.readString();
                long j20 = parcel.readLong();
                y.d(parcel);
                endAdUnitExposure(string18, j20);
                break;
            case 25:
                v8.a aVarM4 = v8.b.M(parcel.readStrongBinder());
                long j21 = parcel.readLong();
                y.d(parcel);
                onActivityStarted(aVarM4, j21);
                break;
            case 26:
                v8.a aVarM5 = v8.b.M(parcel.readStrongBinder());
                long j22 = parcel.readLong();
                y.d(parcel);
                onActivityStopped(aVarM5, j22);
                break;
            case 27:
                v8.a aVarM6 = v8.b.M(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) y.a(parcel, Bundle.CREATOR);
                long j23 = parcel.readLong();
                y.d(parcel);
                onActivityCreated(aVarM6, bundle5, j23);
                break;
            case 28:
                v8.a aVarM7 = v8.b.M(parcel.readStrongBinder());
                long j24 = parcel.readLong();
                y.d(parcel);
                onActivityDestroyed(aVarM7, j24);
                break;
            case 29:
                v8.a aVarM8 = v8.b.M(parcel.readStrongBinder());
                long j25 = parcel.readLong();
                y.d(parcel);
                onActivityPaused(aVarM8, j25);
                break;
            case 30:
                v8.a aVarM9 = v8.b.M(parcel.readStrongBinder());
                long j26 = parcel.readLong();
                y.d(parcel);
                onActivityResumed(aVarM9, j26);
                break;
            case 31:
                v8.a aVarM10 = v8.b.M(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var7 = iInterfaceQueryLocalInterface12 instanceof l0 ? (l0) iInterfaceQueryLocalInterface12 : new k0(strongBinder12);
                }
                long j27 = parcel.readLong();
                y.d(parcel);
                onActivitySaveInstanceState(aVarM10, k0Var7, j27);
                break;
            case 32:
                Bundle bundle6 = (Bundle) y.a(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var6 = iInterfaceQueryLocalInterface13 instanceof l0 ? (l0) iInterfaceQueryLocalInterface13 : new k0(strongBinder13);
                }
                long j28 = parcel.readLong();
                y.d(parcel);
                performAction(bundle6, k0Var6, j28);
                break;
            case 33:
                int i10 = parcel.readInt();
                String string19 = parcel.readString();
                v8.a aVarM11 = v8.b.M(parcel.readStrongBinder());
                v8.a aVarM12 = v8.b.M(parcel.readStrongBinder());
                v8.a aVarM13 = v8.b.M(parcel.readStrongBinder());
                y.d(parcel);
                logHealthData(i10, string19, aVarM11, aVarM12, aVarM13);
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    o0Var3 = iInterfaceQueryLocalInterface14 instanceof q0 ? (q0) iInterfaceQueryLocalInterface14 : new o0(strongBinder14);
                }
                y.d(parcel);
                setEventInterceptor(o0Var3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    o0Var2 = iInterfaceQueryLocalInterface15 instanceof q0 ? (q0) iInterfaceQueryLocalInterface15 : new o0(strongBinder15);
                }
                y.d(parcel);
                registerOnMeasurementEventListener(o0Var2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    o0Var = iInterfaceQueryLocalInterface16 instanceof q0 ? (q0) iInterfaceQueryLocalInterface16 : new o0(strongBinder16);
                }
                y.d(parcel);
                unregisterOnMeasurementEventListener(o0Var);
                break;
            case 37:
                HashMap hashMap = parcel.readHashMap(y.f2729a);
                y.d(parcel);
                initForTests(hashMap);
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var5 = iInterfaceQueryLocalInterface17 instanceof l0 ? (l0) iInterfaceQueryLocalInterface17 : new k0(strongBinder17);
                }
                int i11 = parcel.readInt();
                y.d(parcel);
                getTestFlag(k0Var5, i11);
                break;
            case 39:
                ClassLoader classLoader4 = y.f2729a;
                z10 = parcel.readInt() != 0;
                y.d(parcel);
                setDataCollectionEnabled(z10);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var4 = iInterfaceQueryLocalInterface18 instanceof l0 ? (l0) iInterfaceQueryLocalInterface18 : new k0(strongBinder18);
                }
                y.d(parcel);
                isDataCollectionEnabled(k0Var4);
                break;
            case 41:
            case 47:
            case 49:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) y.a(parcel, Bundle.CREATOR);
                y.d(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long j29 = parcel.readLong();
                y.d(parcel);
                clearMeasurementEnabled(j29);
                break;
            case 44:
                Bundle bundle8 = (Bundle) y.a(parcel, Bundle.CREATOR);
                long j30 = parcel.readLong();
                y.d(parcel);
                setConsent(bundle8, j30);
                break;
            case 45:
                Bundle bundle9 = (Bundle) y.a(parcel, Bundle.CREATOR);
                long j31 = parcel.readLong();
                y.d(parcel);
                setConsentThirdParty(bundle9, j31);
                break;
            case 46:
                IBinder strongBinder19 = parcel.readStrongBinder();
                if (strongBinder19 != null) {
                    IInterface iInterfaceQueryLocalInterface19 = strongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var3 = iInterfaceQueryLocalInterface19 instanceof l0 ? (l0) iInterfaceQueryLocalInterface19 : new k0(strongBinder19);
                }
                y.d(parcel);
                getSessionId(k0Var3);
                break;
            case 48:
                Intent intent = (Intent) y.a(parcel, Intent.CREATOR);
                y.d(parcel);
                setSgtmDebugInfo(intent);
                break;
            case 50:
                v0 v0Var = (v0) y.a(parcel, v0.CREATOR);
                String string20 = parcel.readString();
                String string21 = parcel.readString();
                long j32 = parcel.readLong();
                y.d(parcel);
                setCurrentScreenByScionActivityInfo(v0Var, string20, string21, j32);
                break;
            case 51:
                v0 v0Var2 = (v0) y.a(parcel, v0.CREATOR);
                long j33 = parcel.readLong();
                y.d(parcel);
                onActivityStartedByScionActivityInfo(v0Var2, j33);
                break;
            case 52:
                v0 v0Var3 = (v0) y.a(parcel, v0.CREATOR);
                long j34 = parcel.readLong();
                y.d(parcel);
                onActivityStoppedByScionActivityInfo(v0Var3, j34);
                break;
            case 53:
                v0 v0Var4 = (v0) y.a(parcel, v0.CREATOR);
                Bundle bundle10 = (Bundle) y.a(parcel, Bundle.CREATOR);
                long j35 = parcel.readLong();
                y.d(parcel);
                onActivityCreatedByScionActivityInfo(v0Var4, bundle10, j35);
                break;
            case 54:
                v0 v0Var5 = (v0) y.a(parcel, v0.CREATOR);
                long j36 = parcel.readLong();
                y.d(parcel);
                onActivityDestroyedByScionActivityInfo(v0Var5, j36);
                break;
            case 55:
                v0 v0Var6 = (v0) y.a(parcel, v0.CREATOR);
                long j37 = parcel.readLong();
                y.d(parcel);
                onActivityPausedByScionActivityInfo(v0Var6, j37);
                break;
            case 56:
                v0 v0Var7 = (v0) y.a(parcel, v0.CREATOR);
                long j38 = parcel.readLong();
                y.d(parcel);
                onActivityResumedByScionActivityInfo(v0Var7, j38);
                break;
            case 57:
                v0 v0Var8 = (v0) y.a(parcel, v0.CREATOR);
                IBinder strongBinder20 = parcel.readStrongBinder();
                if (strongBinder20 != null) {
                    IInterface iInterfaceQueryLocalInterface20 = strongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    k0Var2 = iInterfaceQueryLocalInterface20 instanceof l0 ? (l0) iInterfaceQueryLocalInterface20 : new k0(strongBinder20);
                }
                long j39 = parcel.readLong();
                y.d(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(v0Var8, k0Var2, j39);
                break;
            case 58:
                IBinder strongBinder21 = parcel.readStrongBinder();
                if (strongBinder21 != null) {
                    IInterface iInterfaceQueryLocalInterface21 = strongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    m0Var = iInterfaceQueryLocalInterface21 instanceof n0 ? (n0) iInterfaceQueryLocalInterface21 : new m0(strongBinder21, "com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback", 1);
                }
                y.d(parcel);
                retrieveAndUploadBatches(m0Var);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
