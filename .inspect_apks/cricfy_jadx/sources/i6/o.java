package i6;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import g6.a0;
import g6.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements n, j6.a, l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f6296e;
    public final w f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f6298h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j6.i f6299j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j6.e f6300k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j6.i f6301l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j6.i f6302m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j6.i f6303n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j6.i f6304o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final j6.i f6305p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6307r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f6292a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f6293b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PathMeasure f6294c = new PathMeasure();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f6295d = new float[2];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f6306q = new c(0);

    public o(w wVar, o6.a aVar, n6.h hVar) {
        this.f = wVar;
        this.f6296e = hVar.f8805a;
        int i = hVar.f8806b;
        this.f6297g = i;
        this.f6298h = hVar.f8812j;
        this.i = hVar.f8813k;
        j6.i iVarD0 = hVar.f8807c.D0();
        this.f6299j = iVarD0;
        j6.e eVarD0 = hVar.f8808d.D0();
        this.f6300k = eVarD0;
        j6.i iVarD02 = hVar.f8809e.D0();
        this.f6301l = iVarD02;
        j6.i iVarD03 = hVar.f8810g.D0();
        this.f6303n = iVarD03;
        j6.i iVarD04 = hVar.i.D0();
        this.f6305p = iVarD04;
        if (i == 1) {
            this.f6302m = hVar.f.D0();
            this.f6304o = hVar.f8811h.D0();
        } else {
            this.f6302m = null;
            this.f6304o = null;
        }
        aVar.d(iVarD0);
        aVar.d(eVarD0);
        aVar.d(iVarD02);
        aVar.d(iVarD03);
        aVar.d(iVarD04);
        if (i == 1) {
            aVar.d(this.f6302m);
            aVar.d(this.f6304o);
        }
        iVarD0.a(this);
        eVarD0.a(this);
        iVarD02.a(this);
        iVarD03.a(this);
        iVarD04.a(this);
        if (i == 1) {
            this.f6302m.a(this);
            this.f6304o.a(this);
        }
    }

    @Override // j6.a
    public final void b() {
        this.f6307r = false;
        this.f.invalidateSelf();
    }

    @Override // i6.d
    public final void c(List list, List list2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (i >= arrayList.size()) {
                return;
            }
            d dVar = (d) arrayList.get(i);
            if (dVar instanceof u) {
                u uVar = (u) dVar;
                if (uVar.f6341c == 1) {
                    this.f6306q.f6231a.add(uVar);
                    uVar.d(this);
                }
            }
            i++;
        }
    }

    @Override // i6.n
    public final Path f() {
        boolean z10;
        float f;
        double d10;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        int i;
        double d11;
        boolean z11 = this.f6307r;
        Path path = this.f6292a;
        if (z11) {
            return path;
        }
        path.reset();
        if (this.f6298h) {
            this.f6307r = true;
            return path;
        }
        int iC = y.e.c(this.f6297g);
        j6.e eVar = this.f6300k;
        j6.i iVar = this.f6303n;
        j6.i iVar2 = this.f6305p;
        j6.i iVar3 = this.f6301l;
        j6.i iVar4 = this.f6299j;
        if (iC == 0) {
            z10 = true;
            float fFloatValue = ((Float) iVar4.e()).floatValue();
            double radians = Math.toRadians((iVar3 != null ? ((Float) iVar3.e()).floatValue() : 0.0d) - 90.0d);
            double d12 = fFloatValue;
            float f15 = (float) (6.283185307179586d / d12);
            if (this.i) {
                f15 *= -1.0f;
            }
            float f16 = f15;
            float f17 = f16 / 2.0f;
            float f18 = fFloatValue - ((int) fFloatValue);
            if (f18 != 0.0f) {
                f = 2.0f;
                radians += (double) ((1.0f - f18) * f17);
            } else {
                f = 2.0f;
            }
            float fFloatValue2 = ((Float) iVar.e()).floatValue();
            float fFloatValue3 = ((Float) this.f6302m.e()).floatValue();
            j6.i iVar5 = this.f6304o;
            float fFloatValue4 = iVar5 != null ? ((Float) iVar5.e()).floatValue() / 100.0f : 0.0f;
            float fFloatValue5 = iVar2 != null ? ((Float) iVar2.e()).floatValue() / 100.0f : 0.0f;
            if (f18 != 0.0f) {
                float fH = q4.a.h(fFloatValue2, fFloatValue3, f18, fFloatValue3);
                double d13 = fH;
                f12 = fH;
                float fCos = (float) (Math.cos(radians) * d13);
                float fSin = (float) (Math.sin(radians) * d13);
                path.moveTo(fCos, fSin);
                d10 = radians + ((double) ((f16 * f18) / f));
                f10 = fCos;
                f11 = fSin;
            } else {
                double d14 = fFloatValue2;
                float fCos2 = (float) (Math.cos(radians) * d14);
                float fSin2 = (float) (Math.sin(radians) * d14);
                path.moveTo(fCos2, fSin2);
                d10 = radians + ((double) f17);
                f10 = fCos2;
                f11 = fSin2;
                f12 = 0.0f;
            }
            double dCeil = Math.ceil(d12) * 2.0d;
            double d15 = d10;
            int i10 = 0;
            boolean z12 = false;
            while (true) {
                double d16 = i10;
                if (d16 >= dCeil) {
                    break;
                }
                float f19 = z12 ? fFloatValue2 : fFloatValue3;
                float f20 = (f12 == 0.0f || d16 != dCeil - 2.0d) ? f17 : (f16 * f18) / f;
                if (f12 != 0.0f && d16 == dCeil - 1.0d) {
                    f19 = f12;
                }
                double d17 = f19;
                float fCos3 = (float) (Math.cos(d15) * d17);
                float fSin3 = (float) (Math.sin(d15) * d17);
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    path.lineTo(fCos3, fSin3);
                    f13 = f18;
                    f14 = fCos3;
                } else {
                    f13 = f18;
                    Path path2 = path;
                    double dAtan2 = (float) (Math.atan2(f11, f10) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    float f21 = f10;
                    float f22 = f11;
                    double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan22);
                    float fSin5 = (float) Math.sin(dAtan22);
                    float f23 = z12 ? fFloatValue4 : fFloatValue5;
                    float f24 = z12 ? fFloatValue5 : fFloatValue4;
                    float f25 = (z12 ? fFloatValue3 : fFloatValue2) * f23 * 0.47829f;
                    float f26 = fCos4 * f25;
                    float f27 = f25 * fSin4;
                    float f28 = (z12 ? fFloatValue2 : fFloatValue3) * f24 * 0.47829f;
                    float f29 = fCos5 * f28;
                    float f30 = f28 * fSin5;
                    if (f18 != 0.0f) {
                        if (i10 == 0) {
                            f26 *= f13;
                            f27 *= f13;
                        } else if (d16 == dCeil - 1.0d) {
                            f29 *= f13;
                            f30 *= f13;
                        }
                    }
                    f14 = fCos3;
                    path = path2;
                    path.cubicTo(f21 - f26, f22 - f27, f29 + fCos3, fSin3 + f30, f14, fSin3);
                }
                d15 += (double) f20;
                z12 = !z12;
                i10++;
                f10 = f14;
                f11 = fSin3;
                f18 = f13;
                f = 2.0f;
            }
            PointF pointF = (PointF) eVar.e();
            path.offset(pointF.x, pointF.y);
            path.close();
        } else if (iC != 1) {
            z10 = true;
        } else {
            int iFloor = (int) Math.floor(((Float) iVar4.e()).floatValue());
            double radians2 = Math.toRadians((iVar3 != null ? ((Float) iVar3.e()).floatValue() : 0.0d) - 90.0d);
            double d18 = iFloor;
            float fFloatValue6 = ((Float) iVar2.e()).floatValue() / 100.0f;
            float fFloatValue7 = ((Float) iVar.e()).floatValue();
            double d19 = fFloatValue7;
            z10 = true;
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
                    float f31 = fFloatValue7 * fFloatValue6 * 0.25f;
                    float f32 = f31 * fCos8;
                    float f33 = f31 * fSin8;
                    float fCos9 = ((float) Math.cos(dAtan24)) * f31;
                    float fSin9 = f31 * ((float) Math.sin(dAtan24));
                    if (d22 == d23 - 1.0d) {
                        Path path4 = this.f6293b;
                        path4.reset();
                        path4.moveTo(fCos6, fSin6);
                        float f34 = fCos6 - f32;
                        float f35 = fSin6 - f33;
                        float f36 = fCos7 + fCos9;
                        float f37 = fSin7 + fSin9;
                        path4.cubicTo(f34, f35, f36, f37, fCos7, fSin7);
                        PathMeasure pathMeasure = this.f6294c;
                        pathMeasure.setPath(path4, false);
                        float length = pathMeasure.getLength() * 0.9999f;
                        float[] fArr = this.f6295d;
                        pathMeasure.getPosTan(length, fArr, null);
                        path = path3;
                        path.cubicTo(f34, f35, f36, f37, fArr[0], fArr[1]);
                        fCos6 = fCos7;
                        fSin6 = fSin7;
                    } else {
                        float f38 = fSin7 + fSin9;
                        path = path3;
                        fSin6 = fSin7;
                        path.cubicTo(fCos6 - f32, fSin6 - f33, fCos7 + fCos9, f38, fCos7, fSin6);
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
        this.f6306q.a(path);
        this.f6307r = z10;
        return path;
    }

    @Override // l6.f
    public final void g(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
        s6.g.g(eVar, i, arrayList, eVar2, this);
    }

    @Override // i6.d
    public final String getName() {
        return this.f6296e;
    }

    @Override // l6.f
    public final void h(Object obj, nb.w wVar) {
        j6.i iVar;
        j6.i iVar2;
        if (obj == a0.f5051u) {
            this.f6299j.j(wVar);
            return;
        }
        if (obj == a0.f5052v) {
            this.f6301l.j(wVar);
            return;
        }
        if (obj == a0.i) {
            this.f6300k.j(wVar);
            return;
        }
        if (obj == a0.f5053w && (iVar2 = this.f6302m) != null) {
            iVar2.j(wVar);
            return;
        }
        if (obj == a0.f5054x) {
            this.f6303n.j(wVar);
            return;
        }
        if (obj == a0.f5055y && (iVar = this.f6304o) != null) {
            iVar.j(wVar);
        } else if (obj == a0.f5056z) {
            this.f6305p.j(wVar);
        }
    }
}
