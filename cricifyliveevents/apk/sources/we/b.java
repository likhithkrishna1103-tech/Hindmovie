package we;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final /* synthetic */ b[] A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final b f14150v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final b f14151w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final b f14152x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final b f14153y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final b f14154z;

    static {
        b bVar = new b("CPU_ACQUIRED", 0);
        f14150v = bVar;
        b bVar2 = new b("BLOCKING", 1);
        f14151w = bVar2;
        b bVar3 = new b("PARKING", 2);
        f14152x = bVar3;
        b bVar4 = new b("DORMANT", 3);
        f14153y = bVar4;
        b bVar5 = new b("TERMINATED", 4);
        f14154z = bVar5;
        A = new b[]{bVar, bVar2, bVar3, bVar4, bVar5};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) A.clone();
    }
}
