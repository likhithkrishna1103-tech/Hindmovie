package re;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final b f11579u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final b f11580v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final b f11581w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final b f11582x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final b f11583y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ b[] f11584z;

    static {
        b bVar = new b("CPU_ACQUIRED", 0);
        f11579u = bVar;
        b bVar2 = new b("BLOCKING", 1);
        f11580v = bVar2;
        b bVar3 = new b("PARKING", 2);
        f11581w = bVar3;
        b bVar4 = new b("DORMANT", 3);
        f11582x = bVar4;
        b bVar5 = new b("TERMINATED", 4);
        f11583y = bVar5;
        f11584z = new b[]{bVar, bVar2, bVar3, bVar4, bVar5};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f11584z.clone();
    }
}
