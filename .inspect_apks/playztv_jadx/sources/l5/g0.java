package l5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final g0 f7845u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final g0 f7846v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final g0 f7847w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ g0[] f7848x;

    static {
        g0 g0Var = new g0("AUTOMATIC", 0);
        f7845u = g0Var;
        g0 g0Var2 = new g0("HARDWARE", 1);
        f7846v = g0Var2;
        g0 g0Var3 = new g0("SOFTWARE", 2);
        f7847w = g0Var3;
        f7848x = new g0[]{g0Var, g0Var2, g0Var3};
    }

    public static g0 valueOf(String str) {
        return (g0) Enum.valueOf(g0.class, str);
    }

    public static g0[] values() {
        return (g0[]) f7848x.clone();
    }
}
