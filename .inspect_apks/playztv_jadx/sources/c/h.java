package c;

import android.view.View;
import android.view.Window;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements androidx.lifecycle.q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2168u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f2169v;

    public /* synthetic */ h(int i, Object obj) {
        this.f2168u = i;
        this.f2169v = obj;
    }

    @Override // androidx.lifecycle.q
    public final void a(androidx.lifecycle.s sVar, androidx.lifecycle.m mVar) {
        Window window;
        View viewPeekDecorView;
        switch (this.f2168u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h.j jVar = (h.j) this.f2169v;
                if (mVar == androidx.lifecycle.m.ON_STOP && (window = jVar.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                    viewPeekDecorView.cancelPendingInputEvents();
                    break;
                }
                break;
            case 1:
                h.j jVar2 = (h.j) this.f2169v;
                if (mVar == androidx.lifecycle.m.ON_DESTROY) {
                    jVar2.f2182v.f11048v = null;
                    if (!jVar2.isChangingConfigurations()) {
                        jVar2.e().a();
                    }
                    j jVar3 = jVar2.f2186z;
                    h.j jVar4 = jVar3.f2174x;
                    jVar4.getWindow().getDecorView().removeCallbacks(jVar3);
                    jVar4.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(jVar3);
                }
                break;
            default:
                n.s sVar2 = (n.s) this.f2169v;
                be.h.e(sVar2, "this$0");
                if (mVar == androidx.lifecycle.m.ON_START) {
                    sVar2.f8526e = true;
                } else if (mVar == androidx.lifecycle.m.ON_STOP) {
                    sVar2.f8526e = false;
                }
                break;
        }
    }
}
