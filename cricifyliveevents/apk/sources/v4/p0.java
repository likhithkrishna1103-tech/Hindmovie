package v4;

import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f13325a;

    public p0(RecyclerView recyclerView) {
        this.f13325a = recyclerView;
    }

    public final void a() {
        RecyclerView recyclerView = this.f13325a;
        if (!recyclerView.O || !recyclerView.N) {
            recyclerView.V = true;
            recyclerView.requestLayout();
        } else {
            w wVar = recyclerView.D;
            WeakHashMap weakHashMap = t0.m0.f11777a;
            recyclerView.postOnAnimation(wVar);
        }
    }
}
