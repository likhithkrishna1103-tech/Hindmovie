package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import f9.a0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends ContextWrapper {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f2200k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f2201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l8.i f2202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f2203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o8.j f2204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f2205e;
    public final v.e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z6.n f2206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final pc.c f2207h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o7.g f2208j;

    static {
        a aVar = new a();
        aVar.f2192v = q7.b.f10445a;
        f2200k = aVar;
    }

    public g(Context context, a7.g gVar, l lVar, a0 a0Var, o8.j jVar, v.e eVar, List list, z6.n nVar, pc.c cVar, int i) {
        super(context.getApplicationContext());
        this.f2201a = gVar;
        this.f2203c = a0Var;
        this.f2204d = jVar;
        this.f2205e = list;
        this.f = eVar;
        this.f2206g = nVar;
        this.f2207h = cVar;
        this.i = i;
        this.f2202b = new l8.i(lVar);
    }

    public final synchronized o7.g a() {
        try {
            if (this.f2208j == null) {
                this.f2204d.getClass();
                o7.g gVar = new o7.g();
                gVar.H = true;
                this.f2208j = gVar;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f2208j;
    }

    public final k b() {
        return (k) this.f2202b.get();
    }
}
