package l5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final /* synthetic */ h[] A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final h f7849u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final h f7850v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final h f7851w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final h f7852x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final h f7853y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final h f7854z;

    static {
        h hVar = new h("SET_ANIMATION", 0);
        f7849u = hVar;
        h hVar2 = new h("SET_PROGRESS", 1);
        f7850v = hVar2;
        h hVar3 = new h("SET_REPEAT_MODE", 2);
        f7851w = hVar3;
        h hVar4 = new h("SET_REPEAT_COUNT", 3);
        f7852x = hVar4;
        h hVar5 = new h("SET_IMAGE_ASSETS", 4);
        f7853y = hVar5;
        h hVar6 = new h("PLAY_OPTION", 5);
        f7854z = hVar6;
        A = new h[]{hVar, hVar2, hVar3, hVar4, hVar5, hVar6};
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) A.clone();
    }
}
