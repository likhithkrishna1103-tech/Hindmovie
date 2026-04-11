package o5;

import android.graphics.Matrix;
import android.graphics.PointF;
import java.util.Collections;
import l5.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f9408a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f9409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f9410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f9411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f9412e;
    public e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f9413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f9414h;
    public e i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f9415j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i f9416k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i f9417l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e f9418m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f9419n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f9420o;

    public q(r5.d dVar) {
        q6.c cVar = dVar.f11521a;
        this.f = cVar == null ? null : cVar.D0();
        r5.e eVar = dVar.f11522b;
        this.f9413g = eVar == null ? null : eVar.D0();
        r5.a aVar = dVar.f11523c;
        this.f9414h = aVar == null ? null : aVar.D0();
        r5.b bVar = dVar.f11524d;
        this.i = bVar == null ? null : bVar.D0();
        r5.b bVar2 = dVar.f;
        i iVar = bVar2 == null ? null : (i) bVar2.D0();
        this.f9416k = iVar;
        this.f9420o = dVar.f11528j;
        if (iVar != null) {
            this.f9409b = new Matrix();
            this.f9410c = new Matrix();
            this.f9411d = new Matrix();
            this.f9412e = new float[9];
        } else {
            this.f9409b = null;
            this.f9410c = null;
            this.f9411d = null;
            this.f9412e = null;
        }
        r5.b bVar3 = dVar.f11526g;
        this.f9417l = bVar3 == null ? null : (i) bVar3.D0();
        r5.a aVar2 = dVar.f11525e;
        if (aVar2 != null) {
            this.f9415j = aVar2.D0();
        }
        r5.b bVar4 = dVar.f11527h;
        if (bVar4 != null) {
            this.f9418m = bVar4.D0();
        } else {
            this.f9418m = null;
        }
        r5.b bVar5 = dVar.i;
        if (bVar5 != null) {
            this.f9419n = bVar5.D0();
        } else {
            this.f9419n = null;
        }
    }

    public final void a(t5.b bVar) {
        bVar.d(this.f9415j);
        bVar.d(this.f9418m);
        bVar.d(this.f9419n);
        bVar.d(this.f);
        bVar.d(this.f9413g);
        bVar.d(this.f9414h);
        bVar.d(this.i);
        bVar.d(this.f9416k);
        bVar.d(this.f9417l);
    }

    public final void b(a aVar) {
        e eVar = this.f9415j;
        if (eVar != null) {
            eVar.a(aVar);
        }
        e eVar2 = this.f9418m;
        if (eVar2 != null) {
            eVar2.a(aVar);
        }
        e eVar3 = this.f9419n;
        if (eVar3 != null) {
            eVar3.a(aVar);
        }
        e eVar4 = this.f;
        if (eVar4 != null) {
            eVar4.a(aVar);
        }
        e eVar5 = this.f9413g;
        if (eVar5 != null) {
            eVar5.a(aVar);
        }
        e eVar6 = this.f9414h;
        if (eVar6 != null) {
            eVar6.a(aVar);
        }
        e eVar7 = this.i;
        if (eVar7 != null) {
            eVar7.a(aVar);
        }
        i iVar = this.f9416k;
        if (iVar != null) {
            iVar.a(aVar);
        }
        i iVar2 = this.f9417l;
        if (iVar2 != null) {
            iVar2.a(aVar);
        }
    }

    public final boolean c(Object obj, p2.c cVar) {
        Float fValueOf = Float.valueOf(100.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        if (obj == z.f7929a) {
            e eVar = this.f;
            if (eVar == null) {
                this.f = new r(new PointF(), cVar);
                return true;
            }
            eVar.j(cVar);
            return true;
        }
        if (obj == z.f7930b) {
            e eVar2 = this.f9413g;
            if (eVar2 == null) {
                this.f9413g = new r(new PointF(), cVar);
                return true;
            }
            eVar2.j(cVar);
            return true;
        }
        if (obj == z.f7931c) {
            e eVar3 = this.f9413g;
            if (eVar3 instanceof o) {
                ((o) eVar3).f9403m = cVar;
                return true;
            }
        }
        if (obj == z.f7932d) {
            e eVar4 = this.f9413g;
            if (eVar4 instanceof o) {
                ((o) eVar4).f9404n = cVar;
                return true;
            }
        }
        if (obj == z.f7936j) {
            e eVar5 = this.f9414h;
            if (eVar5 == null) {
                this.f9414h = new r(new y5.b(), cVar);
                return true;
            }
            eVar5.j(cVar);
            return true;
        }
        if (obj == z.f7937k) {
            e eVar6 = this.i;
            if (eVar6 == null) {
                this.i = new r(fValueOf2, cVar);
                return true;
            }
            eVar6.j(cVar);
            return true;
        }
        if (obj == 3) {
            e eVar7 = this.f9415j;
            if (eVar7 == null) {
                this.f9415j = new r(100, cVar);
                return true;
            }
            eVar7.j(cVar);
            return true;
        }
        if (obj == z.f7950x) {
            e eVar8 = this.f9418m;
            if (eVar8 == null) {
                this.f9418m = new r(fValueOf, cVar);
                return true;
            }
            eVar8.j(cVar);
            return true;
        }
        if (obj == z.f7951y) {
            e eVar9 = this.f9419n;
            if (eVar9 == null) {
                this.f9419n = new r(fValueOf, cVar);
                return true;
            }
            eVar9.j(cVar);
            return true;
        }
        if (obj == z.f7938l) {
            if (this.f9416k == null) {
                this.f9416k = new i(Collections.singletonList(new y5.a(fValueOf2)));
            }
            this.f9416k.j(cVar);
            return true;
        }
        if (obj != z.f7939m) {
            return false;
        }
        if (this.f9417l == null) {
            this.f9417l = new i(Collections.singletonList(new y5.a(fValueOf2)));
        }
        this.f9417l.j(cVar);
        return true;
    }

    public final void d() {
        for (int i = 0; i < 9; i++) {
            this.f9412e[i] = 0.0f;
        }
    }

    public final Matrix e() {
        PointF pointF;
        y5.b bVar;
        PointF pointF2;
        Matrix matrix = this.f9408a;
        matrix.reset();
        e eVar = this.f9413g;
        if (eVar != null && (pointF2 = (PointF) eVar.e()) != null) {
            float f = pointF2.x;
            if (f != 0.0f || pointF2.y != 0.0f) {
                matrix.preTranslate(f, pointF2.y);
            }
        }
        if (!this.f9420o) {
            e eVar2 = this.i;
            if (eVar2 != null) {
                float fFloatValue = eVar2 instanceof r ? ((Float) eVar2.e()).floatValue() : ((i) eVar2).k();
                if (fFloatValue != 0.0f) {
                    matrix.preRotate(fFloatValue);
                }
            }
        } else if (eVar != null) {
            float f4 = eVar.f9378d;
            PointF pointF3 = (PointF) eVar.e();
            float f10 = pointF3.x;
            float f11 = pointF3.y;
            eVar.i(1.0E-4f + f4);
            PointF pointF4 = (PointF) eVar.e();
            eVar.i(f4);
            matrix.preRotate((float) Math.toDegrees(Math.atan2(pointF4.y - f11, pointF4.x - f10)));
        }
        if (this.f9416k != null) {
            float fCos = this.f9417l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r4.k()) + 90.0f));
            float fSin = this.f9417l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r6.k()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(r1.k()));
            d();
            float[] fArr = this.f9412e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f12 = -fSin;
            fArr[3] = f12;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            Matrix matrix2 = this.f9409b;
            matrix2.setValues(fArr);
            d();
            fArr[0] = 1.0f;
            fArr[3] = fTan;
            fArr[4] = 1.0f;
            fArr[8] = 1.0f;
            Matrix matrix3 = this.f9410c;
            matrix3.setValues(fArr);
            d();
            fArr[0] = fCos;
            fArr[1] = f12;
            fArr[3] = fSin;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            Matrix matrix4 = this.f9411d;
            matrix4.setValues(fArr);
            matrix3.preConcat(matrix2);
            matrix4.preConcat(matrix3);
            matrix.preConcat(matrix4);
        }
        e eVar3 = this.f9414h;
        if (eVar3 != null && (bVar = (y5.b) eVar3.e()) != null) {
            float f13 = bVar.f14535a;
            if (f13 != 1.0f || bVar.f14536b != 1.0f) {
                matrix.preScale(f13, bVar.f14536b);
            }
        }
        e eVar4 = this.f;
        if (eVar4 != null && (pointF = (PointF) eVar4.e()) != null) {
            float f14 = pointF.x;
            if (f14 != 0.0f || pointF.y != 0.0f) {
                matrix.preTranslate(-f14, -pointF.y);
            }
        }
        return matrix;
    }

    public final Matrix f(float f) {
        e eVar = this.f9413g;
        PointF pointF = eVar == null ? null : (PointF) eVar.e();
        e eVar2 = this.f9414h;
        y5.b bVar = eVar2 == null ? null : (y5.b) eVar2.e();
        Matrix matrix = this.f9408a;
        matrix.reset();
        if (pointF != null) {
            matrix.preTranslate(pointF.x * f, pointF.y * f);
        }
        if (bVar != null) {
            double d10 = f;
            matrix.preScale((float) Math.pow(bVar.f14535a, d10), (float) Math.pow(bVar.f14536b, d10));
        }
        e eVar3 = this.i;
        if (eVar3 != null) {
            float fFloatValue = ((Float) eVar3.e()).floatValue();
            e eVar4 = this.f;
            PointF pointF2 = eVar4 != null ? (PointF) eVar4.e() : null;
            matrix.preRotate(fFloatValue * f, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
        }
        return matrix;
    }
}
