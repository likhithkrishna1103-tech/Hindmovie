package androidx.datastore.preferences.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {
    public static final a0 A;
    public static final a0 B;
    public static final a0 C;
    public static final a0 D;
    public static final a0 E;
    public static final /* synthetic */ a0[] F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a0 f675v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a0 f676w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a0 f677x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a0 f678y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a0 f679z;

    static {
        a0 a0Var = new a0("VOID", 0);
        f675v = a0Var;
        a0 a0Var2 = new a0("INT", 1);
        f676w = a0Var2;
        a0 a0Var3 = new a0("LONG", 2);
        f677x = a0Var3;
        a0 a0Var4 = new a0("FLOAT", 3);
        f678y = a0Var4;
        a0 a0Var5 = new a0("DOUBLE", 4);
        f679z = a0Var5;
        a0 a0Var6 = new a0("BOOLEAN", 5);
        A = a0Var6;
        a0 a0Var7 = new a0("STRING", 6);
        B = a0Var7;
        g gVar = g.f703x;
        a0 a0Var8 = new a0("BYTE_STRING", 7);
        C = a0Var8;
        a0 a0Var9 = new a0("ENUM", 8);
        D = a0Var9;
        a0 a0Var10 = new a0("MESSAGE", 9);
        E = a0Var10;
        F = new a0[]{a0Var, a0Var2, a0Var3, a0Var4, a0Var5, a0Var6, a0Var7, a0Var8, a0Var9, a0Var10};
    }

    public static a0 valueOf(String str) {
        return (a0) Enum.valueOf(a0.class, str);
    }

    public static a0[] values() {
        return (a0[]) F.clone();
    }
}
