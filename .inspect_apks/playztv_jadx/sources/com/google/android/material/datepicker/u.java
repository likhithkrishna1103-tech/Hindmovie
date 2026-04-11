package com.google.android.material.datepicker;

import android.R;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.Calendar;
import q4.i0;
import q4.x0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends q4.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f3441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u5.c f3442e;
    public final int f;

    public u(ContextThemeWrapper contextThemeWrapper, b bVar, u5.c cVar) {
        q qVar = bVar.f3386u;
        q qVar2 = bVar.f3387v;
        q qVar3 = bVar.f3389x;
        if (qVar.f3426u.compareTo(qVar3.f3426u) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (qVar3.f3426u.compareTo(qVar2.f3426u) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f = (contextThemeWrapper.getResources().getDimensionPixelSize(p8.d.mtrl_calendar_day_height) * r.f3432x) + (o.U(contextThemeWrapper, R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(p8.d.mtrl_calendar_day_height) : 0);
        this.f3441d = bVar;
        this.f3442e = cVar;
        if (this.f10982a.a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.f10983b = true;
    }

    @Override // q4.z
    public final int a() {
        return this.f3441d.A;
    }

    @Override // q4.z
    public final long b(int i) {
        Calendar calendarA = y.a(this.f3441d.f3386u.f3426u);
        calendarA.add(2, i);
        calendarA.set(5, 1);
        Calendar calendarA2 = y.a(calendarA);
        calendarA2.get(2);
        calendarA2.get(1);
        calendarA2.getMaximum(7);
        calendarA2.getActualMaximum(5);
        calendarA2.getTimeInMillis();
        return calendarA2.getTimeInMillis();
    }

    @Override // q4.z
    public final void d(x0 x0Var, int i) {
        t tVar = (t) x0Var;
        b bVar = this.f3441d;
        Calendar calendarA = y.a(bVar.f3386u.f3426u);
        calendarA.add(2, i);
        q qVar = new q(calendarA);
        tVar.f3439u.setText(qVar.c());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) tVar.f3440v.findViewById(p8.f.month_grid);
        if (materialCalendarGridView.a() == null || !qVar.equals(materialCalendarGridView.a().f3434u)) {
            new r(qVar, bVar);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.a().getClass();
        throw null;
    }

    @Override // q4.z
    public final x0 e(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(p8.h.mtrl_calendar_month_labeled, viewGroup, false);
        if (!o.U(viewGroup.getContext(), R.attr.windowFullscreen)) {
            return new t(linearLayout, false);
        }
        linearLayout.setLayoutParams(new i0(-1, this.f));
        return new t(linearLayout, true);
    }
}
