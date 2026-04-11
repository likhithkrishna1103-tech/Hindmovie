package s6;

import ag.o;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.os.Build;
import o.k1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final Matrix B = new Matrix();
    public a A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Canvas f11559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f11560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f11562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f11563e;
    public Rect f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f11564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f11565h;
    public Rect i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f11566j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h6.a f11567k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bitmap f11568l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Canvas f11569m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Rect f11570n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public h6.a f11571o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Matrix f11572p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float[] f11573q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Bitmap f11574r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Bitmap f11575s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Canvas f11576t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Canvas f11577u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public h6.a f11578v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public BlurMaskFilter f11579w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f11580x = 0.0f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RenderNode f11581y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public RenderNode f11582z;

    public static Bitmap a(RectF rectF, Bitmap.Config config) {
        return Bitmap.createBitmap(Math.max((int) Math.ceil(((double) rectF.width()) * 1.05d), 1), Math.max((int) Math.ceil(((double) rectF.height()) * 1.05d), 1), config);
    }

    public static boolean d(Bitmap bitmap, RectF rectF) {
        return bitmap == null || rectF.width() >= ((float) bitmap.getWidth()) || rectF.height() >= ((float) bitmap.getHeight()) || rectF.width() < ((float) bitmap.getWidth()) * 0.75f || rectF.height() < ((float) bitmap.getHeight()) * 0.75f;
    }

    public final RectF b(RectF rectF, a aVar) {
        if (this.f11563e == null) {
            this.f11563e = new RectF();
        }
        if (this.f11564g == null) {
            this.f11564g = new RectF();
        }
        this.f11563e.set(rectF);
        this.f11563e.offsetTo(rectF.left + aVar.f11542b, rectF.top + aVar.f11543c);
        RectF rectF2 = this.f11563e;
        float f = aVar.f11541a;
        rectF2.inset(-f, -f);
        this.f11564g.set(rectF);
        this.f11563e.union(this.f11564g);
        return this.f11563e;
    }

    public final void c() {
        float f;
        h6.a aVar;
        if (this.f11559a == null || this.f11560b == null || this.f11573q == null || this.f11562d == null) {
            throw new IllegalStateException("OffscreenBitmap: finish() call without matching start()");
        }
        int iC = y.e.c(this.f11561c);
        if (iC == 0 || iC == 1) {
            this.f11559a.restore();
        } else {
            if (iC != 2) {
                if (iC == 3) {
                    if (this.f11581y == null) {
                        throw new IllegalStateException("RenderNode is not ready; should've been initialized at start() time");
                    }
                    int i = Build.VERSION.SDK_INT;
                    if (i < 29) {
                        throw new IllegalStateException("RenderNode not supported but we chose it as render strategy");
                    }
                    this.f11559a.save();
                    Canvas canvas = this.f11559a;
                    float[] fArr = this.f11573q;
                    canvas.scale(1.0f / fArr[0], 1.0f / fArr[4]);
                    this.f11581y.endRecording();
                    if (this.f11560b.h()) {
                        Canvas canvas2 = this.f11559a;
                        a aVar2 = (a) this.f11560b.f455x;
                        if (this.f11581y == null || this.f11582z == null) {
                            throw new IllegalStateException("Cannot render to render node outside a start()/finish() block");
                        }
                        if (i < 31) {
                            throw new RuntimeException("RenderEffect is not supported on API level <31");
                        }
                        float[] fArr2 = this.f11573q;
                        float f10 = fArr2 != null ? fArr2[0] : 1.0f;
                        f = fArr2 != null ? fArr2[4] : 1.0f;
                        a aVar3 = this.A;
                        if (aVar3 == null || aVar2.f11541a != aVar3.f11541a || aVar2.f11542b != aVar3.f11542b || aVar2.f11543c != aVar3.f11543c || aVar2.f11544d != aVar3.f11544d) {
                            RenderEffect renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new PorterDuffColorFilter(aVar2.f11544d, PorterDuff.Mode.SRC_IN));
                            float f11 = aVar2.f11541a;
                            if (f11 > 0.0f) {
                                float f12 = ((f10 + f) * f11) / 2.0f;
                                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                                renderEffectCreateColorFilterEffect = RenderEffect.createBlurEffect(f12, f12, renderEffectCreateColorFilterEffect, Shader.TileMode.CLAMP);
                            }
                            this.f11582z.setRenderEffect(renderEffectCreateColorFilterEffect);
                            this.A = aVar2;
                        }
                        RectF rectFB = b(this.f11562d, aVar2);
                        RectF rectF = new RectF(rectFB.left * f10, rectFB.top * f, rectFB.right * f10, rectFB.bottom * f);
                        this.f11582z.setPosition(0, 0, (int) rectF.width(), (int) rectF.height());
                        RecordingCanvas recordingCanvasBeginRecording = this.f11582z.beginRecording((int) rectF.width(), (int) rectF.height());
                        recordingCanvasBeginRecording.translate((aVar2.f11542b * f10) + (-rectF.left), (aVar2.f11543c * f) + (-rectF.top));
                        recordingCanvasBeginRecording.drawRenderNode(this.f11581y);
                        this.f11582z.endRecording();
                        canvas2.save();
                        canvas2.translate(rectF.left, rectF.top);
                        canvas2.drawRenderNode(this.f11582z);
                        canvas2.restore();
                    }
                    this.f11559a.drawRenderNode(this.f11581y);
                    this.f11559a.restore();
                }
            } else {
                if (this.f11568l == null) {
                    throw new IllegalStateException("Bitmap is not ready; should've been initialized at start() time");
                }
                if (this.f11560b.h()) {
                    Canvas canvas3 = this.f11559a;
                    a aVar4 = (a) this.f11560b.f455x;
                    RectF rectF2 = this.f11562d;
                    if (rectF2 == null || this.f11568l == null) {
                        throw new IllegalStateException("Cannot render to bitmap outside a start()/finish() block");
                    }
                    RectF rectFB2 = b(rectF2, aVar4);
                    if (this.f == null) {
                        this.f = new Rect();
                    }
                    this.f.set((int) Math.floor(rectFB2.left), (int) Math.floor(rectFB2.top), (int) Math.ceil(rectFB2.right), (int) Math.ceil(rectFB2.bottom));
                    float[] fArr3 = this.f11573q;
                    float f13 = fArr3 != null ? fArr3[0] : 1.0f;
                    f = fArr3 != null ? fArr3[4] : 1.0f;
                    if (this.f11565h == null) {
                        this.f11565h = new RectF();
                    }
                    this.f11565h.set(rectFB2.left * f13, rectFB2.top * f, rectFB2.right * f13, rectFB2.bottom * f);
                    if (this.i == null) {
                        this.i = new Rect();
                    }
                    this.i.set(0, 0, Math.round(this.f11565h.width()), Math.round(this.f11565h.height()));
                    if (d(this.f11574r, this.f11565h)) {
                        Bitmap bitmap = this.f11574r;
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        Bitmap bitmap2 = this.f11575s;
                        if (bitmap2 != null) {
                            bitmap2.recycle();
                        }
                        this.f11574r = a(this.f11565h, Bitmap.Config.ARGB_8888);
                        this.f11575s = a(this.f11565h, Bitmap.Config.ALPHA_8);
                        this.f11576t = new Canvas(this.f11574r);
                        this.f11577u = new Canvas(this.f11575s);
                    } else {
                        Canvas canvas4 = this.f11576t;
                        if (canvas4 == null || this.f11577u == null || (aVar = this.f11571o) == null) {
                            throw new IllegalStateException("If needNewBitmap() returns true, we should have a canvas and bitmap ready");
                        }
                        canvas4.drawRect(this.i, aVar);
                        this.f11577u.drawRect(this.i, this.f11571o);
                    }
                    if (this.f11575s == null) {
                        throw new IllegalStateException("Expected to have allocated a shadow mask bitmap");
                    }
                    if (this.f11578v == null) {
                        this.f11578v = new h6.a(1, 0);
                    }
                    RectF rectF3 = this.f11562d;
                    this.f11577u.drawBitmap(this.f11568l, Math.round((rectF3.left - rectFB2.left) * f13), Math.round((rectF3.top - rectFB2.top) * f), (Paint) null);
                    if (this.f11579w == null || this.f11580x != aVar4.f11541a) {
                        float f14 = ((f13 + f) * aVar4.f11541a) / 2.0f;
                        if (f14 > 0.0f) {
                            this.f11579w = new BlurMaskFilter(f14, BlurMaskFilter.Blur.NORMAL);
                        } else {
                            this.f11579w = null;
                        }
                        this.f11580x = aVar4.f11541a;
                    }
                    this.f11578v.setColor(aVar4.f11544d);
                    if (aVar4.f11541a > 0.0f) {
                        this.f11578v.setMaskFilter(this.f11579w);
                    } else {
                        this.f11578v.setMaskFilter(null);
                    }
                    this.f11578v.setFilterBitmap(true);
                    this.f11576t.drawBitmap(this.f11575s, Math.round(aVar4.f11542b * f13), Math.round(aVar4.f11543c * f), this.f11578v);
                    canvas3.drawBitmap(this.f11574r, this.i, this.f, this.f11567k);
                }
                if (this.f11570n == null) {
                    this.f11570n = new Rect();
                }
                this.f11570n.set(0, 0, (int) (this.f11562d.width() * this.f11573q[0]), (int) (this.f11562d.height() * this.f11573q[4]));
                this.f11559a.drawBitmap(this.f11568l, this.f11570n, this.f11562d, this.f11567k);
            }
        }
        this.f11559a = null;
    }

    public final Canvas e(Canvas canvas, RectF rectF, o oVar) {
        if (this.f11559a != null) {
            throw new IllegalStateException("Cannot nest start() calls on a single OffscreenBitmap - call finish() first");
        }
        if (this.f11573q == null) {
            this.f11573q = new float[9];
        }
        if (this.f11572p == null) {
            this.f11572p = new Matrix();
        }
        canvas.getMatrix(this.f11572p);
        this.f11572p.getValues(this.f11573q);
        float[] fArr = this.f11573q;
        float f = fArr[0];
        int i = 4;
        float f10 = fArr[4];
        if (this.f11566j == null) {
            this.f11566j = new RectF();
        }
        this.f11566j.set(rectF.left * f, rectF.top * f10, rectF.right * f, rectF.bottom * f10);
        this.f11559a = canvas;
        this.f11560b = oVar;
        if (oVar.f454w >= 255 && !oVar.h()) {
            i = 1;
        } else if (oVar.h()) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 29 || !canvas.isHardwareAccelerated() || i10 <= 31) {
                i = 3;
            }
        } else {
            i = 2;
        }
        this.f11561c = i;
        if (this.f11562d == null) {
            this.f11562d = new RectF();
        }
        this.f11562d.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        if (this.f11567k == null) {
            this.f11567k = new h6.a();
        }
        this.f11567k.reset();
        int iC = y.e.c(this.f11561c);
        if (iC == 0) {
            canvas.save();
            return canvas;
        }
        if (iC == 1) {
            this.f11567k.setAlpha(oVar.f454w);
            this.f11567k.setColorFilter(null);
            h6.a aVar = this.f11567k;
            Matrix matrix = i.f11583a;
            canvas.saveLayer(rectF, aVar);
            return canvas;
        }
        Matrix matrix2 = B;
        if (iC == 2) {
            if (this.f11571o == null) {
                h6.a aVar2 = new h6.a();
                this.f11571o = aVar2;
                aVar2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            if (d(this.f11568l, this.f11566j)) {
                Bitmap bitmap = this.f11568l;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                this.f11568l = a(this.f11566j, Bitmap.Config.ARGB_8888);
                this.f11569m = new Canvas(this.f11568l);
            } else {
                Canvas canvas2 = this.f11569m;
                if (canvas2 == null) {
                    throw new IllegalStateException("If needNewBitmap() returns true, we should have a canvas ready");
                }
                canvas2.setMatrix(matrix2);
                this.f11569m.drawRect(-1.0f, -1.0f, this.f11566j.width() + 1.0f, this.f11566j.height() + 1.0f, this.f11571o);
            }
            l0.d.a(0, this.f11567k);
            this.f11567k.setColorFilter(null);
            this.f11567k.setAlpha(oVar.f454w);
            Canvas canvas3 = this.f11569m;
            canvas3.scale(f, f10);
            canvas3.translate(-rectF.left, -rectF.top);
            return canvas3;
        }
        if (iC != 3) {
            throw new RuntimeException("Invalid render strategy for OffscreenLayer");
        }
        if (Build.VERSION.SDK_INT < 29) {
            throw new IllegalStateException("RenderNode not supported but we chose it as render strategy");
        }
        if (this.f11581y == null) {
            this.f11581y = k1.c();
        }
        if (oVar.h() && this.f11582z == null) {
            this.f11582z = k1.u();
            this.A = null;
        }
        this.f11581y.setAlpha(oVar.f454w / 255.0f);
        if (oVar.h()) {
            RenderNode renderNode = this.f11582z;
            if (renderNode == null) {
                throw new IllegalStateException("Must initialize shadowRenderNode when we have shadow");
            }
            renderNode.setAlpha(oVar.f454w / 255.0f);
        }
        this.f11581y.setHasOverlappingRendering(true);
        RenderNode renderNode2 = this.f11581y;
        RectF rectF2 = this.f11566j;
        renderNode2.setPosition((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
        RecordingCanvas recordingCanvasBeginRecording = this.f11581y.beginRecording((int) this.f11566j.width(), (int) this.f11566j.height());
        recordingCanvasBeginRecording.setMatrix(matrix2);
        recordingCanvasBeginRecording.scale(f, f10);
        recordingCanvasBeginRecording.translate(-rectF.left, -rectF.top);
        return recordingCanvasBeginRecording;
    }
}
