package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f764a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f765b;

    static {
        r0 r0Var = r0.f786c;
        o oVar = null;
        try {
            oVar = (o) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f765b = oVar;
    }
}
