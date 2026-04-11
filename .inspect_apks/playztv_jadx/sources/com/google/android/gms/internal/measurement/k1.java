package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k1 implements Callable {
    @Override // java.util.concurrent.Callable
    public final Object call() {
        b bVar = new b("internal.platform", 4);
        bVar.f3061v.put("getVersion", new b("getVersion", 0));
        return bVar;
    }
}
