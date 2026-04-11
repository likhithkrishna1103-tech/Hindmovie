package j9;

import android.widget.ImageButton;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class k0 extends ImageButton {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6893u;

    public final void a(int i, boolean z2) {
        super.setVisibility(i);
        if (z2) {
            this.f6893u = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f6893u;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        a(i, true);
    }
}
