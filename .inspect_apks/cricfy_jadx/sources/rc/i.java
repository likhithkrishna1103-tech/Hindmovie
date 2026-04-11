package rc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f10961a;

    public i(j jVar) {
        this.f10961a = jVar;
    }

    public final void a() {
        j jVar = this.f10961a;
        synchronized (jVar) {
            jVar.f10967d = true;
        }
        this.f10961a.g();
    }
}
