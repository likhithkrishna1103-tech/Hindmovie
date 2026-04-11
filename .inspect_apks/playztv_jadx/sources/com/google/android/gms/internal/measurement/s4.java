package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.StrictMode;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class s4 implements j4 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final s.e f3188u = new s.e(0);

    public static s4 a(Context context, q4 q4Var) {
        if (e4.a()) {
            throw null;
        }
        synchronized (s4.class) {
            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                throw null;
            } finally {
            }
        }
    }

    public static synchronized void b() {
        Iterator it = ((s.d) f3188u.values()).iterator();
        if (it.hasNext()) {
            ((s4) it.next()).getClass();
            throw null;
        }
        f3188u.clear();
    }
}
