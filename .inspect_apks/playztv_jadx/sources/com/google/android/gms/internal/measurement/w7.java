package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w7 implements t7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r4 f3229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r4 f3230b;

    static {
        a2.c cVar = new a2.c(o4.a("com.google.android.gms.measurement"), "", "", true, true);
        cVar.n("measurement.client.ad_id_consent_fix", true);
        cVar.n("measurement.service.consent.aiid_reset_fix", false);
        cVar.n("measurement.service.consent.aiid_reset_fix2", true);
        cVar.n("measurement.service.consent.app_start_fix", true);
        f3229a = cVar.n("measurement.service.consent.params_on_fx", true);
        f3230b = cVar.n("measurement.service.consent.pfo_on_fx", true);
    }
}
