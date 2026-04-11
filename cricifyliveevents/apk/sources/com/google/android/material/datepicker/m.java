package com.google.android.material.datepicker;

import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import t0.m0;
import v4.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m<S> extends w {
    public View A0;
    public View B0;
    public View C0;
    public View D0;
    public MaterialButton E0;
    public AccessibilityManager F0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f2866t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public b f2867u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public r f2868v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f2869w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public c f2870x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public RecyclerView f2871y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public RecyclerView f2872z0;

    @Override // androidx.fragment.app.y
    public final void D(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f2866t0);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f2867u0);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f2868v0);
    }

    public final void R(r rVar) {
        v vVar = (v) this.f2872z0.getAdapter();
        int iD = vVar.f2901d.f2843v.d(rVar);
        AccessibilityManager accessibilityManager = this.F0;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            int iD2 = iD - vVar.f2901d.f2843v.d(this.f2868v0);
            boolean z10 = Math.abs(iD2) > 3;
            boolean z11 = iD2 > 0;
            this.f2868v0 = rVar;
            if (z10 && z11) {
                this.f2872z0.g0(iD - 3);
                this.f2872z0.post(new androidx.emoji2.text.k(iD, 1, this));
            } else if (z10) {
                this.f2872z0.g0(iD + 3);
                this.f2872z0.post(new androidx.emoji2.text.k(iD, 1, this));
            } else {
                this.f2872z0.post(new androidx.emoji2.text.k(iD, 1, this));
            }
        } else {
            this.f2868v0 = rVar;
            this.f2872z0.g0(iD);
        }
        T(iD);
    }

    public final void S(int i) {
        this.f2869w0 = i;
        if (i == 2) {
            this.f2871y0.getLayoutManager().r0(this.f2868v0.f2889x - ((b0) this.f2871y0.getAdapter()).f2848d.f2867u0.f2843v.f2889x);
            this.C0.setVisibility(0);
            this.D0.setVisibility(8);
            this.A0.setVisibility(8);
            this.B0.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.C0.setVisibility(8);
            this.D0.setVisibility(0);
            this.A0.setVisibility(0);
            this.B0.setVisibility(0);
            R(this.f2868v0);
        }
    }

    public final void T(int i) {
        this.B0.setEnabled(i + 1 < this.f2872z0.getAdapter().a());
        this.A0.setEnabled(i - 1 >= 0);
    }

    @Override // androidx.fragment.app.y
    public final void w(Bundle bundle) {
        super.w(bundle);
        if (bundle == null) {
            bundle = this.B;
        }
        this.f2866t0 = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("GRID_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.f2867u0 = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.f2868v0 = (r) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i;
        int i10;
        v4.v vVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(j(), this.f2866t0);
        this.f2870x0 = new c(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.F0 = (AccessibilityManager) K().getSystemService("accessibility");
        r rVar = this.f2867u0.f2843v;
        if (p.X(contextThemeWrapper, R.attr.windowFullscreen)) {
            i = k9.h.mtrl_calendar_vertical;
            i10 = 1;
        } else {
            i = k9.h.mtrl_calendar_horizontal;
            i10 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        Resources resources = K().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(k9.d.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(k9.d.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(k9.d.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(k9.d.mtrl_calendar_days_of_week_height);
        int i11 = s.f2892y;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(k9.d.mtrl_calendar_month_vertical_padding) * (i11 - 1)) + (resources.getDimensionPixelSize(k9.d.mtrl_calendar_day_height) * i11) + resources.getDimensionPixelOffset(k9.d.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(k9.f.mtrl_calendar_days_of_week);
        m0.n(gridView, new g(0));
        int i12 = this.f2867u0.f2847z;
        gridView.setAdapter((ListAdapter) (i12 > 0 ? new e(i12) : new e()));
        gridView.setNumColumns(rVar.f2890y);
        gridView.setEnabled(false);
        this.f2872z0 = (RecyclerView) viewInflate.findViewById(k9.f.mtrl_calendar_months);
        this.f2872z0.setLayoutManager(new h(this, i10, i10));
        this.f2872z0.setTag("MONTHS_VIEW_GROUP_TAG");
        v vVar2 = new v(contextThemeWrapper, this.f2867u0, new p6.d(5, this));
        this.f2872z0.setAdapter(vVar2);
        int integer = contextThemeWrapper.getResources().getInteger(k9.g.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) viewInflate.findViewById(k9.f.mtrl_calendar_year_selector_frame);
        this.f2871y0 = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.f2871y0.setLayoutManager(new GridLayoutManager(integer, 0));
            this.f2871y0.setAdapter(new b0(this));
            RecyclerView recyclerView4 = this.f2871y0;
            i iVar = new i();
            z.c(null);
            z.c(null);
            recyclerView4.i(iVar);
        }
        View viewFindViewById = viewInflate.findViewById(k9.f.month_navigation_fragment_toggle);
        b bVar = vVar2.f2901d;
        if (viewFindViewById != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(k9.f.month_navigation_fragment_toggle);
            this.E0 = materialButton;
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            m0.n(this.E0, new j(0, this));
            View viewFindViewById2 = viewInflate.findViewById(k9.f.month_navigation_previous);
            this.A0 = viewFindViewById2;
            viewFindViewById2.setTag("NAVIGATION_PREV_TAG");
            View viewFindViewById3 = viewInflate.findViewById(k9.f.month_navigation_next);
            this.B0 = viewFindViewById3;
            viewFindViewById3.setTag("NAVIGATION_NEXT_TAG");
            this.C0 = viewInflate.findViewById(k9.f.mtrl_calendar_year_selector_frame);
            this.D0 = viewInflate.findViewById(k9.f.mtrl_calendar_day_selector_frame);
            S(1);
            this.E0.setText(this.f2868v0.c());
            this.f2872z0.j(new k(this, vVar2));
            this.E0.setOnClickListener(new l(0, this));
            this.B0.setOnClickListener(new f(this, vVar2, 1));
            this.A0.setOnClickListener(new f(this, vVar2, 0));
            T(bVar.f2843v.d(this.f2868v0));
        }
        if (!p.X(contextThemeWrapper, R.attr.windowFullscreen) && (recyclerView2 = (vVar = new v4.v()).f13374a) != (recyclerView = this.f2872z0)) {
            z0 z0Var = vVar.f13375b;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.D0;
                if (arrayList != null) {
                    arrayList.remove(z0Var);
                }
                vVar.f13374a.setOnFlingListener(null);
            }
            vVar.f13374a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() != null) {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
                vVar.f13374a.j(z0Var);
                vVar.f13374a.setOnFlingListener(vVar);
                new Scroller(vVar.f13374a.getContext(), new DecelerateInterpolator());
                vVar.f();
            }
        }
        this.f2872z0.g0(bVar.f2843v.d(this.f2868v0));
        m0.n(this.f2872z0, new g(1));
        return viewInflate;
    }
}
