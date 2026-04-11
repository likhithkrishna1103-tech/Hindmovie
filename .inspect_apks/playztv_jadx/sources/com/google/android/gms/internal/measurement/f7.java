package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f7 implements g7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r4 f2971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r4 f2972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r4 f2973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r4 f2974d;

    static {
        a2.c cVar = new a2.c(o4.a("com.google.android.gms.measurement"), "", "", true, true);
        f2971a = cVar.n("measurement.consent.stop_reset_on_storage_denied.client", true);
        f2972b = cVar.n("measurement.consent.stop_reset_on_storage_denied.service", true);
        f2973c = cVar.n("measurement.consent.scrub_audience_data_analytics_consent", true);
        f2974d = cVar.n("measurement.consent.fix_first_open_count_from_snapshot", true);
    }
}
