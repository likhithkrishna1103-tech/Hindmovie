package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a9 implements x8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r4 f2890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r4 f2891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r4 f2892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r4 f2893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final r4 f2894e;
    public static final r4 f;

    static {
        a2.c cVar = new a2.c(o4.a("com.google.android.gms.measurement"), "", "", true, true);
        f2890a = cVar.n("measurement.test.boolean_flag", false);
        f2891b = cVar.l("measurement.test.cached_long_flag", -1L);
        Double dValueOf = Double.valueOf(-3.0d);
        Object obj = r4.f3172g;
        f2892c = new r4(cVar, "measurement.test.double_flag", dValueOf, 1);
        f2893d = cVar.l("measurement.test.int_flag", -2L);
        f2894e = cVar.l("measurement.test.long_flag", -1L);
        f = cVar.m("measurement.test.string_flag", "---");
    }
}
