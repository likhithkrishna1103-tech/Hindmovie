package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p6.c f1207v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1208w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1209x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ y f1210y;

    public x(y yVar, p6.c cVar) {
        this.f1210y = yVar;
        this.f1207v = cVar;
    }

    public final void b(boolean z10) {
        if (z10 == this.f1208w) {
            return;
        }
        this.f1208w = z10;
        int i = z10 ? 1 : -1;
        y yVar = this.f1210y;
        int i10 = yVar.f1214c;
        yVar.f1214c = i + i10;
        if (!yVar.f1215d) {
            yVar.f1215d = true;
            while (true) {
                try {
                    int i11 = yVar.f1214c;
                    if (i10 == i11) {
                        break;
                    } else {
                        i10 = i11;
                    }
                } finally {
                    yVar.f1215d = false;
                }
            }
        }
        if (this.f1208w) {
            yVar.c(this);
        }
    }

    public abstract boolean d();

    public void c() {
    }
}
