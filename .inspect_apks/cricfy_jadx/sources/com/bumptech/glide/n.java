package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import androidx.datastore.preferences.protobuf.z0;
import com.google.android.gms.internal.measurement.i4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class n extends o7.a {
    public final Context L;
    public final p M;
    public final Class N;
    public final g O;
    public a P;
    public Object Q;
    public ArrayList R;
    public n S;
    public n T;
    public final boolean U = true;
    public boolean V;
    public boolean W;

    static {
    }

    public n(b bVar, p pVar, Class cls, Context context) {
        o7.g gVar;
        this.M = pVar;
        this.N = cls;
        this.L = context;
        v.e eVar = pVar.f2295v.f2195x.f;
        a aVar = (a) eVar.get(cls);
        if (aVar == null) {
            for (Map.Entry entry : (z0) eVar.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    aVar = (a) entry.getValue();
                }
            }
        }
        this.P = aVar == null ? g.f2200k : aVar;
        this.O = bVar.f2195x;
        Iterator it = pVar.D.iterator();
        while (it.hasNext()) {
            x((o7.f) it.next());
        }
        synchronized (pVar) {
            gVar = pVar.E;
        }
        a(gVar);
    }

    @Override // o7.a
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public n clone() {
        n nVar = (n) super.clone();
        nVar.P = nVar.P.clone();
        if (nVar.R != null) {
            nVar.R = new ArrayList(nVar.R);
        }
        n nVar2 = nVar.S;
        if (nVar2 != null) {
            nVar.S = nVar2.clone();
        }
        n nVar3 = nVar.T;
        if (nVar3 != null) {
            nVar.T = nVar3.clone();
        }
        return nVar;
    }

    public final void B(ImageView imageView) {
        o7.a aVarJ;
        p7.d bVar;
        s7.m.a();
        s7.f.b(imageView);
        if (!o7.a.h(this.f9564v, 2048) && imageView.getScaleType() != null) {
            switch (m.f2256a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarJ = clone().j();
                    break;
                case 2:
                    aVarJ = clone().k();
                    break;
                case 3:
                case g1.h.LONG_FIELD_NUMBER /* 4 */:
                case g1.h.STRING_FIELD_NUMBER /* 5 */:
                    aVarJ = clone().l();
                    break;
                case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                    aVarJ = clone().k();
                    break;
                default:
                    aVarJ = this;
                    break;
            }
        } else {
            aVarJ = this;
        }
        this.O.f2203c.getClass();
        Class cls = this.N;
        if (Bitmap.class.equals(cls)) {
            bVar = new p7.b(imageView, 0);
        } else {
            if (!Drawable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
            }
            bVar = new p7.b(imageView, 1);
        }
        C(bVar, null, aVarJ, s7.f.f11596a);
    }

    public final void C(p7.d dVar, o7.e eVar, o7.a aVar, Executor executor) {
        s7.f.b(dVar);
        if (!this.V) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        o7.c cVarZ = z(new Object(), dVar, eVar, null, this.P, aVar.f9566x, aVar.B, aVar.A, aVar, executor);
        o7.c cVarJ = dVar.j();
        if (cVarZ.d(cVarJ) && (aVar.f9568z || !cVarJ.j())) {
            s7.f.c(cVarJ, "Argument must not be null");
            if (cVarJ.isRunning()) {
                return;
            }
            cVarJ.h();
            return;
        }
        this.M.o(dVar);
        dVar.d(cVarZ);
        p pVar = this.M;
        synchronized (pVar) {
            pVar.A.f2292v.add(dVar);
            i4 i4Var = pVar.f2298y;
            ((Set) i4Var.f2483x).add(cVarZ);
            if (i4Var.f2482w) {
                cVarZ.clear();
                if (Log.isLoggable("RequestTracker", 2)) {
                    Log.v("RequestTracker", "Paused, delaying request");
                }
                ((HashSet) i4Var.f2484y).add(cVarZ);
            } else {
                cVarZ.h();
            }
        }
    }

    public n D(z5.j jVar) {
        if (this.I) {
            return clone().D(jVar);
        }
        this.R = null;
        return x(jVar);
    }

    public n E(String str) {
        return G(str);
    }

    public n F(v6.d dVar) {
        return G(dVar);
    }

    public final n G(Object obj) {
        if (this.I) {
            return clone().G(obj);
        }
        this.Q = obj;
        this.V = true;
        q();
        return this;
    }

    @Override // o7.a
    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return super.equals(nVar) && Objects.equals(this.N, nVar.N) && this.P.equals(nVar.P) && Objects.equals(this.Q, nVar.Q) && Objects.equals(this.R, nVar.R) && Objects.equals(this.S, nVar.S) && Objects.equals(this.T, nVar.T) && this.U == nVar.U && this.V == nVar.V;
    }

    @Override // o7.a
    public final int hashCode() {
        return s7.m.g(this.V ? 1 : 0, s7.m.g(this.U ? 1 : 0, s7.m.h(s7.m.h(s7.m.h(s7.m.h(s7.m.h(s7.m.h(s7.m.h(super.hashCode(), this.N), this.P), this.Q), this.R), this.S), this.T), null)));
    }

    public n x(o7.f fVar) {
        if (this.I) {
            return clone().x(fVar);
        }
        if (fVar != null) {
            if (this.R == null) {
                this.R = new ArrayList();
            }
            this.R.add(fVar);
        }
        q();
        return this;
    }

    @Override // o7.a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public n a(o7.a aVar) {
        s7.f.b(aVar);
        return (n) super.a(aVar);
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
    public final o7.c z(Object obj, p7.d dVar, o7.f fVar, o7.d dVar2, a aVar, h hVar, int i, int i10, o7.a aVar2, Executor executor) {
        o7.d dVar3;
        o7.d bVar;
        o7.a aVar3;
        o7.c hVar2;
        h hVar3;
        if (this.T != null) {
            bVar = new o7.b(obj, dVar2);
            dVar3 = bVar;
        } else {
            dVar3 = null;
            bVar = dVar2;
        }
        n nVar = this.S;
        if (nVar == null) {
            Context context = this.L;
            g gVar = this.O;
            aVar3 = aVar2;
            hVar2 = new o7.h(context, gVar, obj, this.Q, this.N, aVar3, i, i10, hVar, dVar, fVar, this.R, bVar, gVar.f2206g, aVar.f2192v, executor);
        } else {
            if (this.W) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            a aVar4 = nVar.U ? aVar : nVar.P;
            if (o7.a.h(nVar.f9564v, 8)) {
                hVar3 = this.S.f9566x;
            } else {
                int iOrdinal = hVar.ordinal();
                if (iOrdinal == 0 || iOrdinal == 1) {
                    hVar3 = h.f2209v;
                } else if (iOrdinal == 2) {
                    hVar3 = h.f2210w;
                } else {
                    if (iOrdinal != 3) {
                        throw new IllegalArgumentException("unknown priority: " + this.f9566x);
                    }
                    hVar3 = h.f2211x;
                }
            }
            h hVar4 = hVar3;
            n nVar2 = this.S;
            int i11 = nVar2.B;
            int i12 = nVar2.A;
            if (s7.m.i(i, i10)) {
                n nVar3 = this.S;
                if (!s7.m.i(nVar3.B, nVar3.A)) {
                    i11 = aVar2.B;
                    i12 = aVar2.A;
                }
            }
            int i13 = i12;
            int i14 = i11;
            o7.i iVar = new o7.i(obj, bVar);
            Context context2 = this.L;
            g gVar2 = this.O;
            o7.i iVar2 = iVar;
            o7.h hVar5 = new o7.h(context2, gVar2, obj, this.Q, this.N, aVar2, i, i10, hVar, dVar, fVar, this.R, iVar2, gVar2.f2206g, aVar.f2192v, executor);
            this.W = true;
            n nVar4 = this.S;
            o7.c cVarZ = nVar4.z(obj, dVar, fVar, iVar2, aVar4, hVar4, i14, i13, nVar4, executor);
            this.W = false;
            iVar2.f9605c = hVar5;
            iVar2.f9606d = cVarZ;
            aVar3 = aVar2;
            hVar2 = iVar2;
        }
        if (dVar3 == null) {
            return hVar2;
        }
        n nVar5 = this.T;
        int i15 = nVar5.B;
        int i16 = nVar5.A;
        if (s7.m.i(i, i10)) {
            n nVar6 = this.T;
            if (!s7.m.i(nVar6.B, nVar6.A)) {
                i15 = aVar3.B;
                i16 = aVar3.A;
            }
        }
        int i17 = i16;
        n nVar7 = this.T;
        o7.b bVar2 = dVar3;
        o7.c cVarZ2 = nVar7.z(obj, dVar, fVar, bVar2, nVar7.P, nVar7.f9566x, i15, i17, nVar7, executor);
        bVar2.f9571c = hVar2;
        bVar2.f9572d = cVarZ2;
        return bVar2;
    }
}
