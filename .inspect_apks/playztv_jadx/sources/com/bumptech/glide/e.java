package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import e6.n;
import java.util.List;
import k8.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends ContextWrapper {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f2771k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f6.f f2772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q7.h f2773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f2774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t7.j f2775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f2776e;
    public final s.e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n f2777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final wb.c f2778h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t6.g f2779j;

    static {
        a aVar = new a();
        aVar.f2759u = v6.b.f13321a;
        f2771k = aVar;
    }

    public e(Context context, f6.f fVar, a2.c cVar, b0 b0Var, t7.j jVar, s.e eVar, List list, n nVar, wb.c cVar2, int i) {
        super(context.getApplicationContext());
        this.f2772a = fVar;
        this.f2774c = b0Var;
        this.f2775d = jVar;
        this.f2776e = list;
        this.f = eVar;
        this.f2777g = nVar;
        this.f2778h = cVar2;
        this.i = i;
        this.f2773b = new q7.h(cVar);
    }

    public final synchronized t6.g a() {
        try {
            if (this.f2779j == null) {
                this.f2775d.getClass();
                t6.g gVar = new t6.g();
                gVar.G = true;
                this.f2779j = gVar;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f2779j;
    }

    public final i b() {
        return (i) this.f2773b.get();
    }
}
