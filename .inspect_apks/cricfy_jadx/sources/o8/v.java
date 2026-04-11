package o8;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends Exception {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l8.b f9698v;

    public v(l8.b bVar) {
        u.a("ResolvableConnectionException can only be created with a connection result containing a resolution.", (bVar.f7878w == 0 || bVar.f7879x == null) ? false : true);
        this.f9698v = bVar;
    }
}
