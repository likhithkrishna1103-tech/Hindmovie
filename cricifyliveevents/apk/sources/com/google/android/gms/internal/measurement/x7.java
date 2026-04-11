package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x7 implements w7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n4 f2726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n4 f2727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n4 f2728c;

    static {
        o4 o4Var = new o4(m4.a(), true, true);
        o4Var.o("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f2726a = o4Var.o("measurement.audience.refresh_event_count_filters_timestamp", false);
        f2727b = o4Var.o("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f2728c = o4Var.o("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }
}
