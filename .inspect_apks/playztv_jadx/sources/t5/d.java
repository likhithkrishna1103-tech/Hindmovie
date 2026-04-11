package t5;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.HashMap;
import l5.w;
import l5.x;
import l5.z;
import o5.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends b {
    public final m5.a C;
    public final Rect D;
    public final Rect E;
    public final x F;
    public r G;
    public r H;

    public d(w wVar, e eVar) {
        super(wVar, eVar);
        this.C = new m5.a(3, 0);
        this.D = new Rect();
        this.E = new Rect();
        String str = eVar.f12182g;
        l5.j jVar = wVar.f7918u;
        this.F = jVar == null ? null : (x) ((HashMap) jVar.c()).get(str);
    }

    @Override // t5.b, n5.e
    public final void a(RectF rectF, Matrix matrix, boolean z2) {
        super.a(rectF, matrix, z2);
        if (this.F != null) {
            float fC = x5.g.c();
            rectF.set(0.0f, 0.0f, r3.f7924a * fC, r3.f7925b * fC);
            this.f12164n.mapRect(rectF);
        }
    }

    @Override // t5.b, q5.f
    public final void h(Object obj, p2.c cVar) {
        super.h(obj, cVar);
        if (obj == z.F) {
            this.G = new r(null, cVar);
        } else if (obj == z.I) {
            this.H = new r(null, cVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0104  */
    @Override // t5.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(android.graphics.Canvas r18, android.graphics.Matrix r19, int r20) {
        /*
            Method dump skipped, instruction units count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t5.d.k(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }
}
