package v4;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements t0.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f13404v;

    public /* synthetic */ y(RecyclerView recyclerView) {
        this.f13404v = recyclerView;
    }

    @Override // t0.h
    public void C() {
        this.f13404v.o0();
    }

    @Override // t0.h
    public boolean q(float f) {
        int i;
        int i10;
        RecyclerView recyclerView = this.f13404v;
        if (recyclerView.I.e()) {
            i10 = (int) f;
            i = 0;
        } else if (recyclerView.I.d()) {
            i = (int) f;
            i10 = 0;
        } else {
            i = 0;
            i10 = 0;
        }
        if (i == 0 && i10 == 0) {
            return false;
        }
        recyclerView.o0();
        return recyclerView.I(i, i10, 0, Integer.MAX_VALUE);
    }

    @Override // t0.h
    public float z() {
        float f;
        RecyclerView recyclerView = this.f13404v;
        if (recyclerView.I.e()) {
            f = recyclerView.f1450w0;
        } else {
            if (!recyclerView.I.d()) {
                return 0.0f;
            }
            f = recyclerView.f1448v0;
        }
        return -f;
    }
}
