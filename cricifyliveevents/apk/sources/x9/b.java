package x9;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import da.d0;
import h.g;
import h.h;
import k9.d;
import k9.k;
import k9.l;
import ka.i;
import m.c;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14461e = g.a.alertDialogStyle;
    public static final int f = k.MaterialAlertDialog_MaterialComponents;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f14462g = k9.b.materialAlertDialogTheme;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f14463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f14464d;

    /* JADX WARN: Illegal instructions before constructor call */
    public b(Context context, int i) {
        int i10 = f14462g;
        TypedValue typedValueG = android.support.v4.media.session.b.G(context, i10);
        int i11 = typedValueG == null ? 0 : typedValueG.data;
        int i12 = f14461e;
        int i13 = f;
        Context contextA = ra.a.a(context, null, i12, i13);
        contextA = i11 != 0 ? new c(contextA, i11) : contextA;
        if (i == 0) {
            TypedValue typedValueG2 = android.support.v4.media.session.b.G(context, i10);
            i = typedValueG2 == null ? 0 : typedValueG2.data;
        }
        super(contextA, i);
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        int[] iArr = l.MaterialAlertDialog;
        d0.a(context2, null, i12, i13);
        d0.b(context2, null, iArr, i12, i13, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(null, iArr, i12, i13);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetStart, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetTop, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetEnd, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetBottom, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_bottom));
        typedArrayObtainStyledAttributes.recycle();
        int layoutDirection = context2.getResources().getConfiguration().getLayoutDirection();
        this.f14464d = new Rect(layoutDirection == 1 ? dimensionPixelSize3 : dimensionPixelSize, dimensionPixelSize2, layoutDirection != 1 ? dimensionPixelSize3 : dimensionPixelSize, dimensionPixelSize4);
        TypedValue typedValueI = android.support.v4.media.session.b.I(k9.b.colorSurface, context2, b.class.getCanonicalName());
        int i14 = typedValueI.resourceId;
        int color = i14 != 0 ? context2.getColor(i14) : typedValueI.data;
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(null, l.MaterialAlertDialog, i12, i13);
        int color2 = typedArrayObtainStyledAttributes2.getColor(l.MaterialAlertDialog_backgroundTint, color);
        typedArrayObtainStyledAttributes2.recycle();
        i iVar = new i(context2, null, i12, i13);
        iVar.m(context2);
        iVar.q(ColorStateList.valueOf(color2));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                ka.l lVarG = iVar.f7334w.f7316a.g();
                lVarG.b(dimension);
                iVar.setShapeAppearanceModel(lVarG.a());
            }
        }
        this.f14463c = iVar;
    }

    @Override // h.g
    public final g a(String str) {
        this.f5346a.f = str;
        return this;
    }

    @Override // h.g
    public final g b(String str) {
        super.b("CANCEl");
        return this;
    }

    @Override // h.g
    public final g c(String str, DialogInterface.OnClickListener onClickListener) {
        super.c(str, onClickListener);
        return this;
    }

    @Override // h.g
    public final h create() {
        h hVarCreate = super.create();
        Window window = hVarCreate.getWindow();
        View decorView = window.getDecorView();
        i iVar = this.f14463c;
        if (iVar != null) {
            iVar.p(decorView.getElevation());
        }
        Rect rect = this.f14464d;
        window.setBackgroundDrawable(new InsetDrawable((Drawable) iVar, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new a(hVarCreate, rect));
        return hVarCreate;
    }

    public final void e() {
        super.b("Cancel");
    }

    public final void f(String str, DialogInterface.OnClickListener onClickListener) {
        super.c(str, onClickListener);
    }

    public final b g(String str) {
        return (b) super.setTitle(str);
    }

    public final void h(LinearLayout linearLayout) {
    }

    @Override // h.g
    public final g setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setNegativeButton(i, onClickListener);
    }

    @Override // h.g
    public final g setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setPositiveButton(i, onClickListener);
    }

    @Override // h.g
    public final g setTitle(CharSequence charSequence) {
        return (b) super.setTitle(charSequence);
    }

    @Override // h.g
    public final g setView(View view) {
        return (b) super.setView(view);
    }
}
