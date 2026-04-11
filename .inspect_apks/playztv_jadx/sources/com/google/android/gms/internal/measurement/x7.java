package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x7 implements y7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r4 f3238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r4 f3239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r4 f3240c;

    static {
        a2.c cVar = new a2.c(o4.a("com.google.android.gms.measurement"), "", "", true, true);
        cVar.n("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f3238a = cVar.n("measurement.audience.refresh_event_count_filters_timestamp", false);
        f3239b = cVar.n("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f3240c = cVar.n("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }
}
