package i6;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import g6.a0;
import g6.w;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements j6.a, l, n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f6312e;
    public final j6.e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j6.e f6313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j6.i f6314h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6316k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f6308a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f6309b = new RectF();
    public final c i = new c(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j6.e f6315j = null;

    public p(w wVar, o6.a aVar, n6.i iVar) {
        this.f6310c = iVar.f8815b;
        this.f6311d = iVar.f8817d;
        this.f6312e = wVar;
        j6.e eVarD0 = iVar.f8818e.D0();
        this.f = eVarD0;
        j6.e eVarD02 = ((m6.f) iVar.f).D0();
        this.f6313g = eVarD02;
        j6.i iVarD0 = iVar.f8816c.D0();
        this.f6314h = iVarD0;
        aVar.d(eVarD0);
        aVar.d(eVarD02);
        aVar.d(iVarD0);
        eVarD0.a(this);
        eVarD02.a(this);
        iVarD0.a(this);
    }

    @Override // j6.a
    public final void b() {
        this.f6316k = false;
        this.f6312e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    @Override // i6.d
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
            if (r6 >= r1) goto L34
            java.lang.Object r0 = r0.get(r6)
            i6.d r0 = (i6.d) r0
            boolean r1 = r0 instanceof i6.u
            if (r1 == 0) goto L27
            r1 = r0
            i6.u r1 = (i6.u) r1
            int r2 = r1.f6341c
            r3 = 1
            if (r2 != r3) goto L27
            i6.c r0 = r4.i
            java.util.ArrayList r0 = r0.f6231a
            r0.add(r1)
            r1.d(r4)
            goto L31
        L27:
            boolean r1 = r0 instanceof i6.r
            if (r1 == 0) goto L31
            i6.r r0 = (i6.r) r0
            j6.e r0 = r0.f6326b
            r4.f6315j = r0
        L31:
            int r6 = r6 + 1
            goto L1
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.p.c(java.util.List, java.util.List):void");
    }

    @Override // i6.n
    public final Path f() {
        float f;
        j6.e eVar;
        boolean z10 = this.f6316k;
        Path path = this.f6308a;
        if (z10) {
            return path;
        }
        path.reset();
        if (this.f6311d) {
            this.f6316k = true;
            return path;
        }
        PointF pointF = (PointF) this.f6313g.e();
        float f10 = pointF.x / 2.0f;
        float f11 = pointF.y / 2.0f;
        j6.i iVar = this.f6314h;
        float fL = iVar == null ? 0.0f : iVar.l();
        if (fL == 0.0f && (eVar = this.f6315j) != null) {
            fL = Math.min(((Float) eVar.e()).floatValue(), Math.min(f10, f11));
        }
        float fMin = Math.min(f10, f11);
        if (fL > fMin) {
            fL = fMin;
        }
        PointF pointF2 = (PointF) this.f.e();
        path.moveTo(pointF2.x + f10, (pointF2.y - f11) + fL);
        path.lineTo(pointF2.x + f10, (pointF2.y + f11) - fL);
        RectF rectF = this.f6309b;
        if (fL > 0.0f) {
            float f12 = pointF2.x + f10;
            float f13 = fL * 2.0f;
            f = 2.0f;
            float f14 = pointF2.y + f11;
            rectF.set(f12 - f13, f14 - f13, f12, f14);
            path.arcTo(rectF, 0.0f, 90.0f, false);
        } else {
            f = 2.0f;
        }
        path.lineTo((pointF2.x - f10) + fL, pointF2.y + f11);
        if (fL > 0.0f) {
            float f15 = pointF2.x - f10;
            float f16 = pointF2.y + f11;
            float f17 = fL * f;
            rectF.set(f15, f16 - f17, f17 + f15, f16);
            path.arcTo(rectF, 90.0f, 90.0f, false);
        }
        path.lineTo(pointF2.x - f10, (pointF2.y - f11) + fL);
        if (fL > 0.0f) {
            float f18 = pointF2.x - f10;
            float f19 = pointF2.y - f11;
            float f20 = fL * f;
            rectF.set(f18, f19, f18 + f20, f20 + f19);
            path.arcTo(rectF, 180.0f, 90.0f, false);
        }
        path.lineTo((pointF2.x + f10) - fL, pointF2.y - f11);
        if (fL > 0.0f) {
            float f21 = pointF2.x + f10;
            float f22 = fL * f;
            float f23 = pointF2.y - f11;
            rectF.set(f21 - f22, f23, f21, f22 + f23);
            path.arcTo(rectF, 270.0f, 90.0f, false);
        }
        path.close();
        this.i.a(path);
        this.f6316k = true;
        return path;
    }

    @Override // l6.f
    public final void g(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
        s6.g.g(eVar, i, arrayList, eVar2, this);
    }

    @Override // i6.d
    public final String getName() {
        return this.f6310c;
    }

    @Override // l6.f
    public final void h(Object obj, nb.w wVar) {
        if (obj == a0.f5038g) {
            this.f6313g.j(wVar);
        } else if (obj == a0.i) {
            this.f.j(wVar);
        } else if (obj == a0.f5039h) {
            this.f6314h.j(wVar);
        }
    }
}
