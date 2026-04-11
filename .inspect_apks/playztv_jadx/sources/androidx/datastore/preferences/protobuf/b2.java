package androidx.datastore.preferences.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b2 {
    public static final b2 A;
    public static final b2 B;
    public static final b2 C;
    public static final /* synthetic */ b2[] D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final b2 f1012u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final b2 f1013v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final b2 f1014w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final b2 f1015x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final b2 f1016y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final b2 f1017z;

    static {
        b2 b2Var = new b2("INT", 0);
        f1012u = b2Var;
        b2 b2Var2 = new b2("LONG", 1);
        f1013v = b2Var2;
        b2 b2Var3 = new b2("FLOAT", 2);
        f1014w = b2Var3;
        b2 b2Var4 = new b2("DOUBLE", 3);
        f1015x = b2Var4;
        b2 b2Var5 = new b2("BOOLEAN", 4);
        f1016y = b2Var5;
        b2 b2Var6 = new b2("STRING", 5);
        f1017z = b2Var6;
        g gVar = g.f1043w;
        b2 b2Var7 = new b2("BYTE_STRING", 6);
        A = b2Var7;
        b2 b2Var8 = new b2("ENUM", 7);
        B = b2Var8;
        b2 b2Var9 = new b2("MESSAGE", 8);
        C = b2Var9;
        D = new b2[]{b2Var, b2Var2, b2Var3, b2Var4, b2Var5, b2Var6, b2Var7, b2Var8, b2Var9};
    }

    public static b2 valueOf(String str) {
        return (b2) Enum.valueOf(b2.class, str);
    }

    public static b2[] values() {
        return (b2[]) D.clone();
    }
}
