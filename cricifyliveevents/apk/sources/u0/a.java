package u0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f12043v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f12044w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f12045x;

    public a(int i, e eVar, int i10) {
        this.f12043v = i;
        this.f12044w = eVar;
        this.f12045x = i10;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f12043v);
        this.f12044w.f12062a.performAction(this.f12045x, bundle);
    }
}
