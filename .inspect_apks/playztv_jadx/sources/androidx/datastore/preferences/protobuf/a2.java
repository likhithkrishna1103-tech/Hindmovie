package androidx.datastore.preferences.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class a2 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final w1 f1005w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final x1 f1006x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final y1 f1007y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ a2[] f1008z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b2 f1009u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f1010v;

    /* JADX INFO: Fake field, exist only in values array */
    a2 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    a2 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    a2 EF2;

    static {
        a2 a2Var = new a2("DOUBLE", 0, b2.f1015x, 1);
        a2 a2Var2 = new a2("FLOAT", 1, b2.f1014w, 5);
        b2 b2Var = b2.f1013v;
        a2 a2Var3 = new a2("INT64", 2, b2Var, 0);
        a2 a2Var4 = new a2("UINT64", 3, b2Var, 0);
        b2 b2Var2 = b2.f1012u;
        a2 a2Var5 = new a2("INT32", 4, b2Var2, 0);
        a2 a2Var6 = new a2("FIXED64", 5, b2Var, 1);
        a2 a2Var7 = new a2("FIXED32", 6, b2Var2, 5);
        a2 a2Var8 = new a2("BOOL", 7, b2.f1016y, 0);
        w1 w1Var = new w1("STRING", 8, b2.f1017z, 2);
        f1005w = w1Var;
        b2 b2Var3 = b2.C;
        x1 x1Var = new x1("GROUP", 9, b2Var3, 3);
        f1006x = x1Var;
        y1 y1Var = new y1("MESSAGE", 10, b2Var3, 2);
        f1007y = y1Var;
        f1008z = new a2[]{a2Var, a2Var2, a2Var3, a2Var4, a2Var5, a2Var6, a2Var7, a2Var8, w1Var, x1Var, y1Var, new z1("BYTES", 11, b2.A, 2), new a2("UINT32", 12, b2Var2, 0), new a2("ENUM", 13, b2.B, 0), new a2("SFIXED32", 14, b2Var2, 5), new a2("SFIXED64", 15, b2Var, 1), new a2("SINT32", 16, b2Var2, 0), new a2("SINT64", 17, b2Var, 0)};
    }

    public a2(String str, int i, b2 b2Var, int i10) {
        this.f1009u = b2Var;
        this.f1010v = i10;
    }

    public static a2 valueOf(String str) {
        return (a2) Enum.valueOf(a2.class, str);
    }

    public static a2[] values() {
        return (a2[]) f1008z.clone();
    }
}
