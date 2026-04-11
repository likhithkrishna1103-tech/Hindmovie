package n8;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f8872a;

    public h(d dVar) {
        this.f8872a = dVar;
    }

    @Override // n8.b
    public final void a(boolean z10) {
        a9.k kVar = this.f8872a.H;
        kVar.sendMessage(kVar.obtainMessage(1, Boolean.valueOf(z10)));
    }
}
