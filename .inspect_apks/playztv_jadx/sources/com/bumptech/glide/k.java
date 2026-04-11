package com.bumptech.glide;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import androidx.datastore.preferences.protobuf.i1;
import com.bumptech.glide.manager.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class k extends t6.a {
    public final Context L;
    public final m M;
    public final Class N;
    public final e O;
    public a P;
    public Object Q;
    public ArrayList R;
    public k S;
    public k T;
    public final boolean U = true;
    public boolean V;
    public boolean W;

    static {
    }

    public k(b bVar, m mVar, Class cls, Context context) {
        t6.g gVar;
        this.M = mVar;
        this.N = cls;
        this.L = context;
        s.e eVar = mVar.f2824u.f2762w.f;
        a aVar = (a) eVar.get(cls);
        if (aVar == null) {
            for (Map.Entry entry : (i1) eVar.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    aVar = (a) entry.getValue();
                }
            }
        }
        this.P = aVar == null ? e.f2771k : aVar;
        this.O = bVar.f2762w;
        Iterator it = mVar.C.iterator();
        while (it.hasNext()) {
            z((t6.f) it.next());
        }
        synchronized (mVar) {
            gVar = mVar.D;
        }
        a(gVar);
    }

    @Override // t6.a
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public k a(t6.a aVar) {
        x6.f.b(aVar);
        return (k) super.a(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final t6.c B(Object obj, u6.d dVar, t6.f fVar, t6.d dVar2, a aVar, f fVar2, int i, int i10, t6.a aVar2, Executor executor) {
        t6.d dVar3;
        t6.d bVar;
        t6.a aVar3;
        t6.c hVar;
        f fVar3;
        if (this.T != null) {
            bVar = new t6.b(obj, dVar2);
            dVar3 = bVar;
        } else {
            dVar3 = null;
            bVar = dVar2;
        }
        k kVar = this.S;
        if (kVar == null) {
            Context context = this.L;
            e eVar = this.O;
            aVar3 = aVar2;
            hVar = new t6.h(context, eVar, obj, this.Q, this.N, aVar3, i, i10, fVar2, dVar, fVar, this.R, bVar, eVar.f2777g, aVar.f2759u, executor);
        } else {
            if (this.W) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            a aVar4 = kVar.U ? aVar : kVar.P;
            if (t6.a.h(kVar.f12202u, 8)) {
                fVar3 = this.S.f12204w;
            } else {
                int iOrdinal = fVar2.ordinal();
                if (iOrdinal == 0 || iOrdinal == 1) {
                    fVar3 = f.f2780u;
                } else if (iOrdinal == 2) {
                    fVar3 = f.f2781v;
                } else {
                    if (iOrdinal != 3) {
                        throw new IllegalArgumentException("unknown priority: " + this.f12204w);
                    }
                    fVar3 = f.f2782w;
                }
            }
            f fVar4 = fVar3;
            k kVar2 = this.S;
            int i11 = kVar2.A;
            int i12 = kVar2.f12207z;
            if (x6.m.i(i, i10)) {
                k kVar3 = this.S;
                if (!x6.m.i(kVar3.A, kVar3.f12207z)) {
                    i11 = aVar2.A;
                    i12 = aVar2.f12207z;
                }
            }
            int i13 = i12;
            int i14 = i11;
            t6.i iVar = new t6.i(obj, bVar);
            Context context2 = this.L;
            e eVar2 = this.O;
            t6.i iVar2 = iVar;
            t6.h hVar2 = new t6.h(context2, eVar2, obj, this.Q, this.N, aVar2, i, i10, fVar2, dVar, fVar, this.R, iVar2, eVar2.f2777g, aVar.f2759u, executor);
            this.W = true;
            k kVar4 = this.S;
            t6.c cVarB = kVar4.B(obj, dVar, fVar, iVar2, aVar4, fVar4, i14, i13, kVar4, executor);
            this.W = false;
            iVar2.f12245c = hVar2;
            iVar2.f12246d = cVarB;
            aVar3 = aVar2;
            hVar = iVar2;
        }
        if (dVar3 == null) {
            return hVar;
        }
        k kVar5 = this.T;
        int i15 = kVar5.A;
        int i16 = kVar5.f12207z;
        if (x6.m.i(i, i10)) {
            k kVar6 = this.T;
            if (!x6.m.i(kVar6.A, kVar6.f12207z)) {
                i15 = aVar3.A;
                i16 = aVar3.f12207z;
            }
        }
        int i17 = i16;
        k kVar7 = this.T;
        t6.b bVar2 = dVar3;
        t6.c cVarB2 = kVar7.B(obj, dVar, fVar, bVar2, kVar7.P, kVar7.f12204w, i15, i17, kVar7, executor);
        bVar2.f12210c = hVar;
        bVar2.f12211d = cVarB2;
        return bVar2;
    }

    @Override // t6.a
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public k clone() {
        k kVar = (k) super.clone();
        kVar.P = kVar.P.clone();
        if (kVar.R != null) {
            kVar.R = new ArrayList(kVar.R);
        }
        k kVar2 = kVar.S;
        if (kVar2 != null) {
            kVar.S = kVar2.clone();
        }
        k kVar3 = kVar.T;
        if (kVar3 != null) {
            kVar.T = kVar3.clone();
        }
        return kVar;
    }

    public final void D(ImageView imageView) {
        t6.a aVarJ;
        u6.d bVar;
        x6.m.a();
        x6.f.b(imageView);
        if (!t6.a.h(this.f12202u, 2048) && imageView.getScaleType() != null) {
            switch (j.f2793a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarJ = clone().j();
                    break;
                case 2:
                    aVarJ = clone().k();
                    break;
                case 3:
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    aVarJ = clone().l();
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    aVarJ = clone().k();
                    break;
                default:
                    aVarJ = this;
                    break;
            }
        } else {
            aVarJ = this;
        }
        this.O.f2774c.getClass();
        Class cls = this.N;
        if (Bitmap.class.equals(cls)) {
            bVar = new u6.b(imageView, 0);
        } else {
            if (!Drawable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
            }
            bVar = new u6.b(imageView, 1);
        }
        E(bVar, null, aVarJ, x6.f.f14280a);
    }

    public final void E(u6.d dVar, t6.e eVar, t6.a aVar, Executor executor) {
        x6.f.b(dVar);
        if (!this.V) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        t6.c cVarB = B(new Object(), dVar, eVar, null, this.P, aVar.f12204w, aVar.A, aVar.f12207z, aVar, executor);
        t6.c cVarG = dVar.g();
        if (cVarB.i(cVarG) && (aVar.f12206y || !cVarG.k())) {
            x6.f.c(cVarG, "Argument must not be null");
            if (cVarG.isRunning()) {
                return;
            }
            cVarG.h();
            return;
        }
        this.M.p(dVar);
        dVar.j(cVarB);
        m mVar = this.M;
        synchronized (mVar) {
            mVar.f2829z.f2864u.add(dVar);
            s sVar = mVar.f2827x;
            ((Set) sVar.f2863x).add(cVarB);
            if (sVar.f2862w) {
                cVarB.clear();
                if (Log.isLoggable("RequestTracker", 2)) {
                    Log.v("RequestTracker", "Paused, delaying request");
                }
                ((HashSet) sVar.f2861v).add(cVarB);
            } else {
                cVarB.h();
            }
        }
    }

    public k F(pc.j jVar) {
        if (this.I) {
            return clone().F(jVar);
        }
        this.R = null;
        return z(jVar);
    }

    public k G(a6.d dVar) {
        return J(dVar);
    }

    public k H(Integer num) {
        PackageInfo packageInfo;
        k kVarJ = J(num);
        Context context = this.L;
        k kVar = (k) kVarJ.v(context.getTheme());
        ConcurrentHashMap concurrentHashMap = w6.b.f13746a;
        String packageName = context.getPackageName();
        ConcurrentHashMap concurrentHashMap2 = w6.b.f13746a;
        c6.f fVar = (c6.f) concurrentHashMap2.get(packageName);
        if (fVar == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e10) {
                Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e10);
                packageInfo = null;
            }
            w6.d dVar = new w6.d(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
            c6.f fVar2 = (c6.f) concurrentHashMap2.putIfAbsent(packageName, dVar);
            fVar = fVar2 == null ? dVar : fVar2;
        }
        return (k) kVar.t(new w6.a(context.getResources().getConfiguration().uiMode & 48, fVar));
    }

    public k I(String str) {
        return J(str);
    }

    public final k J(Object obj) {
        if (this.I) {
            return clone().J(obj);
        }
        this.Q = obj;
        this.V = true;
        r();
        return this;
    }

    @Override // t6.a
    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return super.equals(kVar) && Objects.equals(this.N, kVar.N) && this.P.equals(kVar.P) && Objects.equals(this.Q, kVar.Q) && Objects.equals(this.R, kVar.R) && Objects.equals(this.S, kVar.S) && Objects.equals(this.T, kVar.T) && this.U == kVar.U && this.V == kVar.V;
    }

    @Override // t6.a
    public final int hashCode() {
        return x6.m.g(this.V ? 1 : 0, x6.m.g(this.U ? 1 : 0, x6.m.h(x6.m.h(x6.m.h(x6.m.h(x6.m.h(x6.m.h(x6.m.h(super.hashCode(), this.N), this.P), this.Q), this.R), this.S), this.T), null)));
    }

    public k z(t6.f fVar) {
        if (this.I) {
            return clone().z(fVar);
        }
        if (fVar != null) {
            if (this.R == null) {
                this.R = new ArrayList();
            }
            this.R.add(fVar);
        }
        r();
        return this;
    }
}
