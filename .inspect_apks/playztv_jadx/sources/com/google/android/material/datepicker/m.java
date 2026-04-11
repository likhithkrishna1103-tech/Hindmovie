package com.google.android.material.datepicker;

import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import q0.o0;
import q4.z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m<S> extends v {
    public View A0;
    public View B0;
    public View C0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f3410s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public b f3411t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public q f3412u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f3413v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public c f3414w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public RecyclerView f3415x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public RecyclerView f3416y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public View f3417z0;

    @Override // androidx.fragment.app.v
    public final void A(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f3410s0);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f3411t0);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f3412u0);
    }

    public final void P(q qVar) {
        u uVar = (u) this.f3416y0.getAdapter();
        int iD = uVar.f3441d.f3386u.d(qVar);
        int iD2 = iD - uVar.f3441d.f3386u.d(this.f3412u0);
        boolean z2 = Math.abs(iD2) > 3;
        boolean z10 = iD2 > 0;
        this.f3412u0 = qVar;
        if (z2 && z10) {
            this.f3416y0.g0(iD - 3);
            this.f3416y0.post(new androidx.emoji2.text.k(iD, 1, this));
        } else if (!z2) {
            this.f3416y0.post(new androidx.emoji2.text.k(iD, 1, this));
        } else {
            this.f3416y0.g0(iD + 3);
            this.f3416y0.post(new androidx.emoji2.text.k(iD, 1, this));
        }
    }

    public final void Q(int i) {
        this.f3413v0 = i;
        if (i == 2) {
            this.f3415x0.getLayoutManager().r0(this.f3412u0.f3428w - ((a0) this.f3415x0.getAdapter()).f3385d.f3411t0.f3386u.f3428w);
            this.B0.setVisibility(0);
            this.C0.setVisibility(8);
            this.f3417z0.setVisibility(8);
            this.A0.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.B0.setVisibility(8);
            this.C0.setVisibility(0);
            this.f3417z0.setVisibility(0);
            this.A0.setVisibility(0);
            P(this.f3412u0);
        }
    }

    @Override // androidx.fragment.app.v
    public final void v(Bundle bundle) {
        super.v(bundle);
        if (bundle == null) {
            bundle = this.A;
        }
        this.f3410s0 = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("GRID_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.f3411t0 = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.f3412u0 = (q) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i;
        int i10;
        q4.w wVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(j(), this.f3410s0);
        this.f3414w0 = new c(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        q qVar = this.f3411t0.f3386u;
        if (o.U(contextThemeWrapper, R.attr.windowFullscreen)) {
            i = p8.h.mtrl_calendar_vertical;
            i10 = 1;
        } else {
            i = p8.h.mtrl_calendar_horizontal;
            i10 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        Resources resources = H().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(p8.d.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(p8.d.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(p8.d.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(p8.d.mtrl_calendar_days_of_week_height);
        int i11 = r.f3432x;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(p8.d.mtrl_calendar_month_vertical_padding) * (i11 - 1)) + (resources.getDimensionPixelSize(p8.d.mtrl_calendar_day_height) * i11) + resources.getDimensionPixelOffset(p8.d.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(p8.f.mtrl_calendar_days_of_week);
        o0.n(gridView, new g(0));
        int i12 = this.f3411t0.f3390y;
        gridView.setAdapter((ListAdapter) (i12 > 0 ? new e(i12) : new e()));
        gridView.setNumColumns(qVar.f3429x);
        gridView.setEnabled(false);
        this.f3416y0 = (RecyclerView) viewInflate.findViewById(p8.f.mtrl_calendar_months);
        this.f3416y0.setLayoutManager(new h(this, i10, i10));
        this.f3416y0.setTag("MONTHS_VIEW_GROUP_TAG");
        u uVar = new u(contextThemeWrapper, this.f3411t0, new u5.c(8, this));
        this.f3416y0.setAdapter(uVar);
        int integer = contextThemeWrapper.getResources().getInteger(p8.g.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) viewInflate.findViewById(p8.f.mtrl_calendar_year_selector_frame);
        this.f3415x0 = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.f3415x0.setLayoutManager(new GridLayoutManager(integer, 0));
            this.f3415x0.setAdapter(new a0(this));
            RecyclerView recyclerView4 = this.f3415x0;
            i iVar = new i();
            y.c(null);
            y.c(null);
            recyclerView4.i(iVar);
        }
        if (viewInflate.findViewById(p8.f.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(p8.f.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            o0.n(materialButton, new j(0, this));
            View viewFindViewById = viewInflate.findViewById(p8.f.month_navigation_previous);
            this.f3417z0 = viewFindViewById;
            viewFindViewById.setTag("NAVIGATION_PREV_TAG");
            View viewFindViewById2 = viewInflate.findViewById(p8.f.month_navigation_next);
            this.A0 = viewFindViewById2;
            viewFindViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.B0 = viewInflate.findViewById(p8.f.mtrl_calendar_year_selector_frame);
            this.C0 = viewInflate.findViewById(p8.f.mtrl_calendar_day_selector_frame);
            Q(1);
            materialButton.setText(this.f3412u0.c());
            this.f3416y0.j(new k(this, uVar, materialButton));
            materialButton.setOnClickListener(new l(0, this));
            this.A0.setOnClickListener(new f(this, uVar, 1));
            this.f3417z0.setOnClickListener(new f(this, uVar, 0));
        }
        if (!o.U(contextThemeWrapper, R.attr.windowFullscreen) && (recyclerView2 = (wVar = new q4.w()).f10949a) != (recyclerView = this.f3416y0)) {
            z0 z0Var = wVar.f10950b;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.C0;
                if (arrayList != null) {
                    arrayList.remove(z0Var);
                }
                wVar.f10949a.setOnFlingListener(null);
            }
            wVar.f10949a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() != null) {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
                wVar.f10949a.j(z0Var);
                wVar.f10949a.setOnFlingListener(wVar);
                new Scroller(wVar.f10949a.getContext(), new DecelerateInterpolator());
                wVar.f();
            }
        }
        this.f3416y0.g0(uVar.f3441d.f3386u.d(this.f3412u0));
        o0.n(this.f3416y0, new g(1));
        return viewInflate;
    }
}
