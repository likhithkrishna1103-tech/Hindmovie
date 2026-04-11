package r4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final x f11512u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final x f11513v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ x[] f11514w;

    static {
        x xVar = new x("DEFERRED", 0);
        f11512u = xVar;
        x xVar2 = new x("IMMEDIATE", 1);
        f11513v = xVar2;
        f11514w = new x[]{xVar, xVar2, new x("EXCLUSIVE", 2)};
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) f11514w.clone();
    }
}
