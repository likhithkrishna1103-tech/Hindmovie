package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m9 implements j9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r4 f3104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r4 f3105b;

    static {
        a2.c cVar = new a2.c(o4.a("com.google.android.gms.measurement"), "", "", true, true);
        cVar.n("measurement.client.sessions.background_sessions_enabled", true);
        f3104a = cVar.n("measurement.client.sessions.enable_fix_background_engagement", false);
        cVar.n("measurement.client.sessions.immediate_start_enabled_foreground", true);
        f3105b = cVar.n("measurement.client.sessions.enable_pause_engagement_in_background", true);
        cVar.n("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        cVar.n("measurement.client.sessions.session_id_enabled", true);
        cVar.l("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }
}
