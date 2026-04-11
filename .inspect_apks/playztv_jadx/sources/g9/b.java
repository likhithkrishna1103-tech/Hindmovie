package g9;

import androidx.appcompat.widget.ActionBarContextView;
import q0.u0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f5333c;

    @Override // q0.u0
    public void a() {
        if (this.f5331a) {
            return;
        }
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.f5333c;
        actionBarContextView.f877z = null;
        super/*android.view.ViewGroup*/.setVisibility(this.f5332b);
    }

    @Override // q0.u0
    public void b() {
        this.f5331a = true;
    }

    @Override // q0.u0
    public void c() {
        super/*android.view.ViewGroup*/.setVisibility(0);
        this.f5331a = false;
    }
}
