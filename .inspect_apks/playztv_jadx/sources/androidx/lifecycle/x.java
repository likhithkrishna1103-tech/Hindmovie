package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final u5.c f1511u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1512v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1513w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ y f1514x;

    public x(y yVar, u5.c cVar) {
        this.f1514x = yVar;
        this.f1511u = cVar;
    }

    public final void b(boolean z2) {
        if (z2 == this.f1512v) {
            return;
        }
        this.f1512v = z2;
        int i = z2 ? 1 : -1;
        y yVar = this.f1514x;
        int i10 = yVar.f1518c;
        yVar.f1518c = i + i10;
        if (!yVar.f1519d) {
            yVar.f1519d = true;
            while (true) {
                try {
                    int i11 = yVar.f1518c;
                    if (i10 == i11) {
                        break;
                    } else {
                        i10 = i11;
                    }
                } finally {
                    yVar.f1519d = false;
                }
            }
        }
        if (this.f1512v) {
            yVar.c(this);
        }
    }

    public abstract boolean e();

    public void c() {
    }
}
