package l5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f7820u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f7821v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ a[] f7822w;

    static {
        a aVar = new a("AUTOMATIC", 0);
        f7820u = aVar;
        a aVar2 = new a("ENABLED", 1);
        f7821v = aVar2;
        f7822w = new a[]{aVar, aVar2, new a("DISABLED", 2)};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f7822w.clone();
    }
}
