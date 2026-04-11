package a5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final h f552u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final h f553v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final h f554w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final h f555x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final h f556y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ h[] f557z;

    static {
        h hVar = new h("ON_CONFIGURE", 0);
        f552u = hVar;
        h hVar2 = new h("ON_CREATE", 1);
        f553v = hVar2;
        h hVar3 = new h("ON_UPGRADE", 2);
        f554w = hVar3;
        h hVar4 = new h("ON_DOWNGRADE", 3);
        f555x = hVar4;
        h hVar5 = new h("ON_OPEN", 4);
        f556y = hVar5;
        f557z = new h[]{hVar, hVar2, hVar3, hVar4, hVar5};
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f557z.clone();
    }
}
