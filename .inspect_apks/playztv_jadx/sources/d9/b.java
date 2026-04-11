package d9;

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
import h.f;
import j9.e0;
import java.util.WeakHashMap;
import l.c;
import p8.d;
import p8.k;
import p8.l;
import q0.f0;
import q0.o0;
import q9.g;
import q9.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4107e = p8.b.alertDialogStyle;
    public static final int f = k.MaterialAlertDialog_MaterialComponents;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4108g = p8.b.materialAlertDialogTheme;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f4109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f4110d;

    /* JADX WARN: Illegal instructions before constructor call */
    public b(Context context, int i) {
        int i10 = f4108g;
        TypedValue typedValueY = z7.a.y(context, i10);
        int i11 = typedValueY == null ? 0 : typedValueY.data;
        int i12 = f4107e;
        int i13 = f;
        Context contextA = x9.a.a(context, null, i12, i13);
        contextA = i11 != 0 ? new c(contextA, i11) : contextA;
        if (i == 0) {
            TypedValue typedValueY2 = z7.a.y(context, i10);
            i = typedValueY2 == null ? 0 : typedValueY2.data;
        }
        super(contextA, i);
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        int[] iArr = l.MaterialAlertDialog;
        e0.a(context2, null, i12, i13);
        e0.b(context2, null, iArr, i12, i13, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(null, iArr, i12, i13);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetStart, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetTop, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetEnd, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.MaterialAlertDialog_backgroundInsetBottom, context2.getResources().getDimensionPixelSize(d.mtrl_alert_dialog_background_inset_bottom));
        typedArrayObtainStyledAttributes.recycle();
        if (context2.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        this.f4110d = new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
        TypedValue typedValueB = z7.a.B(p8.b.colorSurface, context2, b.class.getCanonicalName());
        int i14 = typedValueB.resourceId;
        int color = i14 != 0 ? context2.getColor(i14) : typedValueB.data;
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(null, l.MaterialAlertDialog, i12, i13);
        int color2 = typedArrayObtainStyledAttributes2.getColor(l.MaterialAlertDialog_backgroundTint, color);
        typedArrayObtainStyledAttributes2.recycle();
        g gVar = new g(context2, null, i12, i13);
        gVar.j(context2);
        gVar.l(ColorStateList.valueOf(color2));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                j jVarF = gVar.f11105u.f11090a.f();
                jVarF.b(dimension);
                gVar.setShapeAppearanceModel(jVarF.a());
            }
        }
        this.f4109c = gVar;
    }

    @Override // h.f
    public final f a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        throw null;
    }

    public final void c() {
        h.c cVar = this.f5489a;
        cVar.i = "Cancel";
        cVar.f5447j = null;
    }

    @Override // h.f
    public final h.g create() {
        h.g gVarCreate = super.create();
        Window window = gVarCreate.getWindow();
        View decorView = window.getDecorView();
        g gVar = this.f4109c;
        if (gVar != null) {
            WeakHashMap weakHashMap = o0.f10475a;
            gVar.k(f0.e(decorView));
        }
        Rect rect = this.f4110d;
        window.setBackgroundDrawable(new InsetDrawable((Drawable) gVar, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new a(gVarCreate, rect));
        return gVarCreate;
    }

    public final void d(String str, DialogInterface.OnClickListener onClickListener) {
        super.a(str, onClickListener);
    }

    public final b e(String str) {
        return (b) super.setTitle(str);
    }

    public final void f(LinearLayout linearLayout) {
    }

    @Override // h.f
    public final f setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setNegativeButton(i, onClickListener);
    }

    @Override // h.f
    public final f setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setPositiveButton(i, onClickListener);
    }

    @Override // h.f
    public final f setTitle(CharSequence charSequence) {
        return (b) super.setTitle(charSequence);
    }

    @Override // h.f
    public final f setView(View view) {
        return (b) super.setView(view);
    }
}
