package i6;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import g6.a0;
import g6.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements f, j6.a, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f6249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h6.a f6250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o6.a f6251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6253e;
    public final ArrayList f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j6.f f6254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j6.f f6255h;
    public j6.s i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w f6256j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public j6.e f6257k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6258l;

    public h(w wVar, o6.a aVar, n6.l lVar) {
        Path path = new Path();
        this.f6249a = path;
        this.f6250b = new h6.a(1, 0);
        this.f = new ArrayList();
        this.f6251c = aVar;
        String str = lVar.f8825c;
        m6.a aVar2 = lVar.f8827e;
        m6.a aVar3 = lVar.f8826d;
        this.f6252d = str;
        this.f6253e = lVar.f;
        this.f6256j = wVar;
        if (aVar.l() != null) {
            j6.i iVarD0 = ((m6.b) aVar.l().f7697v).D0();
            this.f6257k = iVarD0;
            iVarD0.a(this);
            aVar.d(this.f6257k);
        }
        if (aVar3 == null) {
            this.f6254g = null;
            this.f6255h = null;
            return;
        }
        path.setFillType(lVar.f8824b);
        j6.e eVarD0 = aVar3.D0();
        this.f6254g = (j6.f) eVarD0;
        eVarD0.a(this);
        aVar.d(eVarD0);
        j6.e eVarD02 = aVar2.D0();
        this.f6255h = (j6.f) eVarD02;
        eVarD02.a(this);
        aVar.d(eVarD02);
    }

    @Override // i6.f
    public final void a(RectF rectF, Matrix matrix, boolean z10) {
        Path path = this.f6249a;
        path.reset();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f;
            if (i >= arrayList.size()) {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            } else {
                path.addPath(((n) arrayList.get(i)).f(), matrix);
                i++;
            }
        }
    }

    @Override // j6.a
    public final void b() {
        this.f6256j.invalidateSelf();
    }

    @Override // i6.d
    public final void c(List list, List list2) {
        for (int i = 0; i < list2.size(); i++) {
            d dVar = (d) list2.get(i);
            if (dVar instanceof n) {
                this.f.add((n) dVar);
            }
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
    @Override // i6.f
    public final void e(Canvas canvas, Matrix matrix, int i, s6.a aVar) {
        MaskFilter maskFilter;
        if (this.f6253e) {
            return;
        }
        j6.f fVar = this.f6254g;
        float fIntValue = ((Integer) this.f6255h.e()).intValue() / 100.0f;
        int iC = (s6.g.c((int) (i * fIntValue)) << 24) | (fVar.l(fVar.f6632c.e(), fVar.c()) & 16777215);
        h6.a aVar2 = this.f6250b;
        aVar2.setColor(iC);
        j6.s sVar = this.i;
        if (sVar != null) {
            aVar2.setColorFilter((ColorFilter) sVar.e());
        }
        j6.e eVar = this.f6257k;
        if (eVar != null) {
            float fFloatValue = ((Float) eVar.e()).floatValue();
            if (fFloatValue == 0.0f) {
                aVar2.setMaskFilter(null);
            } else if (fFloatValue != this.f6258l) {
                o6.a aVar3 = this.f6251c;
                if (aVar3.A == fFloatValue) {
                    maskFilter = aVar3.B;
                } else {
                    BlurMaskFilter blurMaskFilter = new BlurMaskFilter(fFloatValue / 2.0f, BlurMaskFilter.Blur.NORMAL);
                    aVar3.B = blurMaskFilter;
                    aVar3.A = fFloatValue;
                    maskFilter = blurMaskFilter;
                }
                aVar2.setMaskFilter(maskFilter);
            }
            this.f6258l = fFloatValue;
        }
        if (aVar != null) {
            aVar.a((int) (fIntValue * 255.0f), aVar2);
        } else {
            aVar2.clearShadowLayer();
        }
        Path path = this.f6249a;
        path.reset();
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f;
            if (i10 >= arrayList.size()) {
                canvas.drawPath(path, aVar2);
                return;
            } else {
                path.addPath(((n) arrayList.get(i10)).f(), matrix);
                i10++;
            }
        }
    }

    @Override // l6.f
    public final void g(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
        s6.g.g(eVar, i, arrayList, eVar2, this);
    }

    @Override // i6.d
    public final String getName() {
        return this.f6252d;
    }

    @Override // l6.f
    public final void h(Object obj, nb.w wVar) {
        PointF pointF = a0.f5033a;
        if (obj == 1) {
            this.f6254g.j(wVar);
            return;
        }
        if (obj == 4) {
            this.f6255h.j(wVar);
            return;
        }
        ColorFilter colorFilter = a0.I;
        o6.a aVar = this.f6251c;
        if (obj == colorFilter) {
            j6.s sVar = this.i;
            if (sVar != null) {
                aVar.o(sVar);
            }
            j6.s sVar2 = new j6.s(null, wVar);
            this.i = sVar2;
            sVar2.a(this);
            aVar.d(this.i);
            return;
        }
        if (obj == a0.f5037e) {
            j6.e eVar = this.f6257k;
            if (eVar != null) {
                eVar.j(wVar);
                return;
            }
            j6.s sVar3 = new j6.s(null, wVar);
            this.f6257k = sVar3;
            sVar3.a(this);
            aVar.d(this.f6257k);
        }
    }
}
