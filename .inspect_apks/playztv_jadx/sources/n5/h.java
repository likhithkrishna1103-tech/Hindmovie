package n5;

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
import java.util.ArrayList;
import java.util.List;
import l5.w;
import l5.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements e, o5.a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t5.b f8734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s.g f8735d = new s.g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s.g f8736e = new s.g();
    public final Path f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m5.a f8737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f8738h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f8739j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final o5.j f8740k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final o5.f f8741l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final o5.j f8742m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final o5.j f8743n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public o5.r f8744o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public o5.r f8745p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final w f8746q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f8747r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public o5.e f8748s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f8749t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final o5.h f8750u;

    public h(w wVar, l5.j jVar, t5.b bVar, s5.d dVar) {
        Path path = new Path();
        this.f = path;
        this.f8737g = new m5.a(1, 0);
        this.f8738h = new RectF();
        this.i = new ArrayList();
        this.f8749t = 0.0f;
        this.f8734c = bVar;
        this.f8732a = dVar.f11802g;
        this.f8733b = dVar.f11803h;
        this.f8746q = wVar;
        this.f8739j = dVar.f11797a;
        path.setFillType(dVar.f11798b);
        this.f8747r = (int) (jVar.b() / 32.0f);
        o5.e eVarD0 = dVar.f11799c.D0();
        this.f8740k = (o5.j) eVarD0;
        eVarD0.a(this);
        bVar.d(eVarD0);
        o5.e eVarD02 = dVar.f11800d.D0();
        this.f8741l = (o5.f) eVarD02;
        eVarD02.a(this);
        bVar.d(eVarD02);
        o5.e eVarD03 = dVar.f11801e.D0();
        this.f8742m = (o5.j) eVarD03;
        eVarD03.a(this);
        bVar.d(eVarD03);
        o5.e eVarD04 = dVar.f.D0();
        this.f8743n = (o5.j) eVarD04;
        eVarD04.a(this);
        bVar.d(eVarD04);
        if (bVar.l() != null) {
            o5.e eVarD05 = ((r5.b) bVar.l().f10436v).D0();
            this.f8748s = eVarD05;
            eVarD05.a(this);
            bVar.d(this.f8748s);
        }
        if (bVar.m() != null) {
            this.f8750u = new o5.h(this, bVar, bVar.m());
        }
    }

    @Override // n5.e
    public final void a(RectF rectF, Matrix matrix, boolean z2) {
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
                path.addPath(((m) arrayList.get(i)).f(), matrix);
                i++;
            }
        }
    }

    @Override // o5.a
    public final void b() {
        this.f8746q.invalidateSelf();
    }

    @Override // n5.c
    public final void c(List list, List list2) {
        for (int i = 0; i < list2.size(); i++) {
            c cVar = (c) list2.get(i);
            if (cVar instanceof m) {
                this.i.add((m) cVar);
            }
        }
    }

    public final int[] d(int[] iArr) {
        o5.r rVar = this.f8745p;
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

    @Override // n5.e
    public final void e(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        Shader radialGradient;
        if (this.f8733b) {
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
            path.addPath(((m) arrayList.get(i10)).f(), matrix);
            i10++;
        }
        path.computeBounds(this.f8738h, false);
        int i11 = this.f8739j;
        o5.j jVar = this.f8740k;
        o5.j jVar2 = this.f8743n;
        o5.j jVar3 = this.f8742m;
        if (i11 == 1) {
            long jI = i();
            s.g gVar = this.f8735d;
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
            s.g gVar2 = this.f8736e;
            shader = (RadialGradient) gVar2.d(jI2);
            if (shader == null) {
                PointF pointF3 = (PointF) jVar3.e();
                PointF pointF4 = (PointF) jVar2.e();
                s5.c cVar2 = (s5.c) jVar.e();
                int[] iArrD = d(cVar2.f11796b);
                float[] fArr = cVar2.f11795a;
                float f = pointF3.x;
                float f4 = pointF3.y;
                float fHypot = (float) Math.hypot(pointF4.x - f, pointF4.y - f4);
                if (fHypot <= 0.0f) {
                    fHypot = 0.001f;
                }
                radialGradient = new RadialGradient(f, f4, fHypot, iArrD, fArr, Shader.TileMode.CLAMP);
                gVar2.h(jI2, radialGradient);
                shader = radialGradient;
            }
        }
        shader.setLocalMatrix(matrix);
        m5.a aVar = this.f8737g;
        aVar.setShader(shader);
        o5.r rVar = this.f8744o;
        if (rVar != null) {
            aVar.setColorFilter((ColorFilter) rVar.e());
        }
        o5.e eVar = this.f8748s;
        if (eVar != null) {
            float fFloatValue = ((Float) eVar.e()).floatValue();
            if (fFloatValue == 0.0f) {
                aVar.setMaskFilter(null);
            } else if (fFloatValue != this.f8749t) {
                aVar.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f8749t = fFloatValue;
        }
        o5.h hVar = this.f8750u;
        if (hVar != null) {
            hVar.a(aVar);
        }
        PointF pointF5 = x5.f.f14266a;
        aVar.setAlpha(Math.max(0, Math.min(255, (int) ((((i / 255.0f) * ((Integer) this.f8741l.e()).intValue()) / 100.0f) * 255.0f))));
        canvas.drawPath(path, aVar);
    }

    @Override // q5.f
    public final void g(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
        x5.f.f(eVar, i, arrayList, eVar2, this);
    }

    @Override // n5.c
    public final String getName() {
        return this.f8732a;
    }

    @Override // q5.f
    public final void h(Object obj, p2.c cVar) {
        PointF pointF = z.f7929a;
        if (obj == 4) {
            this.f8741l.j(cVar);
            return;
        }
        ColorFilter colorFilter = z.F;
        t5.b bVar = this.f8734c;
        if (obj == colorFilter) {
            o5.r rVar = this.f8744o;
            if (rVar != null) {
                bVar.p(rVar);
            }
            o5.r rVar2 = new o5.r(null, cVar);
            this.f8744o = rVar2;
            rVar2.a(this);
            bVar.d(this.f8744o);
            return;
        }
        if (obj == z.G) {
            o5.r rVar3 = this.f8745p;
            if (rVar3 != null) {
                bVar.p(rVar3);
            }
            this.f8735d.b();
            this.f8736e.b();
            o5.r rVar4 = new o5.r(null, cVar);
            this.f8745p = rVar4;
            rVar4.a(this);
            bVar.d(this.f8745p);
            return;
        }
        if (obj == z.f7933e) {
            o5.e eVar = this.f8748s;
            if (eVar != null) {
                eVar.j(cVar);
                return;
            }
            o5.r rVar5 = new o5.r(null, cVar);
            this.f8748s = rVar5;
            rVar5.a(this);
            bVar.d(this.f8748s);
            return;
        }
        o5.h hVar = this.f8750u;
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

    public final int i() {
        float f = this.f8742m.f9378d;
        float f4 = this.f8747r;
        int iRound = Math.round(f * f4);
        int iRound2 = Math.round(this.f8743n.f9378d * f4);
        int iRound3 = Math.round(this.f8740k.f9378d * f4);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }
}
