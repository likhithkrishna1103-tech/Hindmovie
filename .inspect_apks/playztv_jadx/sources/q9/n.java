package q9;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f11136c;

    public n(p pVar) {
        this.f11136c = pVar;
    }

    @Override // q9.s
    public final void a(Matrix matrix, p9.a aVar, int i, Canvas canvas) {
        float f;
        p pVar = this.f11136c;
        float f4 = pVar.f;
        float f10 = pVar.f11145g;
        RectF rectF = new RectF(pVar.f11141b, pVar.f11142c, pVar.f11143d, pVar.f11144e);
        Paint paint = aVar.f10291b;
        boolean z2 = f10 < 0.0f;
        Path path = aVar.f10295g;
        int[] iArr = p9.a.f10288k;
        if (z2) {
            iArr[0] = 0;
            iArr[1] = aVar.f;
            iArr[2] = aVar.f10294e;
            iArr[3] = aVar.f10293d;
            f = 0.0f;
        } else {
            path.rewind();
            f = 0.0f;
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f4, f10);
            path.close();
            float f11 = -i;
            rectF.inset(f11, f11);
            iArr[0] = 0;
            iArr[1] = aVar.f10293d;
            iArr[2] = aVar.f10294e;
            iArr[3] = aVar.f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= f) {
            return;
        }
        float f12 = 1.0f - (i / fWidth);
        float[] fArr = p9.a.f10289l;
        fArr[1] = f12;
        fArr[2] = ((1.0f - f12) / 2.0f) + f12;
        paint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z2) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, aVar.f10296h);
        }
        canvas.drawArc(rectF, f4, f10, true, paint);
        canvas.restore();
    }
}
