package e5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final /* synthetic */ f[] A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final f f3791v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final f f3792w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final f f3793x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final f f3794y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final f f3795z;

    static {
        f fVar = new f("ON_CONFIGURE", 0);
        f3791v = fVar;
        f fVar2 = new f("ON_CREATE", 1);
        f3792w = fVar2;
        f fVar3 = new f("ON_UPGRADE", 2);
        f3793x = fVar3;
        f fVar4 = new f("ON_DOWNGRADE", 3);
        f3794y = fVar4;
        f fVar5 = new f("ON_OPEN", 4);
        f3795z = fVar5;
        A = new f[]{fVar, fVar2, fVar3, fVar4, fVar5};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) A.clone();
    }
}
