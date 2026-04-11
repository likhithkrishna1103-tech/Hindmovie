package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f1095a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f1096b;

    static {
        o oVar = null;
        try {
            oVar = (o) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f1096b = oVar;
    }
}
