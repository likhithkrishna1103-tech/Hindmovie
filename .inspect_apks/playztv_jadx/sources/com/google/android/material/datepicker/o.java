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
import com.google.android.material.internal.CheckableImageButton;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import q0.f0;
import q0.o0;
import q0.s1;
import q0.t1;
import q0.u1;
import q0.v1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o<S> extends androidx.fragment.app.n {
    public final LinkedHashSet H0;
    public final LinkedHashSet I0;
    public int J0;
    public v K0;
    public b L0;
    public m M0;
    public int N0;
    public CharSequence O0;
    public boolean P0;
    public int Q0;
    public int R0;
    public CharSequence S0;
    public int T0;
    public CharSequence U0;
    public int V0;
    public CharSequence W0;
    public int X0;
    public CharSequence Y0;
    public TextView Z0;
    public CheckableImageButton a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public q9.g f3420b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public boolean f3421c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public CharSequence f3422d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public CharSequence f3423e1;

    public o() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.H0 = new LinkedHashSet();
        this.I0 = new LinkedHashSet();
    }

    public static int T(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(p8.d.mtrl_calendar_content_padding);
        Calendar calendarB = y.b();
        calendarB.set(5, 1);
        Calendar calendarA = y.a(calendarB);
        calendarA.get(2);
        calendarA.get(1);
        int maximum = calendarA.getMaximum(7);
        calendarA.getActualMaximum(5);
        calendarA.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(p8.d.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(p8.d.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean U(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(z7.a.B(p8.b.materialCalendarStyle, context, m.class.getCanonicalName()).data, new int[]{i});
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z2;
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.v
    public final void A(Bundle bundle) {
        super.A(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.J0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        b bVar = this.L0;
        a aVar = new a();
        int i = a.f3383b;
        int i10 = a.f3383b;
        long j5 = bVar.f3386u.f3431z;
        long j8 = bVar.f3387v.f3431z;
        aVar.f3384a = Long.valueOf(bVar.f3389x.f3431z);
        int i11 = bVar.f3390y;
        d dVar = bVar.f3388w;
        m mVar = this.M0;
        q qVar = mVar == null ? null : mVar.f3412u0;
        if (qVar != null) {
            aVar.f3384a = Long.valueOf(qVar.f3431z);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dVar);
        q qVarB = q.b(j5);
        q qVarB2 = q.b(j8);
        d dVar2 = (d) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l10 = aVar.f3384a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new b(qVarB, qVarB2, dVar2, l10 == null ? null : q.b(l10.longValue()), i11));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.N0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.O0);
        bundle.putInt("INPUT_MODE_KEY", this.Q0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.R0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.S0);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.T0);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.U0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.V0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.W0);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.X0);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.Y0);
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.v
    public final void B() {
        super.B();
        Dialog dialog = this.C0;
        if (dialog == null) {
            throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
        }
        Window window = dialog.getWindow();
        if (this.P0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f3420b1);
            if (!this.f3421c1) {
                View viewFindViewById = I().findViewById(p8.f.fullscreen_header);
                ColorStateList colorStateListK = a.a.k(viewFindViewById.getBackground());
                Integer numValueOf = colorStateListK != null ? Integer.valueOf(colorStateListK.getDefaultColor()) : null;
                int i = Build.VERSION.SDK_INT;
                boolean z2 = false;
                boolean z10 = numValueOf == null || numValueOf.intValue() == 0;
                int iL = z7.a.l(window.getContext(), R.attr.colorBackground, -16777216);
                if (z10) {
                    numValueOf = Integer.valueOf(iL);
                }
                a.a.K(window, false);
                window.getContext();
                int iD = i < 27 ? i0.b.d(z7.a.l(window.getContext(), R.attr.navigationBarColor, -16777216), 128) : 0;
                window.setStatusBarColor(0);
                window.setNavigationBarColor(iD);
                boolean z11 = z7.a.p(0) || z7.a.p(numValueOf.intValue());
                q0.e eVar = new q0.e(window.getDecorView());
                int i10 = Build.VERSION.SDK_INT;
                (i10 >= 35 ? new v1(window, eVar) : i10 >= 30 ? new u1(window, eVar) : i10 >= 26 ? new t1(window, eVar) : new s1(window, eVar)).C(z11);
                boolean zP = z7.a.p(iL);
                if (z7.a.p(iD) || (iD == 0 && zP)) {
                    z2 = true;
                }
                q0.e eVar2 = new q0.e(window.getDecorView());
                int i11 = Build.VERSION.SDK_INT;
                (i11 >= 35 ? new v1(window, eVar2) : i11 >= 30 ? new u1(window, eVar2) : i11 >= 26 ? new t1(window, eVar2) : new s1(window, eVar2)).B(z2);
                int paddingTop = viewFindViewById.getPaddingTop();
                int i12 = viewFindViewById.getLayoutParams().height;
                a0.g gVar = new a0.g();
                gVar.f59u = i12;
                gVar.f61w = viewFindViewById;
                gVar.f60v = paddingTop;
                WeakHashMap weakHashMap = o0.f10475a;
                f0.l(viewFindViewById, gVar);
                this.f3421c1 = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = m().getDimensionPixelOffset(p8.d.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f3420b1, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            View decorView = window.getDecorView();
            Dialog dialog2 = this.C0;
            if (dialog2 == null) {
                throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
            }
            decorView.setOnTouchListener(new d9.a(dialog2, rect));
        }
        H();
        int i13 = this.J0;
        if (i13 == 0) {
            S();
            throw null;
        }
        S();
        b bVar = this.L0;
        m mVar = new m();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i13);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", bVar.f3389x);
        mVar.L(bundle);
        this.M0 = mVar;
        v vVar = mVar;
        if (this.Q0 == 1) {
            S();
            b bVar2 = this.L0;
            p pVar = new p();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i13);
            bundle2.putParcelable("DATE_SELECTOR_KEY", null);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar2);
            pVar.L(bundle2);
            vVar = pVar;
        }
        this.K0 = vVar;
        this.Z0.setText((this.Q0 == 1 && m().getConfiguration().orientation == 2) ? this.f3423e1 : this.f3422d1);
        S();
        throw null;
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.v
    public final void C() {
        this.K0.f3443r0.clear();
        super.C();
    }

    @Override // androidx.fragment.app.n
    public final Dialog Q(Bundle bundle) {
        Context contextH = H();
        H();
        int i = this.J0;
        if (i == 0) {
            S();
            throw null;
        }
        Dialog dialog = new Dialog(contextH, i);
        Context context = dialog.getContext();
        this.P0 = U(context, R.attr.windowFullscreen);
        this.f3420b1 = new q9.g(context, null, p8.b.materialCalendarStyle, p8.k.Widget_MaterialComponents_MaterialCalendar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, p8.l.MaterialCalendar, p8.b.materialCalendarStyle, p8.k.Widget_MaterialComponents_MaterialCalendar);
        int color = typedArrayObtainStyledAttributes.getColor(p8.l.MaterialCalendar_backgroundTint, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f3420b1.j(context);
        this.f3420b1.l(ColorStateList.valueOf(color));
        q9.g gVar = this.f3420b1;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap weakHashMap = o0.f10475a;
        gVar.k(f0.e(decorView));
        return dialog;
    }

    public final void S() {
        if (this.A.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.fragment.app.n, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.H0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.n, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.I0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.f1378a0;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.v
    public final void v(Bundle bundle) {
        super.v(bundle);
        if (bundle == null) {
            bundle = this.A;
        }
        this.J0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.L0 = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.N0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.O0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.Q0 = bundle.getInt("INPUT_MODE_KEY");
        this.R0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.S0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.T0 = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.U0 = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.V0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.W0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.X0 = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.Y0 = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.O0;
        if (text == null) {
            text = H().getResources().getText(this.N0);
        }
        this.f3422d1 = text;
        if (text != null) {
            CharSequence[] charSequenceArrSplit = TextUtils.split(String.valueOf(text), "\n");
            if (charSequenceArrSplit.length > 1) {
                text = charSequenceArrSplit[0];
            }
        } else {
            text = null;
        }
        this.f3423e1 = text;
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(this.P0 ? p8.h.mtrl_picker_fullscreen : p8.h.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.P0) {
            viewInflate.findViewById(p8.f.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(T(context), -2));
        } else {
            viewInflate.findViewById(p8.f.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(T(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(p8.f.mtrl_picker_header_selection_text);
        WeakHashMap weakHashMap = o0.f10475a;
        textView.setAccessibilityLiveRegion(1);
        this.a1 = (CheckableImageButton) viewInflate.findViewById(p8.f.mtrl_picker_header_toggle);
        this.Z0 = (TextView) viewInflate.findViewById(p8.f.mtrl_picker_title_text);
        this.a1.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.a1;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, com.bumptech.glide.d.p(context, p8.e.material_ic_calendar_black_24dp));
        int i = 0;
        stateListDrawable.addState(new int[0], com.bumptech.glide.d.p(context, p8.e.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.a1.setChecked(this.Q0 != 0);
        o0.n(this.a1, null);
        CheckableImageButton checkableImageButton2 = this.a1;
        this.a1.setContentDescription(this.Q0 == 1 ? checkableImageButton2.getContext().getString(p8.j.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton2.getContext().getString(p8.j.mtrl_picker_toggle_to_text_input_mode));
        this.a1.setOnClickListener(new n(i, this));
        S();
        throw null;
    }
}
