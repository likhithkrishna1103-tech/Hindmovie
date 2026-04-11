package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h9 implements i9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r4 f3042a;

    static {
        a2.c cVar = new a2.c(o4.a("com.google.android.gms.measurement"), "", "", true, true);
        cVar.n("measurement.collection.enable_session_stitching_token.client.dev", true);
        cVar.n("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        f3042a = cVar.n("measurement.session_stitching_token_enabled", false);
        cVar.n("measurement.link_sst_to_sid", true);
    }
}
