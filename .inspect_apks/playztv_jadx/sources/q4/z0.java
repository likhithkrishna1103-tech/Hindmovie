package q4;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10985a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f10986b;

    public z0(w wVar) {
        this.f10986b = wVar;
    }

    @Override // q4.k0
    public final void a(RecyclerView recyclerView, int i) {
        if (i == 0 && this.f10985a) {
            this.f10985a = false;
            this.f10986b.f();
        }
    }

    @Override // q4.k0
    public final void b(RecyclerView recyclerView, int i, int i10) {
        if (i == 0 && i10 == 0) {
            return;
        }
        this.f10985a = true;
    }
}
