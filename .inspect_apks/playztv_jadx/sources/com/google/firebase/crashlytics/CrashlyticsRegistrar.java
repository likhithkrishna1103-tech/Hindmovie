package com.google.firebase.crashlytics;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import dc.c;
import dc.d;
import ga.g;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import ma.a;
import ma.b;
import na.j;
import na.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f3566c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f3567a = new r(a.class, ExecutorService.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f3568b = new r(b.class, ExecutorService.class);

    static {
        Map map = c.f4124b;
        d dVar = d.f4125u;
        if (map.containsKey(dVar)) {
            Log.d("SessionsDependencies", "Dependency " + dVar + " already added.");
            return;
        }
        map.put(dVar, new dc.a(new se.c(true)));
        Log.d("SessionsDependencies", "Dependency to " + dVar + " added.");
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        na.a aVarA = na.b.a(pa.b.class);
        aVarA.f8873a = "fire-cls";
        aVarA.a(j.a(g.class));
        aVarA.a(j.a(ob.d.class));
        aVarA.a(new j(this.f3567a, 1, 0));
        aVarA.a(new j(this.f3568b, 1, 0));
        aVarA.a(new j(0, 2, qa.a.class));
        aVarA.a(new j(0, 2, ka.b.class));
        aVarA.a(new j(0, 2, ac.a.class));
        aVarA.f8878g = new nc.c(3, this);
        aVarA.c(2);
        return Arrays.asList(aVarA.b(), com.bumptech.glide.c.g("fire-cls", "19.2.0"));
    }
}
