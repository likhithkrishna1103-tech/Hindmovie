package i4;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s0 {
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f6292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f6293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f6294e;
    public final TextPaint f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f6295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f6296h;
    public CharSequence i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Layout.Alignment f6297j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f6298k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6299l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6300m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6301n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6302o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6303p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f6304q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f6305r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6306s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6307t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6308u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6309v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6310w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f6311x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f6312y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f6313z;

    public s0(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f6294e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f6293d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f6290a = fRound;
        this.f6291b = fRound;
        this.f6292c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f6295g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f6296h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public final void a(Canvas canvas, boolean z2) {
        Canvas canvas2;
        if (!z2) {
            this.J.getClass();
            this.f6298k.getClass();
            canvas.drawBitmap(this.f6298k, (Rect) null, this.J, this.f6296h);
            return;
        }
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f6308u) > 0) {
            int i = this.f6308u;
            Paint paint = this.f6295g;
            paint.setColor(i);
            canvas2 = canvas;
            canvas2.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), paint);
        } else {
            canvas2 = canvas;
        }
        int i10 = this.f6310w;
        TextPaint textPaint = this.f;
        if (i10 == 1) {
            textPaint.setStrokeJoin(Paint.Join.ROUND);
            textPaint.setStrokeWidth(this.f6290a);
            textPaint.setColor(this.f6309v);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas2);
        } else {
            float f = this.f6291b;
            if (i10 == 2) {
                float f4 = this.f6292c;
                textPaint.setShadowLayer(f, f4, f4, this.f6309v);
            } else if (i10 == 3 || i10 == 4) {
                boolean z10 = i10 == 3;
                int i11 = z10 ? -1 : this.f6309v;
                int i12 = z10 ? this.f6309v : -1;
                float f10 = f / 2.0f;
                textPaint.setColor(this.f6306s);
                textPaint.setStyle(Paint.Style.FILL);
                float f11 = -f10;
                textPaint.setShadowLayer(f, f11, f11, i11);
                staticLayout2.draw(canvas2);
                textPaint.setShadowLayer(f, f10, f10, i12);
            }
        }
        textPaint.setColor(this.f6306s);
        textPaint.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas2);
        textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas2.restoreToCount(iSave);
    }
}
