package z6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f14891u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f14892v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f14893w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ d[] f14894x;

    static {
        d dVar = new d("DEFAULT", 0);
        f14891u = dVar;
        d dVar2 = new d("VERY_LOW", 1);
        f14892v = dVar2;
        d dVar3 = new d("HIGHEST", 2);
        f14893w = dVar3;
        f14894x = new d[]{dVar, dVar2, dVar3};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f14894x.clone();
    }
}
