package n;

import android.widget.AbsListView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d2 implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f2 f8372a;

    public d2(f2 f2Var) {
        this.f8372a = f2Var;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        f2 f2Var = this.f8372a;
        c2 c2Var = f2Var.L;
        a0 a0Var = f2Var.T;
        if (i != 1 || a0Var.getInputMethodMode() == 2 || a0Var.getContentView() == null) {
            return;
        }
        f2Var.P.removeCallbacks(c2Var);
        c2Var.run();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i10, int i11) {
    }
}
