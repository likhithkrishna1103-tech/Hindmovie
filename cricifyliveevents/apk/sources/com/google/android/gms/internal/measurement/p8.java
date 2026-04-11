package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p8 implements o8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n4 f2574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n4 f2575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n4 f2576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n4 f2577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n4 f2578e;
    public static final n4 f;

    static {
        o4 o4Var = new o4(m4.a(), true, true);
        f2574a = o4Var.o("measurement.test.boolean_flag", false);
        f2575b = o4Var.m("measurement.test.cached_long_flag", -1L);
        Double dValueOf = Double.valueOf(-3.0d);
        Object obj = n4.f2543g;
        f2576c = new n4(o4Var, "measurement.test.double_flag", dValueOf, 2);
        f2577d = o4Var.m("measurement.test.int_flag", -2L);
        f2578e = o4Var.m("measurement.test.long_flag", -1L);
        f = o4Var.p("measurement.test.string_flag", "---");
    }
}
