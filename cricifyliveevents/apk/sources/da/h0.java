package da;

import android.widget.ImageButton;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h0 extends ImageButton {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3619v;

    public final void a(int i, boolean z10) {
        super.setVisibility(i);
        if (z10) {
            this.f3619v = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f3619v;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        a(i, true);
    }
}
