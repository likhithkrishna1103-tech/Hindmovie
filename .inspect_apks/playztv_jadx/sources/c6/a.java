package c6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f2510u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f2511v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f2512w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ a[] f2513x;

    static {
        a aVar = new a("PREFER_ARGB_8888", 0);
        f2510u = aVar;
        a aVar2 = new a("PREFER_RGB_565", 1);
        f2511v = aVar2;
        f2513x = new a[]{aVar, aVar2};
        f2512w = aVar;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f2513x.clone();
    }
}
