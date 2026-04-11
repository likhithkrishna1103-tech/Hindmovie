package h5;

import aa.l0;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Matrix f5917p = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f5918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f5919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f5920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f5921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f5922e;
    public PathMeasure f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f5923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f5924h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f5925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f5926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f5928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f5929n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final s.e f5930o;

    public o() {
        this.f5920c = new Matrix();
        this.f5924h = 0.0f;
        this.i = 0.0f;
        this.f5925j = 0.0f;
        this.f5926k = 0.0f;
        this.f5927l = 255;
        this.f5928m = null;
        this.f5929n = null;
        this.f5930o = new s.e(0);
        this.f5923g = new l();
        this.f5918a = new Path();
        this.f5919b = new Path();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(l lVar, Matrix matrix, Canvas canvas, int i, int i10) {
        int i11;
        float f;
        int i12;
        float f4;
        Matrix matrix2 = lVar.f5905a;
        ArrayList arrayList = lVar.f5906b;
        matrix2.set(matrix);
        Matrix matrix3 = lVar.f5905a;
        matrix3.preConcat(lVar.f5912j);
        canvas.save();
        char c9 = 0;
        int i13 = 0;
        while (i13 < arrayList.size()) {
            m mVar = (m) arrayList.get(i13);
            if (mVar instanceof l) {
                a((l) mVar, matrix3, canvas, i, i10);
            } else if (mVar instanceof n) {
                n nVar = (n) mVar;
                float f10 = i / this.f5925j;
                float f11 = i10 / this.f5926k;
                float fMin = Math.min(f10, f11);
                Matrix matrix4 = this.f5920c;
                matrix4.set(matrix3);
                matrix4.postScale(f10, f11);
                float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                matrix3.mapVectors(fArr);
                float fHypot = (float) Math.hypot(fArr[c9], fArr[1]);
                boolean z2 = c9;
                i11 = i13;
                float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                float f12 = (fArr[z2 ? 1 : 0] * fArr[3]) - (fArr[1] * fArr[2]);
                float fMax = Math.max(fHypot, fHypot2);
                float fAbs = fMax > 0.0f ? Math.abs(f12) / fMax : 0.0f;
                if (fAbs != 0.0f) {
                    Path path = this.f5918a;
                    path.reset();
                    i0.f[] fVarArr = nVar.f5914a;
                    if (fVarArr != null) {
                        i0.f.b(fVarArr, path);
                    }
                    Path path2 = this.f5919b;
                    path2.reset();
                    if (nVar instanceof j) {
                        path2.setFillType(nVar.f5916c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                        path2.addPath(path, matrix4);
                        canvas.clipPath(path2);
                    } else {
                        k kVar = (k) nVar;
                        float f13 = kVar.i;
                        if (f13 != 0.0f || kVar.f5900j != 1.0f) {
                            float f14 = kVar.f5901k;
                            float f15 = (f13 + f14) % 1.0f;
                            float f16 = (kVar.f5900j + f14) % 1.0f;
                            if (this.f == null) {
                                this.f = new PathMeasure();
                            }
                            this.f.setPath(path, z2);
                            float length = this.f.getLength();
                            float f17 = f15 * length;
                            float f18 = f16 * length;
                            path.reset();
                            if (f17 > f18) {
                                this.f.getSegment(f17, length, path, true);
                                f = 0.0f;
                                this.f.getSegment(0.0f, f18, path, true);
                            } else {
                                f = 0.0f;
                                this.f.getSegment(f17, f18, path, true);
                            }
                            path.rLineTo(f, f);
                        }
                        path2.addPath(path, matrix4);
                        l0 l0Var = kVar.f;
                        if (((Shader) l0Var.f706w) == null && l0Var.f705v == 0) {
                            f4 = 255.0f;
                            i12 = 16777215;
                        } else {
                            if (this.f5922e == null) {
                                i12 = 16777215;
                                Paint paint = new Paint(1);
                                this.f5922e = paint;
                                paint.setStyle(Paint.Style.FILL);
                            } else {
                                i12 = 16777215;
                            }
                            Paint paint2 = this.f5922e;
                            Shader shader = (Shader) l0Var.f706w;
                            if (shader != null) {
                                shader.setLocalMatrix(matrix4);
                                paint2.setShader(shader);
                                paint2.setAlpha(Math.round(kVar.f5899h * 255.0f));
                                f4 = 255.0f;
                            } else {
                                paint2.setShader(null);
                                paint2.setAlpha(255);
                                int i14 = l0Var.f705v;
                                float f19 = kVar.f5899h;
                                PorterDuff.Mode mode = r.D;
                                f4 = 255.0f;
                                paint2.setColor((i14 & i12) | (((int) (Color.alpha(i14) * f19)) << 24));
                            }
                            paint2.setColorFilter(null);
                            path2.setFillType(kVar.f5916c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            canvas.drawPath(path2, paint2);
                        }
                        l0 l0Var2 = kVar.f5896d;
                        if (((Shader) l0Var2.f706w) != null || l0Var2.f705v != 0) {
                            if (this.f5921d == null) {
                                Paint paint3 = new Paint(1);
                                this.f5921d = paint3;
                                paint3.setStyle(Paint.Style.STROKE);
                            }
                            Paint paint4 = this.f5921d;
                            Paint.Join join = kVar.f5903m;
                            if (join != null) {
                                paint4.setStrokeJoin(join);
                            }
                            Paint.Cap cap = kVar.f5902l;
                            if (cap != null) {
                                paint4.setStrokeCap(cap);
                            }
                            paint4.setStrokeMiter(kVar.f5904n);
                            Shader shader2 = (Shader) l0Var2.f706w;
                            if (shader2 != null) {
                                shader2.setLocalMatrix(matrix4);
                                paint4.setShader(shader2);
                                paint4.setAlpha(Math.round(kVar.f5898g * f4));
                            } else {
                                paint4.setShader(null);
                                paint4.setAlpha(255);
                                int i15 = l0Var2.f705v;
                                float f20 = kVar.f5898g;
                                PorterDuff.Mode mode2 = r.D;
                                paint4.setColor((i15 & i12) | (((int) (Color.alpha(i15) * f20)) << 24));
                            }
                            paint4.setColorFilter(null);
                            paint4.setStrokeWidth(kVar.f5897e * fMin * fAbs);
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
        return this.f5927l;
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (f * 255.0f));
    }

    public void setRootAlpha(int i) {
        this.f5927l = i;
    }

    public o(o oVar) {
        this.f5920c = new Matrix();
        this.f5924h = 0.0f;
        this.i = 0.0f;
        this.f5925j = 0.0f;
        this.f5926k = 0.0f;
        this.f5927l = 255;
        this.f5928m = null;
        this.f5929n = null;
        s.e eVar = new s.e(0);
        this.f5930o = eVar;
        this.f5923g = new l(oVar.f5923g, eVar);
        this.f5918a = new Path(oVar.f5918a);
        this.f5919b = new Path(oVar.f5919b);
        this.f5924h = oVar.f5924h;
        this.i = oVar.i;
        this.f5925j = oVar.f5925j;
        this.f5926k = oVar.f5926k;
        this.f5927l = oVar.f5927l;
        this.f5928m = oVar.f5928m;
        String str = oVar.f5928m;
        if (str != null) {
            eVar.put(str, this);
        }
        this.f5929n = oVar.f5929n;
    }
}
