package i6;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import g6.a0;
import g6.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends b {
    public j6.s A;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f6277q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f6278r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final v.h f6279s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final v.h f6280t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RectF f6281u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f6282v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f6283w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final j6.j f6284x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j6.j f6285y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final j6.j f6286z;

    /* JADX WARN: Illegal instructions before constructor call */
    public j(w wVar, o6.a aVar, n6.e eVar) {
        int iC = y.e.c(eVar.f8794h);
        Paint.Cap cap = iC != 0 ? iC != 1 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        int iC2 = y.e.c(eVar.i);
        super(wVar, aVar, cap, iC2 != 0 ? iC2 != 1 ? iC2 != 2 ? null : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER, eVar.f8795j, eVar.f8791d, eVar.f8793g, eVar.f8796k, eVar.f8797l);
        this.f6279s = new v.h();
        this.f6280t = new v.h();
        this.f6281u = new RectF();
        this.f6277q = eVar.f8788a;
        this.f6282v = eVar.f8789b;
        this.f6278r = eVar.f8798m;
        this.f6283w = (int) (wVar.f5152v.b() / 32.0f);
        j6.e eVarD0 = eVar.f8790c.D0();
        this.f6284x = (j6.j) eVarD0;
        eVarD0.a(this);
        aVar.d(eVarD0);
        j6.e eVarD02 = eVar.f8792e.D0();
        this.f6285y = (j6.j) eVarD02;
        eVarD02.a(this);
        aVar.d(eVarD02);
        j6.e eVarD03 = eVar.f.D0();
        this.f6286z = (j6.j) eVarD03;
        eVarD03.a(this);
        aVar.d(eVarD03);
    }

    public final int[] d(int[] iArr) {
        j6.s sVar = this.A;
        if (sVar != null) {
            Integer[] numArr = (Integer[]) sVar.e();
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

    @Override // i6.b, i6.f
    public final void e(Canvas canvas, Matrix matrix, int i, s6.a aVar) {
        Shader shader;
        Shader radialGradient;
        if (this.f6278r) {
            return;
        }
        a(this.f6281u, matrix, false);
        int i10 = this.f6282v;
        j6.j jVar = this.f6284x;
        j6.j jVar2 = this.f6286z;
        j6.j jVar3 = this.f6285y;
        if (i10 == 1) {
            long jI = i();
            v.h hVar = this.f6279s;
            shader = (LinearGradient) hVar.d(jI);
            if (shader == null) {
                PointF pointF = (PointF) jVar3.e();
                PointF pointF2 = (PointF) jVar2.e();
                n6.c cVar = (n6.c) jVar.e();
                radialGradient = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, d(cVar.f8780b), cVar.f8779a, Shader.TileMode.CLAMP);
                hVar.h(jI, radialGradient);
                shader = radialGradient;
            }
        } else {
            long jI2 = i();
            v.h hVar2 = this.f6280t;
            shader = (RadialGradient) hVar2.d(jI2);
            if (shader == null) {
                PointF pointF3 = (PointF) jVar3.e();
                PointF pointF4 = (PointF) jVar2.e();
                n6.c cVar2 = (n6.c) jVar.e();
                int[] iArrD = d(cVar2.f8780b);
                float[] fArr = cVar2.f8779a;
                radialGradient = new RadialGradient(pointF3.x, pointF3.y, (float) Math.hypot(pointF4.x - r10, pointF4.y - r11), iArrD, fArr, Shader.TileMode.CLAMP);
                hVar2.h(jI2, radialGradient);
                shader = radialGradient;
            }
        }
        this.i.setShader(shader);
        super.e(canvas, matrix, i, aVar);
    }

    @Override // i6.d
    public final String getName() {
        return this.f6277q;
    }

    @Override // i6.b, l6.f
    public final void h(Object obj, nb.w wVar) {
        super.h(obj, wVar);
        if (obj == a0.J) {
            j6.s sVar = this.A;
            o6.a aVar = this.f;
            if (sVar != null) {
                aVar.o(sVar);
            }
            j6.s sVar2 = new j6.s(null, wVar);
            this.A = sVar2;
            sVar2.a(this);
            aVar.d(this.A);
        }
    }

    public final int i() {
        float f = this.f6285y.f6633d;
        float f10 = this.f6283w;
        int iRound = Math.round(f * f10);
        int iRound2 = Math.round(this.f6286z.f6633d * f10);
        int iRound3 = Math.round(this.f6284x.f6633d * f10);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }
}
