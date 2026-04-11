package f5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final /* synthetic */ c[] A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final c f3963v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final c f3964w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final c f3965x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final c f3966y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final c f3967z;

    static {
        c cVar = new c("END", 0);
        f3963v = cVar;
        c cVar2 = new c("ROLLBACK", 1);
        f3964w = cVar2;
        c cVar3 = new c("BEGIN_EXCLUSIVE", 2);
        f3965x = cVar3;
        c cVar4 = new c("BEGIN_IMMEDIATE", 3);
        f3966y = cVar4;
        c cVar5 = new c("BEGIN_DEFERRED", 4);
        f3967z = cVar5;
        A = new c[]{cVar, cVar2, cVar3, cVar4, cVar5};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) A.clone();
    }
}
