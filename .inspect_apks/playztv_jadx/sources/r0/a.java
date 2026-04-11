package r0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f11207u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e f11208v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11209w;

    public a(int i, e eVar, int i10) {
        this.f11207u = i;
        this.f11208v = eVar;
        this.f11209w = i10;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f11207u);
        this.f11208v.f11226a.performAction(this.f11209w, bundle);
    }
}
