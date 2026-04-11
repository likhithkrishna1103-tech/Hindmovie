package v4;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f13260a;

    public i(j jVar) {
        this.f13260a = jVar;
    }

    @Override // v4.k0
    public final void b(RecyclerView recyclerView, int i, int i10) {
        int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        j jVar = this.f13260a;
        int i11 = jVar.f13265a;
        int iComputeVerticalScrollRange = jVar.f13281s.computeVerticalScrollRange();
        int i12 = jVar.f13280r;
        jVar.f13282t = iComputeVerticalScrollRange - i12 > 0 && i12 >= i11;
        int iComputeHorizontalScrollRange = jVar.f13281s.computeHorizontalScrollRange();
        int i13 = jVar.f13279q;
        boolean z10 = iComputeHorizontalScrollRange - i13 > 0 && i13 >= i11;
        jVar.f13283u = z10;
        boolean z11 = jVar.f13282t;
        if (!z11 && !z10) {
            if (jVar.f13284v != 0) {
                jVar.f(0);
                return;
            }
            return;
        }
        if (z11) {
            float f = i12;
            jVar.f13274l = (int) ((((f / 2.0f) + iComputeVerticalScrollOffset) * f) / iComputeVerticalScrollRange);
            jVar.f13273k = Math.min(i12, (i12 * i12) / iComputeVerticalScrollRange);
        }
        if (jVar.f13283u) {
            float f10 = iComputeHorizontalScrollOffset;
            float f11 = i13;
            jVar.f13277o = (int) ((((f11 / 2.0f) + f10) * f11) / iComputeHorizontalScrollRange);
            jVar.f13276n = Math.min(i13, (i13 * i13) / iComputeHorizontalScrollRange);
        }
        int i14 = jVar.f13284v;
        if (i14 == 0 || i14 == 1) {
            jVar.f(1);
        }
    }
}
