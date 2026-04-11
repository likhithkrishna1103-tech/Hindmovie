package androidx.navigation;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends x {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Class f1397n;

    public t(Class cls) {
        super(0, cls);
        if (cls.isEnum()) {
            this.f1397n = cls;
            return;
        }
        throw new IllegalArgumentException(cls + " is not an Enum type.");
    }

    @Override // androidx.navigation.x, androidx.navigation.y
    public final String b() {
        return this.f1397n.getName();
    }

    @Override // androidx.navigation.x
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Enum c(String str) {
        Class cls = this.f1397n;
        for (Enum r42 : (Enum[]) cls.getEnumConstants()) {
            if (r42.name().equals(str)) {
                return r42;
            }
        }
        throw new IllegalArgumentException("Enum value " + str + " not found for type " + cls.getName() + ".");
    }
}
