package i6;

import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import g6.a0;
import g6.w;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements j6.a, l, f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f6221e;
    public final o6.a f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f6223h;
    public final h6.a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j6.i f6224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j6.f f6225k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f6226l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j6.i f6227m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public j6.s f6228n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j6.e f6229o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f6230p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PathMeasure f6217a = new PathMeasure();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f6218b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f6219c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f6220d = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f6222g = new ArrayList();

    public b(w wVar, o6.a aVar, Paint.Cap cap, Paint.Join join, float f, m6.a aVar2, m6.b bVar, ArrayList arrayList, m6.b bVar2) {
        h6.a aVar3 = new h6.a(1, 0);
        this.i = aVar3;
        this.f6230p = 0.0f;
        this.f6221e = wVar;
        this.f = aVar;
        aVar3.setStyle(Paint.Style.STROKE);
        aVar3.setStrokeCap(cap);
        aVar3.setStrokeJoin(join);
        aVar3.setStrokeMiter(f);
        this.f6225k = (j6.f) aVar2.D0();
        this.f6224j = bVar.D0();
        if (bVar2 == null) {
            this.f6227m = null;
        } else {
            this.f6227m = bVar2.D0();
        }
        this.f6226l = new ArrayList(arrayList.size());
        this.f6223h = new float[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            this.f6226l.add(((m6.b) arrayList.get(i)).D0());
        }
        aVar.d(this.f6225k);
        aVar.d(this.f6224j);
        for (int i10 = 0; i10 < this.f6226l.size(); i10++) {
            aVar.d((j6.e) this.f6226l.get(i10));
        }
        j6.i iVar = this.f6227m;
        if (iVar != null) {
            aVar.d(iVar);
        }
        this.f6225k.a(this);
        this.f6224j.a(this);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            ((j6.e) this.f6226l.get(i11)).a(this);
        }
        j6.i iVar2 = this.f6227m;
        if (iVar2 != null) {
            iVar2.a(this);
        }
        if (aVar.l() != null) {
            j6.i iVarD0 = ((m6.b) aVar.l().f7697v).D0();
            this.f6229o = iVarD0;
            iVarD0.a(this);
            aVar.d(this.f6229o);
        }
    }

    @Override // i6.f
    public final void a(RectF rectF, Matrix matrix, boolean z10) {
        Path path = this.f6218b;
        path.reset();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f6222g;
            if (i >= arrayList.size()) {
                RectF rectF2 = this.f6220d;
                path.computeBounds(rectF2, false);
                float fL = this.f6224j.l() / 2.0f;
                rectF2.set(rectF2.left - fL, rectF2.top - fL, rectF2.right + fL, rectF2.bottom + fL);
                rectF.set(rectF2);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            }
            a aVar = (a) arrayList.get(i);
            for (int i10 = 0; i10 < aVar.f6215a.size(); i10++) {
                path.addPath(((n) aVar.f6215a.get(i10)).f(), matrix);
            }
            i++;
        }
    }

    @Override // j6.a
    public final void b() {
        this.f6221e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    @Override // i6.d
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
            i6.d r4 = (i6.d) r4
            boolean r5 = r4 instanceof i6.u
            if (r5 == 0) goto L1e
            i6.u r4 = (i6.u) r4
            int r5 = r4.f6341c
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
            java.util.ArrayList r0 = r7.f6222g
            if (r8 < 0) goto L65
            java.lang.Object r4 = r9.get(r8)
            i6.d r4 = (i6.d) r4
            boolean r5 = r4 instanceof i6.u
            if (r5 == 0) goto L50
            r5 = r4
            i6.u r5 = (i6.u) r5
            int r6 = r5.f6341c
            if (r6 != r3) goto L50
            if (r1 == 0) goto L46
            r0.add(r1)
        L46:
            i6.a r0 = new i6.a
            r0.<init>(r5)
            r5.d(r7)
            r1 = r0
            goto L62
        L50:
            boolean r0 = r4 instanceof i6.n
            if (r0 == 0) goto L62
            if (r1 != 0) goto L5b
            i6.a r1 = new i6.a
            r1.<init>(r2)
        L5b:
            java.util.ArrayList r0 = r1.f6215a
            i6.n r4 = (i6.n) r4
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
        throw new UnsupportedOperationException("Method not decompiled: i6.b.c(java.util.List, java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x01f0  */
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
    @Override // i6.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(android.graphics.Canvas r21, android.graphics.Matrix r22, int r23, s6.a r24) {
        /*
            Method dump skipped, instruction units count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.b.e(android.graphics.Canvas, android.graphics.Matrix, int, s6.a):void");
    }

    @Override // l6.f
    public final void g(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
        s6.g.g(eVar, i, arrayList, eVar2, this);
    }

    @Override // l6.f
    public void h(Object obj, nb.w wVar) {
        PointF pointF = a0.f5033a;
        if (obj == 4) {
            this.f6225k.j(wVar);
            return;
        }
        if (obj == a0.f5047q) {
            this.f6224j.j(wVar);
            return;
        }
        ColorFilter colorFilter = a0.I;
        o6.a aVar = this.f;
        if (obj == colorFilter) {
            j6.s sVar = this.f6228n;
            if (sVar != null) {
                aVar.o(sVar);
            }
            j6.s sVar2 = new j6.s(null, wVar);
            this.f6228n = sVar2;
            sVar2.a(this);
            aVar.d(this.f6228n);
            return;
        }
        if (obj == a0.f5037e) {
            j6.e eVar = this.f6229o;
            if (eVar != null) {
                eVar.j(wVar);
                return;
            }
            j6.s sVar3 = new j6.s(null, wVar);
            this.f6229o = sVar3;
            sVar3.a(this);
            aVar.d(this.f6229o);
        }
    }
}
