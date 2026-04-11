package c;

import android.view.View;
import android.view.Window;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements androidx.lifecycle.q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1955v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f1956w;

    public /* synthetic */ h(int i, Object obj) {
        this.f1955v = i;
        this.f1956w = obj;
    }

    @Override // androidx.lifecycle.q
    public final void a(androidx.lifecycle.s sVar, androidx.lifecycle.m mVar) {
        Window window;
        View viewPeekDecorView;
        switch (this.f1955v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h.j jVar = (h.j) this.f1956w;
                if (mVar == androidx.lifecycle.m.ON_STOP && (window = jVar.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                    viewPeekDecorView.cancelPendingInputEvents();
                    break;
                }
                break;
            case 1:
                h.j jVar2 = (h.j) this.f1956w;
                if (mVar == androidx.lifecycle.m.ON_DESTROY) {
                    jVar2.f1975w.f7898w = null;
                    if (!jVar2.isChangingConfigurations()) {
                        jVar2.e().a();
                    }
                    j jVar3 = jVar2.A;
                    h.j jVar4 = jVar3.f1963y;
                    jVar4.getWindow().getDecorView().removeCallbacks(jVar3);
                    jVar4.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(jVar3);
                }
                break;
            default:
                b5.e eVar = (b5.e) this.f1956w;
                ge.i.e(eVar, "this$0");
                if (mVar == androidx.lifecycle.m.ON_START) {
                    eVar.f1787c = true;
                } else if (mVar == androidx.lifecycle.m.ON_STOP) {
                    eVar.f1787c = false;
                }
                break;
        }
    }
}
