package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v8 implements w8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r4 f3220a;

    static {
        a2.c cVar = new a2.c(o4.a("com.google.android.gms.measurement"), "", "", true, true);
        cVar.n("measurement.sdk.collection.enable_extend_user_property_size", true);
        cVar.n("measurement.sdk.collection.last_deep_link_referrer2", true);
        f3220a = cVar.n("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        cVar.l("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }
}
