package n5;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import l5.w;
import l5.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends b {
    public final o5.j A;
    public o5.r B;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f8751r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f8752s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final s.g f8753t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s.g f8754u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f8755v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f8756w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f8757x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final o5.j f8758y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final o5.j f8759z;

    /* JADX WARN: Illegal instructions before constructor call */
    public i(w wVar, t5.b bVar, s5.e eVar) {
        int iC = v.e.c(eVar.f11810h);
        Paint.Cap cap = iC != 0 ? iC != 1 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        int iC2 = v.e.c(eVar.i);
        super(wVar, bVar, cap, iC2 != 0 ? iC2 != 1 ? iC2 != 2 ? null : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER, eVar.f11811j, eVar.f11807d, eVar.f11809g, eVar.f11812k, eVar.f11813l);
        this.f8753t = new s.g();
        this.f8754u = new s.g();
        this.f8755v = new RectF();
        this.f8751r = eVar.f11804a;
        this.f8756w = eVar.f11805b;
        this.f8752s = eVar.f11814m;
        this.f8757x = (int) (wVar.f7918u.b() / 32.0f);
        o5.e eVarD0 = eVar.f11806c.D0();
        this.f8758y = (o5.j) eVarD0;
        eVarD0.a(this);
        bVar.d(eVarD0);
        o5.e eVarD02 = eVar.f11808e.D0();
        this.f8759z = (o5.j) eVarD02;
        eVarD02.a(this);
        bVar.d(eVarD02);
        o5.e eVarD03 = eVar.f.D0();
        this.A = (o5.j) eVarD03;
        eVarD03.a(this);
        bVar.d(eVarD03);
    }

    public final int[] d(int[] iArr) {
        o5.r rVar = this.B;
        if (rVar != null) {
            Integer[] numArr = (Integer[]) rVar.e();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    @Override // n5.b, n5.e
    public final void e(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        Shader radialGradient;
        if (this.f8752s) {
            return;
        }
        a(this.f8755v, matrix, false);
        int i10 = this.f8756w;
        o5.j jVar = this.f8758y;
        o5.j jVar2 = this.A;
        o5.j jVar3 = this.f8759z;
        if (i10 == 1) {
            long jI = i();
            s.g gVar = this.f8753t;
            shader = (LinearGradient) gVar.d(jI);
            if (shader == null) {
                PointF pointF = (PointF) jVar3.e();
                PointF pointF2 = (PointF) jVar2.e();
                s5.c cVar = (s5.c) jVar.e();
                radialGradient = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, d(cVar.f11796b), cVar.f11795a, Shader.TileMode.CLAMP);
                gVar.h(jI, radialGradient);
                shader = radialGradient;
            }
        } else {
            long jI2 = i();
            s.g gVar2 = this.f8754u;
            shader = (RadialGradient) gVar2.d(jI2);
            if (shader == null) {
                PointF pointF3 = (PointF) jVar3.e();
                PointF pointF4 = (PointF) jVar2.e();
                s5.c cVar2 = (s5.c) jVar.e();
                int[] iArrD = d(cVar2.f11796b);
                float[] fArr = cVar2.f11795a;
                radialGradient = new RadialGradient(pointF3.x, pointF3.y, (float) Math.hypot(pointF4.x - r10, pointF4.y - r11), iArrD, fArr, Shader.TileMode.CLAMP);
                gVar2.h(jI2, radialGradient);
                shader = radialGradient;
            }
        }
        shader.setLocalMatrix(matrix);
        this.i.setShader(shader);
        super.e(canvas, matrix, i);
    }

    @Override // n5.c
    public final String getName() {
        return this.f8751r;
    }

    @Override // n5.b, q5.f
    public final void h(Object obj, p2.c cVar) {
        super.h(obj, cVar);
        if (obj == z.G) {
            o5.r rVar = this.B;
            t5.b bVar = this.f;
            if (rVar != null) {
                bVar.p(rVar);
            }
            o5.r rVar2 = new o5.r(null, cVar);
            this.B = rVar2;
            rVar2.a(this);
            bVar.d(this.B);
        }
    }

    public final int i() {
        float f = this.f8759z.f9378d;
        float f4 = this.f8757x;
        int iRound = Math.round(f * f4);
        int iRound2 = Math.round(this.A.f9378d * f4);
        int iRound3 = Math.round(this.f8758y.f9378d * f4);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }
}
