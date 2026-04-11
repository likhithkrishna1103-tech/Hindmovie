package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import f9.a0;
import nb.w;
import t.a;
import t.b;
import t.c;
import t.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {
    public static final int[] A = {R.attr.colorBackground};
    public static final a0 B = new a0(26);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f633v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f634w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f635x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f636y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final w f637z;

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.cardViewStyle);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((u.a) ((Drawable) this.f637z.f9016w)).f12039h;
    }

    public float getCardElevation() {
        return ((CardView) this.f637z.f9017x).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f635x.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f635x.left;
    }

    public int getContentPaddingRight() {
        return this.f635x.right;
    }

    public int getContentPaddingTop() {
        return this.f635x.top;
    }

    public float getMaxCardElevation() {
        return ((u.a) ((Drawable) this.f637z.f9016w)).f12037e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f634w;
    }

    public float getRadius() {
        return ((u.a) ((Drawable) this.f637z.f9016w)).f12033a;
    }

    public boolean getUseCompatPadding() {
        return this.f633v;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
    }

    public void setCardBackgroundColor(int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        u.a aVar = (u.a) ((Drawable) this.f637z.f9016w);
        if (colorStateListValueOf == null) {
            aVar.getClass();
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        aVar.f12039h = colorStateListValueOf;
        aVar.f12034b.setColor(colorStateListValueOf.getColorForState(aVar.getState(), aVar.f12039h.getDefaultColor()));
        aVar.invalidateSelf();
    }

    public void setCardElevation(float f) {
        ((CardView) this.f637z.f9017x).setElevation(f);
    }

    public void setMaxCardElevation(float f) {
        B.r(this.f637z, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f634w) {
            this.f634w = z10;
            w wVar = this.f637z;
            B.r(wVar, ((u.a) ((Drawable) wVar.f9016w)).f12037e);
        }
    }

    public void setRadius(float f) {
        u.a aVar = (u.a) ((Drawable) this.f637z.f9016w);
        if (f == aVar.f12033a) {
            return;
        }
        aVar.f12033a = f;
        aVar.b(null);
        aVar.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f633v != z10) {
            this.f633v = z10;
            w wVar = this.f637z;
            B.r(wVar, ((u.a) ((Drawable) wVar.f9016w)).f12037e);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i);
        Rect rect = new Rect();
        this.f635x = rect;
        this.f636y = new Rect();
        w wVar = new w(this);
        this.f637z = wVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.CardView, i, c.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(d.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(d.CardView_cardBackgroundColor);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(A);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(b.cardview_light_background) : getResources().getColor(b.cardview_dark_background));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(d.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(d.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(d.CardView_cardMaxElevation, 0.0f);
        this.f633v = typedArrayObtainStyledAttributes.getBoolean(d.CardView_cardUseCompatPadding, false);
        this.f634w = typedArrayObtainStyledAttributes.getBoolean(d.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPadding, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingBottom, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        u.a aVar = new u.a(colorStateListValueOf, dimension);
        wVar.f9016w = aVar;
        setBackgroundDrawable(aVar);
        setClipToOutline(true);
        setElevation(dimension2);
        B.r(wVar, dimension3);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        u.a aVar = (u.a) ((Drawable) this.f637z.f9016w);
        if (colorStateList == null) {
            aVar.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        aVar.f12039h = colorStateList;
        aVar.f12034b.setColor(colorStateList.getColorForState(aVar.getState(), aVar.f12039h.getDefaultColor()));
        aVar.invalidateSelf();
    }

    @Override // android.view.View
    public final void setPadding(int i, int i10, int i11, int i12) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i10, int i11, int i12) {
    }
}
