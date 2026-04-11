package o7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import s7.m;
import z6.b0;
import z6.n;
import z6.r;
import z6.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements c, p7.c {
    public static final boolean D = Log.isLoggable("GlideRequest", 2);
    public boolean A;
    public final RuntimeException B;
    public int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t7.e f9580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f9581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f9582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f9583e;
    public final Context f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bumptech.glide.g f9584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f9585h;
    public final Class i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f9586j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f9587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f9588l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bumptech.glide.h f9589m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final p7.d f9590n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f9591o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final q7.a f9592p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Executor f9593q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b0 f9594r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public z6.e f9595s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f9596t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile n f9597u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f9598v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f9599w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f9600x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f9601y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f9602z;

    public h(Context context, com.bumptech.glide.g gVar, Object obj, Object obj2, Class cls, a aVar, int i, int i10, com.bumptech.glide.h hVar, p7.d dVar, f fVar, ArrayList arrayList, d dVar2, n nVar, q7.a aVar2, Executor executor) {
        this.f9579a = D ? String.valueOf(hashCode()) : null;
        this.f9580b = new t7.e();
        this.f9581c = obj;
        this.f = context;
        this.f9584g = gVar;
        this.f9585h = obj2;
        this.i = cls;
        this.f9586j = aVar;
        this.f9587k = i;
        this.f9588l = i10;
        this.f9589m = hVar;
        this.f9590n = dVar;
        this.f9582d = fVar;
        this.f9591o = arrayList;
        this.f9583e = dVar2;
        this.f9597u = nVar;
        this.f9592p = aVar2;
        this.f9593q = executor;
        this.C = 1;
        if (this.B == null && ((Map) gVar.f2207h.f10180v).containsKey(com.bumptech.glide.d.class)) {
            this.B = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // o7.c
    public final boolean a() {
        boolean z10;
        synchronized (this.f9581c) {
            z10 = this.C == 4;
        }
        return z10;
    }

    public final void b() {
        if (this.A) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
        this.f9580b.a();
        this.f9590n.f(this);
        z6.e eVar = this.f9595s;
        if (eVar != null) {
            synchronized (((n) eVar.f15253c)) {
                ((r) eVar.f15251a).j((h) eVar.f15252b);
            }
            this.f9595s = null;
        }
    }

    @Override // o7.c
    public final void c() {
        synchronized (this.f9581c) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o7.c
    public final void clear() {
        synchronized (this.f9581c) {
            try {
                if (this.A) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f9580b.a();
                if (this.C == 6) {
                    return;
                }
                b();
                b0 b0Var = this.f9594r;
                if (b0Var != null) {
                    this.f9594r = null;
                } else {
                    b0Var = null;
                }
                d dVar = this.f9583e;
                if (dVar == null || dVar.e(this)) {
                    this.f9590n.k(e());
                }
                this.C = 6;
                if (b0Var != null) {
                    this.f9597u.getClass();
                    n.g(b0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o7.c
    public final boolean d(c cVar) {
        int i;
        int i10;
        Object obj;
        Class cls;
        a aVar;
        com.bumptech.glide.h hVar;
        int size;
        int i11;
        int i12;
        Object obj2;
        Class cls2;
        a aVar2;
        com.bumptech.glide.h hVar2;
        int size2;
        if (!(cVar instanceof h)) {
            return false;
        }
        synchronized (this.f9581c) {
            try {
                i = this.f9587k;
                i10 = this.f9588l;
                obj = this.f9585h;
                cls = this.i;
                aVar = this.f9586j;
                hVar = this.f9589m;
                List list = this.f9591o;
                size = list != null ? list.size() : 0;
            } finally {
            }
        }
        h hVar3 = (h) cVar;
        synchronized (hVar3.f9581c) {
            try {
                i11 = hVar3.f9587k;
                i12 = hVar3.f9588l;
                obj2 = hVar3.f9585h;
                cls2 = hVar3.i;
                aVar2 = hVar3.f9586j;
                hVar2 = hVar3.f9589m;
                List list2 = hVar3.f9591o;
                size2 = list2 != null ? list2.size() : 0;
            } finally {
            }
        }
        if (i == i11 && i10 == i12) {
            char[] cArr = m.f11607a;
            if ((obj == null ? obj2 == null : obj.equals(obj2)) && cls.equals(cls2)) {
                if ((aVar == null ? aVar2 == null : aVar.g(aVar2)) && hVar == hVar2 && size == size2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Drawable e() {
        if (this.f9599w == null) {
            a aVar = this.f9586j;
            aVar.getClass();
            this.f9599w = null;
            int i = aVar.f9567y;
            if (i > 0) {
                aVar.getClass();
                Context context = this.f;
                this.f9599w = sd.i.s(context, context, i, context.getTheme());
            }
        }
        return this.f9599w;
    }

    @Override // o7.c
    public final boolean f() {
        boolean z10;
        synchronized (this.f9581c) {
            z10 = this.C == 6;
        }
        return z10;
    }

    public final void g(String str) {
        Log.v("GlideRequest", str + " this: " + this.f9579a);
    }

    @Override // o7.c
    public final void h() {
        synchronized (this.f9581c) {
            try {
                if (this.A) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f9580b.a();
                int i = s7.h.f11599b;
                this.f9596t = SystemClock.elapsedRealtimeNanos();
                if (this.f9585h == null) {
                    if (m.i(this.f9587k, this.f9588l)) {
                        this.f9601y = this.f9587k;
                        this.f9602z = this.f9588l;
                    }
                    if (this.f9600x == null) {
                        this.f9586j.getClass();
                        this.f9600x = null;
                    }
                    i(new x("Received null model"), this.f9600x == null ? 5 : 3);
                    return;
                }
                int i10 = this.C;
                if (i10 == 2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (i10 == 4) {
                    k(this.f9594r, 5, false);
                    return;
                }
                List<f> list = this.f9591o;
                if (list != null) {
                    for (f fVar : list) {
                    }
                }
                this.C = 3;
                if (m.i(this.f9587k, this.f9588l)) {
                    m(this.f9587k, this.f9588l);
                } else {
                    this.f9590n.e(this);
                }
                int i11 = this.C;
                if (i11 == 2 || i11 == 3) {
                    d dVar = this.f9583e;
                    if (dVar == null || dVar.k(this)) {
                        this.f9590n.g(e());
                    }
                }
                if (D) {
                    g("finished run method in " + s7.h.a(this.f9596t));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i(x xVar, int i) {
        Drawable drawableE;
        this.f9580b.a();
        synchronized (this.f9581c) {
            try {
                xVar.getClass();
                int i10 = this.f9584g.i;
                if (i10 <= i) {
                    Log.w("Glide", "Load failed for [" + this.f9585h + "] with dimensions [" + this.f9601y + "x" + this.f9602z + "]", xVar);
                    if (i10 <= 4) {
                        xVar.d();
                    }
                }
                this.f9595s = null;
                this.C = 5;
                d dVar = this.f9583e;
                if (dVar != null) {
                    dVar.i(this);
                }
                boolean z10 = true;
                this.A = true;
                try {
                    List<f> list = this.f9591o;
                    if (list != null) {
                        for (f fVar : list) {
                            d dVar2 = this.f9583e;
                            if (dVar2 != null) {
                                dVar2.getRoot().a();
                            }
                            fVar.i(xVar);
                        }
                    }
                    f fVar2 = this.f9582d;
                    if (fVar2 != null) {
                        d dVar3 = this.f9583e;
                        if (dVar3 != null) {
                            dVar3.getRoot().a();
                        }
                        fVar2.i(xVar);
                    }
                    d dVar4 = this.f9583e;
                    if (dVar4 != null && !dVar4.k(this)) {
                        z10 = false;
                    }
                    if (z10) {
                        if (this.f9585h == null) {
                            if (this.f9600x == null) {
                                this.f9586j.getClass();
                                this.f9600x = null;
                            }
                            drawableE = this.f9600x;
                        } else {
                            drawableE = null;
                        }
                        if (drawableE == null) {
                            if (this.f9598v == null) {
                                this.f9586j.getClass();
                                this.f9598v = null;
                            }
                            drawableE = this.f9598v;
                        }
                        if (drawableE == null) {
                            drawableE = e();
                        }
                        this.f9590n.b(drawableE);
                    }
                } finally {
                    this.A = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // o7.c
    public final boolean isRunning() {
        boolean z10;
        synchronized (this.f9581c) {
            int i = this.C;
            z10 = i == 2 || i == 3;
        }
        return z10;
    }

    @Override // o7.c
    public final boolean j() {
        boolean z10;
        synchronized (this.f9581c) {
            z10 = this.C == 4;
        }
        return z10;
    }

    public final void k(b0 b0Var, int i, boolean z10) {
        this.f9580b.a();
        b0 b0Var2 = null;
        try {
            synchronized (this.f9581c) {
                try {
                    this.f9595s = null;
                    if (b0Var == null) {
                        i(new x("Expected to receive a Resource<R> with an object of " + this.i + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = b0Var.get();
                    try {
                        if (obj == null || !this.i.isAssignableFrom(obj.getClass())) {
                            this.f9594r = null;
                            StringBuilder sb = new StringBuilder("Expected to receive an object of ");
                            sb.append(this.i);
                            sb.append(" but instead got ");
                            sb.append(obj != null ? obj.getClass() : "");
                            sb.append("{");
                            sb.append(obj);
                            sb.append("} inside Resource{");
                            sb.append(b0Var);
                            sb.append("}.");
                            sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                            i(new x(sb.toString()), 5);
                        } else {
                            d dVar = this.f9583e;
                            if (dVar == null || dVar.g(this)) {
                                l(b0Var, obj, i);
                                return;
                            } else {
                                this.f9594r = null;
                                this.C = 4;
                            }
                        }
                        this.f9597u.getClass();
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
                this.f9597u.getClass();
                n.g(b0Var2);
            }
            throw th3;
        }
    }

    public final void l(b0 b0Var, Object obj, int i) {
        boolean zMo0a;
        d dVar = this.f9583e;
        if (dVar != null) {
            dVar.getRoot().a();
        }
        this.C = 4;
        this.f9594r = b0Var;
        if (this.f9584g.i <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + l0.e.v(i) + " for " + this.f9585h + " with size [" + this.f9601y + "x" + this.f9602z + "] in " + s7.h.a(this.f9596t) + " ms");
        }
        if (dVar != null) {
            dVar.b(this);
        }
        boolean z10 = true;
        this.A = true;
        try {
            List list = this.f9591o;
            if (list != null) {
                Iterator it = list.iterator();
                zMo0a = false;
                while (it.hasNext()) {
                    zMo0a |= ((f) it.next()).mo0a(obj);
                }
            } else {
                zMo0a = false;
            }
            f fVar = this.f9582d;
            if (fVar == null || !fVar.mo0a(obj)) {
                z10 = false;
            }
            if (!(z10 | zMo0a)) {
                this.f9592p.getClass();
                this.f9590n.a(obj);
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
        hVar.f9580b.a();
        Object obj2 = hVar.f9581c;
        synchronized (obj2) {
            try {
                try {
                    boolean z10 = D;
                    if (z10) {
                        hVar.g("Got onSizeReady in " + s7.h.a(hVar.f9596t));
                    }
                    if (hVar.C == 3) {
                        hVar.C = 2;
                        hVar.f9586j.getClass();
                        if (iRound != Integer.MIN_VALUE) {
                            iRound = Math.round(iRound * 1.0f);
                        }
                        hVar.f9601y = iRound;
                        hVar.f9602z = i10 == Integer.MIN_VALUE ? i10 : Math.round(1.0f * i10);
                        if (z10) {
                            hVar.g("finished setup for calling load in " + s7.h.a(hVar.f9596t));
                        }
                        n nVar = hVar.f9597u;
                        com.bumptech.glide.g gVar = hVar.f9584g;
                        Object obj3 = hVar.f9585h;
                        a aVar = hVar.f9586j;
                        x6.e eVar = aVar.C;
                        try {
                            int i11 = hVar.f9601y;
                            int i12 = hVar.f9602z;
                            Class cls = aVar.G;
                            try {
                                Class cls2 = hVar.i;
                                com.bumptech.glide.h hVar2 = hVar.f9589m;
                                z6.m mVar = aVar.f9565w;
                                try {
                                    s7.c cVar = aVar.F;
                                    boolean z11 = aVar.D;
                                    boolean z12 = aVar.J;
                                    try {
                                        x6.h hVar3 = aVar.E;
                                        boolean z13 = aVar.f9568z;
                                        boolean z14 = aVar.K;
                                        Executor executor = hVar.f9593q;
                                        Object obj4 = obj2;
                                        try {
                                            hVar.f9595s = nVar.a(gVar, obj3, eVar, i11, i12, cls, cls2, hVar2, mVar, cVar, z11, z12, hVar3, z13, z14, hVar, executor);
                                            if (hVar.C != 2) {
                                                hVar.f9595s = null;
                                            }
                                            if (z10) {
                                                hVar.g("finished onSizeReady in " + s7.h.a(hVar.f9596t));
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
        synchronized (this.f9581c) {
            obj = this.f9585h;
            cls = this.i;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
