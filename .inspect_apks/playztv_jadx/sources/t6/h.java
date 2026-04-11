package t6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import e6.b0;
import e6.n;
import e6.r;
import e6.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import wa.t1;
import x6.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements c, u6.c {
    public static final boolean D = Log.isLoggable("GlideRequest", 2);
    public boolean A;
    public final RuntimeException B;
    public int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y6.e f12220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f12222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f12223e;
    public final Context f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bumptech.glide.e f12224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f12225h;
    public final Class i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f12226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f12227k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f12228l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bumptech.glide.f f12229m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final u6.d f12230n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f12231o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final v6.a f12232p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Executor f12233q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b0 f12234r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a7.b f12235s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f12236t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile n f12237u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f12238v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f12239w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f12240x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12241y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f12242z;

    public h(Context context, com.bumptech.glide.e eVar, Object obj, Object obj2, Class cls, a aVar, int i, int i10, com.bumptech.glide.f fVar, u6.d dVar, f fVar2, ArrayList arrayList, d dVar2, n nVar, v6.a aVar2, Executor executor) {
        this.f12219a = D ? String.valueOf(hashCode()) : null;
        this.f12220b = new y6.e();
        this.f12221c = obj;
        this.f = context;
        this.f12224g = eVar;
        this.f12225h = obj2;
        this.i = cls;
        this.f12226j = aVar;
        this.f12227k = i;
        this.f12228l = i10;
        this.f12229m = fVar;
        this.f12230n = dVar;
        this.f12222d = fVar2;
        this.f12231o = arrayList;
        this.f12223e = dVar2;
        this.f12237u = nVar;
        this.f12232p = aVar2;
        this.f12233q = executor;
        this.C = 1;
        if (this.B == null && ((Map) eVar.f2778h.f14088v).containsKey(com.bumptech.glide.d.class)) {
            this.B = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // t6.c
    public final boolean a() {
        boolean z2;
        synchronized (this.f12221c) {
            z2 = this.C == 4;
        }
        return z2;
    }

    public final void b() {
        if (this.A) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
        this.f12220b.a();
        this.f12230n.k(this);
        a7.b bVar = this.f12235s;
        if (bVar != null) {
            synchronized (((n) bVar.f620x)) {
                ((r) bVar.f618v).j((h) bVar.f619w);
            }
            this.f12235s = null;
        }
    }

    @Override // t6.c
    public final boolean c() {
        boolean z2;
        synchronized (this.f12221c) {
            z2 = this.C == 6;
        }
        return z2;
    }

    @Override // t6.c
    public final void clear() {
        synchronized (this.f12221c) {
            try {
                if (this.A) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f12220b.a();
                if (this.C == 6) {
                    return;
                }
                b();
                b0 b0Var = this.f12234r;
                if (b0Var != null) {
                    this.f12234r = null;
                } else {
                    b0Var = null;
                }
                d dVar = this.f12223e;
                if (dVar == null || dVar.j(this)) {
                    this.f12230n.h(d());
                }
                this.C = 6;
                if (b0Var != null) {
                    this.f12237u.getClass();
                    n.g(b0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Drawable d() {
        if (this.f12239w == null) {
            a aVar = this.f12226j;
            aVar.getClass();
            this.f12239w = null;
            int i = aVar.f12205x;
            if (i > 0) {
                Resources.Theme theme = aVar.H;
                Context context = this.f;
                if (theme == null) {
                    theme = context.getTheme();
                }
                this.f12239w = t1.n(context, context, i, theme);
            }
        }
        return this.f12239w;
    }

    public final void e(String str) {
        Log.v("GlideRequest", str + " this: " + this.f12219a);
    }

    @Override // t6.c
    public final void f() {
        synchronized (this.f12221c) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(x xVar, int i) {
        Drawable drawableD;
        this.f12220b.a();
        synchronized (this.f12221c) {
            try {
                xVar.getClass();
                int i10 = this.f12224g.i;
                if (i10 <= i) {
                    Log.w("Glide", "Load failed for [" + this.f12225h + "] with dimensions [" + this.f12241y + "x" + this.f12242z + "]", xVar);
                    if (i10 <= 4) {
                        xVar.d();
                    }
                }
                this.f12235s = null;
                this.C = 5;
                d dVar = this.f12223e;
                if (dVar != null) {
                    dVar.b(this);
                }
                boolean z2 = true;
                this.A = true;
                try {
                    List<f> list = this.f12231o;
                    if (list != null) {
                        for (f fVar : list) {
                            d dVar2 = this.f12223e;
                            if (dVar2 != null) {
                                dVar2.getRoot().a();
                            }
                            fVar.i(xVar);
                        }
                    }
                    f fVar2 = this.f12222d;
                    if (fVar2 != null) {
                        d dVar3 = this.f12223e;
                        if (dVar3 != null) {
                            dVar3.getRoot().a();
                        }
                        fVar2.i(xVar);
                    }
                    d dVar4 = this.f12223e;
                    if (dVar4 != null && !dVar4.d(this)) {
                        z2 = false;
                    }
                    if (z2) {
                        if (this.f12225h == null) {
                            if (this.f12240x == null) {
                                this.f12226j.getClass();
                                this.f12240x = null;
                            }
                            drawableD = this.f12240x;
                        } else {
                            drawableD = null;
                        }
                        if (drawableD == null) {
                            if (this.f12238v == null) {
                                this.f12226j.getClass();
                                this.f12238v = null;
                            }
                            drawableD = this.f12238v;
                        }
                        if (drawableD == null) {
                            drawableD = d();
                        }
                        this.f12230n.c(drawableD);
                    }
                } finally {
                    this.A = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t6.c
    public final void h() {
        synchronized (this.f12221c) {
            try {
                if (this.A) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f12220b.a();
                int i = x6.h.f14283b;
                this.f12236t = SystemClock.elapsedRealtimeNanos();
                if (this.f12225h == null) {
                    if (m.i(this.f12227k, this.f12228l)) {
                        this.f12241y = this.f12227k;
                        this.f12242z = this.f12228l;
                    }
                    if (this.f12240x == null) {
                        this.f12226j.getClass();
                        this.f12240x = null;
                    }
                    g(new x("Received null model"), this.f12240x == null ? 5 : 3);
                    return;
                }
                int i10 = this.C;
                if (i10 == 2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (i10 == 4) {
                    j(this.f12234r, 5, false);
                    return;
                }
                List<f> list = this.f12231o;
                if (list != null) {
                    for (f fVar : list) {
                    }
                }
                this.C = 3;
                if (m.i(this.f12227k, this.f12228l)) {
                    m(this.f12227k, this.f12228l);
                } else {
                    this.f12230n.b(this);
                }
                int i11 = this.C;
                if (i11 == 2 || i11 == 3) {
                    d dVar = this.f12223e;
                    if (dVar == null || dVar.d(this)) {
                        this.f12230n.e(d());
                    }
                }
                if (D) {
                    e("finished run method in " + x6.h.a(this.f12236t));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t6.c
    public final boolean i(c cVar) {
        int i;
        int i10;
        Object obj;
        Class cls;
        a aVar;
        com.bumptech.glide.f fVar;
        int size;
        int i11;
        int i12;
        Object obj2;
        Class cls2;
        a aVar2;
        com.bumptech.glide.f fVar2;
        int size2;
        if (!(cVar instanceof h)) {
            return false;
        }
        synchronized (this.f12221c) {
            try {
                i = this.f12227k;
                i10 = this.f12228l;
                obj = this.f12225h;
                cls = this.i;
                aVar = this.f12226j;
                fVar = this.f12229m;
                List list = this.f12231o;
                size = list != null ? list.size() : 0;
            } finally {
            }
        }
        h hVar = (h) cVar;
        synchronized (hVar.f12221c) {
            try {
                i11 = hVar.f12227k;
                i12 = hVar.f12228l;
                obj2 = hVar.f12225h;
                cls2 = hVar.i;
                aVar2 = hVar.f12226j;
                fVar2 = hVar.f12229m;
                List list2 = hVar.f12231o;
                size2 = list2 != null ? list2.size() : 0;
            } finally {
            }
        }
        if (i == i11 && i10 == i12) {
            char[] cArr = m.f14291a;
            if ((obj == null ? obj2 == null : obj.equals(obj2)) && cls.equals(cls2)) {
                if ((aVar == null ? aVar2 == null : aVar.g(aVar2)) && fVar == fVar2 && size == size2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // t6.c
    public final boolean isRunning() {
        boolean z2;
        synchronized (this.f12221c) {
            int i = this.C;
            z2 = i == 2 || i == 3;
        }
        return z2;
    }

    public final void j(b0 b0Var, int i, boolean z2) {
        this.f12220b.a();
        b0 b0Var2 = null;
        try {
            synchronized (this.f12221c) {
                try {
                    this.f12235s = null;
                    if (b0Var == null) {
                        g(new x("Expected to receive a Resource<R> with an object of " + this.i + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = b0Var.get();
                    try {
                        if (obj == null || !this.i.isAssignableFrom(obj.getClass())) {
                            this.f12234r = null;
                            StringBuilder sb2 = new StringBuilder("Expected to receive an object of ");
                            sb2.append(this.i);
                            sb2.append(" but instead got ");
                            sb2.append(obj != null ? obj.getClass() : "");
                            sb2.append("{");
                            sb2.append(obj);
                            sb2.append("} inside Resource{");
                            sb2.append(b0Var);
                            sb2.append("}.");
                            sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                            g(new x(sb2.toString()), 5);
                        } else {
                            d dVar = this.f12223e;
                            if (dVar == null || dVar.g(this)) {
                                l(b0Var, obj, i);
                                return;
                            } else {
                                this.f12234r = null;
                                this.C = 4;
                            }
                        }
                        this.f12237u.getClass();
                        n.g(b0Var);
                    } catch (Throwable th) {
                        b0Var2 = b0Var;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (b0Var2 != null) {
                this.f12237u.getClass();
                n.g(b0Var2);
            }
            throw th3;
        }
    }

    @Override // t6.c
    public final boolean k() {
        boolean z2;
        synchronized (this.f12221c) {
            z2 = this.C == 4;
        }
        return z2;
    }

    public final void l(b0 b0Var, Object obj, int i) {
        boolean zMo3a;
        d dVar = this.f12223e;
        if (dVar != null) {
            dVar.getRoot().a();
        }
        this.C = 4;
        this.f12234r = b0Var;
        if (this.f12224g.i <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + l4.a.z(i) + " for " + this.f12225h + " with size [" + this.f12241y + "x" + this.f12242z + "] in " + x6.h.a(this.f12236t) + " ms");
        }
        if (dVar != null) {
            dVar.e(this);
        }
        boolean z2 = true;
        this.A = true;
        try {
            List list = this.f12231o;
            if (list != null) {
                Iterator it = list.iterator();
                zMo3a = false;
                while (it.hasNext()) {
                    zMo3a |= ((f) it.next()).mo3a(obj);
                }
            } else {
                zMo3a = false;
            }
            f fVar = this.f12222d;
            if (fVar == null || !fVar.mo3a(obj)) {
                z2 = false;
            }
            if (!(z2 | zMo3a)) {
                this.f12232p.getClass();
                this.f12230n.a(obj);
            }
            this.A = false;
        } catch (Throwable th) {
            this.A = false;
            throw th;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void m(int i, int i10) throws Throwable {
        Object obj;
        h hVar = this;
        int iRound = i;
        hVar.f12220b.a();
        Object obj2 = hVar.f12221c;
        synchronized (obj2) {
            try {
                try {
                    boolean z2 = D;
                    if (z2) {
                        hVar.e("Got onSizeReady in " + x6.h.a(hVar.f12236t));
                    }
                    if (hVar.C == 3) {
                        hVar.C = 2;
                        hVar.f12226j.getClass();
                        if (iRound != Integer.MIN_VALUE) {
                            iRound = Math.round(iRound * 1.0f);
                        }
                        hVar.f12241y = iRound;
                        hVar.f12242z = i10 == Integer.MIN_VALUE ? i10 : Math.round(1.0f * i10);
                        if (z2) {
                            hVar.e("finished setup for calling load in " + x6.h.a(hVar.f12236t));
                        }
                        n nVar = hVar.f12237u;
                        com.bumptech.glide.e eVar = hVar.f12224g;
                        Object obj3 = hVar.f12225h;
                        a aVar = hVar.f12226j;
                        c6.f fVar = aVar.B;
                        try {
                            int i11 = hVar.f12241y;
                            int i12 = hVar.f12242z;
                            Class cls = aVar.F;
                            try {
                                Class cls2 = hVar.i;
                                com.bumptech.glide.f fVar2 = hVar.f12229m;
                                e6.m mVar = aVar.f12203v;
                                try {
                                    x6.c cVar = aVar.E;
                                    boolean z10 = aVar.C;
                                    boolean z11 = aVar.J;
                                    try {
                                        c6.i iVar = aVar.D;
                                        boolean z12 = aVar.f12206y;
                                        boolean z13 = aVar.K;
                                        Executor executor = hVar.f12233q;
                                        Object obj4 = obj2;
                                        try {
                                            hVar.f12235s = nVar.a(eVar, obj3, fVar, i11, i12, cls, cls2, fVar2, mVar, cVar, z10, z11, iVar, z12, z13, hVar, executor);
                                            if (hVar.C != 2) {
                                                hVar.f12235s = null;
                                            }
                                            if (z2) {
                                                hVar.e("finished onSizeReady in " + x6.h.a(hVar.f12236t));
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            obj = obj4;
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        obj = obj2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj = obj2;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                obj = obj2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            obj = obj2;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    obj = hVar;
                }
            } catch (Throwable th7) {
                th = th7;
                obj = obj2;
            }
        }
    }

    public final String toString() {
        Object obj;
        Class cls;
        synchronized (this.f12221c) {
            obj = this.f12225h;
            cls = this.i;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
