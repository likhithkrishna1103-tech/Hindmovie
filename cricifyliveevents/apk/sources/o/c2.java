package o;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c2 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9185v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ g2 f9186w;

    public /* synthetic */ c2(g2 g2Var, int i) {
        this.f9185v = i;
        this.f9186w = g2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9185v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                t1 t1Var = this.f9186w.f9231x;
                if (t1Var != null) {
                    t1Var.setListSelectionHidden(true);
                    t1Var.requestLayout();
                }
                break;
            default:
                g2 g2Var = this.f9186w;
                t1 t1Var2 = g2Var.f9231x;
                if (t1Var2 != null && t1Var2.isAttachedToWindow() && g2Var.f9231x.getCount() > g2Var.f9231x.getChildCount() && g2Var.f9231x.getChildCount() <= g2Var.H) {
                    g2Var.U.setInputMethodMode(2);
                    g2Var.d();
                    break;
                }
                break;
        }
    }
}
