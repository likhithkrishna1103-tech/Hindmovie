package n5;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import l5.w;
import l5.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements m, o5.a, k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8769e;
    public final w f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f8771h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o5.i f8772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final o5.e f8773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final o5.i f8774l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final o5.i f8775m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final o5.i f8776n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final o5.i f8777o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final o5.i f8778p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f8780r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f8765a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f8766b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PathMeasure f8767c = new PathMeasure();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f8768d = new float[2];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final rc.b f8779q = new rc.b(26);

    public n(w wVar, t5.b bVar, s5.h hVar) {
        this.f = wVar;
        this.f8769e = hVar.f11821a;
        int i = hVar.f11822b;
        this.f8770g = i;
        this.f8771h = hVar.f11828j;
        this.i = hVar.f11829k;
        o5.e eVarD0 = hVar.f11823c.D0();
        this.f8772j = (o5.i) eVarD0;
        o5.e eVarD02 = hVar.f11824d.D0();
        this.f8773k = eVarD02;
        o5.e eVarD03 = hVar.f11825e.D0();
        this.f8774l = (o5.i) eVarD03;
        o5.e eVarD04 = hVar.f11826g.D0();
        this.f8776n = (o5.i) eVarD04;
        o5.e eVarD05 = hVar.i.D0();
        this.f8778p = (o5.i) eVarD05;
        if (i == 1) {
            this.f8775m = (o5.i) hVar.f.D0();
            this.f8777o = (o5.i) hVar.f11827h.D0();
        } else {
            this.f8775m = null;
            this.f8777o = null;
        }
        bVar.d(eVarD0);
        bVar.d(eVarD02);
        bVar.d(eVarD03);
        bVar.d(eVarD04);
        bVar.d(eVarD05);
        if (i == 1) {
            bVar.d(this.f8775m);
            bVar.d(this.f8777o);
        }
        eVarD0.a(this);
        eVarD02.a(this);
        eVarD03.a(this);
        eVarD04.a(this);
        eVarD05.a(this);
        if (i == 1) {
            this.f8775m.a(this);
            this.f8777o.a(this);
        }
    }

    @Override // o5.a
    public final void b() {
        this.f8780r = false;
        this.f.invalidateSelf();
    }

    @Override // n5.c
    public final void c(List list, List list2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (i >= arrayList.size()) {
                return;
            }
            c cVar = (c) arrayList.get(i);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.f8814c == 1) {
                    ((ArrayList) this.f8779q.f11562v).add(tVar);
                    tVar.d(this);
                }
            }
            i++;
        }
    }

    @Override // n5.m
    public final Path f() {
        boolean z2;
        float f;
        double d10;
        float f4;
        float f10;
        float f11;
        float f12;
        float f13;
        int i;
        double d11;
        boolean z10 = this.f8780r;
        Path path = this.f8765a;
        if (z10) {
            return path;
        }
        path.reset();
        if (this.f8771h) {
            this.f8780r = true;
            return path;
        }
        int iC = v.e.c(this.f8770g);
        o5.e eVar = this.f8773k;
        o5.i iVar = this.f8776n;
        o5.i iVar2 = this.f8778p;
        o5.i iVar3 = this.f8774l;
        o5.i iVar4 = this.f8772j;
        if (iC == 0) {
            z2 = true;
            float fFloatValue = ((Float) iVar4.e()).floatValue();
            double radians = Math.toRadians((iVar3 != null ? ((Float) iVar3.e()).floatValue() : 0.0d) - 90.0d);
            double d12 = fFloatValue;
            float f14 = (float) (6.283185307179586d / d12);
            if (this.i) {
                f14 *= -1.0f;
            }
            float f15 = f14;
            float f16 = f15 / 2.0f;
            float f17 = fFloatValue - ((int) fFloatValue);
            if (f17 != 0.0f) {
                f = 2.0f;
                radians += (double) ((1.0f - f17) * f16);
            } else {
                f = 2.0f;
            }
            float fFloatValue2 = ((Float) iVar.e()).floatValue();
            float fFloatValue3 = ((Float) this.f8775m.e()).floatValue();
            o5.i iVar5 = this.f8777o;
            float fFloatValue4 = iVar5 != null ? ((Float) iVar5.e()).floatValue() / 100.0f : 0.0f;
            float fFloatValue5 = iVar2 != null ? ((Float) iVar2.e()).floatValue() / 100.0f : 0.0f;
            if (f17 != 0.0f) {
                float fG = e6.j.g(fFloatValue2, fFloatValue3, f17, fFloatValue3);
                double d13 = fG;
                f11 = fG;
                float fCos = (float) (Math.cos(radians) * d13);
                float fSin = (float) (Math.sin(radians) * d13);
                path.moveTo(fCos, fSin);
                d10 = radians + ((double) ((f15 * f17) / f));
                f4 = fCos;
                f10 = fSin;
            } else {
                double d14 = fFloatValue2;
                float fCos2 = (float) (Math.cos(radians) * d14);
                float fSin2 = (float) (Math.sin(radians) * d14);
                path.moveTo(fCos2, fSin2);
                d10 = radians + ((double) f16);
                f4 = fCos2;
                f10 = fSin2;
                f11 = 0.0f;
            }
            double dCeil = Math.ceil(d12) * 2.0d;
            double d15 = d10;
            int i10 = 0;
            boolean z11 = false;
            while (true) {
                double d16 = i10;
                if (d16 >= dCeil) {
                    break;
                }
                float f18 = z11 ? fFloatValue2 : fFloatValue3;
                float f19 = (f11 == 0.0f || d16 != dCeil - 2.0d) ? f16 : (f15 * f17) / f;
                if (f11 != 0.0f && d16 == dCeil - 1.0d) {
                    f18 = f11;
                }
                double d17 = f18;
                float fCos3 = (float) (Math.cos(d15) * d17);
                float fSin3 = (float) (Math.sin(d15) * d17);
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    path.lineTo(fCos3, fSin3);
                    f12 = f17;
                    f13 = fCos3;
                } else {
                    f12 = f17;
                    Path path2 = path;
                    double dAtan2 = (float) (Math.atan2(f10, f4) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    float f20 = f4;
                    float f21 = f10;
                    double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan22);
                    float fSin5 = (float) Math.sin(dAtan22);
                    float f22 = z11 ? fFloatValue4 : fFloatValue5;
                    float f23 = z11 ? fFloatValue5 : fFloatValue4;
                    float f24 = (z11 ? fFloatValue3 : fFloatValue2) * f22 * 0.47829f;
                    float f25 = fCos4 * f24;
                    float f26 = f24 * fSin4;
                    float f27 = (z11 ? fFloatValue2 : fFloatValue3) * f23 * 0.47829f;
                    float f28 = fCos5 * f27;
                    float f29 = f27 * fSin5;
                    if (f17 != 0.0f) {
                        if (i10 == 0) {
                            f25 *= f12;
                            f26 *= f12;
                        } else if (d16 == dCeil - 1.0d) {
                            f28 *= f12;
                            f29 *= f12;
                        }
                    }
                    f13 = fCos3;
                    path = path2;
                    path.cubicTo(f20 - f25, f21 - f26, f28 + fCos3, fSin3 + f29, f13, fSin3);
                }
                d15 += (double) f19;
                z11 = !z11;
                i10++;
                f4 = f13;
                f10 = fSin3;
                f17 = f12;
                f = 2.0f;
            }
            PointF pointF = (PointF) eVar.e();
            path.offset(pointF.x, pointF.y);
            path.close();
        } else if (iC != 1) {
            z2 = true;
        } else {
            int iFloor = (int) Math.floor(((Float) iVar4.e()).floatValue());
            double radians2 = Math.toRadians((iVar3 != null ? ((Float) iVar3.e()).floatValue() : 0.0d) - 90.0d);
            double d18 = iFloor;
            float fFloatValue6 = ((Float) iVar2.e()).floatValue() / 100.0f;
            float fFloatValue7 = ((Float) iVar.e()).floatValue();
            double d19 = fFloatValue7;
            z2 = true;
            float fCos6 = (float) (Math.cos(radians2) * d19);
            float fSin6 = (float) (Math.sin(radians2) * d19);
            path.moveTo(fCos6, fSin6);
            double d20 = (float) (6.283185307179586d / d18);
            double dCeil2 = Math.ceil(d18);
            double d21 = radians2 + d20;
            int i11 = 0;
            while (true) {
                double d22 = i11;
                if (d22 >= dCeil2) {
                    break;
                }
                double d23 = dCeil2;
                float fCos7 = (float) (Math.cos(d21) * d19);
                float fSin7 = (float) (Math.sin(d21) * d19);
                if (fFloatValue6 != 0.0f) {
                    i = i11;
                    Path path3 = path;
                    d11 = d19;
                    double dAtan23 = (float) (Math.atan2(fSin6, fCos6) - 1.5707963267948966d);
                    float fCos8 = (float) Math.cos(dAtan23);
                    float fSin8 = (float) Math.sin(dAtan23);
                    double dAtan24 = (float) (Math.atan2(fSin7, fCos7) - 1.5707963267948966d);
                    float f30 = fFloatValue7 * fFloatValue6 * 0.25f;
                    float f31 = f30 * fCos8;
                    float f32 = f30 * fSin8;
                    float fCos9 = ((float) Math.cos(dAtan24)) * f30;
                    float fSin9 = f30 * ((float) Math.sin(dAtan24));
                    if (d22 == d23 - 1.0d) {
                        Path path4 = this.f8766b;
                        path4.reset();
                        path4.moveTo(fCos6, fSin6);
                        float f33 = fCos6 - f31;
                        float f34 = fSin6 - f32;
                        float f35 = fCos7 + fCos9;
                        float f36 = fSin7 + fSin9;
                        path4.cubicTo(f33, f34, f35, f36, fCos7, fSin7);
                        PathMeasure pathMeasure = this.f8767c;
                        pathMeasure.setPath(path4, false);
                        float length = pathMeasure.getLength() * 0.9999f;
                        float[] fArr = this.f8768d;
                        pathMeasure.getPosTan(length, fArr, null);
                        path = path3;
                        path.cubicTo(f33, f34, f35, f36, fArr[0], fArr[1]);
                        fCos6 = fCos7;
                        fSin6 = fSin7;
                    } else {
                        float f37 = fSin7 + fSin9;
                        path = path3;
                        fSin6 = fSin7;
                        path.cubicTo(fCos6 - f31, fSin6 - f32, fCos7 + fCos9, f37, fCos7, fSin6);
                        fCos6 = fCos7;
                    }
                } else {
                    i = i11;
                    d11 = d19;
                    fCos6 = fCos7;
                    fSin6 = fSin7;
                    if (d22 == d23 - 1.0d) {
                        i11 = i + 1;
                        dCeil2 = d23;
                        d19 = d11;
                    } else {
                        path.lineTo(fCos6, fSin6);
                    }
                }
                d21 += d20;
                i11 = i + 1;
                dCeil2 = d23;
                d19 = d11;
            }
            PointF pointF2 = (PointF) eVar.e();
            path.offset(pointF2.x, pointF2.y);
            path.close();
        }
        path.close();
        this.f8779q.G(path);
        this.f8780r = z2;
        return path;
    }

    @Override // q5.f
    public final void g(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
        x5.f.f(eVar, i, arrayList, eVar2, this);
    }

    @Override // n5.c
    public final String getName() {
        return this.f8769e;
    }

    @Override // q5.f
    public final void h(Object obj, p2.c cVar) {
        o5.i iVar;
        o5.i iVar2;
        if (obj == z.f7944r) {
            this.f8772j.j(cVar);
            return;
        }
        if (obj == z.f7945s) {
            this.f8774l.j(cVar);
            return;
        }
        if (obj == z.i) {
            this.f8773k.j(cVar);
            return;
        }
        if (obj == z.f7946t && (iVar2 = this.f8775m) != null) {
            iVar2.j(cVar);
            return;
        }
        if (obj == z.f7947u) {
            this.f8776n.j(cVar);
            return;
        }
        if (obj == z.f7948v && (iVar = this.f8777o) != null) {
            iVar.j(cVar);
        } else if (obj == z.f7949w) {
            this.f8778p.j(cVar);
        }
    }
}
