package o6;

import ag.o;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import g6.a0;
import g6.w;
import g6.y;
import j6.s;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a {
    public final h6.a D;
    public final Rect E;
    public final Rect F;
    public final RectF G;
    public final y H;
    public s I;
    public s J;
    public final j6.h K;
    public s6.h L;
    public o M;

    public c(w wVar, d dVar) {
        super(wVar, dVar);
        this.D = new h6.a(3, 0);
        this.E = new Rect();
        this.F = new Rect();
        this.G = new RectF();
        String str = dVar.f9537g;
        g6.i iVar = wVar.f5152v;
        this.H = iVar == null ? null : (y) ((HashMap) iVar.c()).get(str);
        dd.c cVar = this.f9521p.f9553x;
        if (cVar != null) {
            this.K = new j6.h(this, this, cVar);
        }
    }

    @Override // o6.a, i6.f
    public final void a(RectF rectF, Matrix matrix, boolean z10) {
        Bitmap bitmapS;
        super.a(rectF, matrix, z10);
        y yVar = this.H;
        if (yVar != null) {
            int i = yVar.f5160b;
            int i10 = yVar.f5159a;
            float fC = s6.i.c();
            if (this.f9520o.H || (bitmapS = s()) == null) {
                rectF.set(0.0f, 0.0f, i10 * fC, i * fC);
            } else {
                rectF.set(0.0f, 0.0f, bitmapS.getWidth() * fC, bitmapS.getHeight() * fC);
            }
            this.f9519n.mapRect(rectF);
        }
    }

    @Override // o6.a, l6.f
    public final void h(Object obj, nb.w wVar) {
        super.h(obj, wVar);
        if (obj == a0.I) {
            this.I = new s(null, wVar);
            return;
        }
        if (obj == a0.L) {
            this.J = new s(null, wVar);
            return;
        }
        j6.h hVar = this.K;
        if (obj == 5 && hVar != null) {
            hVar.f6640c.j(wVar);
            return;
        }
        if (obj == a0.E && hVar != null) {
            hVar.c(wVar);
            return;
        }
        if (obj == a0.F && hVar != null) {
            hVar.f6642e.j(wVar);
            return;
        }
        if (obj == a0.G && hVar != null) {
            hVar.f.j(wVar);
        } else {
            if (obj != a0.H || hVar == null) {
                return;
            }
            hVar.f6643g.j(wVar);
        }
    }

    @Override // o6.a
    public final void k(Canvas canvas, Matrix matrix, int i, s6.a aVar) {
        y yVar;
        Bitmap bitmapS = s();
        if (bitmapS == null || bitmapS.isRecycled() || (yVar = this.H) == null) {
            return;
        }
        float fC = s6.i.c();
        h6.a aVar2 = this.D;
        aVar2.setAlpha(i);
        s sVar = this.I;
        if (sVar != null) {
            aVar2.setColorFilter((ColorFilter) sVar.e());
        }
        j6.h hVar = this.K;
        if (hVar != null) {
            aVar = hVar.a(matrix, i);
        }
        int width = bitmapS.getWidth();
        int height = bitmapS.getHeight();
        Rect rect = this.E;
        rect.set(0, 0, width, height);
        boolean z10 = this.f9520o.H;
        Rect rect2 = this.F;
        if (z10) {
            rect2.set(0, 0, (int) (yVar.f5159a * fC), (int) (yVar.f5160b * fC));
        } else {
            rect2.set(0, 0, (int) (bitmapS.getWidth() * fC), (int) (bitmapS.getHeight() * fC));
        }
        boolean z11 = aVar != null;
        if (z11) {
            if (this.L == null) {
                this.L = new s6.h();
            }
            if (this.M == null) {
                this.M = new o(8, (byte) 0);
            }
            o oVar = this.M;
            oVar.f454w = 255;
            oVar.f455x = null;
            aVar.getClass();
            s6.a aVar3 = new s6.a(aVar);
            oVar.f455x = aVar3;
            aVar3.b(i);
            float f = rect2.left;
            float f10 = rect2.top;
            float f11 = rect2.right;
            float f12 = rect2.bottom;
            RectF rectF = this.G;
            rectF.set(f, f10, f11, f12);
            matrix.mapRect(rectF);
            canvas = this.L.e(canvas, rectF, this.M);
        }
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmapS, rect, rect2, aVar2);
        if (z11) {
            this.L.c();
            if (this.L.f11561c == 4) {
                return;
            }
        }
        canvas.restore();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap s() {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.c.s():android.graphics.Bitmap");
    }
}
