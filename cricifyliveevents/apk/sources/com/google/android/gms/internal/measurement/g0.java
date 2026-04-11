package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends x implements l0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f2451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2452e;

    public g0() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        this.f2451d = new AtomicReference();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0002, code lost:
    
        r3 = r3.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(android.os.Bundle r3, java.lang.Class r4) {
        /*
            if (r3 == 0) goto L38
            java.lang.String r0 = "r"
            java.lang.Object r3 = r3.get(r0)
            if (r3 == 0) goto L38
            java.lang.Object r3 = r4.cast(r3)     // Catch: java.lang.ClassCastException -> Lf
            return r3
        Lf:
            r0 = move-exception
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getCanonicalName()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected object type. Expected, Received: "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r4 = ", "
            r1.append(r4)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            java.lang.String r4 = "AM"
            android.util.Log.w(r4, r3, r0)
            throw r0
        L38:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.g0.f(android.os.Bundle, java.lang.Class):java.lang.Object");
    }

    @Override // com.google.android.gms.internal.measurement.x
    public final boolean b(int i, Parcel parcel, Parcel parcel2) {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) y.a(parcel, Bundle.CREATOR);
        y.d(parcel);
        t(bundle);
        parcel2.writeNoException();
        return true;
    }

    public final Bundle e(long j4) {
        Bundle bundle;
        AtomicReference atomicReference = this.f2451d;
        synchronized (atomicReference) {
            if (!this.f2452e) {
                try {
                    atomicReference.wait(j4);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.f2451d.get();
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.measurement.l0
    public final void t(Bundle bundle) {
        AtomicReference atomicReference = this.f2451d;
        synchronized (atomicReference) {
            try {
                try {
                    atomicReference.set(bundle);
                    this.f2452e = true;
                } finally {
                    this.f2451d.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
