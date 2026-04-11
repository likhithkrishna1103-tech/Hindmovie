package i6;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import g6.a0;
import g6.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements f, j6.a, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o6.a f6261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v.h f6262d = new v.h();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v.h f6263e = new v.h();
    public final Path f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h6.a f6264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f6265h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f6266j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j6.j f6267k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j6.f f6268l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j6.j f6269m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j6.j f6270n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j6.s f6271o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public j6.s f6272p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final w f6273q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f6274r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public j6.e f6275s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f6276t;

    public i(w wVar, g6.i iVar, o6.a aVar, n6.d dVar) {
        Path path = new Path();
        this.f = path;
        this.f6264g = new h6.a(1, 0);
        this.f6265h = new RectF();
        this.i = new ArrayList();
        this.f6276t = 0.0f;
        this.f6261c = aVar;
        this.f6259a = dVar.f8786g;
        this.f6260b = dVar.f8787h;
        this.f6273q = wVar;
        this.f6266j = dVar.f8781a;
        path.setFillType(dVar.f8782b);
        this.f6274r = (int) (iVar.b() / 32.0f);
        j6.e eVarD0 = dVar.f8783c.D0();
        this.f6267k = (j6.j) eVarD0;
        eVarD0.a(this);
        aVar.d(eVarD0);
        j6.e eVarD02 = dVar.f8784d.D0();
        this.f6268l = (j6.f) eVarD02;
        eVarD02.a(this);
        aVar.d(eVarD02);
        j6.e eVarD03 = dVar.f8785e.D0();
        this.f6269m = (j6.j) eVarD03;
        eVarD03.a(this);
        aVar.d(eVarD03);
        j6.e eVarD04 = dVar.f.D0();
        this.f6270n = (j6.j) eVarD04;
        eVarD04.a(this);
        aVar.d(eVarD04);
        if (aVar.l() != null) {
            j6.i iVarD0 = ((m6.b) aVar.l().f7697v).D0();
            this.f6275s = iVarD0;
            iVarD0.a(this);
            aVar.d(this.f6275s);
        }
    }

    @Override // i6.f
    public final void a(RectF rectF, Matrix matrix, boolean z10) {
        Path path = this.f;
        path.reset();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.i;
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
        this.f6273q.invalidateSelf();
    }

    @Override // i6.d
    public final void c(List list, List list2) {
        for (int i = 0; i < list2.size(); i++) {
            d dVar = (d) list2.get(i);
            if (dVar instanceof n) {
                this.i.add((n) dVar);
            }
        }
    }

    public final int[] d(int[] iArr) {
        j6.s sVar = this.f6272p;
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

    @Override // i6.f
    public final void e(Canvas canvas, Matrix matrix, int i, s6.a aVar) {
        float[] fArr;
        int[] iArr;
        Shader linearGradient;
        int[] iArr2;
        if (this.f6260b) {
            return;
        }
        Path path = this.f;
        path.reset();
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.i;
            if (i10 >= arrayList.size()) {
                break;
            }
            path.addPath(((n) arrayList.get(i10)).f(), matrix);
            i10++;
        }
        path.computeBounds(this.f6265h, false);
        int i11 = this.f6266j;
        j6.j jVar = this.f6267k;
        j6.j jVar2 = this.f6270n;
        j6.j jVar3 = this.f6269m;
        if (i11 == 1) {
            long jI = i();
            v.h hVar = this.f6262d;
            linearGradient = (LinearGradient) hVar.d(jI);
            if (linearGradient == null) {
                PointF pointF = (PointF) jVar3.e();
                PointF pointF2 = (PointF) jVar2.e();
                n6.c cVar = (n6.c) jVar.e();
                int[] iArrD = d(cVar.f8780b);
                float[] fArr2 = cVar.f8779a;
                if (iArrD.length < 2) {
                    fArr2 = new float[]{0.0f, 1.0f};
                    iArr2 = new int[]{iArrD[0], iArrD[0]};
                } else {
                    iArr2 = iArrD;
                }
                linearGradient = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, iArr2, fArr2, Shader.TileMode.CLAMP);
                hVar.h(jI, linearGradient);
            }
        } else {
            long jI2 = i();
            v.h hVar2 = this.f6263e;
            RadialGradient radialGradient = (RadialGradient) hVar2.d(jI2);
            if (radialGradient != null) {
                linearGradient = radialGradient;
            } else {
                PointF pointF3 = (PointF) jVar3.e();
                PointF pointF4 = (PointF) jVar2.e();
                n6.c cVar2 = (n6.c) jVar.e();
                int[] iArrD2 = d(cVar2.f8780b);
                float[] fArr3 = cVar2.f8779a;
                if (iArrD2.length < 2) {
                    iArr = new int[]{iArrD2[0], iArrD2[0]};
                    fArr = new float[]{0.0f, 1.0f};
                } else {
                    fArr = fArr3;
                    iArr = iArrD2;
                }
                float f = pointF3.x;
                float f10 = pointF3.y;
                float fHypot = (float) Math.hypot(pointF4.x - f, pointF4.y - f10);
                if (fHypot <= 0.0f) {
                    fHypot = 0.001f;
                }
                RadialGradient radialGradient2 = new RadialGradient(f, f10, fHypot, iArr, fArr, Shader.TileMode.CLAMP);
                hVar2.h(jI2, radialGradient2);
                linearGradient = radialGradient2;
            }
        }
        linearGradient.setLocalMatrix(matrix);
        h6.a aVar2 = this.f6264g;
        aVar2.setShader(linearGradient);
        j6.s sVar = this.f6271o;
        if (sVar != null) {
            aVar2.setColorFilter((ColorFilter) sVar.e());
        }
        j6.e eVar = this.f6275s;
        if (eVar != null) {
            float fFloatValue = ((Float) eVar.e()).floatValue();
            if (fFloatValue == 0.0f) {
                aVar2.setMaskFilter(null);
            } else if (fFloatValue != this.f6276t) {
                aVar2.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f6276t = fFloatValue;
        }
        float fIntValue = ((Integer) this.f6268l.e()).intValue() / 100.0f;
        aVar2.setAlpha(s6.g.c((int) (i * fIntValue)));
        if (aVar != null) {
            aVar.a((int) (fIntValue * 255.0f), aVar2);
        }
        canvas.drawPath(path, aVar2);
    }

    @Override // l6.f
    public final void g(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
        s6.g.g(eVar, i, arrayList, eVar2, this);
    }

    @Override // i6.d
    public final String getName() {
        return this.f6259a;
    }

    @Override // l6.f
    public final void h(Object obj, nb.w wVar) {
        PointF pointF = a0.f5033a;
        if (obj == 4) {
            this.f6268l.j(wVar);
            return;
        }
        ColorFilter colorFilter = a0.I;
        o6.a aVar = this.f6261c;
        if (obj == colorFilter) {
            j6.s sVar = this.f6271o;
            if (sVar != null) {
                aVar.o(sVar);
            }
            j6.s sVar2 = new j6.s(null, wVar);
            this.f6271o = sVar2;
            sVar2.a(this);
            aVar.d(this.f6271o);
            return;
        }
        if (obj == a0.J) {
            j6.s sVar3 = this.f6272p;
            if (sVar3 != null) {
                aVar.o(sVar3);
            }
            this.f6262d.b();
            this.f6263e.b();
            j6.s sVar4 = new j6.s(null, wVar);
            this.f6272p = sVar4;
            sVar4.a(this);
            aVar.d(this.f6272p);
            return;
        }
        if (obj == a0.f5037e) {
            j6.e eVar = this.f6275s;
            if (eVar != null) {
                eVar.j(wVar);
                return;
            }
            j6.s sVar5 = new j6.s(null, wVar);
            this.f6275s = sVar5;
            sVar5.a(this);
            aVar.d(this.f6275s);
        }
    }

    public final int i() {
        float f = this.f6269m.f6633d;
        float f10 = this.f6274r;
        int iRound = Math.round(f * f10);
        int iRound2 = Math.round(this.f6270n.f6633d * f10);
        int iRound3 = Math.round(this.f6267k.f6633d * f10);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }
}
