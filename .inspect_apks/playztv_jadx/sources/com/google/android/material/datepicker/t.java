package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.WeakHashMap;
import q0.b0;
import q0.o0;
import q4.x0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t extends x0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f3439u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final MaterialCalendarGridView f3440v;

    public t(LinearLayout linearLayout, boolean z2) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(p8.f.month_title);
        this.f3439u = textView;
        WeakHashMap weakHashMap = o0.f10475a;
        new b0(d0.c.tag_accessibility_heading, Boolean.class, 0, 28, 2).f(textView, Boolean.TRUE);
        this.f3440v = (MaterialCalendarGridView) linearLayout.findViewById(p8.f.month_grid);
        if (z2) {
            return;
        }
        textView.setVisibility(8);
    }
}
