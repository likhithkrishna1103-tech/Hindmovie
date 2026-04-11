package ka;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final j f7349m = new j(0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bumptech.glide.d f7350a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bumptech.glide.d f7351b = new k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.d f7352c = new k();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bumptech.glide.d f7353d = new k();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f7354e = new a(0.0f);
    public d f = new a(0.0f);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f7355g = new a(0.0f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f7356h = new a(0.0f);
    public f i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f7357j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f7358k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f7359l;

    public m() {
        int i = 0;
        this.i = new f(i);
        this.f7357j = new f(i);
        this.f7358k = new f(i);
        this.f7359l = new f(i);
    }

    public static l a(Context context, int i, int i10) {
        return b(context, i, i10, new a(0));
    }

    public static l b(Context context, int i, int i10, d dVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i10 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i10, true);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(k9.l.ShapeAppearance);
        try {
            int i11 = typedArrayObtainStyledAttributes.getInt(k9.l.ShapeAppearance_cornerFamily, 0);
            int i12 = typedArrayObtainStyledAttributes.getInt(k9.l.ShapeAppearance_cornerFamilyTopLeft, i11);
            int i13 = typedArrayObtainStyledAttributes.getInt(k9.l.ShapeAppearance_cornerFamilyTopRight, i11);
            int i14 = typedArrayObtainStyledAttributes.getInt(k9.l.ShapeAppearance_cornerFamilyBottomRight, i11);
            int i15 = typedArrayObtainStyledAttributes.getInt(k9.l.ShapeAppearance_cornerFamilyBottomLeft, i11);
            d dVarD = d(typedArrayObtainStyledAttributes, k9.l.ShapeAppearance_cornerSize, dVar);
            d dVarD2 = d(typedArrayObtainStyledAttributes, k9.l.ShapeAppearance_cornerSizeTopLeft, dVarD);
            d dVarD3 = d(typedArrayObtainStyledAttributes, k9.l.ShapeAppearance_cornerSizeTopRight, dVarD);
            d dVarD4 = d(typedArrayObtainStyledAttributes, k9.l.ShapeAppearance_cornerSizeBottomRight, dVarD);
            d dVarD5 = d(typedArrayObtainStyledAttributes, k9.l.ShapeAppearance_cornerSizeBottomLeft, dVarD);
            l lVar = new l();
            lVar.f7339a = com.bumptech.glide.e.e(i12);
            lVar.f7343e = dVarD2;
            lVar.f7340b = com.bumptech.glide.e.e(i13);
            lVar.f = dVarD3;
            lVar.f7341c = com.bumptech.glide.e.e(i14);
            lVar.f7344g = dVarD4;
            lVar.f7342d = com.bumptech.glide.e.e(i15);
            lVar.f7345h = dVarD5;
            return lVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static l c(Context context, AttributeSet attributeSet, int i, int i10) {
        a aVar = new a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k9.l.MaterialShape, i, i10);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(k9.l.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(k9.l.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return b(context, resourceId, resourceId2, aVar);
    }

    public static d d(TypedArray typedArray, int i, d dVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i10 = typedValuePeekValue.type;
            if (i10 == 5) {
                return new a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i10 == 6) {
                return new j(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return dVar;
    }

    public final boolean e() {
        return (this.f7351b instanceof k) && (this.f7350a instanceof k) && (this.f7352c instanceof k) && (this.f7353d instanceof k);
    }

    public final boolean f(RectF rectF) {
        boolean z10 = this.f7359l.getClass().equals(f.class) && this.f7357j.getClass().equals(f.class) && this.i.getClass().equals(f.class) && this.f7358k.getClass().equals(f.class);
        float fA = this.f7354e.a(rectF);
        return z10 && ((this.f.a(rectF) > fA ? 1 : (this.f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f7356h.a(rectF) > fA ? 1 : (this.f7356h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f7355g.a(rectF) > fA ? 1 : (this.f7355g.a(rectF) == fA ? 0 : -1)) == 0) && e();
    }

    public final l g() {
        l lVar = new l();
        lVar.f7339a = this.f7350a;
        lVar.f7340b = this.f7351b;
        lVar.f7341c = this.f7352c;
        lVar.f7342d = this.f7353d;
        lVar.f7343e = this.f7354e;
        lVar.f = this.f;
        lVar.f7344g = this.f7355g;
        lVar.f7345h = this.f7356h;
        lVar.i = this.i;
        lVar.f7346j = this.f7357j;
        lVar.f7347k = this.f7358k;
        lVar.f7348l = this.f7359l;
        return lVar;
    }

    public final String toString() {
        return "[" + this.f7354e + ", " + this.f + ", " + this.f7355g + ", " + this.f7356h + "]";
    }
}
