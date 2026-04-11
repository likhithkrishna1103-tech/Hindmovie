package n5;

import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import l5.w;
import l5.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements o5.a, k, e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f8694e;
    public final t5.b f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f8696h;
    public final m5.a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o5.i f8697j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final o5.f f8698k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f8699l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final o5.i f8700m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o5.r f8701n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public o5.e f8702o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f8703p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final o5.h f8704q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PathMeasure f8690a = new PathMeasure();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f8691b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f8692c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f8693d = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f8695g = new ArrayList();

    public b(w wVar, t5.b bVar, Paint.Cap cap, Paint.Join join, float f, r5.a aVar, r5.b bVar2, ArrayList arrayList, r5.b bVar3) {
        m5.a aVar2 = new m5.a(1, 0);
        this.i = aVar2;
        this.f8703p = 0.0f;
        this.f8694e = wVar;
        this.f = bVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f);
        this.f8698k = (o5.f) aVar.D0();
        this.f8697j = (o5.i) bVar2.D0();
        if (bVar3 == null) {
            this.f8700m = null;
        } else {
            this.f8700m = (o5.i) bVar3.D0();
        }
        this.f8699l = new ArrayList(arrayList.size());
        this.f8696h = new float[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            this.f8699l.add(((r5.b) arrayList.get(i)).D0());
        }
        bVar.d(this.f8698k);
        bVar.d(this.f8697j);
        for (int i10 = 0; i10 < this.f8699l.size(); i10++) {
            bVar.d((o5.e) this.f8699l.get(i10));
        }
        o5.i iVar = this.f8700m;
        if (iVar != null) {
            bVar.d(iVar);
        }
        this.f8698k.a(this);
        this.f8697j.a(this);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            ((o5.e) this.f8699l.get(i11)).a(this);
        }
        o5.i iVar2 = this.f8700m;
        if (iVar2 != null) {
            iVar2.a(this);
        }
        if (bVar.l() != null) {
            o5.e eVarD0 = ((r5.b) bVar.l().f10436v).D0();
            this.f8702o = eVarD0;
            eVarD0.a(this);
            bVar.d(this.f8702o);
        }
        if (bVar.m() != null) {
            this.f8704q = new o5.h(this, bVar, bVar.m());
        }
    }

    @Override // n5.e
    public final void a(RectF rectF, Matrix matrix, boolean z2) {
        Path path = this.f8691b;
        path.reset();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f8695g;
            if (i >= arrayList.size()) {
                RectF rectF2 = this.f8693d;
                path.computeBounds(rectF2, false);
                float fK = this.f8697j.k() / 2.0f;
                rectF2.set(rectF2.left - fK, rectF2.top - fK, rectF2.right + fK, rectF2.bottom + fK);
                rectF.set(rectF2);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            }
            a aVar = (a) arrayList.get(i);
            for (int i10 = 0; i10 < aVar.f8688a.size(); i10++) {
                path.addPath(((m) aVar.f8688a.get(i10)).f(), matrix);
            }
            i++;
        }
    }

    @Override // o5.a
    public final void b() {
        this.f8694e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    @Override // n5.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.util.List r8, java.util.List r9) {
        /*
            r7 = this;
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        La:
            r3 = 2
            if (r0 < 0) goto L21
            java.lang.Object r4 = r8.get(r0)
            n5.c r4 = (n5.c) r4
            boolean r5 = r4 instanceof n5.t
            if (r5 == 0) goto L1e
            n5.t r4 = (n5.t) r4
            int r5 = r4.f8814c
            if (r5 != r3) goto L1e
            r2 = r4
        L1e:
            int r0 = r0 + (-1)
            goto La
        L21:
            if (r2 == 0) goto L26
            r2.d(r7)
        L26:
            int r8 = r9.size()
            int r8 = r8 + (-1)
        L2c:
            java.util.ArrayList r0 = r7.f8695g
            if (r8 < 0) goto L65
            java.lang.Object r4 = r9.get(r8)
            n5.c r4 = (n5.c) r4
            boolean r5 = r4 instanceof n5.t
            if (r5 == 0) goto L50
            r5 = r4
            n5.t r5 = (n5.t) r5
            int r6 = r5.f8814c
            if (r6 != r3) goto L50
            if (r1 == 0) goto L46
            r0.add(r1)
        L46:
            n5.a r0 = new n5.a
            r0.<init>(r5)
            r5.d(r7)
            r1 = r0
            goto L62
        L50:
            boolean r0 = r4 instanceof n5.m
            if (r0 == 0) goto L62
            if (r1 != 0) goto L5b
            n5.a r1 = new n5.a
            r1.<init>(r2)
        L5b:
            java.util.ArrayList r0 = r1.f8688a
            n5.m r4 = (n5.m) r4
            r0.add(r4)
        L62:
            int r8 = r8 + (-1)
            goto L2c
        L65:
            if (r1 == 0) goto L6a
            r0.add(r1)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.b.c(java.util.List, java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x020a  */
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
    @Override // n5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(android.graphics.Canvas r21, android.graphics.Matrix r22, int r23) {
        /*
            Method dump skipped, instruction units count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.b.e(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    @Override // q5.f
    public final void g(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
        x5.f.f(eVar, i, arrayList, eVar2, this);
    }

    @Override // q5.f
    public void h(Object obj, p2.c cVar) {
        PointF pointF = z.f7929a;
        if (obj == 4) {
            this.f8698k.j(cVar);
            return;
        }
        if (obj == z.f7940n) {
            this.f8697j.j(cVar);
            return;
        }
        ColorFilter colorFilter = z.F;
        t5.b bVar = this.f;
        if (obj == colorFilter) {
            o5.r rVar = this.f8701n;
            if (rVar != null) {
                bVar.p(rVar);
            }
            o5.r rVar2 = new o5.r(null, cVar);
            this.f8701n = rVar2;
            rVar2.a(this);
            bVar.d(this.f8701n);
            return;
        }
        if (obj == z.f7933e) {
            o5.e eVar = this.f8702o;
            if (eVar != null) {
                eVar.j(cVar);
                return;
            }
            o5.r rVar3 = new o5.r(null, cVar);
            this.f8702o = rVar3;
            rVar3.a(this);
            bVar.d(this.f8702o);
            return;
        }
        o5.h hVar = this.f8704q;
        if (obj == 5 && hVar != null) {
            hVar.f9384b.j(cVar);
            return;
        }
        if (obj == z.B && hVar != null) {
            hVar.c(cVar);
            return;
        }
        if (obj == z.C && hVar != null) {
            hVar.f9386d.j(cVar);
            return;
        }
        if (obj == z.D && hVar != null) {
            hVar.f9387e.j(cVar);
        } else {
            if (obj != z.E || hVar == null) {
                return;
            }
            hVar.f.j(cVar);
        }
    }
}
