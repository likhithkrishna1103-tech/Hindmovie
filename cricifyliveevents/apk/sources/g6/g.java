package g6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final g A;
    public static final /* synthetic */ g[] B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final g f5075v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final g f5076w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final g f5077x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final g f5078y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final g f5079z;

    static {
        g gVar = new g("SET_ANIMATION", 0);
        f5075v = gVar;
        g gVar2 = new g("SET_PROGRESS", 1);
        f5076w = gVar2;
        g gVar3 = new g("SET_REPEAT_MODE", 2);
        f5077x = gVar3;
        g gVar4 = new g("SET_REPEAT_COUNT", 3);
        f5078y = gVar4;
        g gVar5 = new g("SET_IMAGE_ASSETS", 4);
        f5079z = gVar5;
        g gVar6 = new g("PLAY_OPTION", 5);
        A = gVar6;
        B = new g[]{gVar, gVar2, gVar3, gVar4, gVar5, gVar6};
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) B.clone();
    }
}
