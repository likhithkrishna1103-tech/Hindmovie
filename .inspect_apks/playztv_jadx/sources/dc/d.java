package dc;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f4125u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f4126v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ d[] f4127w;

    static {
        d dVar = new d("CRASHLYTICS", 0);
        f4125u = dVar;
        d dVar2 = new d("PERFORMANCE", 1);
        f4126v = dVar2;
        f4127w = new d[]{dVar, dVar2, new d("MATT_SAYS_HI", 2)};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f4127w.clone();
    }
}
