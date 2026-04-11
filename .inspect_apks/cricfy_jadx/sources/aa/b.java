package aa;

import androidx.appcompat.widget.ActionBarContextView;
import t0.r0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f376c;

    @Override // t0.r0
    public void a() {
        if (this.f374a) {
            return;
        }
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.f376c;
        actionBarContextView.A = null;
        super/*android.view.ViewGroup*/.setVisibility(this.f375b);
    }

    @Override // t0.r0
    public void b() {
        this.f374a = true;
    }

    @Override // t0.r0
    public void c() {
        super/*android.view.ViewGroup*/.setVisibility(0);
        this.f374a = false;
    }
}
