package u7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f12281v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f12282w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final d f12283x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ d[] f12284y;

    static {
        d dVar = new d("DEFAULT", 0);
        f12281v = dVar;
        d dVar2 = new d("VERY_LOW", 1);
        f12282w = dVar2;
        d dVar3 = new d("HIGHEST", 2);
        f12283x = dVar3;
        f12284y = new d[]{dVar, dVar2, dVar3};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f12284y.clone();
    }
}
