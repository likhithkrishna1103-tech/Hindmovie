package n5;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import l5.w;
import l5.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s extends b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final t5.b f8807r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f8808s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f8809t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final o5.f f8810u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public o5.r f8811v;

    /* JADX WARN: Illegal instructions before constructor call */
    public s(w wVar, t5.b bVar, s5.o oVar) {
        int iC = v.e.c(oVar.f11856g);
        Paint.Cap cap = iC != 0 ? iC != 1 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        int iC2 = v.e.c(oVar.f11857h);
        super(wVar, bVar, cap, iC2 != 0 ? iC2 != 1 ? iC2 != 2 ? null : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER, oVar.i, oVar.f11855e, oVar.f, oVar.f11853c, oVar.f11852b);
        this.f8807r = bVar;
        this.f8808s = oVar.f11851a;
        this.f8809t = oVar.f11858j;
        o5.e eVarD0 = oVar.f11854d.D0();
        this.f8810u = (o5.f) eVarD0;
        eVarD0.a(this);
        bVar.d(eVarD0);
    }

    @Override // n5.b, n5.e
    public final void e(Canvas canvas, Matrix matrix, int i) {
        if (this.f8809t) {
            return;
        }
        o5.f fVar = this.f8810u;
        int iK = fVar.k(fVar.f9377c.k(), fVar.c());
        m5.a aVar = this.i;
        aVar.setColor(iK);
        o5.r rVar = this.f8811v;
        if (rVar != null) {
            aVar.setColorFilter((ColorFilter) rVar.e());
        }
        super.e(canvas, matrix, i);
    }

    @Override // n5.c
    public final String getName() {
        return this.f8808s;
    }

    @Override // n5.b, q5.f
    public final void h(Object obj, p2.c cVar) {
        super.h(obj, cVar);
        PointF pointF = z.f7929a;
        o5.f fVar = this.f8810u;
        if (obj == 2) {
            fVar.j(cVar);
            return;
        }
        if (obj == z.F) {
            o5.r rVar = this.f8811v;
            t5.b bVar = this.f8807r;
            if (rVar != null) {
                bVar.p(rVar);
            }
            o5.r rVar2 = new o5.r(null, cVar);
            this.f8811v = rVar2;
            rVar2.a(this);
            bVar.d(fVar);
        }
    }
}
