package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l7 implements k7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n4 f2521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n4 f2522b;

    static {
        o4 o4Var = new o4(m4.a(), true, true);
        o4Var.o("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        o4Var.o("measurement.set_default_event_parameters_with_backfill.service", true);
        o4Var.m("measurement.id.set_default_event_parameters.fix_service_request_ordering", 0L);
        f2521a = o4Var.o("measurement.set_default_event_parameters.fix_app_update_logging", true);
        f2522b = o4Var.o("measurement.set_default_event_parameters.fix_service_request_ordering", false);
        o4Var.o("measurement.set_default_event_parameters.fix_subsequent_launches", true);
    }
}
