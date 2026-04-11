package v7;

import android.content.Context;
import android.os.Build;
import com.bumptech.glide.manager.s;
import com.google.android.gms.internal.measurement.r0;
import k8.c0;
import k8.z;
import o8.h;
import o8.o;
import q0.e;
import s7.p;
import s7.r;
import t7.l;
import t7.m;
import t7.v;
import ta.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final pb.c i = new pb.c(new b(), new c0(23));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pb.c f13326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f13327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s7.a f13328e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z f13329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s7.d f13330h;

    public c(Context context, pb.c cVar, m mVar, r7.b bVar) {
        v.i(context, "Null context is not permitted.");
        v.i(cVar, "Api must not be null.");
        v.i(bVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        v.i(applicationContext, "The provided context did not have an application context.");
        this.f13324a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.f13325b = attributionTag;
        this.f13326c = cVar;
        this.f13327d = mVar;
        this.f13328e = new s7.a(cVar, mVar, attributionTag);
        s7.d dVarE = s7.d.e(applicationContext);
        this.f13330h = dVarE;
        this.f = dVarE.B.getAndIncrement();
        this.f13329g = bVar.f11530a;
        r0 r0Var = dVarE.G;
        r0Var.sendMessage(r0Var.obtainMessage(7, this));
    }

    public final o a(l lVar) {
        e eVar = new e(8, false);
        q7.d[] dVarArr = {d8.c.f4100a};
        eVar.f10436v = new j(lVar);
        s sVar = new s(eVar, dVarArr, false);
        h hVar = new h();
        s7.d dVar = this.f13330h;
        dVar.getClass();
        p pVar = new p(new r(sVar, hVar, this.f13329g), dVar.C.get(), this);
        r0 r0Var = dVar.G;
        r0Var.sendMessage(r0Var.obtainMessage(4, pVar));
        return hVar.f9421a;
    }
}
