package h5;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r extends i {
    public static final PorterDuff.Mode D = PorterDuff.Mode.SRC_IN;
    public final float[] A;
    public final Matrix B;
    public final Rect C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public p f5942v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public PorterDuffColorFilter f5943w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ColorFilter f5944x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f5945y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f5946z;

    public r() {
        this.f5946z = true;
        this.A = new float[9];
        this.B = new Matrix();
        this.C = new Rect();
        p pVar = new p();
        pVar.f5933c = null;
        pVar.f5934d = D;
        pVar.f5932b = new o();
        this.f5942v = pVar;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f5895u;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.C;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f5944x;
        if (colorFilter == null) {
            colorFilter = this.f5943w;
        }
        Matrix matrix = this.B;
        canvas.getMatrix(matrix);
        float[] fArr = this.A;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && getLayoutDirection() == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        p pVar = this.f5942v;
        Bitmap bitmap = pVar.f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != pVar.f.getHeight()) {
            pVar.f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            pVar.f5939k = true;
        }
        if (this.f5946z) {
            p pVar2 = this.f5942v;
            if (pVar2.f5939k || pVar2.f5936g != pVar2.f5933c || pVar2.f5937h != pVar2.f5934d || pVar2.f5938j != pVar2.f5935e || pVar2.i != pVar2.f5932b.getRootAlpha()) {
                p pVar3 = this.f5942v;
                pVar3.f.eraseColor(0);
                Canvas canvas2 = new Canvas(pVar3.f);
                o oVar = pVar3.f5932b;
                oVar.a(oVar.f5923g, o.f5917p, canvas2, iMin, iMin2);
                p pVar4 = this.f5942v;
                pVar4.f5936g = pVar4.f5933c;
                pVar4.f5937h = pVar4.f5934d;
                pVar4.i = pVar4.f5932b.getRootAlpha();
                pVar4.f5938j = pVar4.f5935e;
                pVar4.f5939k = false;
            }
        } else {
            p pVar5 = this.f5942v;
            pVar5.f.eraseColor(0);
            Canvas canvas3 = new Canvas(pVar5.f);
            o oVar2 = pVar5.f5932b;
            oVar2.a(oVar2.f5923g, o.f5917p, canvas3, iMin, iMin2);
        }
        p pVar6 = this.f5942v;
        if (pVar6.f5932b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (pVar6.f5940l == null) {
                Paint paint2 = new Paint();
                pVar6.f5940l = paint2;
                paint2.setFilterBitmap(true);
            }
            pVar6.f5940l.setAlpha(pVar6.f5932b.getRootAlpha());
            pVar6.f5940l.setColorFilter(colorFilter);
            paint = pVar6.f5940l;
        }
        canvas.drawBitmap(pVar6.f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.getAlpha() : this.f5942v.f5932b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f5942v.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.getColorFilter() : this.f5944x;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f5895u != null && Build.VERSION.SDK_INT >= 24) {
            return new q(this.f5895u.getConstantState());
        }
        this.f5942v.f5931a = getChangingConfigurations();
        return this.f5942v;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f5942v.f5932b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f5942v.f5932b.f5924h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.isAutoMirrored() : this.f5942v.f5935e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        p pVar = this.f5942v;
        if (pVar == null) {
            return false;
        }
        o oVar = pVar.f5932b;
        if (oVar.f5929n == null) {
            oVar.f5929n = Boolean.valueOf(oVar.f5923g.a());
        }
        if (oVar.f5929n.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.f5942v.f5933c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f5945y && super.mutate() == this) {
            p pVar = this.f5942v;
            p pVar2 = new p();
            pVar2.f5933c = null;
            pVar2.f5934d = D;
            if (pVar != null) {
                pVar2.f5931a = pVar.f5931a;
                o oVar = new o(pVar.f5932b);
                pVar2.f5932b = oVar;
                if (pVar.f5932b.f5922e != null) {
                    oVar.f5922e = new Paint(pVar.f5932b.f5922e);
                }
                if (pVar.f5932b.f5921d != null) {
                    pVar2.f5932b.f5921d = new Paint(pVar.f5932b.f5921d);
                }
                pVar2.f5933c = pVar.f5933c;
                pVar2.f5934d = pVar.f5934d;
                pVar2.f5935e = pVar.f5935e;
            }
            this.f5942v = pVar2;
            this.f5945y = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z2;
        PorterDuff.Mode mode;
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        p pVar = this.f5942v;
        ColorStateList colorStateList = pVar.f5933c;
        if (colorStateList == null || (mode = pVar.f5934d) == null) {
            z2 = false;
        } else {
            this.f5943w = a(colorStateList, mode);
            invalidateSelf();
            z2 = true;
        }
        o oVar = pVar.f5932b;
        if (oVar.f5929n == null) {
            oVar.f5929n = Boolean.valueOf(oVar.f5923g.a());
        }
        if (oVar.f5929n.booleanValue()) {
            boolean zB = pVar.f5932b.f5923g.b(iArr);
            pVar.f5939k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j5) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j5);
        } else {
            super.scheduleSelf(runnable, j5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f5942v.f5932b.getRootAlpha() != i) {
            this.f5942v.f5932b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.setAutoMirrored(z2);
        } else {
            this.f5942v.f5935e = z2;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f5944x = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            com.bumptech.glide.d.P(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        p pVar = this.f5942v;
        if (pVar.f5933c != colorStateList) {
            pVar.f5933c = colorStateList;
            this.f5943w = a(colorStateList, pVar.f5934d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.setTintMode(mode);
            return;
        }
        p pVar = this.f5942v;
        if (pVar.f5934d != mode) {
            pVar.f5934d = mode;
            this.f5943w = a(pVar.f5933c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z2, boolean z10) {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.setVisible(z2, z10) : super.setVisible(z2, z10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int i;
        char c9;
        int i10;
        Paint.Cap cap;
        Paint.Join join;
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        p pVar = this.f5942v;
        pVar.f5932b = new o();
        TypedArray typedArrayG = h0.b.g(resources, theme, attributeSet, a.f5869a);
        p pVar2 = this.f5942v;
        o oVar = pVar2.f5932b;
        int i11 = !h0.b.d(xmlPullParser, "tintMode") ? -1 : typedArrayG.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (i11 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i11 != 5) {
            if (i11 != 9) {
                switch (i11) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        pVar2.f5934d = mode;
        ColorStateList colorStateListA = null;
        int i12 = 1;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
            TypedValue typedValue = new TypedValue();
            typedArrayG.getValue(1, typedValue);
            int i13 = typedValue.type;
            if (i13 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i13 >= 28 && i13 <= 31) {
                colorStateListA = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = typedArrayG.getResources();
                int resourceId = typedArrayG.getResourceId(1, 0);
                ThreadLocal threadLocal = h0.c.f5582a;
                try {
                    colorStateListA = h0.c.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e10) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e10);
                }
            }
        }
        ColorStateList colorStateList = colorStateListA;
        if (colorStateList != null) {
            pVar2.f5933c = colorStateList;
        }
        boolean z2 = pVar2.f5935e;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z2 = typedArrayG.getBoolean(5, z2);
        }
        pVar2.f5935e = z2;
        float f = oVar.f5925j;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f = typedArrayG.getFloat(7, f);
        }
        oVar.f5925j = f;
        float f4 = oVar.f5926k;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f4 = typedArrayG.getFloat(8, f4);
        }
        oVar.f5926k = f4;
        if (oVar.f5925j <= 0.0f) {
            throw new XmlPullParserException(typedArrayG.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f4 > 0.0f) {
            oVar.f5924h = typedArrayG.getDimension(3, oVar.f5924h);
            float dimension = typedArrayG.getDimension(2, oVar.i);
            oVar.i = dimension;
            if (oVar.f5924h <= 0.0f) {
                throw new XmlPullParserException(typedArrayG.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = oVar.getAlpha();
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
                    alpha = typedArrayG.getFloat(4, alpha);
                }
                oVar.setAlpha(alpha);
                String string = typedArrayG.getString(0);
                if (string != null) {
                    oVar.f5928m = string;
                    oVar.f5930o.put(string, oVar);
                }
                typedArrayG.recycle();
                pVar.f5931a = getChangingConfigurations();
                pVar.f5939k = true;
                p pVar3 = this.f5942v;
                o oVar2 = pVar3.f5932b;
                ArrayDeque arrayDeque = new ArrayDeque();
                l lVar = oVar2.f5923g;
                s.e eVar = oVar2.f5930o;
                arrayDeque.push(lVar);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z10 = true;
                while (eventType != i12 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        l lVar2 = (l) arrayDeque.peek();
                        i = depth;
                        if ("path".equals(name)) {
                            k kVar = new k();
                            kVar.f5897e = 0.0f;
                            kVar.f5898g = 1.0f;
                            kVar.f5899h = 1.0f;
                            kVar.i = 0.0f;
                            kVar.f5900j = 1.0f;
                            kVar.f5901k = 0.0f;
                            Paint.Cap cap2 = Paint.Cap.BUTT;
                            kVar.f5902l = cap2;
                            Paint.Join join2 = Paint.Join.MITER;
                            kVar.f5903m = join2;
                            kVar.f5904n = 4.0f;
                            TypedArray typedArrayG2 = h0.b.g(resources, theme, attributeSet, a.f5871c);
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                String string2 = typedArrayG2.getString(0);
                                if (string2 != null) {
                                    kVar.f5915b = string2;
                                }
                                String string3 = typedArrayG2.getString(2);
                                if (string3 != null) {
                                    kVar.f5914a = ga.b.h(string3);
                                }
                                kVar.f = h0.b.b(typedArrayG2, xmlPullParser, theme, "fillColor", 1);
                                float f10 = kVar.f5899h;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                                    f10 = typedArrayG2.getFloat(12, f10);
                                }
                                kVar.f5899h = f10;
                                int i14 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? typedArrayG2.getInt(8, -1) : -1;
                                Paint.Cap cap3 = kVar.f5902l;
                                if (i14 == 0) {
                                    cap = cap2;
                                } else if (i14 != 1) {
                                    cap = i14 != 2 ? cap3 : Paint.Cap.SQUARE;
                                } else {
                                    cap = Paint.Cap.ROUND;
                                }
                                kVar.f5902l = cap;
                                int i15 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? typedArrayG2.getInt(9, -1) : -1;
                                Paint.Join join3 = kVar.f5903m;
                                if (i15 == 0) {
                                    join = join2;
                                } else if (i15 != 1) {
                                    join = i15 != 2 ? join3 : Paint.Join.BEVEL;
                                } else {
                                    join = Paint.Join.ROUND;
                                }
                                kVar.f5903m = join;
                                float f11 = kVar.f5904n;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                                    f11 = typedArrayG2.getFloat(10, f11);
                                }
                                kVar.f5904n = f11;
                                kVar.f5896d = h0.b.b(typedArrayG2, xmlPullParser, theme, "strokeColor", 3);
                                float f12 = kVar.f5898g;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                                    f12 = typedArrayG2.getFloat(11, f12);
                                }
                                kVar.f5898g = f12;
                                float f13 = kVar.f5897e;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                                    f13 = typedArrayG2.getFloat(4, f13);
                                }
                                kVar.f5897e = f13;
                                float f14 = kVar.f5900j;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                                    f14 = typedArrayG2.getFloat(6, f14);
                                }
                                kVar.f5900j = f14;
                                float f15 = kVar.f5901k;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                                    f15 = typedArrayG2.getFloat(7, f15);
                                }
                                kVar.f5901k = f15;
                                float f16 = kVar.i;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                                    f16 = typedArrayG2.getFloat(5, f16);
                                }
                                kVar.i = f16;
                                int i16 = kVar.f5916c;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                                    i16 = typedArrayG2.getInt(13, i16);
                                }
                                kVar.f5916c = i16;
                            }
                            typedArrayG2.recycle();
                            lVar2.f5906b.add(kVar);
                            if (kVar.getPathName() != null) {
                                eVar.put(kVar.getPathName(), kVar);
                            }
                            pVar3.f5931a = pVar3.f5931a;
                            z10 = false;
                            c9 = '\b';
                        } else {
                            c9 = '\b';
                            if ("clip-path".equals(name)) {
                                j jVar = new j();
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                    TypedArray typedArrayG3 = h0.b.g(resources, theme, attributeSet, a.f5872d);
                                    String string4 = typedArrayG3.getString(0);
                                    if (string4 != null) {
                                        jVar.f5915b = string4;
                                    }
                                    String string5 = typedArrayG3.getString(1);
                                    if (string5 != null) {
                                        jVar.f5914a = ga.b.h(string5);
                                    }
                                    jVar.f5916c = !h0.b.d(xmlPullParser, "fillType") ? 0 : typedArrayG3.getInt(2, 0);
                                    typedArrayG3.recycle();
                                }
                                lVar2.f5906b.add(jVar);
                                if (jVar.getPathName() != null) {
                                    eVar.put(jVar.getPathName(), jVar);
                                }
                                pVar3.f5931a = pVar3.f5931a;
                            } else if ("group".equals(name)) {
                                l lVar3 = new l();
                                TypedArray typedArrayG4 = h0.b.g(resources, theme, attributeSet, a.f5870b);
                                float f17 = lVar3.f5907c;
                                if (h0.b.d(xmlPullParser, "rotation")) {
                                    f17 = typedArrayG4.getFloat(5, f17);
                                }
                                lVar3.f5907c = f17;
                                lVar3.f5908d = typedArrayG4.getFloat(1, lVar3.f5908d);
                                lVar3.f5909e = typedArrayG4.getFloat(2, lVar3.f5909e);
                                float f18 = lVar3.f;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                                    f18 = typedArrayG4.getFloat(3, f18);
                                }
                                lVar3.f = f18;
                                float f19 = lVar3.f5910g;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                                    f19 = typedArrayG4.getFloat(4, f19);
                                }
                                lVar3.f5910g = f19;
                                float f20 = lVar3.f5911h;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                                    f20 = typedArrayG4.getFloat(6, f20);
                                }
                                lVar3.f5911h = f20;
                                float f21 = lVar3.i;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                                    f21 = typedArrayG4.getFloat(7, f21);
                                }
                                lVar3.i = f21;
                                String string6 = typedArrayG4.getString(0);
                                if (string6 != null) {
                                    lVar3.f5913k = string6;
                                }
                                lVar3.c();
                                typedArrayG4.recycle();
                                lVar2.f5906b.add(lVar3);
                                arrayDeque.push(lVar3);
                                if (lVar3.getGroupName() != null) {
                                    eVar.put(lVar3.getGroupName(), lVar3);
                                }
                                pVar3.f5931a = pVar3.f5931a;
                            }
                        }
                        i10 = 1;
                    } else {
                        i = depth;
                        c9 = '\b';
                        i10 = 1;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i12 = i10;
                    depth = i;
                }
                if (!z10) {
                    this.f5943w = a(pVar.f5933c, pVar.f5934d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayG.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayG.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public r(p pVar) {
        this.f5946z = true;
        this.A = new float[9];
        this.B = new Matrix();
        this.C = new Rect();
        this.f5942v = pVar;
        this.f5943w = a(pVar.f5933c, pVar.f5934d);
    }
}
