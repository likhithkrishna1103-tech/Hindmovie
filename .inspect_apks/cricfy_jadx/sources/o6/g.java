package o6;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import g6.a0;
import g6.w;
import j6.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends a {
    public final RectF D;
    public final h6.a E;
    public final float[] F;
    public final Path G;
    public final d H;
    public s I;
    public s J;

    public g(w wVar, d dVar) {
        super(wVar, dVar);
        this.D = new RectF();
        h6.a aVar = new h6.a();
        this.E = aVar;
        this.F = new float[8];
        this.G = new Path();
        this.H = dVar;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(dVar.f9541l);
    }

    @Override // o6.a, i6.f
    public final void a(RectF rectF, Matrix matrix, boolean z10) {
        super.a(rectF, matrix, z10);
        d dVar = this.H;
        float f = dVar.f9539j;
        float f10 = dVar.f9540k;
        RectF rectF2 = this.D;
        rectF2.set(0.0f, 0.0f, f, f10);
        this.f9519n.mapRect(rectF2);
        rectF.set(rectF2);
    }

    @Override // o6.a, l6.f
    public final void h(Object obj, nb.w wVar) {
        super.h(obj, wVar);
        if (obj == a0.I) {
            this.I = new s(null, wVar);
        } else if (obj == 1) {
            this.J = new s(null, wVar);
        }
    }

    @Override // o6.a
    public final void k(Canvas canvas, Matrix matrix, int i, s6.a aVar) {
        d dVar = this.H;
        int iAlpha = Color.alpha(dVar.f9541l);
        if (iAlpha == 0) {
            return;
        }
        s sVar = this.J;
        Integer num = sVar == null ? null : (Integer) sVar.e();
        h6.a aVar2 = this.E;
        if (num != null) {
            aVar2.setColor(num.intValue());
        } else {
            aVar2.setColor(dVar.f9541l);
        }
        int iIntValue = (int) ((((iAlpha / 255.0f) * (this.f9528w.f6678p == null ? 100 : ((Integer) r2.e()).intValue())) / 100.0f) * (i / 255.0f) * 255.0f);
        aVar2.setAlpha(iIntValue);
        if (aVar == null || Color.alpha(aVar.f11544d) <= 0) {
            aVar2.clearShadowLayer();
        } else {
            aVar2.setShadowLayer(Math.max(aVar.f11541a, Float.MIN_VALUE), aVar.f11542b, aVar.f11543c, aVar.f11544d);
        }
        s sVar2 = this.I;
        if (sVar2 != null) {
            aVar2.setColorFilter((ColorFilter) sVar2.e());
        }
        if (iIntValue > 0) {
            float[] fArr = this.F;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            float f = dVar.f9539j;
            fArr[2] = f;
            fArr[3] = 0.0f;
            fArr[4] = f;
            float f10 = dVar.f9540k;
            fArr[5] = f10;
            fArr[6] = 0.0f;
            fArr[7] = f10;
            matrix.mapPoints(fArr);
            Path path = this.G;
            path.reset();
            path.moveTo(fArr[0], fArr[1]);
            path.lineTo(fArr[2], fArr[3]);
            path.lineTo(fArr[4], fArr[5]);
            path.lineTo(fArr[6], fArr[7]);
            path.lineTo(fArr[0], fArr[1]);
            path.close();
            canvas.drawPath(path, aVar2);
        }
    }
}
