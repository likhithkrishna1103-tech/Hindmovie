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
import k8.c0;
import p2.c;
import q.a;
import q.b;
import q.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f956u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f957v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f958w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f959x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c f960y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f955z = {R.attr.colorBackground};
    public static final c0 A = new c0(22);

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.cardViewStyle);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((r.a) ((Drawable) this.f960y.f10130v)).f11203h;
    }

    public float getCardElevation() {
        return ((CardView) this.f960y.f10131w).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f958w.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f958w.left;
    }

    public int getContentPaddingRight() {
        return this.f958w.right;
    }

    public int getContentPaddingTop() {
        return this.f958w.top;
    }

    public float getMaxCardElevation() {
        return ((r.a) ((Drawable) this.f960y.f10130v)).f11201e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f957v;
    }

    public float getRadius() {
        return ((r.a) ((Drawable) this.f960y.f10130v)).f11197a;
    }

    public boolean getUseCompatPadding() {
        return this.f956u;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
    }

    public void setCardBackgroundColor(int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        r.a aVar = (r.a) ((Drawable) this.f960y.f10130v);
        if (colorStateListValueOf == null) {
            aVar.getClass();
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        aVar.f11203h = colorStateListValueOf;
        aVar.f11198b.setColor(colorStateListValueOf.getColorForState(aVar.getState(), aVar.f11203h.getDefaultColor()));
        aVar.invalidateSelf();
    }

    public void setCardElevation(float f) {
        ((CardView) this.f960y.f10131w).setElevation(f);
    }

    public void setMaxCardElevation(float f) {
        A.i(this.f960y, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    public void setPreventCornerOverlap(boolean z2) {
        if (z2 != this.f957v) {
            this.f957v = z2;
            c cVar = this.f960y;
            A.i(cVar, ((r.a) ((Drawable) cVar.f10130v)).f11201e);
        }
    }

    public void setRadius(float f) {
        r.a aVar = (r.a) ((Drawable) this.f960y.f10130v);
        if (f == aVar.f11197a) {
            return;
        }
        aVar.f11197a = f;
        aVar.b(null);
        aVar.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.f956u != z2) {
            this.f956u = z2;
            c cVar = this.f960y;
            A.i(cVar, ((r.a) ((Drawable) cVar.f10130v)).f11201e);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i);
        Rect rect = new Rect();
        this.f958w = rect;
        this.f959x = new Rect();
        c cVar = new c(7, this);
        this.f960y = cVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.CardView, i, q.c.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(d.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(d.CardView_cardBackgroundColor);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f955z);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(b.cardview_light_background) : getResources().getColor(b.cardview_dark_background));
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(d.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(d.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(d.CardView_cardMaxElevation, 0.0f);
        this.f956u = typedArrayObtainStyledAttributes.getBoolean(d.CardView_cardUseCompatPadding, false);
        this.f957v = typedArrayObtainStyledAttributes.getBoolean(d.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPadding, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingBottom, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        r.a aVar = new r.a(colorStateListValueOf, dimension);
        cVar.f10130v = aVar;
        setBackgroundDrawable(aVar);
        setClipToOutline(true);
        setElevation(dimension2);
        A.i(cVar, dimension3);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        r.a aVar = (r.a) ((Drawable) this.f960y.f10130v);
        if (colorStateList == null) {
            aVar.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        aVar.f11203h = colorStateList;
        aVar.f11198b.setColor(colorStateList.getColorForState(aVar.getState(), aVar.f11203h.getDefaultColor()));
        aVar.invalidateSelf();
    }

    @Override // android.view.View
    public final void setPadding(int i, int i10, int i11, int i12) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i10, int i11, int i12) {
    }
}
