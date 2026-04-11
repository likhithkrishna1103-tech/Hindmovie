package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static final /* synthetic */ n[] A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final n f1179v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final n f1180w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final n f1181x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final n f1182y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final n f1183z;

    static {
        n nVar = new n("DESTROYED", 0);
        f1179v = nVar;
        n nVar2 = new n("INITIALIZED", 1);
        f1180w = nVar2;
        n nVar3 = new n("CREATED", 2);
        f1181x = nVar3;
        n nVar4 = new n("STARTED", 3);
        f1182y = nVar4;
        n nVar5 = new n("RESUMED", 4);
        f1183z = nVar5;
        A = new n[]{nVar, nVar2, nVar3, nVar4, nVar5};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) A.clone();
    }
}
