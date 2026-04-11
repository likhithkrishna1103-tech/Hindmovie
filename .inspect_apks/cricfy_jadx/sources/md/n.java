package md;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static final n A;
    public static final n B;
    public static final n C;
    public static final /* synthetic */ n[] D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final n f8446v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final n f8447w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final n f8448x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final n f8449y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final n f8450z;

    /* JADX INFO: Fake field, exist only in values array */
    n EF0;

    static {
        n nVar = new n("NOT_SPECIFIED", 0);
        n nVar2 = new n("DOWNLOAD_ADDED", 1);
        f8446v = nVar2;
        n nVar3 = new n("DOWNLOAD_QUEUED", 2);
        f8447w = nVar3;
        n nVar4 = new n("DOWNLOAD_STARTED", 3);
        f8448x = nVar4;
        n nVar5 = new n("DOWNLOAD_WAITING_ON_NETWORK", 4);
        f8449y = nVar5;
        n nVar6 = new n("DOWNLOAD_PROGRESS_CHANGED", 5);
        f8450z = nVar6;
        n nVar7 = new n("DOWNLOAD_COMPLETED", 6);
        A = nVar7;
        n nVar8 = new n("DOWNLOAD_ERROR", 7);
        B = nVar8;
        n nVar9 = new n("DOWNLOAD_PAUSED", 8);
        n nVar10 = new n("DOWNLOAD_RESUMED", 9);
        n nVar11 = new n("DOWNLOAD_CANCELLED", 10);
        n nVar12 = new n("DOWNLOAD_REMOVED", 11);
        n nVar13 = new n("DOWNLOAD_DELETED", 12);
        n nVar14 = new n("DOWNLOAD_BLOCK_UPDATED", 13);
        C = nVar14;
        D = new n[]{nVar, nVar2, nVar3, nVar4, nVar5, nVar6, nVar7, nVar8, nVar9, nVar10, nVar11, nVar12, nVar13, nVar14, new n("OBSERVER_ATTACHED", 14), new n("REPORTING", 15)};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) D.clone();
    }
}
