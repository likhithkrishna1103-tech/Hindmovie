package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v.e f2584a = new v.e(0);

    public static synchronized void a() {
        v.e eVar = f2584a;
        Iterator it = ((v.d) eVar.values()).iterator();
        if (it.hasNext()) {
            ((r4) it.next()).getClass();
            throw null;
        }
        eVar.clear();
    }
}
