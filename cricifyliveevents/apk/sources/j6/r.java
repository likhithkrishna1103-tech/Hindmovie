package j6;

import android.graphics.Matrix;
import android.graphics.PointF;
import g6.a0;
import java.util.Collections;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f6666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f6667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f6668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f6669e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e f6674l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e f6675m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f6676n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public e f6677o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public e f6678p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i f6679q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public i f6680r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public i f6681s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public i f6682t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public i f6683u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public e f6684v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public e f6685w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f6686x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f6665a = new Matrix();
    public float f = Float.NaN;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6670g = Float.NaN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f6671h = Float.NaN;
    public float i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f6672j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6673k = true;

    public r(m6.e eVar) {
        m6.c cVar = eVar.f8376a;
        this.f6674l = cVar == null ? null : cVar.D0();
        m6.f fVar = eVar.f8377b;
        this.f6675m = fVar == null ? null : fVar.D0();
        m6.a aVar = eVar.f8378c;
        this.f6676n = aVar == null ? null : aVar.D0();
        m6.b bVar = eVar.f8379d;
        this.f6677o = bVar == null ? null : bVar.D0();
        m6.b bVar2 = eVar.f;
        this.f6679q = bVar2 == null ? null : bVar2.D0();
        this.f6686x = eVar.f8386m;
        m6.b bVar3 = eVar.f8382h;
        this.f6681s = bVar3 == null ? null : bVar3.D0();
        m6.b bVar4 = eVar.i;
        this.f6682t = bVar4 == null ? null : bVar4.D0();
        m6.b bVar5 = eVar.f8383j;
        this.f6683u = bVar5 == null ? null : bVar5.D0();
        if (this.f6679q != null) {
            this.f6666b = new Matrix();
            this.f6667c = new Matrix();
            this.f6668d = new Matrix();
            this.f6669e = new float[9];
        } else {
            this.f6666b = null;
            this.f6667c = null;
            this.f6668d = null;
            this.f6669e = null;
        }
        m6.b bVar6 = eVar.f8381g;
        this.f6680r = bVar6 == null ? null : bVar6.D0();
        m6.a aVar2 = eVar.f8380e;
        if (aVar2 != null) {
            this.f6678p = aVar2.D0();
        }
        m6.b bVar7 = eVar.f8384k;
        if (bVar7 != null) {
            this.f6684v = bVar7.D0();
        } else {
            this.f6684v = null;
        }
        m6.b bVar8 = eVar.f8385l;
        if (bVar8 != null) {
            this.f6685w = bVar8.D0();
        } else {
            this.f6685w = null;
        }
    }

    public final void a(o6.a aVar) {
        aVar.d(this.f6678p);
        aVar.d(this.f6684v);
        aVar.d(this.f6685w);
        aVar.d(this.f6674l);
        aVar.d(this.f6675m);
        aVar.d(this.f6676n);
        aVar.d(this.f6677o);
        aVar.d(this.f6679q);
        aVar.d(this.f6680r);
        aVar.d(this.f6681s);
        aVar.d(this.f6682t);
        aVar.d(this.f6683u);
    }

    public final void b(a aVar) {
        e eVar = this.f6678p;
        if (eVar != null) {
            eVar.a(aVar);
        }
        e eVar2 = this.f6684v;
        if (eVar2 != null) {
            eVar2.a(aVar);
        }
        e eVar3 = this.f6685w;
        if (eVar3 != null) {
            eVar3.a(aVar);
        }
        e eVar4 = this.f6674l;
        if (eVar4 != null) {
            eVar4.a(aVar);
        }
        e eVar5 = this.f6675m;
        if (eVar5 != null) {
            eVar5.a(aVar);
        }
        e eVar6 = this.f6676n;
        if (eVar6 != null) {
            eVar6.a(aVar);
        }
        e eVar7 = this.f6677o;
        if (eVar7 != null) {
            eVar7.a(aVar);
        }
        i iVar = this.f6679q;
        if (iVar != null) {
            iVar.a(aVar);
        }
        i iVar2 = this.f6680r;
        if (iVar2 != null) {
            iVar2.a(aVar);
        }
        i iVar3 = this.f6681s;
        if (iVar3 != null) {
            iVar3.a(aVar);
            this.f6681s.a(new q(0, this));
        }
        i iVar4 = this.f6682t;
        if (iVar4 != null) {
            iVar4.a(aVar);
            this.f6682t.a(new q(1, this));
        }
        i iVar5 = this.f6683u;
        if (iVar5 != null) {
            iVar5.a(aVar);
            this.f6683u.a(new q(2, this));
        }
    }

    public final boolean c(Object obj, w wVar) {
        Float fValueOf = Float.valueOf(100.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        if (obj == a0.f5033a) {
            e eVar = this.f6674l;
            if (eVar == null) {
                this.f6674l = new s(new PointF(), wVar);
                return true;
            }
            eVar.j(wVar);
            return true;
        }
        if (obj == a0.f5034b) {
            e eVar2 = this.f6675m;
            if (eVar2 == null) {
                this.f6675m = new s(new PointF(), wVar);
                return true;
            }
            eVar2.j(wVar);
            return true;
        }
        if (obj == a0.f5035c) {
            e eVar3 = this.f6675m;
            if (eVar3 instanceof o) {
                ((o) eVar3).f6659m = wVar;
                return true;
            }
        }
        if (obj == a0.f5036d) {
            e eVar4 = this.f6675m;
            if (eVar4 instanceof o) {
                ((o) eVar4).f6660n = wVar;
                return true;
            }
        }
        if (obj == a0.f5040j) {
            e eVar5 = this.f6676n;
            if (eVar5 == null) {
                this.f6676n = new s(new t6.b(), wVar);
                return true;
            }
            eVar5.j(wVar);
            return true;
        }
        if (obj == a0.f5041k) {
            e eVar6 = this.f6677o;
            if (eVar6 == null) {
                this.f6677o = new s(fValueOf2, wVar);
                return true;
            }
            eVar6.j(wVar);
            return true;
        }
        if (obj == 3) {
            e eVar7 = this.f6678p;
            if (eVar7 == null) {
                this.f6678p = new s(100, wVar);
                return true;
            }
            eVar7.j(wVar);
            return true;
        }
        if (obj == a0.A) {
            e eVar8 = this.f6684v;
            if (eVar8 == null) {
                this.f6684v = new s(fValueOf, wVar);
                return true;
            }
            eVar8.j(wVar);
            return true;
        }
        if (obj == a0.B) {
            e eVar9 = this.f6685w;
            if (eVar9 == null) {
                this.f6685w = new s(fValueOf, wVar);
                return true;
            }
            eVar9.j(wVar);
            return true;
        }
        if (obj == a0.f5045o) {
            if (this.f6679q == null) {
                this.f6679q = new i(Collections.singletonList(new t6.a(fValueOf2)));
            }
            this.f6679q.j(wVar);
            return true;
        }
        if (obj == a0.f5046p) {
            if (this.f6680r == null) {
                this.f6680r = new i(Collections.singletonList(new t6.a(fValueOf2)));
            }
            this.f6680r.j(wVar);
            return true;
        }
        if (obj == a0.f5042l) {
            if (this.f6681s == null) {
                this.f6681s = new i(Collections.singletonList(new t6.a(fValueOf2)));
            }
            this.f6681s.j(wVar);
            return true;
        }
        if (obj == a0.f5043m) {
            if (this.f6682t == null) {
                this.f6682t = new i(Collections.singletonList(new t6.a(fValueOf2)));
            }
            this.f6682t.j(wVar);
            return true;
        }
        if (obj != a0.f5044n) {
            return false;
        }
        if (this.f6683u == null) {
            this.f6683u = new i(Collections.singletonList(new t6.a(fValueOf2)));
        }
        this.f6683u.j(wVar);
        return true;
    }

    public final void d() {
        for (int i = 0; i < 9; i++) {
            this.f6669e[i] = 0.0f;
        }
    }

    public final Matrix e() {
        i iVar;
        i iVar2;
        PointF pointF;
        t6.b bVar;
        PointF pointF2;
        Matrix matrix = this.f6665a;
        matrix.reset();
        i iVar3 = this.f6681s;
        if ((iVar3 == null || iVar3.l() == 0.0f) && (((iVar = this.f6682t) == null || iVar.l() == 0.0f) && ((iVar2 = this.f6683u) == null || iVar2.l() == 0.0f))) {
            e eVar = this.f6675m;
            if (eVar != null && (pointF2 = (PointF) eVar.e()) != null) {
                float f = pointF2.x;
                if (f != 0.0f || pointF2.y != 0.0f) {
                    matrix.preTranslate(f, pointF2.y);
                }
            }
            if (!this.f6686x) {
                e eVar2 = this.f6677o;
                if (eVar2 != null) {
                    float fFloatValue = eVar2 instanceof s ? ((Float) eVar2.e()).floatValue() : ((i) eVar2).l();
                    if (fFloatValue != 0.0f) {
                        matrix.preRotate(fFloatValue);
                    }
                }
            } else if (eVar != null) {
                float f10 = eVar.f6633d;
                PointF pointF3 = (PointF) eVar.e();
                float f11 = pointF3.x;
                float f12 = pointF3.y;
                eVar.i(1.0E-4f + f10);
                PointF pointF4 = (PointF) eVar.e();
                eVar.i(f10);
                matrix.preRotate((float) Math.toDegrees(Math.atan2(pointF4.y - f12, pointF4.x - f11)));
            }
            if (this.f6679q != null) {
                float fCos = this.f6680r == null ? 0.0f : (float) Math.cos(Math.toRadians((-r5.l()) + 90.0f));
                float fSin = this.f6680r == null ? 1.0f : (float) Math.sin(Math.toRadians((-r7.l()) + 90.0f));
                float fTan = (float) Math.tan(Math.toRadians(r1.l()));
                d();
                float[] fArr = this.f6669e;
                fArr[0] = fCos;
                fArr[1] = fSin;
                float f13 = -fSin;
                fArr[3] = f13;
                fArr[4] = fCos;
                fArr[8] = 1.0f;
                Matrix matrix2 = this.f6666b;
                matrix2.setValues(fArr);
                d();
                fArr[0] = 1.0f;
                fArr[3] = fTan;
                fArr[4] = 1.0f;
                fArr[8] = 1.0f;
                Matrix matrix3 = this.f6667c;
                matrix3.setValues(fArr);
                d();
                fArr[0] = fCos;
                fArr[1] = f13;
                fArr[3] = fSin;
                fArr[4] = fCos;
                fArr[8] = 1.0f;
                Matrix matrix4 = this.f6668d;
                matrix4.setValues(fArr);
                matrix3.preConcat(matrix2);
                matrix4.preConcat(matrix3);
                matrix.preConcat(matrix4);
            }
            e eVar3 = this.f6676n;
            if (eVar3 != null && (bVar = (t6.b) eVar3.e()) != null) {
                float f14 = bVar.f11945a;
                if (f14 != 1.0f || bVar.f11946b != 1.0f) {
                    matrix.preScale(f14, bVar.f11946b);
                }
            }
            e eVar4 = this.f6674l;
            if (eVar4 != null && (pointF = (PointF) eVar4.e()) != null) {
                float f15 = pointF.x;
                if (f15 != 0.0f || pointF.y != 0.0f) {
                    matrix.preTranslate(-f15, -pointF.y);
                }
            }
        } else {
            i iVar4 = this.f6681s;
            float fL = iVar4 != null ? iVar4.l() : 0.0f;
            i iVar5 = this.f6682t;
            float fL2 = iVar5 != null ? iVar5.l() : 0.0f;
            i iVar6 = this.f6683u;
            float fL3 = iVar6 != null ? iVar6.l() : 0.0f;
            if (this.f6673k || fL != this.f || fL2 != this.f6670g || fL3 != this.f6671h) {
                this.f = fL;
                this.f6670g = fL2;
                this.f6671h = fL3;
                if (fL != 0.0f) {
                    this.i = (float) Math.cos(Math.toRadians(fL));
                } else {
                    this.i = 1.0f;
                }
                if (fL2 != 0.0f) {
                    this.f6672j = (float) Math.cos(Math.toRadians(fL2));
                } else {
                    this.f6672j = 1.0f;
                }
                this.f6673k = false;
            }
            e eVar5 = this.f6674l;
            PointF pointF5 = eVar5 == null ? null : (PointF) eVar5.e();
            e eVar6 = this.f6675m;
            PointF pointF6 = eVar6 == null ? null : (PointF) eVar6.e();
            e eVar7 = this.f6676n;
            t6.b bVar2 = eVar7 != null ? (t6.b) eVar7.e() : null;
            float f16 = bVar2 != null ? bVar2.f11945a : 1.0f;
            float f17 = bVar2 != null ? bVar2.f11946b : 1.0f;
            float f18 = this.i;
            float f19 = this.f6672j;
            matrix.reset();
            if (pointF6 != null) {
                float f20 = pointF6.x;
                if (f20 != 0.0f || pointF6.y != 0.0f) {
                    matrix.preTranslate(f20, pointF6.y);
                }
            }
            if (fL3 != 0.0f) {
                matrix.preRotate(fL3);
            }
            if (fL2 != 0.0f) {
                matrix.preScale(f19, 1.0f);
            }
            if (fL != 0.0f) {
                matrix.preScale(1.0f, f18);
            }
            if (f16 != 1.0f || f17 != 1.0f) {
                matrix.preScale(f16, f17);
            }
            if (pointF5 != null) {
                float f21 = pointF5.x;
                if (f21 != 0.0f || pointF5.y != 0.0f) {
                    matrix.preTranslate(-f21, -pointF5.y);
                    return matrix;
                }
            }
        }
        return matrix;
    }

    public final Matrix f(float f) {
        e eVar = this.f6675m;
        PointF pointF = eVar == null ? null : (PointF) eVar.e();
        e eVar2 = this.f6676n;
        t6.b bVar = eVar2 == null ? null : (t6.b) eVar2.e();
        e eVar3 = this.f6674l;
        PointF pointF2 = eVar3 != null ? (PointF) eVar3.e() : null;
        Matrix matrix = this.f6665a;
        matrix.reset();
        if (pointF != null) {
            matrix.preTranslate(pointF.x * f, pointF.y * f);
        }
        i iVar = this.f6681s;
        float fL = iVar != null ? iVar.l() * f : 0.0f;
        i iVar2 = this.f6682t;
        float fL2 = iVar2 != null ? iVar2.l() * f : 0.0f;
        i iVar3 = this.f6683u;
        float fL3 = iVar3 != null ? iVar3.l() * f : 0.0f;
        if (fL == 0.0f && fL2 == 0.0f && fL3 == 0.0f) {
            e eVar4 = this.f6677o;
            if (eVar4 != null) {
                matrix.preRotate(((Float) eVar4.e()).floatValue() * f, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
            }
        } else {
            float fCos = fL != 0.0f ? (float) Math.cos(Math.toRadians(fL)) : 1.0f;
            float fCos2 = fL2 != 0.0f ? (float) Math.cos(Math.toRadians(fL2)) : 1.0f;
            if (fL3 != 0.0f) {
                matrix.preRotate(fL3, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
            }
            if (fL2 != 0.0f) {
                matrix.preScale(fCos2, 1.0f);
            }
            if (fL != 0.0f) {
                matrix.preScale(1.0f, fCos);
            }
        }
        if (bVar != null) {
            double d10 = f;
            matrix.preScale((float) Math.pow(bVar.f11945a, d10), (float) Math.pow(bVar.f11946b, d10));
        }
        return matrix;
    }
}
