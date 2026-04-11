package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h6 f3037c = new h6();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x5 f3038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3039b = new ConcurrentHashMap();

    public h6() {
        a6[] a6VarArr = {k5.f3072b, x5.f3234b};
        x5 x5Var = new x5();
        x5Var.f3235a = a6VarArr;
        x5 x5Var2 = new x5();
        Charset charset = l5.f3086a;
        x5Var2.f3235a = x5Var;
        this.f3038a = x5Var2;
    }

    public final j6 a(Class cls) {
        j6 j6VarL;
        Charset charset = l5.f3086a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.f3039b;
        j6 j6Var = (j6) concurrentHashMap.get(cls);
        if (j6Var != null) {
            return j6Var;
        }
        x5 x5Var = this.f3038a;
        x5Var.getClass();
        j5.class.isAssignableFrom(cls);
        i6 i6VarA = ((x5) x5Var.f3235a).a(cls);
        if ((i6VarA.f3056d & 2) == 2) {
            j6VarL = new d6(i6VarA.f3053a);
        } else {
            j6VarL = c6.l(i6VarA, y5.f3248a[v.e.c(i6VarA.a())] != 1 ? q0.f3159a : null);
        }
        j6 j6Var2 = (j6) concurrentHashMap.putIfAbsent(cls, j6VarL);
        return j6Var2 != null ? j6Var2 : j6VarL;
    }
}
