package id;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final o A;
    public static final o B;
    public static final /* synthetic */ o[] C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final o f6591u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final o f6592v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final o f6593w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final o f6594x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final o f6595y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final o f6596z;

    /* JADX INFO: Fake field, exist only in values array */
    o EF0;

    static {
        o oVar = new o("NOT_SPECIFIED", 0);
        o oVar2 = new o("DOWNLOAD_ADDED", 1);
        f6591u = oVar2;
        o oVar3 = new o("DOWNLOAD_QUEUED", 2);
        f6592v = oVar3;
        o oVar4 = new o("DOWNLOAD_STARTED", 3);
        f6593w = oVar4;
        o oVar5 = new o("DOWNLOAD_WAITING_ON_NETWORK", 4);
        f6594x = oVar5;
        o oVar6 = new o("DOWNLOAD_PROGRESS_CHANGED", 5);
        f6595y = oVar6;
        o oVar7 = new o("DOWNLOAD_COMPLETED", 6);
        f6596z = oVar7;
        o oVar8 = new o("DOWNLOAD_ERROR", 7);
        A = oVar8;
        o oVar9 = new o("DOWNLOAD_PAUSED", 8);
        o oVar10 = new o("DOWNLOAD_RESUMED", 9);
        o oVar11 = new o("DOWNLOAD_CANCELLED", 10);
        o oVar12 = new o("DOWNLOAD_REMOVED", 11);
        o oVar13 = new o("DOWNLOAD_DELETED", 12);
        o oVar14 = new o("DOWNLOAD_BLOCK_UPDATED", 13);
        B = oVar14;
        C = new o[]{oVar, oVar2, oVar3, oVar4, oVar5, oVar6, oVar7, oVar8, oVar9, oVar10, oVar11, oVar12, oVar13, oVar14, new o("OBSERVER_ATTACHED", 14), new o("REPORTING", 15)};
    }

    public static o valueOf(String str) {
        return (o) Enum.valueOf(o.class, str);
    }

    public static o[] values() {
        return (o[]) C.clone();
    }
}
