package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import com.google.android.gms.internal.measurement.z3;
import com.google.firebase.components.ComponentRegistrar;
import gb.a;
import gb.c;
import gb.d;
import h2.e;
import hb.b;
import hb.f;
import hb.n;
import hb.r;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f3024a = new n(new f(2));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f3025b = new n(new f(3));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f3026c = new n(new f(4));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f3027d = new n(new f(5));

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        r rVar = new r(a.class, ScheduledExecutorService.class);
        r[] rVarArr = {new r(a.class, ExecutorService.class), new r(a.class, Executor.class)};
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(rVar);
        for (r rVar2 : rVarArr) {
            z3.h(rVar2, "Null interface");
        }
        Collections.addAll(hashSet, rVarArr);
        b bVar = new b(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new e(10), hashSet3);
        r rVar3 = new r(gb.b.class, ScheduledExecutorService.class);
        r[] rVarArr2 = {new r(gb.b.class, ExecutorService.class), new r(gb.b.class, Executor.class)};
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        hashSet4.add(rVar3);
        for (r rVar4 : rVarArr2) {
            z3.h(rVar4, "Null interface");
        }
        Collections.addAll(hashSet4, rVarArr2);
        b bVar2 = new b(null, new HashSet(hashSet4), new HashSet(hashSet5), 0, 0, new e(11), hashSet6);
        r rVar5 = new r(c.class, ScheduledExecutorService.class);
        r[] rVarArr3 = {new r(c.class, ExecutorService.class), new r(c.class, Executor.class)};
        HashSet hashSet7 = new HashSet();
        HashSet hashSet8 = new HashSet();
        HashSet hashSet9 = new HashSet();
        hashSet7.add(rVar5);
        for (r rVar6 : rVarArr3) {
            z3.h(rVar6, "Null interface");
        }
        Collections.addAll(hashSet7, rVarArr3);
        b bVar3 = new b(null, new HashSet(hashSet7), new HashSet(hashSet8), 0, 0, new e(12), hashSet9);
        hb.a aVarA = b.a(new r(d.class, Executor.class));
        aVarA.f5875g = new e(13);
        return Arrays.asList(bVar, bVar2, bVar3, aVarA.b());
    }
}
