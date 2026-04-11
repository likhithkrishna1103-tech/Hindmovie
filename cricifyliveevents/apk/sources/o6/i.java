package o6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import g6.a0;
import g6.w;
import i2.k;
import j6.p;
import j6.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import k8.m;
import ka.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends a {
    public final StringBuilder D;
    public final StringBuilder E;
    public final StringBuilder F;
    public final StringBuilder G;
    public final RectF H;
    public final Matrix I;
    public final h6.a J;
    public final h6.a K;
    public final HashMap L;
    public final v.h M;
    public final ArrayList N;
    public final ArrayList O;
    public final j6.f P;
    public final w Q;
    public final g6.i R;
    public final int S;
    public final j6.f T;
    public s U;
    public final j6.f V;
    public s W;
    public final j6.i X;
    public s Y;
    public final j6.i Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public s f9557a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final j6.f f9558b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public s f9559c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public s f9560d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final j6.f f9561e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final j6.f f9562f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final j6.f f9563g0;

    public i(w wVar, d dVar) {
        m mVar;
        m mVar2;
        m6.a aVar;
        m mVar3;
        m6.a aVar2;
        m mVar4;
        m6.a aVar3;
        dd.c cVar;
        m6.a aVar4;
        dd.c cVar2;
        m6.b bVar;
        dd.c cVar3;
        m6.b bVar2;
        dd.c cVar4;
        m6.a aVar5;
        dd.c cVar5;
        m6.a aVar6;
        super(wVar, dVar);
        this.D = new StringBuilder(2);
        this.E = new StringBuilder(0);
        this.F = new StringBuilder(0);
        this.G = new StringBuilder(0);
        this.H = new RectF();
        this.I = new Matrix();
        h6.a aVar7 = new h6.a(1, 1);
        aVar7.setStyle(Paint.Style.FILL);
        this.J = aVar7;
        h6.a aVar8 = new h6.a(1, 2);
        aVar8.setStyle(Paint.Style.STROKE);
        this.K = aVar8;
        this.L = new HashMap();
        this.M = new v.h();
        this.N = new ArrayList();
        this.O = new ArrayList();
        this.S = 2;
        this.Q = wVar;
        this.R = dVar.f9533b;
        j6.f fVar = new j6.f(2, (List) dVar.f9546q.f307w);
        this.P = fVar;
        fVar.a(this);
        d(fVar);
        k kVar = dVar.f9547r;
        if (kVar != null && (cVar5 = (dd.c) kVar.f6085v) != null && (aVar6 = (m6.a) cVar5.f3672w) != null) {
            j6.e eVarD0 = aVar6.D0();
            this.T = (j6.f) eVarD0;
            eVarD0.a(this);
            d(eVarD0);
        }
        if (kVar != null && (cVar4 = (dd.c) kVar.f6085v) != null && (aVar5 = (m6.a) cVar4.f3673x) != null) {
            j6.e eVarD02 = aVar5.D0();
            this.V = (j6.f) eVarD02;
            eVarD02.a(this);
            d(eVarD02);
        }
        if (kVar != null && (cVar3 = (dd.c) kVar.f6085v) != null && (bVar2 = (m6.b) cVar3.f3674y) != null) {
            j6.i iVarD0 = bVar2.D0();
            this.X = iVarD0;
            iVarD0.a(this);
            d(iVarD0);
        }
        if (kVar != null && (cVar2 = (dd.c) kVar.f6085v) != null && (bVar = (m6.b) cVar2.f3675z) != null) {
            j6.i iVarD02 = bVar.D0();
            this.Z = iVarD02;
            iVarD02.a(this);
            d(iVarD02);
        }
        if (kVar != null && (cVar = (dd.c) kVar.f6085v) != null && (aVar4 = (m6.a) cVar.A) != null) {
            j6.e eVarD03 = aVar4.D0();
            this.f9558b0 = (j6.f) eVarD03;
            eVarD03.a(this);
            d(eVarD03);
        }
        if (kVar != null && (mVar4 = (m) kVar.f6086w) != null && (aVar3 = (m6.a) mVar4.f7280w) != null) {
            j6.e eVarD04 = aVar3.D0();
            this.f9561e0 = (j6.f) eVarD04;
            eVarD04.a(this);
            d(eVarD04);
        }
        if (kVar != null && (mVar3 = (m) kVar.f6086w) != null && (aVar2 = (m6.a) mVar3.f7281x) != null) {
            j6.e eVarD05 = aVar2.D0();
            this.f9562f0 = (j6.f) eVarD05;
            eVarD05.a(this);
            d(eVarD05);
        }
        if (kVar != null && (mVar2 = (m) kVar.f6086w) != null && (aVar = (m6.a) mVar2.f7282y) != null) {
            j6.e eVarD06 = aVar.D0();
            this.f9563g0 = (j6.f) eVarD06;
            eVarD06.a(this);
            d(eVarD06);
        }
        if (kVar == null || (mVar = (m) kVar.f6086w) == null) {
            return;
        }
        this.S = mVar.f7279v;
    }

    public static void u(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public static void v(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    @Override // o6.a, i6.f
    public final void a(RectF rectF, Matrix matrix, boolean z10) {
        super.a(rectF, matrix, z10);
        g6.i iVar = this.R;
        rectF.set(0.0f, 0.0f, iVar.f5094k.width(), iVar.f5094k.height());
    }

    @Override // o6.a, l6.f
    public final void h(Object obj, nb.w wVar) {
        super.h(obj, wVar);
        PointF pointF = a0.f5033a;
        if (obj == 1) {
            s sVar = this.U;
            if (sVar != null) {
                o(sVar);
            }
            s sVar2 = new s(null, wVar);
            this.U = sVar2;
            sVar2.a(this);
            d(this.U);
            return;
        }
        if (obj == 2) {
            s sVar3 = this.W;
            if (sVar3 != null) {
                o(sVar3);
            }
            s sVar4 = new s(null, wVar);
            this.W = sVar4;
            sVar4.a(this);
            d(this.W);
            return;
        }
        if (obj == a0.f5047q) {
            s sVar5 = this.Y;
            if (sVar5 != null) {
                o(sVar5);
            }
            s sVar6 = new s(null, wVar);
            this.Y = sVar6;
            sVar6.a(this);
            d(this.Y);
            return;
        }
        if (obj == a0.f5048r) {
            s sVar7 = this.f9557a0;
            if (sVar7 != null) {
                o(sVar7);
            }
            s sVar8 = new s(null, wVar);
            this.f9557a0 = sVar8;
            sVar8.a(this);
            d(this.f9557a0);
            return;
        }
        if (obj == a0.D) {
            s sVar9 = this.f9559c0;
            if (sVar9 != null) {
                o(sVar9);
            }
            s sVar10 = new s(null, wVar);
            this.f9559c0 = sVar10;
            sVar10.a(this);
            d(this.f9559c0);
            return;
        }
        if (obj != a0.K) {
            if (obj == a0.M) {
                j6.f fVar = this.P;
                fVar.getClass();
                fVar.j(new p(new v(), wVar, new l6.b()));
                return;
            }
            return;
        }
        s sVar11 = this.f9560d0;
        if (sVar11 != null) {
            o(sVar11);
        }
        s sVar12 = new s(null, wVar);
        this.f9560d0 = sVar12;
        sVar12.a(this);
        d(this.f9560d0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:165:0x0529, code lost:
    
        r3.insert(0, r6);
        r5 = r5 + 1;
        r1 = r23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e8  */
    @Override // o6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(android.graphics.Canvas r31, android.graphics.Matrix r32, int r33, s6.a r34) {
        /*
            Method dump skipped, instruction units count: 1456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.i.k(android.graphics.Canvas, android.graphics.Matrix, int, s6.a):void");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final String s(int i, String str) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (Character.getType(iCodePointAt2) != 16 && Character.getType(iCodePointAt2) != 27 && Character.getType(iCodePointAt2) != 6 && Character.getType(iCodePointAt2) != 28 && Character.getType(iCodePointAt2) != 8 && Character.getType(iCodePointAt2) != 19) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j4 = iCodePointAt;
        v.h hVar = this.M;
        if (hVar.f(j4) >= 0) {
            return (String) hVar.d(j4);
        }
        StringBuilder sb = this.D;
        sb.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            sb.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = sb.toString();
        hVar.h(j4, string);
        return string;
    }

    public final void t(l6.b bVar, int i, int i10) {
        s sVar = this.U;
        h6.a aVar = this.J;
        if (sVar != null) {
            aVar.setColor(((Integer) sVar.e()).intValue());
        } else {
            j6.f fVar = this.T;
            if (fVar == null || !x(i10)) {
                aVar.setColor(bVar.f7843h);
            } else {
                aVar.setColor(((Integer) fVar.e()).intValue());
            }
        }
        s sVar2 = this.W;
        h6.a aVar2 = this.K;
        if (sVar2 != null) {
            aVar2.setColor(((Integer) sVar2.e()).intValue());
        } else {
            j6.f fVar2 = this.V;
            if (fVar2 == null || !x(i10)) {
                aVar2.setColor(bVar.i);
            } else {
                aVar2.setColor(((Integer) fVar2.e()).intValue());
            }
        }
        j6.e eVar = this.f9528w.f6678p;
        int iIntValue = 100;
        int iIntValue2 = eVar == null ? 100 : ((Integer) eVar.e()).intValue();
        j6.f fVar3 = this.f9558b0;
        if (fVar3 != null && x(i10)) {
            iIntValue = ((Integer) fVar3.e()).intValue();
        }
        int iRound = Math.round((((iIntValue / 100.0f) * ((iIntValue2 * 255.0f) / 100.0f)) * i) / 255.0f);
        aVar.setAlpha(iRound);
        aVar2.setAlpha(iRound);
        s sVar3 = this.Y;
        if (sVar3 != null) {
            aVar2.setStrokeWidth(((Float) sVar3.e()).floatValue());
            return;
        }
        j6.i iVar = this.X;
        if (iVar == null || !x(i10)) {
            aVar2.setStrokeWidth(s6.i.c() * bVar.f7844j);
        } else {
            aVar2.setStrokeWidth(((Float) iVar.e()).floatValue());
        }
    }

    public final h w(int i) {
        ArrayList arrayList = this.O;
        for (int size = arrayList.size(); size < i; size++) {
            h hVar = new h();
            hVar.f9555a = "";
            hVar.f9556b = 0.0f;
            arrayList.add(hVar);
        }
        return (h) arrayList.get(i - 1);
    }

    public final boolean x(int i) {
        j6.f fVar;
        int length = ((l6.b) this.P.e()).f7837a.length();
        j6.f fVar2 = this.f9561e0;
        if (fVar2 == null || (fVar = this.f9562f0) == null) {
            return true;
        }
        int iMin = Math.min(((Integer) fVar2.e()).intValue(), ((Integer) fVar.e()).intValue());
        int iMax = Math.max(((Integer) fVar2.e()).intValue(), ((Integer) fVar.e()).intValue());
        j6.f fVar3 = this.f9563g0;
        if (fVar3 != null) {
            int iIntValue = ((Integer) fVar3.e()).intValue();
            iMin += iIntValue;
            iMax += iIntValue;
        }
        if (this.S == 2) {
            return i >= iMin && i < iMax;
        }
        float f = (i / length) * 100.0f;
        return f >= ((float) iMin) && f < ((float) iMax);
    }

    public final boolean y(Canvas canvas, l6.b bVar, int i, float f) {
        PointF pointF = bVar.f7846l;
        PointF pointF2 = bVar.f7847m;
        float fC = s6.i.c();
        float f10 = (i * bVar.f * fC) + (pointF == null ? 0.0f : (bVar.f * fC) + pointF.y);
        if (this.Q.P && pointF2 != null && pointF != null && f10 >= pointF.y + pointF2.y + bVar.f7839c) {
            return false;
        }
        float f11 = pointF == null ? 0.0f : pointF.x;
        float f12 = pointF2 != null ? pointF2.x : 0.0f;
        int iC = y.e.c(bVar.f7840d);
        if (iC == 0) {
            canvas.translate(f11, f10);
            return true;
        }
        if (iC == 1) {
            canvas.translate((f11 + f12) - f, f10);
            return true;
        }
        if (iC != 2) {
            return true;
        }
        canvas.translate(((f12 / 2.0f) + f11) - (f / 2.0f), f10);
        return true;
    }

    public final List z(String str, float f, l6.c cVar, float f10, float f11, boolean z10) {
        float fMeasureText;
        int i = 0;
        int i10 = 0;
        boolean z11 = false;
        int i11 = 0;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        for (int i12 = 0; i12 < str.length(); i12++) {
            char cCharAt = str.charAt(i12);
            if (z10) {
                l6.d dVar = (l6.d) this.R.f5092h.c(l6.d.a(cCharAt, cVar.f7848a, cVar.f7850c));
                if (dVar != null) {
                    fMeasureText = (s6.i.c() * ((float) dVar.f7854c) * f10) + f11;
                }
            } else {
                fMeasureText = this.J.measureText(str.substring(i12, i12 + 1)) + f11;
            }
            if (cCharAt == ' ') {
                z11 = true;
                f14 = fMeasureText;
            } else if (z11) {
                z11 = false;
                i11 = i12;
                f13 = fMeasureText;
            } else {
                f13 += fMeasureText;
            }
            f12 += fMeasureText;
            if (f > 0.0f && f12 >= f && cCharAt != ' ') {
                i++;
                h hVarW = w(i);
                if (i11 == i10) {
                    hVarW.f9555a = str.substring(i10, i12).trim();
                    hVarW.f9556b = (f12 - fMeasureText) - ((r10.length() - r8.length()) * f14);
                    i10 = i12;
                    i11 = i10;
                    f12 = fMeasureText;
                    f13 = f12;
                } else {
                    hVarW.f9555a = str.substring(i10, i11 - 1).trim();
                    hVarW.f9556b = ((f12 - f13) - ((r8.length() - r14.length()) * f14)) - f14;
                    f12 = f13;
                    i10 = i11;
                }
            }
        }
        if (f12 > 0.0f) {
            i++;
            h hVarW2 = w(i);
            hVarW2.f9555a = str.substring(i10);
            hVarW2.f9556b = f12;
        }
        return this.O.subList(0, i);
    }
}
