package p0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f9869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9870c;

    public final void a(b bVar) {
        synchronized (this) {
            while (this.f9870c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (this.f9869b == bVar) {
                return;
            }
            this.f9869b = bVar;
            if (this.f9868a) {
                bVar.onCancel();
            }
        }
    }
}
