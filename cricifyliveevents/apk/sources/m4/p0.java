package m4;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {
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
    public final float f8204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f8205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f8206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f8207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f8208e;
    public final TextPaint f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f8209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f8210h;
    public CharSequence i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Layout.Alignment f8211j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f8212k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f8213l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8214m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8215n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f8216o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8217p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f8218q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f8219r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f8220s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f8221t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f8222u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8223v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8224w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f8225x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f8226y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f8227z;

    public p0(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f8208e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f8207d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f8204a = fRound;
        this.f8205b = fRound;
        this.f8206c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f8209g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f8210h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public final void a(Canvas canvas, boolean z10) {
        Canvas canvas2;
        if (!z10) {
            this.J.getClass();
            this.f8212k.getClass();
            canvas.drawBitmap(this.f8212k, (Rect) null, this.J, this.f8210h);
            return;
        }
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f8222u) > 0) {
            int i = this.f8222u;
            Paint paint = this.f8209g;
            paint.setColor(i);
            canvas2 = canvas;
            canvas2.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), paint);
        } else {
            canvas2 = canvas;
        }
        int i10 = this.f8224w;
        TextPaint textPaint = this.f;
        if (i10 == 1) {
            textPaint.setStrokeJoin(Paint.Join.ROUND);
            textPaint.setStrokeWidth(this.f8204a);
            textPaint.setColor(this.f8223v);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas2);
        } else {
            float f = this.f8205b;
            if (i10 == 2) {
                float f10 = this.f8206c;
                textPaint.setShadowLayer(f, f10, f10, this.f8223v);
            } else if (i10 == 3 || i10 == 4) {
                boolean z11 = i10 == 3;
                int i11 = z11 ? -1 : this.f8223v;
                int i12 = z11 ? this.f8223v : -1;
                float f11 = f / 2.0f;
                textPaint.setColor(this.f8220s);
                textPaint.setStyle(Paint.Style.FILL);
                float f12 = -f11;
                textPaint.setShadowLayer(f, f12, f12, i11);
                staticLayout2.draw(canvas2);
                textPaint.setShadowLayer(f, f11, f11, i12);
            }
        }
        textPaint.setColor(this.f8220s);
        textPaint.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas2);
        textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas2.restoreToCount(iSave);
    }
}
