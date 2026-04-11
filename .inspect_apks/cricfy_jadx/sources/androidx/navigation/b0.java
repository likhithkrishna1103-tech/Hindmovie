package androidx.navigation;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f1323b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1324a = new HashMap();

    public static String b(Class cls) {
        HashMap map = f1323b;
        String str = (String) map.get(cls);
        if (str != null) {
            return str;
        }
        z zVar = (z) cls.getAnnotation(z.class);
        String strValue = zVar != null ? zVar.value() : null;
        if (strValue == null || strValue.isEmpty()) {
            throw new IllegalArgumentException("No @Navigator.Name annotation found for ".concat(cls.getSimpleName()));
        }
        map.put(cls, strValue);
        return strValue;
    }

    public final void a(a0 a0Var) {
        String strB = b(a0Var.getClass());
        if (strB == null || strB.isEmpty()) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
    }

    public final a0 c(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        a0 a0Var = (a0) this.f1324a.get(str);
        if (a0Var != null) {
            return a0Var;
        }
        throw new IllegalStateException(l0.e.k("Could not find Navigator with name \"", str, "\". You must call NavController.addNavigator() for each navigation type."));
    }
}
