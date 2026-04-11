package m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f8277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8278c;

    public final void a(b bVar) {
        synchronized (this) {
            while (this.f8278c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (this.f8277b == bVar) {
                return;
            }
            this.f8277b = bVar;
            if (this.f8276a) {
                bVar.onCancel();
            }
        }
    }
}
