package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r7 implements s7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r4 f3181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r4 f3182b;

    static {
        a2.c cVar = new a2.c(o4.a("com.google.android.gms.measurement"), "", "", true, true);
        cVar.n("measurement.collection.event_safelist", true);
        f3181a = cVar.n("measurement.service.store_null_safelist", true);
        f3182b = cVar.n("measurement.service.store_safelist", true);
    }
}
