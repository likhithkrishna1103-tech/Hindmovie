package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final n f1482u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final n f1483v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final n f1484w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final n f1485x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final n f1486y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ n[] f1487z;

    static {
        n nVar = new n("DESTROYED", 0);
        f1482u = nVar;
        n nVar2 = new n("INITIALIZED", 1);
        f1483v = nVar2;
        n nVar3 = new n("CREATED", 2);
        f1484w = nVar3;
        n nVar4 = new n("STARTED", 3);
        f1485x = nVar4;
        n nVar5 = new n("RESUMED", 4);
        f1486y = nVar5;
        f1487z = new n[]{nVar, nVar2, nVar3, nVar4, nVar5};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f1487z.clone();
    }
}
