package n;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c2 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8362u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ f2 f8363v;

    public /* synthetic */ c2(f2 f2Var, int i) {
        this.f8362u = i;
        this.f8363v = f2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8362u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                t1 t1Var = this.f8363v.f8383w;
                if (t1Var != null) {
                    t1Var.setListSelectionHidden(true);
                    t1Var.requestLayout();
                }
                break;
            default:
                f2 f2Var = this.f8363v;
                t1 t1Var2 = f2Var.f8383w;
                if (t1Var2 != null && t1Var2.isAttachedToWindow() && f2Var.f8383w.getCount() > f2Var.f8383w.getChildCount() && f2Var.f8383w.getChildCount() <= f2Var.G) {
                    f2Var.T.setInputMethodMode(2);
                    f2Var.d();
                    break;
                }
                break;
        }
    }
}
