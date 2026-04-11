package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.WeakHashMap;
import t0.m0;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends x0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f2899u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final MaterialCalendarGridView f2900v;

    public u(LinearLayout linearLayout, boolean z10) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(k9.f.month_title);
        this.f2899u = textView;
        WeakHashMap weakHashMap = m0.f11777a;
        new t0.z(g0.c.tag_accessibility_heading, Boolean.class, 0, 28, 3).f(textView, Boolean.TRUE);
        this.f2900v = (MaterialCalendarGridView) linearLayout.findViewById(k9.f.month_grid);
        if (z10) {
            return;
        }
        textView.setVisibility(8);
    }
}
