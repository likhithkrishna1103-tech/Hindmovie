package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g6 f2460c = new g6();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2462b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w5 f2461a = new w5(0);

    public final j6 a(Class cls) {
        j6 j6VarU;
        Charset charset = p5.f2570a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.f2462b;
        j6 j6Var = (j6) concurrentHashMap.get(cls);
        if (j6Var != null) {
            return j6Var;
        }
        w5 w5Var = this.f2461a;
        w5Var.getClass();
        g5 g5Var = k6.f2510a;
        i5.class.isAssignableFrom(cls);
        i6 i6VarB = ((w5) w5Var.f2709a).b(cls);
        if ((i6VarB.f2488d & 2) == 2) {
            g5 g5Var2 = k6.f2510a;
            g5 g5Var3 = d5.f2365a;
            j6VarU = new d6(g5Var2, i6VarB.f2485a);
        } else {
            int i = e6.f2380a;
            int i10 = t5.f2641a;
            g5 g5Var4 = k6.f2510a;
            g5 g5Var5 = i6VarB.a() + (-1) != 1 ? d5.f2365a : null;
            int i11 = z5.f2743a;
            j6VarU = c6.u(i6VarB, g5Var4, g5Var5);
        }
        j6 j6Var2 = (j6) concurrentHashMap.putIfAbsent(cls, j6VarU);
        return j6Var2 != null ? j6Var2 : j6VarU;
    }
}
