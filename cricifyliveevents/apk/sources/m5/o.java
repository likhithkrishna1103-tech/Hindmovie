package m5;

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
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends f {
    public static final PorterDuff.Mode E = PorterDuff.Mode.SRC_IN;
    public boolean A;
    public final float[] B;
    public final Matrix C;
    public final Rect D;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public m f8368w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PorterDuffColorFilter f8369x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ColorFilter f8370y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f8371z;

    public o() {
        this.A = true;
        this.B = new float[9];
        this.C = new Matrix();
        this.D = new Rect();
        m mVar = new m();
        mVar.f8359c = null;
        mVar.f8360d = E;
        mVar.f8358b = new l();
        this.f8368w = mVar;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f8321v;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.D;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f8370y;
        if (colorFilter == null) {
            colorFilter = this.f8369x;
        }
        Matrix matrix = this.C;
        canvas.getMatrix(matrix);
        float[] fArr = this.B;
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
        m mVar = this.f8368w;
        Bitmap bitmap = mVar.f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != mVar.f.getHeight()) {
            mVar.f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            mVar.f8365k = true;
        }
        if (this.A) {
            m mVar2 = this.f8368w;
            if (mVar2.f8365k || mVar2.f8362g != mVar2.f8359c || mVar2.f8363h != mVar2.f8360d || mVar2.f8364j != mVar2.f8361e || mVar2.i != mVar2.f8358b.getRootAlpha()) {
                m mVar3 = this.f8368w;
                mVar3.f.eraseColor(0);
                Canvas canvas2 = new Canvas(mVar3.f);
                l lVar = mVar3.f8358b;
                lVar.a(lVar.f8349g, l.f8343p, canvas2, iMin, iMin2);
                m mVar4 = this.f8368w;
                mVar4.f8362g = mVar4.f8359c;
                mVar4.f8363h = mVar4.f8360d;
                mVar4.i = mVar4.f8358b.getRootAlpha();
                mVar4.f8364j = mVar4.f8361e;
                mVar4.f8365k = false;
            }
        } else {
            m mVar5 = this.f8368w;
            mVar5.f.eraseColor(0);
            Canvas canvas3 = new Canvas(mVar5.f);
            l lVar2 = mVar5.f8358b;
            lVar2.a(lVar2.f8349g, l.f8343p, canvas3, iMin, iMin2);
        }
        m mVar6 = this.f8368w;
        if (mVar6.f8358b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (mVar6.f8366l == null) {
                Paint paint2 = new Paint();
                mVar6.f8366l = paint2;
                paint2.setFilterBitmap(true);
            }
            mVar6.f8366l.setAlpha(mVar6.f8358b.getRootAlpha());
            mVar6.f8366l.setColorFilter(colorFilter);
            paint = mVar6.f8366l;
        }
        canvas.drawBitmap(mVar6.f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.getAlpha() : this.f8368w.f8358b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f8368w.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.getColorFilter() : this.f8370y;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f8321v != null && Build.VERSION.SDK_INT >= 24) {
            return new n(this.f8321v.getConstantState());
        }
        this.f8368w.f8357a = getChangingConfigurations();
        return this.f8368w;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f8368w.f8358b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f8368w.f8358b.f8350h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.isAutoMirrored() : this.f8368w.f8361e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        m mVar = this.f8368w;
        if (mVar == null) {
            return false;
        }
        l lVar = mVar.f8358b;
        if (lVar.f8355n == null) {
            lVar.f8355n = Boolean.valueOf(lVar.f8349g.a());
        }
        if (lVar.f8355n.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.f8368w.f8359c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f8371z && super.mutate() == this) {
            m mVar = this.f8368w;
            m mVar2 = new m();
            mVar2.f8359c = null;
            mVar2.f8360d = E;
            if (mVar != null) {
                mVar2.f8357a = mVar.f8357a;
                l lVar = new l(mVar.f8358b);
                mVar2.f8358b = lVar;
                if (mVar.f8358b.f8348e != null) {
                    lVar.f8348e = new Paint(mVar.f8358b.f8348e);
                }
                if (mVar.f8358b.f8347d != null) {
                    mVar2.f8358b.f8347d = new Paint(mVar.f8358b.f8347d);
                }
                mVar2.f8359c = mVar.f8359c;
                mVar2.f8360d = mVar.f8360d;
                mVar2.f8361e = mVar.f8361e;
            }
            this.f8368w = mVar2;
            this.f8371z = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        m mVar = this.f8368w;
        ColorStateList colorStateList = mVar.f8359c;
        if (colorStateList == null || (mode = mVar.f8360d) == null) {
            z10 = false;
        } else {
            this.f8369x = a(colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        l lVar = mVar.f8358b;
        if (lVar.f8355n == null) {
            lVar.f8355n = Boolean.valueOf(lVar.f8349g.a());
        }
        if (lVar.f8355n.booleanValue()) {
            boolean zB = mVar.f8358b.f8349g.b(iArr);
            mVar.f8365k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z10;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j4) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j4);
        } else {
            super.scheduleSelf(runnable, j4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f8368w.f8358b.getRootAlpha() != i) {
            this.f8368w.f8358b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.setAutoMirrored(z10);
        } else {
            this.f8368w.f8361e = z10;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f8370y = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            t1.n(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        m mVar = this.f8368w;
        if (mVar.f8359c != colorStateList) {
            mVar.f8359c = colorStateList;
            this.f8369x = a(colorStateList, mVar.f8360d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.setTintMode(mode);
            return;
        }
        m mVar = this.f8368w;
        if (mVar.f8360d != mode) {
            mVar.f8360d = mode;
            this.f8369x = a(mVar.f8359c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.setVisible(z10, z11) : super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f8321v;
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
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        m mVar = this.f8368w;
        mVar.f8358b = new l();
        TypedArray typedArrayG = k0.b.g(resources, theme, attributeSet, a.f8302a);
        m mVar2 = this.f8368w;
        l lVar = mVar2.f8358b;
        int i11 = !k0.b.d(xmlPullParser, "tintMode") ? -1 : typedArrayG.getInt(6, -1);
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
        mVar2.f8360d = mode;
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
                ThreadLocal threadLocal = k0.c.f6757a;
                try {
                    colorStateListA = k0.c.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e9) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e9);
                }
            }
        }
        ColorStateList colorStateList = colorStateListA;
        if (colorStateList != null) {
            mVar2.f8359c = colorStateList;
        }
        boolean z10 = mVar2.f8361e;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z10 = typedArrayG.getBoolean(5, z10);
        }
        mVar2.f8361e = z10;
        float f = lVar.f8351j;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f = typedArrayG.getFloat(7, f);
        }
        lVar.f8351j = f;
        float f10 = lVar.f8352k;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f10 = typedArrayG.getFloat(8, f10);
        }
        lVar.f8352k = f10;
        if (lVar.f8351j <= 0.0f) {
            throw new XmlPullParserException(typedArrayG.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f10 > 0.0f) {
            lVar.f8350h = typedArrayG.getDimension(3, lVar.f8350h);
            float dimension = typedArrayG.getDimension(2, lVar.i);
            lVar.i = dimension;
            if (lVar.f8350h <= 0.0f) {
                throw new XmlPullParserException(typedArrayG.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = lVar.getAlpha();
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
                    alpha = typedArrayG.getFloat(4, alpha);
                }
                lVar.setAlpha(alpha);
                String string = typedArrayG.getString(0);
                if (string != null) {
                    lVar.f8354m = string;
                    lVar.f8356o.put(string, lVar);
                }
                typedArrayG.recycle();
                mVar.f8357a = getChangingConfigurations();
                mVar.f8365k = true;
                m mVar3 = this.f8368w;
                l lVar2 = mVar3.f8358b;
                ArrayDeque arrayDeque = new ArrayDeque();
                i iVar = lVar2.f8349g;
                v.e eVar = lVar2.f8356o;
                arrayDeque.push(iVar);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z11 = true;
                while (eventType != i12 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        i iVar2 = (i) arrayDeque.peek();
                        i = depth;
                        if ("path".equals(name)) {
                            h hVar = new h();
                            hVar.f8323e = 0.0f;
                            hVar.f8324g = 1.0f;
                            hVar.f8325h = 1.0f;
                            hVar.i = 0.0f;
                            hVar.f8326j = 1.0f;
                            hVar.f8327k = 0.0f;
                            Paint.Cap cap2 = Paint.Cap.BUTT;
                            hVar.f8328l = cap2;
                            Paint.Join join2 = Paint.Join.MITER;
                            hVar.f8329m = join2;
                            hVar.f8330n = 4.0f;
                            TypedArray typedArrayG2 = k0.b.g(resources, theme, attributeSet, a.f8304c);
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                String string2 = typedArrayG2.getString(0);
                                if (string2 != null) {
                                    hVar.f8341b = string2;
                                }
                                String string3 = typedArrayG2.getString(2);
                                if (string3 != null) {
                                    hVar.f8340a = u8.a.m(string3);
                                }
                                hVar.f = k0.b.b(typedArrayG2, xmlPullParser, theme, "fillColor", 1);
                                float f11 = hVar.f8325h;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                                    f11 = typedArrayG2.getFloat(12, f11);
                                }
                                hVar.f8325h = f11;
                                int i14 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? typedArrayG2.getInt(8, -1) : -1;
                                Paint.Cap cap3 = hVar.f8328l;
                                if (i14 == 0) {
                                    cap = cap2;
                                } else if (i14 != 1) {
                                    cap = i14 != 2 ? cap3 : Paint.Cap.SQUARE;
                                } else {
                                    cap = Paint.Cap.ROUND;
                                }
                                hVar.f8328l = cap;
                                int i15 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? typedArrayG2.getInt(9, -1) : -1;
                                Paint.Join join3 = hVar.f8329m;
                                if (i15 == 0) {
                                    join = join2;
                                } else if (i15 != 1) {
                                    join = i15 != 2 ? join3 : Paint.Join.BEVEL;
                                } else {
                                    join = Paint.Join.ROUND;
                                }
                                hVar.f8329m = join;
                                float f12 = hVar.f8330n;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                                    f12 = typedArrayG2.getFloat(10, f12);
                                }
                                hVar.f8330n = f12;
                                hVar.f8322d = k0.b.b(typedArrayG2, xmlPullParser, theme, "strokeColor", 3);
                                float f13 = hVar.f8324g;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                                    f13 = typedArrayG2.getFloat(11, f13);
                                }
                                hVar.f8324g = f13;
                                float f14 = hVar.f8323e;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                                    f14 = typedArrayG2.getFloat(4, f14);
                                }
                                hVar.f8323e = f14;
                                float f15 = hVar.f8326j;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                                    f15 = typedArrayG2.getFloat(6, f15);
                                }
                                hVar.f8326j = f15;
                                float f16 = hVar.f8327k;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                                    f16 = typedArrayG2.getFloat(7, f16);
                                }
                                hVar.f8327k = f16;
                                float f17 = hVar.i;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                                    f17 = typedArrayG2.getFloat(5, f17);
                                }
                                hVar.i = f17;
                                int i16 = hVar.f8342c;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                                    i16 = typedArrayG2.getInt(13, i16);
                                }
                                hVar.f8342c = i16;
                            }
                            typedArrayG2.recycle();
                            iVar2.f8332b.add(hVar);
                            if (hVar.getPathName() != null) {
                                eVar.put(hVar.getPathName(), hVar);
                            }
                            mVar3.f8357a = mVar3.f8357a;
                            z11 = false;
                            c9 = '\b';
                        } else {
                            c9 = '\b';
                            if ("clip-path".equals(name)) {
                                g gVar = new g();
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                    TypedArray typedArrayG3 = k0.b.g(resources, theme, attributeSet, a.f8305d);
                                    String string4 = typedArrayG3.getString(0);
                                    if (string4 != null) {
                                        gVar.f8341b = string4;
                                    }
                                    String string5 = typedArrayG3.getString(1);
                                    if (string5 != null) {
                                        gVar.f8340a = u8.a.m(string5);
                                    }
                                    gVar.f8342c = !k0.b.d(xmlPullParser, "fillType") ? 0 : typedArrayG3.getInt(2, 0);
                                    typedArrayG3.recycle();
                                }
                                iVar2.f8332b.add(gVar);
                                if (gVar.getPathName() != null) {
                                    eVar.put(gVar.getPathName(), gVar);
                                }
                                mVar3.f8357a = mVar3.f8357a;
                            } else if ("group".equals(name)) {
                                i iVar3 = new i();
                                TypedArray typedArrayG4 = k0.b.g(resources, theme, attributeSet, a.f8303b);
                                float f18 = iVar3.f8333c;
                                if (k0.b.d(xmlPullParser, "rotation")) {
                                    f18 = typedArrayG4.getFloat(5, f18);
                                }
                                iVar3.f8333c = f18;
                                iVar3.f8334d = typedArrayG4.getFloat(1, iVar3.f8334d);
                                iVar3.f8335e = typedArrayG4.getFloat(2, iVar3.f8335e);
                                float f19 = iVar3.f;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                                    f19 = typedArrayG4.getFloat(3, f19);
                                }
                                iVar3.f = f19;
                                float f20 = iVar3.f8336g;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                                    f20 = typedArrayG4.getFloat(4, f20);
                                }
                                iVar3.f8336g = f20;
                                float f21 = iVar3.f8337h;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                                    f21 = typedArrayG4.getFloat(6, f21);
                                }
                                iVar3.f8337h = f21;
                                float f22 = iVar3.i;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                                    f22 = typedArrayG4.getFloat(7, f22);
                                }
                                iVar3.i = f22;
                                String string6 = typedArrayG4.getString(0);
                                if (string6 != null) {
                                    iVar3.f8339k = string6;
                                }
                                iVar3.c();
                                typedArrayG4.recycle();
                                iVar2.f8332b.add(iVar3);
                                arrayDeque.push(iVar3);
                                if (iVar3.getGroupName() != null) {
                                    eVar.put(iVar3.getGroupName(), iVar3);
                                }
                                mVar3.f8357a = mVar3.f8357a;
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
                if (!z11) {
                    this.f8369x = a(mVar.f8359c, mVar.f8360d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayG.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayG.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public o(m mVar) {
        this.A = true;
        this.B = new float[9];
        this.C = new Matrix();
        this.D = new Rect();
        this.f8368w = mVar;
        this.f8369x = a(mVar.f8359c, mVar.f8360d);
    }
}
