package o;

import android.widget.AbsListView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e2 implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g2 f9204a;

    public e2(g2 g2Var) {
        this.f9204a = g2Var;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        g2 g2Var = this.f9204a;
        c2 c2Var = g2Var.M;
        y yVar = g2Var.U;
        if (i != 1 || yVar.getInputMethodMode() == 2 || yVar.getContentView() == null) {
            return;
        }
        g2Var.Q.removeCallbacks(c2Var);
        c2Var.run();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i10, int i11) {
    }
}
