package q9;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f11137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f11138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f11139e;

    public o(q qVar, float f, float f4) {
        this.f11137c = qVar;
        this.f11138d = f;
        this.f11139e = f4;
    }

    @Override // q9.s
    public final void a(Matrix matrix, p9.a aVar, int i, Canvas canvas) {
        q qVar = this.f11137c;
        float f = qVar.f11147c;
        float f4 = this.f11139e;
        float f10 = qVar.f11146b;
        float f11 = this.f11138d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f - f4, f10 - f11), 0.0f);
        Matrix matrix2 = this.f11150a;
        matrix2.set(matrix);
        matrix2.preTranslate(f11, f4);
        matrix2.preRotate(b());
        aVar.getClass();
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int i10 = aVar.f;
        int[] iArr = p9.a.i;
        iArr[0] = i10;
        iArr[1] = aVar.f10294e;
        iArr[2] = aVar.f10293d;
        Paint paint = aVar.f10292c;
        float f12 = rectF.left;
        paint.setShader(new LinearGradient(f12, rectF.top, f12, rectF.bottom, iArr, p9.a.f10287j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        q qVar = this.f11137c;
        return (float) Math.toDegrees(Math.atan((qVar.f11147c - this.f11139e) / (qVar.f11146b - this.f11138d)));
    }
}
