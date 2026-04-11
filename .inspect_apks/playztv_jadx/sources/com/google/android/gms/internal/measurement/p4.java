package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p4 implements z9.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public /* synthetic */ Context f3149u;

    @Override // z9.l
    public final Object get() {
        z9.g gVar;
        z9.g gVarD;
        Context contextCreateDeviceProtectedStorageContext = this.f3149u;
        z9.g gVar2 = m4.f3096a;
        if (gVar2 != null) {
            return gVar2;
        }
        synchronized (m4.class) {
            try {
                gVar = m4.f3096a;
                if (gVar == null) {
                    String str = Build.TYPE;
                    String str2 = Build.TAGS;
                    s.e eVar = o4.f3140a;
                    if ((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys"))) {
                        if (e4.a() && !contextCreateDeviceProtectedStorageContext.isDeviceProtectedStorage()) {
                            contextCreateDeviceProtectedStorageContext = contextCreateDeviceProtectedStorageContext.createDeviceProtectedStorageContext();
                        }
                        gVarD = m4.d(contextCreateDeviceProtectedStorageContext);
                    } else {
                        gVarD = z9.a.f14905u;
                    }
                    gVar = gVarD;
                    m4.f3096a = gVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }
}
