package q4;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f10830a;

    public i(j jVar) {
        this.f10830a = jVar;
    }

    @Override // q4.k0
    public final void b(RecyclerView recyclerView, int i, int i10) {
        int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        j jVar = this.f10830a;
        int i11 = jVar.f10835a;
        int iComputeVerticalScrollRange = jVar.f10851s.computeVerticalScrollRange();
        int i12 = jVar.f10850r;
        jVar.f10852t = iComputeVerticalScrollRange - i12 > 0 && i12 >= i11;
        int iComputeHorizontalScrollRange = jVar.f10851s.computeHorizontalScrollRange();
        int i13 = jVar.f10849q;
        boolean z2 = iComputeHorizontalScrollRange - i13 > 0 && i13 >= i11;
        jVar.f10853u = z2;
        boolean z10 = jVar.f10852t;
        if (!z10 && !z2) {
            if (jVar.f10854v != 0) {
                jVar.f(0);
                return;
            }
            return;
        }
        if (z10) {
            float f = i12;
            jVar.f10844l = (int) ((((f / 2.0f) + iComputeVerticalScrollOffset) * f) / iComputeVerticalScrollRange);
            jVar.f10843k = Math.min(i12, (i12 * i12) / iComputeVerticalScrollRange);
        }
        if (jVar.f10853u) {
            float f4 = iComputeHorizontalScrollOffset;
            float f10 = i13;
            jVar.f10847o = (int) ((((f10 / 2.0f) + f4) * f10) / iComputeHorizontalScrollRange);
            jVar.f10846n = Math.min(i13, (i13 * i13) / iComputeHorizontalScrollRange);
        }
        int i14 = jVar.f10854v;
        if (i14 == 0 || i14 == 1) {
            jVar.f(1);
        }
    }
}
