package q4;

import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f10896a;

    public p0(RecyclerView recyclerView) {
        this.f10896a = recyclerView;
    }

    public final void a() {
        RecyclerView recyclerView = this.f10896a;
        if (!recyclerView.N || !recyclerView.M) {
            recyclerView.U = true;
            recyclerView.requestLayout();
        } else {
            x xVar = recyclerView.C;
            WeakHashMap weakHashMap = q0.o0.f10475a;
            recyclerView.postOnAnimation(xVar);
        }
    }
}
