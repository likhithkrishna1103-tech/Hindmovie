package n5;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import l5.w;
import l5.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements o5.a, k, m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f8785e;
    public final o5.e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o5.e f8786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o5.i f8787h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8789k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f8781a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f8782b = new RectF();
    public final rc.b i = new rc.b(26);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o5.e f8788j = null;

    public o(w wVar, t5.b bVar, s5.i iVar) {
        this.f8783c = iVar.f11831b;
        this.f8784d = iVar.f11833d;
        this.f8785e = wVar;
        o5.e eVarD0 = iVar.f11834e.D0();
        this.f = eVarD0;
        o5.e eVarD02 = ((r5.e) iVar.f).D0();
        this.f8786g = eVarD02;
        o5.e eVarD03 = iVar.f11832c.D0();
        this.f8787h = (o5.i) eVarD03;
        bVar.d(eVarD0);
        bVar.d(eVarD02);
        bVar.d(eVarD03);
        eVarD0.a(this);
        eVarD02.a(this);
        eVarD03.a(this);
    }

    @Override // o5.a
    public final void b() {
        this.f8789k = false;
        this.f8785e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    @Override // n5.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.util.List r5, java.util.List r6) {
        /*
            r4 = this;
            r6 = 0
        L1:
            r0 = r5
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r1 = r0.size()
            if (r6 >= r1) goto L36
            java.lang.Object r0 = r0.get(r6)
            n5.c r0 = (n5.c) r0
            boolean r1 = r0 instanceof n5.t
            if (r1 == 0) goto L29
            r1 = r0
            n5.t r1 = (n5.t) r1
            int r2 = r1.f8814c
            r3 = 1
            if (r2 != r3) goto L29
            rc.b r0 = r4.i
            java.lang.Object r0 = r0.f11562v
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r0.add(r1)
            r1.d(r4)
            goto L33
        L29:
            boolean r1 = r0 instanceof n5.q
            if (r1 == 0) goto L33
            n5.q r0 = (n5.q) r0
            o5.e r0 = r0.f8799b
            r4.f8788j = r0
        L33:
            int r6 = r6 + 1
            goto L1
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.o.c(java.util.List, java.util.List):void");
    }

    @Override // n5.m
    public final Path f() {
        float f;
        o5.e eVar;
        boolean z2 = this.f8789k;
        Path path = this.f8781a;
        if (z2) {
            return path;
        }
        path.reset();
        if (this.f8784d) {
            this.f8789k = true;
            return path;
        }
        PointF pointF = (PointF) this.f8786g.e();
        float f4 = pointF.x / 2.0f;
        float f10 = pointF.y / 2.0f;
        o5.i iVar = this.f8787h;
        float fK = iVar == null ? 0.0f : iVar.k();
        if (fK == 0.0f && (eVar = this.f8788j) != null) {
            fK = Math.min(((Float) eVar.e()).floatValue(), Math.min(f4, f10));
        }
        float fMin = Math.min(f4, f10);
        if (fK > fMin) {
            fK = fMin;
        }
        PointF pointF2 = (PointF) this.f.e();
        path.moveTo(pointF2.x + f4, (pointF2.y - f10) + fK);
        path.lineTo(pointF2.x + f4, (pointF2.y + f10) - fK);
        RectF rectF = this.f8782b;
        if (fK > 0.0f) {
            float f11 = pointF2.x + f4;
            float f12 = fK * 2.0f;
            f = 2.0f;
            float f13 = pointF2.y + f10;
            rectF.set(f11 - f12, f13 - f12, f11, f13);
            path.arcTo(rectF, 0.0f, 90.0f, false);
        } else {
            f = 2.0f;
        }
        path.lineTo((pointF2.x - f4) + fK, pointF2.y + f10);
        if (fK > 0.0f) {
            float f14 = pointF2.x - f4;
            float f15 = pointF2.y + f10;
            float f16 = fK * f;
            rectF.set(f14, f15 - f16, f16 + f14, f15);
            path.arcTo(rectF, 90.0f, 90.0f, false);
        }
        path.lineTo(pointF2.x - f4, (pointF2.y - f10) + fK);
        if (fK > 0.0f) {
            float f17 = pointF2.x - f4;
            float f18 = pointF2.y - f10;
            float f19 = fK * f;
            rectF.set(f17, f18, f17 + f19, f19 + f18);
            path.arcTo(rectF, 180.0f, 90.0f, false);
        }
        path.lineTo((pointF2.x + f4) - fK, pointF2.y - f10);
        if (fK > 0.0f) {
            float f20 = pointF2.x + f4;
            float f21 = fK * f;
            float f22 = pointF2.y - f10;
            rectF.set(f20 - f21, f22, f20, f21 + f22);
            path.arcTo(rectF, 270.0f, 90.0f, false);
        }
        path.close();
        this.i.G(path);
        this.f8789k = true;
        return path;
    }

    @Override // q5.f
    public final void g(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
        x5.f.f(eVar, i, arrayList, eVar2, this);
    }

    @Override // n5.c
    public final String getName() {
        return this.f8783c;
    }

    @Override // q5.f
    public final void h(Object obj, p2.c cVar) {
        if (obj == z.f7934g) {
            this.f8786g.j(cVar);
        } else if (obj == z.i) {
            this.f.j(cVar);
        } else if (obj == z.f7935h) {
            this.f8787h.j(cVar);
        }
    }
}
