package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import t0.d0;
import t0.m0;
import t0.q1;
import t0.r1;
import t0.s1;
import t0.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class p<S> extends androidx.fragment.app.q {
    public final LinkedHashSet I0;
    public final LinkedHashSet J0;
    public int K0;
    public w L0;
    public b M0;
    public m N0;
    public int O0;
    public CharSequence P0;
    public boolean Q0;
    public int R0;
    public int S0;
    public CharSequence T0;
    public int U0;
    public CharSequence V0;
    public int W0;
    public CharSequence X0;
    public int Y0;
    public CharSequence Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public TextView f2880a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public CheckableImageButton f2881b1;
    public ka.i c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public boolean f2882d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public CharSequence f2883e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public CharSequence f2884f1;

    public p() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.I0 = new LinkedHashSet();
        this.J0 = new LinkedHashSet();
    }

    public static int W(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(k9.d.mtrl_calendar_content_padding);
        Calendar calendarB = z.b();
        calendarB.set(5, 1);
        Calendar calendarA = z.a(calendarB);
        calendarA.get(2);
        calendarA.get(1);
        int maximum = calendarA.getMaximum(7);
        calendarA.getActualMaximum(5);
        calendarA.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(k9.d.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(k9.d.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean X(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(android.support.v4.media.session.b.I(k9.b.materialCalendarStyle, context, m.class.getCanonicalName()).data, new int[]{i});
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z10;
    }

    @Override // androidx.fragment.app.q, androidx.fragment.app.y
    public final void D(Bundle bundle) {
        super.D(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.K0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        b bVar = this.M0;
        a aVar = new a();
        int i = a.f2840b;
        int i10 = a.f2840b;
        long j4 = bVar.f2843v.A;
        long j7 = bVar.f2844w.A;
        aVar.f2841a = Long.valueOf(bVar.f2846y.A);
        int i11 = bVar.f2847z;
        d dVar = bVar.f2845x;
        m mVar = this.N0;
        r rVar = mVar == null ? null : mVar.f2868v0;
        if (rVar != null) {
            aVar.f2841a = Long.valueOf(rVar.A);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dVar);
        r rVarB = r.b(j4);
        r rVarB2 = r.b(j7);
        d dVar2 = (d) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l10 = aVar.f2841a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new b(rVarB, rVarB2, dVar2, l10 == null ? null : r.b(l10.longValue()), i11));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.O0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.P0);
        bundle.putInt("INPUT_MODE_KEY", this.R0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.S0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.T0);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.U0);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.V0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.W0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.X0);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.Y0);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.Z0);
    }

    @Override // androidx.fragment.app.q, androidx.fragment.app.y
    public final void E() {
        super.E();
        Window window = T().getWindow();
        if (this.Q0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.c1);
            if (!this.f2882d1) {
                View viewFindViewById = L().findViewById(k9.f.fullscreen_header);
                ColorStateList colorStateListR = u8.a.r(viewFindViewById.getBackground());
                Integer numValueOf = colorStateListR != null ? Integer.valueOf(colorStateListR.getDefaultColor()) : null;
                boolean z10 = false;
                boolean z11 = numValueOf == null || numValueOf.intValue() == 0;
                int iM = com.bumptech.glide.f.m(window.getContext(), R.attr.colorBackground, -16777216);
                if (z11) {
                    numValueOf = Integer.valueOf(iM);
                }
                w8.e.l(window, false);
                window.getContext();
                int iD = Build.VERSION.SDK_INT < 27 ? l0.b.d(com.bumptech.glide.f.m(window.getContext(), R.attr.navigationBarColor, -16777216), 128) : 0;
                window.setStatusBarColor(0);
                window.setNavigationBarColor(iD);
                boolean z12 = com.bumptech.glide.f.x(0) || com.bumptech.glide.f.x(numValueOf.intValue());
                l4.a aVar = new l4.a(window.getDecorView());
                int i = Build.VERSION.SDK_INT;
                (i >= 35 ? new t1(window, aVar) : i >= 30 ? new s1(window, aVar) : i >= 26 ? new r1(window, aVar) : new q1(window, aVar)).A(z12);
                boolean zX = com.bumptech.glide.f.x(iM);
                if (com.bumptech.glide.f.x(iD) || (iD == 0 && zX)) {
                    z10 = true;
                }
                l4.a aVar2 = new l4.a(window.getDecorView());
                int i10 = Build.VERSION.SDK_INT;
                (i10 >= 35 ? new t1(window, aVar2) : i10 >= 30 ? new s1(window, aVar2) : i10 >= 26 ? new r1(window, aVar2) : new q1(window, aVar2)).z(z10);
                int paddingTop = viewFindViewById.getPaddingTop();
                int paddingLeft = viewFindViewById.getPaddingLeft();
                int paddingRight = viewFindViewById.getPaddingRight();
                int i11 = viewFindViewById.getLayoutParams().height;
                o oVar = new o();
                oVar.f2875v = i11;
                oVar.f2879z = viewFindViewById;
                oVar.f2876w = paddingLeft;
                oVar.f2877x = paddingTop;
                oVar.f2878y = paddingRight;
                WeakHashMap weakHashMap = m0.f11777a;
                d0.l(viewFindViewById, oVar);
                this.f2882d1 = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = m().getDimensionPixelOffset(k9.d.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.c1, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new x9.a(T(), rect));
        }
        K();
        int i12 = this.K0;
        if (i12 == 0) {
            V();
            throw null;
        }
        V();
        b bVar = this.M0;
        m mVar = new m();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i12);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", bVar.f2846y);
        mVar.N(bundle);
        this.N0 = mVar;
        w wVar = mVar;
        if (this.R0 == 1) {
            V();
            b bVar2 = this.M0;
            q qVar = new q();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i12);
            bundle2.putParcelable("DATE_SELECTOR_KEY", null);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar2);
            qVar.N(bundle2);
            wVar = qVar;
        }
        this.L0 = wVar;
        this.f2880a1.setText((this.R0 == 1 && m().getConfiguration().orientation == 2) ? this.f2884f1 : this.f2883e1);
        V();
        throw null;
    }

    @Override // androidx.fragment.app.q, androidx.fragment.app.y
    public final void F() {
        this.L0.f2903s0.clear();
        super.F();
    }

    @Override // androidx.fragment.app.q
    public final Dialog S(Bundle bundle) {
        Context contextK = K();
        K();
        int i = this.K0;
        if (i == 0) {
            V();
            throw null;
        }
        Dialog dialog = new Dialog(contextK, i);
        Context context = dialog.getContext();
        this.Q0 = X(context, R.attr.windowFullscreen);
        this.c1 = new ka.i(context, null, k9.b.materialCalendarStyle, k9.k.Widget_MaterialComponents_MaterialCalendar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, k9.l.MaterialCalendar, k9.b.materialCalendarStyle, k9.k.Widget_MaterialComponents_MaterialCalendar);
        int color = typedArrayObtainStyledAttributes.getColor(k9.l.MaterialCalendar_backgroundTint, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.c1.m(context);
        this.c1.q(ColorStateList.valueOf(color));
        this.c1.p(dialog.getWindow().getDecorView().getElevation());
        return dialog;
    }

    public final void V() {
        if (this.B.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.fragment.app.q, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.I0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.q, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.J0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.f1103b0;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.q, androidx.fragment.app.y
    public final void w(Bundle bundle) {
        super.w(bundle);
        if (bundle == null) {
            bundle = this.B;
        }
        this.K0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.M0 = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.O0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.P0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.R0 = bundle.getInt("INPUT_MODE_KEY");
        this.S0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.T0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.U0 = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.V0 = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.W0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.X0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.Y0 = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.Z0 = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.P0;
        if (text == null) {
            text = K().getResources().getText(this.O0);
        }
        this.f2883e1 = text;
        if (text != null) {
            CharSequence[] charSequenceArrSplit = TextUtils.split(String.valueOf(text), "\n");
            if (charSequenceArrSplit.length > 1) {
                text = charSequenceArrSplit[0];
            }
        } else {
            text = null;
        }
        this.f2884f1 = text;
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(this.Q0 ? k9.h.mtrl_picker_fullscreen : k9.h.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.Q0) {
            viewInflate.findViewById(k9.f.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(W(context), -2));
        } else {
            viewInflate.findViewById(k9.f.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(W(context), -1));
        }
        ((TextView) viewInflate.findViewById(k9.f.mtrl_picker_header_selection_text)).setAccessibilityLiveRegion(1);
        this.f2881b1 = (CheckableImageButton) viewInflate.findViewById(k9.f.mtrl_picker_header_toggle);
        this.f2880a1 = (TextView) viewInflate.findViewById(k9.f.mtrl_picker_title_text);
        this.f2881b1.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.f2881b1;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, j4.i(context, k9.e.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], j4.i(context, k9.e.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.f2881b1.setChecked(this.R0 != 0);
        m0.n(this.f2881b1, null);
        CheckableImageButton checkableImageButton2 = this.f2881b1;
        this.f2881b1.setContentDescription(this.R0 == 1 ? checkableImageButton2.getContext().getString(k9.j.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton2.getContext().getString(k9.j.mtrl_picker_toggle_to_text_input_mode));
        this.f2881b1.setOnClickListener(new n(0, this));
        V();
        throw null;
    }
}
