package q9;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final h f11122m = new h(0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ga.b f11123a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ga.b f11124b = new i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ga.b f11125c = new i();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ga.b f11126d = new i();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f11127e = new a(0.0f);
    public c f = new a(0.0f);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f11128g = new a(0.0f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f11129h = new a(0.0f);
    public e i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f11130j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f11131k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e f11132l;

    public k() {
        int i = 0;
        this.i = new e(i);
        this.f11130j = new e(i);
        this.f11131k = new e(i);
        this.f11132l = new e(i);
    }

    public static j a(Context context, int i, int i10) {
        return b(context, i, i10, new a(0));
    }

    public static j b(Context context, int i, int i10, c cVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i10 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i10);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(p8.l.ShapeAppearance);
        try {
            int i11 = typedArrayObtainStyledAttributes.getInt(p8.l.ShapeAppearance_cornerFamily, 0);
            int i12 = typedArrayObtainStyledAttributes.getInt(p8.l.ShapeAppearance_cornerFamilyTopLeft, i11);
            int i13 = typedArrayObtainStyledAttributes.getInt(p8.l.ShapeAppearance_cornerFamilyTopRight, i11);
            int i14 = typedArrayObtainStyledAttributes.getInt(p8.l.ShapeAppearance_cornerFamilyBottomRight, i11);
            int i15 = typedArrayObtainStyledAttributes.getInt(p8.l.ShapeAppearance_cornerFamilyBottomLeft, i11);
            c cVarD = d(typedArrayObtainStyledAttributes, p8.l.ShapeAppearance_cornerSize, cVar);
            c cVarD2 = d(typedArrayObtainStyledAttributes, p8.l.ShapeAppearance_cornerSizeTopLeft, cVarD);
            c cVarD3 = d(typedArrayObtainStyledAttributes, p8.l.ShapeAppearance_cornerSizeTopRight, cVarD);
            c cVarD4 = d(typedArrayObtainStyledAttributes, p8.l.ShapeAppearance_cornerSizeBottomRight, cVarD);
            c cVarD5 = d(typedArrayObtainStyledAttributes, p8.l.ShapeAppearance_cornerSizeBottomLeft, cVarD);
            j jVar = new j();
            jVar.f11112a = i5.a.g(i12);
            jVar.f11116e = cVarD2;
            jVar.f11113b = i5.a.g(i13);
            jVar.f = cVarD3;
            jVar.f11114c = i5.a.g(i14);
            jVar.f11117g = cVarD4;
            jVar.f11115d = i5.a.g(i15);
            jVar.f11118h = cVarD5;
            return jVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static j c(Context context, AttributeSet attributeSet, int i, int i10) {
        a aVar = new a(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p8.l.MaterialShape, i, i10);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(p8.l.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(p8.l.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return b(context, resourceId, resourceId2, aVar);
    }

    public static c d(TypedArray typedArray, int i, c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i10 = typedValuePeekValue.type;
            if (i10 == 5) {
                return new a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i10 == 6) {
                return new h(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return cVar;
    }

    public final boolean e(RectF rectF) {
        boolean z2 = this.f11132l.getClass().equals(e.class) && this.f11130j.getClass().equals(e.class) && this.i.getClass().equals(e.class) && this.f11131k.getClass().equals(e.class);
        float fA = this.f11127e.a(rectF);
        return z2 && ((this.f.a(rectF) > fA ? 1 : (this.f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f11129h.a(rectF) > fA ? 1 : (this.f11129h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f11128g.a(rectF) > fA ? 1 : (this.f11128g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f11124b instanceof i) && (this.f11123a instanceof i) && (this.f11125c instanceof i) && (this.f11126d instanceof i));
    }

    public final j f() {
        j jVar = new j();
        jVar.f11112a = this.f11123a;
        jVar.f11113b = this.f11124b;
        jVar.f11114c = this.f11125c;
        jVar.f11115d = this.f11126d;
        jVar.f11116e = this.f11127e;
        jVar.f = this.f;
        jVar.f11117g = this.f11128g;
        jVar.f11118h = this.f11129h;
        jVar.i = this.i;
        jVar.f11119j = this.f11130j;
        jVar.f11120k = this.f11131k;
        jVar.f11121l = this.f11132l;
        return jVar;
    }
}
