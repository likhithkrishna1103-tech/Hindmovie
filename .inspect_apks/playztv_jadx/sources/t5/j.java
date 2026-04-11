package t5;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import l5.w;
import l5.z;
import o5.p;
import o5.r;
import q9.t;
import ub.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends b {
    public final StringBuilder C;
    public final RectF D;
    public final Matrix E;
    public final m5.a F;
    public final m5.a G;
    public final HashMap H;
    public final s.g I;
    public final ArrayList J;
    public final o5.f K;
    public final w L;
    public final l5.j M;
    public final o5.f N;
    public r O;
    public final o5.f P;
    public r Q;
    public final o5.i R;
    public r S;
    public final o5.i T;
    public r U;
    public r V;
    public r W;

    public j(w wVar, e eVar) {
        r5.b bVar;
        r5.b bVar2;
        r5.a aVar;
        r5.a aVar2;
        super(wVar, eVar);
        this.C = new StringBuilder(2);
        this.D = new RectF();
        this.E = new Matrix();
        m5.a aVar3 = new m5.a(1, 1);
        aVar3.setStyle(Paint.Style.FILL);
        this.F = aVar3;
        m5.a aVar4 = new m5.a(1, 2);
        aVar4.setStyle(Paint.Style.STROKE);
        this.G = aVar4;
        this.H = new HashMap();
        this.I = new s.g();
        this.J = new ArrayList();
        this.L = wVar;
        this.M = eVar.f12178b;
        o5.f fVar = new o5.f(2, (List) eVar.f12191q.f2454v);
        this.K = fVar;
        fVar.a(this);
        d(fVar);
        o oVar = eVar.f12192r;
        if (oVar != null && (aVar2 = (r5.a) oVar.f12868v) != null) {
            o5.e eVarD0 = aVar2.D0();
            this.N = (o5.f) eVarD0;
            eVarD0.a(this);
            d(eVarD0);
        }
        if (oVar != null && (aVar = (r5.a) oVar.f12869w) != null) {
            o5.e eVarD02 = aVar.D0();
            this.P = (o5.f) eVarD02;
            eVarD02.a(this);
            d(eVarD02);
        }
        if (oVar != null && (bVar2 = (r5.b) oVar.f12870x) != null) {
            o5.e eVarD03 = bVar2.D0();
            this.R = (o5.i) eVarD03;
            eVarD03.a(this);
            d(eVarD03);
        }
        if (oVar == null || (bVar = (r5.b) oVar.f12871y) == null) {
            return;
        }
        o5.e eVarD04 = bVar.D0();
        this.T = (o5.i) eVarD04;
        eVarD04.a(this);
        d(eVarD04);
    }

    public static void t(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public static void u(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    @Override // t5.b, n5.e
    public final void a(RectF rectF, Matrix matrix, boolean z2) {
        super.a(rectF, matrix, z2);
        l5.j jVar = this.M;
        rectF.set(0.0f, 0.0f, jVar.f7865k.width(), jVar.f7865k.height());
    }

    @Override // t5.b, q5.f
    public final void h(Object obj, p2.c cVar) {
        super.h(obj, cVar);
        PointF pointF = z.f7929a;
        if (obj == 1) {
            r rVar = this.O;
            if (rVar != null) {
                p(rVar);
            }
            r rVar2 = new r(null, cVar);
            this.O = rVar2;
            rVar2.a(this);
            d(this.O);
            return;
        }
        if (obj == 2) {
            r rVar3 = this.Q;
            if (rVar3 != null) {
                p(rVar3);
            }
            r rVar4 = new r(null, cVar);
            this.Q = rVar4;
            rVar4.a(this);
            d(this.Q);
            return;
        }
        if (obj == z.f7940n) {
            r rVar5 = this.S;
            if (rVar5 != null) {
                p(rVar5);
            }
            r rVar6 = new r(null, cVar);
            this.S = rVar6;
            rVar6.a(this);
            d(this.S);
            return;
        }
        if (obj == z.f7941o) {
            r rVar7 = this.U;
            if (rVar7 != null) {
                p(rVar7);
            }
            r rVar8 = new r(null, cVar);
            this.U = rVar8;
            rVar8.a(this);
            d(this.U);
            return;
        }
        if (obj == z.A) {
            r rVar9 = this.V;
            if (rVar9 != null) {
                p(rVar9);
            }
            r rVar10 = new r(null, cVar);
            this.V = rVar10;
            rVar10.a(this);
            d(this.V);
            return;
        }
        if (obj != z.H) {
            if (obj == z.J) {
                o5.f fVar = this.K;
                fVar.getClass();
                fVar.j(new p(new t(), cVar, new q5.b()));
                return;
            }
            return;
        }
        r rVar11 = this.W;
        if (rVar11 != null) {
            p(rVar11);
        }
        r rVar12 = new r(null, cVar);
        this.W = rVar12;
        rVar12.a(this);
        d(this.W);
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0142  */
    @Override // t5.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(android.graphics.Canvas r27, android.graphics.Matrix r28, int r29) {
        /*
            Method dump skipped, instruction units count: 1282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t5.j.k(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public final i v(int i) {
        ArrayList arrayList = this.J;
        for (int size = arrayList.size(); size < i; size++) {
            i iVar = new i();
            iVar.f12200a = "";
            iVar.f12201b = 0.0f;
            arrayList.add(iVar);
        }
        return (i) arrayList.get(i - 1);
    }

    public final boolean w(Canvas canvas, q5.b bVar, int i, float f) {
        PointF pointF = bVar.f10999l;
        PointF pointF2 = bVar.f11000m;
        float fC = x5.g.c();
        float f4 = (i * bVar.f * fC) + (pointF == null ? 0.0f : (bVar.f * fC) + pointF.y);
        if (this.L.N && pointF2 != null && pointF != null && f4 >= pointF.y + pointF2.y + bVar.f10992c) {
            return false;
        }
        float f10 = pointF == null ? 0.0f : pointF.x;
        float f11 = pointF2 != null ? pointF2.x : 0.0f;
        int iC = v.e.c(bVar.f10993d);
        if (iC == 0) {
            canvas.translate(f10, f4);
            return true;
        }
        if (iC == 1) {
            canvas.translate((f10 + f11) - f, f4);
            return true;
        }
        if (iC != 2) {
            return true;
        }
        canvas.translate(((f11 / 2.0f) + f10) - (f / 2.0f), f4);
        return true;
    }

    public final List x(String str, float f, q5.c cVar, float f4, float f10, boolean z2) {
        float fMeasureText;
        int i = 0;
        int i10 = 0;
        boolean z10 = false;
        int i11 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i12 = 0; i12 < str.length(); i12++) {
            char cCharAt = str.charAt(i12);
            if (z2) {
                q5.d dVar = (q5.d) this.M.f7863h.c(q5.d.a(cCharAt, cVar.f11001a, cVar.f11003c));
                if (dVar != null) {
                    fMeasureText = (x5.g.c() * ((float) dVar.f11007c) * f4) + f10;
                }
            } else {
                fMeasureText = this.F.measureText(str.substring(i12, i12 + 1)) + f10;
            }
            if (cCharAt == ' ') {
                z10 = true;
                f13 = fMeasureText;
            } else if (z10) {
                z10 = false;
                i11 = i12;
                f12 = fMeasureText;
            } else {
                f12 += fMeasureText;
            }
            f11 += fMeasureText;
            if (f > 0.0f && f11 >= f && cCharAt != ' ') {
                i++;
                i iVarV = v(i);
                if (i11 == i10) {
                    iVarV.f12200a = str.substring(i10, i12).trim();
                    iVarV.f12201b = (f11 - fMeasureText) - ((r10.length() - r8.length()) * f13);
                    i10 = i12;
                    i11 = i10;
                    f11 = fMeasureText;
                    f12 = f11;
                } else {
                    iVarV.f12200a = str.substring(i10, i11 - 1).trim();
                    iVarV.f12201b = ((f11 - f12) - ((r8.length() - r14.length()) * f13)) - f13;
                    f11 = f12;
                    i10 = i11;
                }
            }
        }
        if (f11 > 0.0f) {
            i++;
            i iVarV2 = v(i);
            iVarV2.f12200a = str.substring(i10);
            iVarV2.f12201b = f11;
        }
        return this.J.subList(0, i);
    }
}
