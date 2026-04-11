package t5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import l5.w;
import l5.z;
import o5.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends b {
    public final RectF C;
    public final m5.a D;
    public final float[] E;
    public final Path F;
    public final e G;
    public r H;
    public r I;

    public h(w wVar, e eVar) {
        super(wVar, eVar);
        this.C = new RectF();
        m5.a aVar = new m5.a();
        this.D = aVar;
        this.E = new float[8];
        this.F = new Path();
        this.G = eVar;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(eVar.f12186l);
    }

    @Override // t5.b, n5.e
    public final void a(RectF rectF, Matrix matrix, boolean z2) {
        super.a(rectF, matrix, z2);
        e eVar = this.G;
        float f = eVar.f12184j;
        float f4 = eVar.f12185k;
        RectF rectF2 = this.C;
        rectF2.set(0.0f, 0.0f, f, f4);
        this.f12164n.mapRect(rectF2);
        rectF.set(rectF2);
    }

    @Override // t5.b, q5.f
    public final void h(Object obj, p2.c cVar) {
        super.h(obj, cVar);
        if (obj == z.F) {
            this.H = new r(null, cVar);
        } else if (obj == 1) {
            this.I = new r(null, cVar);
        }
    }

    @Override // t5.b
    public final void k(Canvas canvas, Matrix matrix, int i) {
        e eVar = this.G;
        int iAlpha = Color.alpha(eVar.f12186l);
        if (iAlpha == 0) {
            return;
        }
        r rVar = this.I;
        Integer num = rVar == null ? null : (Integer) rVar.e();
        m5.a aVar = this.D;
        if (num != null) {
            aVar.setColor(num.intValue());
        } else {
            aVar.setColor(eVar.f12186l);
        }
        int iIntValue = (int) ((((iAlpha / 255.0f) * (this.f12173w.f9415j == null ? 100 : ((Integer) r2.e()).intValue())) / 100.0f) * (i / 255.0f) * 255.0f);
        aVar.setAlpha(iIntValue);
        r rVar2 = this.H;
        if (rVar2 != null) {
            aVar.setColorFilter((ColorFilter) rVar2.e());
        }
        if (iIntValue > 0) {
            float[] fArr = this.E;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            float f = eVar.f12184j;
            fArr[2] = f;
            fArr[3] = 0.0f;
            fArr[4] = f;
            float f4 = eVar.f12185k;
            fArr[5] = f4;
            fArr[6] = 0.0f;
            fArr[7] = f4;
            matrix.mapPoints(fArr);
            Path path = this.F;
            path.reset();
            path.moveTo(fArr[0], fArr[1]);
            path.lineTo(fArr[2], fArr[3]);
            path.lineTo(fArr[4], fArr[5]);
            path.lineTo(fArr[6], fArr[7]);
            path.lineTo(fArr[0], fArr[1]);
            path.close();
            canvas.drawPath(path, aVar);
        }
    }
}
