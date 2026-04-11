package com.google.android.material.datepicker;

import android.R;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.Calendar;
import v4.i0;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends v4.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f2901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p6.d f2902e;
    public final int f;

    public v(ContextThemeWrapper contextThemeWrapper, b bVar, p6.d dVar) {
        r rVar = bVar.f2843v;
        r rVar2 = bVar.f2844w;
        r rVar3 = bVar.f2846y;
        if (rVar.f2887v.compareTo(rVar3.f2887v) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (rVar3.f2887v.compareTo(rVar2.f2887v) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f = (contextThemeWrapper.getResources().getDimensionPixelSize(k9.d.mtrl_calendar_day_height) * s.f2892y) + (p.X(contextThemeWrapper, R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(k9.d.mtrl_calendar_day_height) : 0);
        this.f2901d = bVar;
        this.f2902e = dVar;
        if (this.f13407a.a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.f13408b = true;
    }

    @Override // v4.z
    public final int a() {
        return this.f2901d.B;
    }

    @Override // v4.z
    public final long b(int i) {
        Calendar calendarA = z.a(this.f2901d.f2843v.f2887v);
        calendarA.add(2, i);
        calendarA.set(5, 1);
        Calendar calendarA2 = z.a(calendarA);
        calendarA2.get(2);
        calendarA2.get(1);
        calendarA2.getMaximum(7);
        calendarA2.getActualMaximum(5);
        calendarA2.getTimeInMillis();
        return calendarA2.getTimeInMillis();
    }

    @Override // v4.z
    public final void e(x0 x0Var, int i) {
        u uVar = (u) x0Var;
        b bVar = this.f2901d;
        Calendar calendarA = z.a(bVar.f2843v.f2887v);
        calendarA.add(2, i);
        r rVar = new r(calendarA);
        uVar.f2899u.setText(rVar.c());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) uVar.f2900v.findViewById(k9.f.month_grid);
        if (materialCalendarGridView.a() == null || !rVar.equals(materialCalendarGridView.a().f2894v)) {
            new s(rVar, bVar);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.a().getClass();
        throw null;
    }

    @Override // v4.z
    public final x0 f(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(k9.h.mtrl_calendar_month_labeled, viewGroup, false);
        if (!p.X(viewGroup.getContext(), R.attr.windowFullscreen)) {
            return new u(linearLayout, false);
        }
        linearLayout.setLayoutParams(new i0(-1, this.f));
        return new u(linearLayout, true);
    }
}
