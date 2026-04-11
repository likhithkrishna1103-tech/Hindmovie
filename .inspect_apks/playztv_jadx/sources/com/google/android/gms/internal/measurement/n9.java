package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n9 implements o9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r4 f3127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r4 f3128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r4 f3129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r4 f3130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final r4 f3131e;

    static {
        a2.c cVar = new a2.c(o4.a("com.google.android.gms.measurement"), "", "", true, true);
        f3127a = cVar.n("measurement.sgtm.google_signal.enable", false);
        f3128b = cVar.n("measurement.sgtm.preview_mode_enabled", true);
        f3129c = cVar.n("measurement.sgtm.rollout_percentage_fix", false);
        f3130d = cVar.n("measurement.sgtm.service", true);
        f3131e = cVar.n("measurement.sgtm.upload_queue", false);
        cVar.l("measurement.id.sgtm", 0L);
    }
}
