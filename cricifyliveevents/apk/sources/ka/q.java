package ka;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f7364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f7365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f7366e;

    public q(s sVar, float f, float f10) {
        this.f7364c = sVar;
        this.f7365d = f;
        this.f7366e = f10;
    }

    @Override // ka.u
    public final void a(Matrix matrix, ja.a aVar, int i, Canvas canvas) {
        s sVar = this.f7364c;
        float f = sVar.f7374c;
        float f10 = this.f7366e;
        float f11 = sVar.f7373b;
        float f12 = this.f7365d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f - f10, f11 - f12), 0.0f);
        Matrix matrix2 = this.f7377a;
        matrix2.set(matrix);
        matrix2.preTranslate(f12, f10);
        matrix2.preRotate(b());
        aVar.getClass();
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int i10 = aVar.f;
        int[] iArr = ja.a.i;
        iArr[0] = i10;
        iArr[1] = aVar.f6719e;
        iArr[2] = aVar.f6718d;
        Paint paint = aVar.f6717c;
        float f13 = rectF.left;
        paint.setShader(new LinearGradient(f13, rectF.top, f13, rectF.bottom, iArr, ja.a.f6712j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        s sVar = this.f7364c;
        return (float) Math.toDegrees(Math.atan((sVar.f7374c - this.f7366e) / (sVar.f7373b - this.f7365d)));
    }
}
