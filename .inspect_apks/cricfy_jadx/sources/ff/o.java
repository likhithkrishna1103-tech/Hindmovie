package ff;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final o A;
    public static final /* synthetic */ o[] B;
    public static final /* synthetic */ yd.a C;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final o f4605x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final o f4606y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final o f4607z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final char f4608v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final char f4609w;

    static {
        o oVar = new o("OBJ", 0, '{', '}');
        f4605x = oVar;
        o oVar2 = new o("LIST", 1, '[', ']');
        f4606y = oVar2;
        o oVar3 = new o("MAP", 2, '{', '}');
        f4607z = oVar3;
        o oVar4 = new o("POLY_OBJ", 3, '[', ']');
        A = oVar4;
        o[] oVarArr = {oVar, oVar2, oVar3, oVar4};
        B = oVarArr;
        C = new yd.a(oVarArr);
    }

    public o(String str, int i, char c9, char c10) {
        this.f4608v = c9;
        this.f4609w = c10;
    }

    public static o valueOf(String str) {
        return (o) Enum.valueOf(o.class, str);
    }

    public static o[] values() {
        return (o[]) B.clone();
    }
}
