package yc;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final h f14678u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final h f14679v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ h[] f14680w;

    static {
        h hVar = new h("ASC", 0);
        f14678u = hVar;
        h hVar2 = new h("DESC", 1);
        f14679v = hVar2;
        f14680w = new h[]{hVar, hVar2};
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f14680w.clone();
    }
}
