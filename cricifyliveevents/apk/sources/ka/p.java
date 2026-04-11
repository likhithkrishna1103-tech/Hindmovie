package ka;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f7363c;

    public p(r rVar) {
        this.f7363c = rVar;
    }

    @Override // ka.u
    public final void a(Matrix matrix, ja.a aVar, int i, Canvas canvas) {
        float f;
        r rVar = this.f7363c;
        float f10 = rVar.f;
        float f11 = rVar.f7372g;
        RectF rectF = new RectF(rVar.f7368b, rVar.f7369c, rVar.f7370d, rVar.f7371e);
        Paint paint = aVar.f6716b;
        boolean z10 = f11 < 0.0f;
        Path path = aVar.f6720g;
        int[] iArr = ja.a.f6713k;
        if (z10) {
            iArr[0] = 0;
            iArr[1] = aVar.f;
            iArr[2] = aVar.f6719e;
            iArr[3] = aVar.f6718d;
            f = 0.0f;
        } else {
            path.rewind();
            f = 0.0f;
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f10, f11);
            path.close();
            float f12 = -i;
            rectF.inset(f12, f12);
            iArr[0] = 0;
            iArr[1] = aVar.f6718d;
            iArr[2] = aVar.f6719e;
            iArr[3] = aVar.f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= f) {
            return;
        }
        float f13 = 1.0f - (i / fWidth);
        float[] fArr = ja.a.f6714l;
        fArr[1] = f13;
        fArr[2] = ((1.0f - f13) / 2.0f) + f13;
        paint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z10) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, aVar.f6721h);
        }
        canvas.drawArc(rectF, f10, f11, true, paint);
        canvas.restore();
    }
}
