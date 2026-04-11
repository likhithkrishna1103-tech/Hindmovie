package i6;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import g6.a0;
import g6.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final o6.a f6334q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f6335r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f6336s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final j6.f f6337t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public j6.s f6338u;

    /* JADX WARN: Illegal instructions before constructor call */
    public t(w wVar, o6.a aVar, n6.o oVar) {
        int iC = y.e.c(oVar.f8840g);
        Paint.Cap cap = iC != 0 ? iC != 1 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        int iC2 = y.e.c(oVar.f8841h);
        super(wVar, aVar, cap, iC2 != 0 ? iC2 != 1 ? iC2 != 2 ? null : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER, oVar.i, oVar.f8839e, oVar.f, oVar.f8837c, oVar.f8836b);
        this.f6334q = aVar;
        this.f6335r = oVar.f8835a;
        this.f6336s = oVar.f8842j;
        j6.e eVarD0 = oVar.f8838d.D0();
        this.f6337t = (j6.f) eVarD0;
        eVarD0.a(this);
        aVar.d(eVarD0);
    }

    @Override // i6.b, i6.f
    public final void e(Canvas canvas, Matrix matrix, int i, s6.a aVar) {
        if (this.f6336s) {
            return;
        }
        j6.f fVar = this.f6337t;
        int iL = fVar.l(fVar.f6632c.e(), fVar.c());
        h6.a aVar2 = this.i;
        aVar2.setColor(iL);
        j6.s sVar = this.f6338u;
        if (sVar != null) {
            aVar2.setColorFilter((ColorFilter) sVar.e());
        }
        super.e(canvas, matrix, i, aVar);
    }

    @Override // i6.d
    public final String getName() {
        return this.f6335r;
    }

    @Override // i6.b, l6.f
    public final void h(Object obj, nb.w wVar) {
        super.h(obj, wVar);
        PointF pointF = a0.f5033a;
        j6.f fVar = this.f6337t;
        if (obj == 2) {
            fVar.j(wVar);
            return;
        }
        if (obj == a0.I) {
            j6.s sVar = this.f6338u;
            o6.a aVar = this.f6334q;
            if (sVar != null) {
                aVar.o(sVar);
            }
            j6.s sVar2 = new j6.s(null, wVar);
            this.f6338u = sVar2;
            sVar2.a(this);
            aVar.d(fVar);
        }
    }
}
