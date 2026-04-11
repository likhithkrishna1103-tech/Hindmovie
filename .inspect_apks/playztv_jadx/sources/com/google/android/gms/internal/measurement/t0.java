package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 extends i0 implements w0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f3194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3195e;

    public t0() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        this.f3194d = new AtomicReference();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0002, code lost:
    
        r3 = r3.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object f(android.os.Bundle r3, java.lang.Class r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.t0.f(android.os.Bundle, java.lang.Class):java.lang.Object");
    }

    @Override // com.google.android.gms.internal.measurement.i0
    public final boolean c(int i, Parcel parcel, Parcel parcel2) {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) h0.a(parcel, Bundle.CREATOR);
        h0.d(parcel);
        h(bundle);
        parcel2.writeNoException();
        return true;
    }

    public final Bundle e(long j5) {
        Bundle bundle;
        synchronized (this.f3194d) {
            if (!this.f3195e) {
                try {
                    this.f3194d.wait(j5);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.f3194d.get();
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.measurement.w0
    public final void h(Bundle bundle) {
        synchronized (this.f3194d) {
            try {
                try {
                    this.f3194d.set(bundle);
                    this.f3195e = true;
                } finally {
                    this.f3194d.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
