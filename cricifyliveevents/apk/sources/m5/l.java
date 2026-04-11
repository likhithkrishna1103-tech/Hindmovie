package m5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Matrix f8343p = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f8344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f8345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f8346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f8347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f8348e;
    public PathMeasure f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f8349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f8350h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f8351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f8352k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8353l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f8354m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f8355n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final v.e f8356o;

    public l() {
        this.f8346c = new Matrix();
        this.f8350h = 0.0f;
        this.i = 0.0f;
        this.f8351j = 0.0f;
        this.f8352k = 0.0f;
        this.f8353l = 255;
        this.f8354m = null;
        this.f8355n = null;
        this.f8356o = new v.e(0);
        this.f8349g = new i();
        this.f8344a = new Path();
        this.f8345b = new Path();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(i iVar, Matrix matrix, Canvas canvas, int i, int i10) {
        int i11;
        float f;
        int i12;
        float f10;
        Matrix matrix2 = iVar.f8331a;
        ArrayList arrayList = iVar.f8332b;
        matrix2.set(matrix);
        Matrix matrix3 = iVar.f8331a;
        matrix3.preConcat(iVar.f8338j);
        canvas.save();
        char c9 = 0;
        int i13 = 0;
        while (i13 < arrayList.size()) {
            j jVar = (j) arrayList.get(i13);
            if (jVar instanceof i) {
                a((i) jVar, matrix3, canvas, i, i10);
            } else if (jVar instanceof k) {
                k kVar = (k) jVar;
                float f11 = i / this.f8351j;
                float f12 = i10 / this.f8352k;
                float fMin = Math.min(f11, f12);
                Matrix matrix4 = this.f8346c;
                matrix4.set(matrix3);
                matrix4.postScale(f11, f12);
                float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                matrix3.mapVectors(fArr);
                float fHypot = (float) Math.hypot(fArr[c9], fArr[1]);
                boolean z10 = c9;
                i11 = i13;
                float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                float f13 = (fArr[z10 ? 1 : 0] * fArr[3]) - (fArr[1] * fArr[2]);
                float fMax = Math.max(fHypot, fHypot2);
                float fAbs = fMax > 0.0f ? Math.abs(f13) / fMax : 0.0f;
                if (fAbs != 0.0f) {
                    Path path = this.f8344a;
                    path.reset();
                    l0.f[] fVarArr = kVar.f8340a;
                    if (fVarArr != null) {
                        l0.f.b(fVarArr, path);
                    }
                    Path path2 = this.f8345b;
                    path2.reset();
                    if (kVar instanceof g) {
                        path2.setFillType(kVar.f8342c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                        path2.addPath(path, matrix4);
                        canvas.clipPath(path2);
                    } else {
                        h hVar = (h) kVar;
                        float f14 = hVar.i;
                        if (f14 != 0.0f || hVar.f8326j != 1.0f) {
                            float f15 = hVar.f8327k;
                            float f16 = (f14 + f15) % 1.0f;
                            float f17 = (hVar.f8326j + f15) % 1.0f;
                            if (this.f == null) {
                                this.f = new PathMeasure();
                            }
                            this.f.setPath(path, z10);
                            float length = this.f.getLength();
                            float f18 = f16 * length;
                            float f19 = f17 * length;
                            path.reset();
                            if (f18 > f19) {
                                this.f.getSegment(f18, length, path, true);
                                f = 0.0f;
                                this.f.getSegment(0.0f, f19, path, true);
                            } else {
                                f = 0.0f;
                                this.f.getSegment(f18, f19, path, true);
                            }
                            path.rLineTo(f, f);
                        }
                        path2.addPath(path, matrix4);
                        f3.a aVar = hVar.f;
                        if (((Shader) aVar.f3936x) == null && aVar.f3935w == 0) {
                            f10 = 255.0f;
                            i12 = 16777215;
                        } else {
                            if (this.f8348e == null) {
                                i12 = 16777215;
                                Paint paint = new Paint(1);
                                this.f8348e = paint;
                                paint.setStyle(Paint.Style.FILL);
                            } else {
                                i12 = 16777215;
                            }
                            Paint paint2 = this.f8348e;
                            Shader shader = (Shader) aVar.f3936x;
                            if (shader != null) {
                                shader.setLocalMatrix(matrix4);
                                paint2.setShader(shader);
                                paint2.setAlpha(Math.round(hVar.f8325h * 255.0f));
                                f10 = 255.0f;
                            } else {
                                paint2.setShader(null);
                                paint2.setAlpha(255);
                                int i14 = aVar.f3935w;
                                float f20 = hVar.f8325h;
                                PorterDuff.Mode mode = o.E;
                                f10 = 255.0f;
                                paint2.setColor((i14 & i12) | (((int) (Color.alpha(i14) * f20)) << 24));
                            }
                            paint2.setColorFilter(null);
                            path2.setFillType(hVar.f8342c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            canvas.drawPath(path2, paint2);
                        }
                        f3.a aVar2 = hVar.f8322d;
                        if (((Shader) aVar2.f3936x) != null || aVar2.f3935w != 0) {
                            if (this.f8347d == null) {
                                Paint paint3 = new Paint(1);
                                this.f8347d = paint3;
                                paint3.setStyle(Paint.Style.STROKE);
                            }
                            Paint paint4 = this.f8347d;
                            Paint.Join join = hVar.f8329m;
                            if (join != null) {
                                paint4.setStrokeJoin(join);
                            }
                            Paint.Cap cap = hVar.f8328l;
                            if (cap != null) {
                                paint4.setStrokeCap(cap);
                            }
                            paint4.setStrokeMiter(hVar.f8330n);
                            Shader shader2 = (Shader) aVar2.f3936x;
                            if (shader2 != null) {
                                shader2.setLocalMatrix(matrix4);
                                paint4.setShader(shader2);
                                paint4.setAlpha(Math.round(hVar.f8324g * f10));
                            } else {
                                paint4.setShader(null);
                                paint4.setAlpha(255);
                                int i15 = aVar2.f3935w;
                                float f21 = hVar.f8324g;
                                PorterDuff.Mode mode2 = o.E;
                                paint4.setColor((i15 & i12) | (((int) (Color.alpha(i15) * f21)) << 24));
                            }
                            paint4.setColorFilter(null);
                            paint4.setStrokeWidth(hVar.f8323e * fMin * fAbs);
                            canvas.drawPath(path2, paint4);
                        }
                    }
                }
                i13 = i11 + 1;
                c9 = 0;
            }
            i11 = i13;
            i13 = i11 + 1;
            c9 = 0;
        }
        canvas.restore();
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f8353l;
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (f * 255.0f));
    }

    public void setRootAlpha(int i) {
        this.f8353l = i;
    }

    public l(l lVar) {
        this.f8346c = new Matrix();
        this.f8350h = 0.0f;
        this.i = 0.0f;
        this.f8351j = 0.0f;
        this.f8352k = 0.0f;
        this.f8353l = 255;
        this.f8354m = null;
        this.f8355n = null;
        v.e eVar = new v.e(0);
        this.f8356o = eVar;
        this.f8349g = new i(lVar.f8349g, eVar);
        this.f8344a = new Path(lVar.f8344a);
        this.f8345b = new Path(lVar.f8345b);
        this.f8350h = lVar.f8350h;
        this.i = lVar.i;
        this.f8351j = lVar.f8351j;
        this.f8352k = lVar.f8352k;
        this.f8353l = lVar.f8353l;
        this.f8354m = lVar.f8354m;
        String str = lVar.f8354m;
        if (str != null) {
            eVar.put(str, this);
        }
        this.f8355n = lVar.f8355n;
    }
}
