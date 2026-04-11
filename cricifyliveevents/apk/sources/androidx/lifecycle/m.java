package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    private static final /* synthetic */ m[] $VALUES;
    public static final k Companion;
    public static final m ON_ANY;
    public static final m ON_CREATE;
    public static final m ON_DESTROY;
    public static final m ON_PAUSE;
    public static final m ON_RESUME;
    public static final m ON_START;
    public static final m ON_STOP;

    static {
        m mVar = new m("ON_CREATE", 0);
        ON_CREATE = mVar;
        m mVar2 = new m("ON_START", 1);
        ON_START = mVar2;
        m mVar3 = new m("ON_RESUME", 2);
        ON_RESUME = mVar3;
        m mVar4 = new m("ON_PAUSE", 3);
        ON_PAUSE = mVar4;
        m mVar5 = new m("ON_STOP", 4);
        ON_STOP = mVar5;
        m mVar6 = new m("ON_DESTROY", 5);
        ON_DESTROY = mVar6;
        m mVar7 = new m("ON_ANY", 6);
        ON_ANY = mVar7;
        $VALUES = new m[]{mVar, mVar2, mVar3, mVar4, mVar5, mVar6, mVar7};
        Companion = new k();
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) $VALUES.clone();
    }

    public final n a() {
        switch (l.f1172a[ordinal()]) {
            case 1:
            case 2:
                return n.f1181x;
            case 3:
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return n.f1182y;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return n.f1183z;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return n.f1179v;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
