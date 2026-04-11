package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public enum x implements cc.f {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("LOG_ENVIRONMENT_UNKNOWN"),
    /* JADX INFO: Fake field, exist only in values array */
    EF2("LOG_ENVIRONMENT_AUTOPUSH"),
    /* JADX INFO: Fake field, exist only in values array */
    EF4("LOG_ENVIRONMENT_STAGING"),
    f13708w("LOG_ENVIRONMENT_PROD");


    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f13710v;

    x(String str) {
        this.f13710v = i;
    }

    @Override // cc.f
    public final int a() {
        return this.f13710v;
    }
}
